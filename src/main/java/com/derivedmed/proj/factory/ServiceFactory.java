package com.derivedmed.proj.factory;

import com.derivedmed.proj.services.ProxyService;
import com.derivedmed.proj.services.UserService;
import com.derivedmed.proj.services.UserServiceImpl;
import com.derivedmed.proj.util.annotations.Transactional;

import java.lang.reflect.Method;

public class ServiceFactory {

    private static ServiceFactory ourInstance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private ServiceFactory() {
    }

    public UserService getUserService() {
        if (checkForTransactional(UserService.class)) {
            ProxyService<UserService> userServ = new ProxyService<>(UserServiceImpl.getInstance());
            return userServ.getProxy();
        } else {
            return UserServiceImpl.getInstance();
        }
    }

    private boolean checkForTransactional(Class cl) {
        boolean has = false;
        for (Method m : cl.getMethods()) {
            if (m.isAnnotationPresent(Transactional.class)) {
                has = true;
            }
        }
        return has;
    }
}

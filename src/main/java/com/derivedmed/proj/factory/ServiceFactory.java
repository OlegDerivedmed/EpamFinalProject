package com.derivedmed.proj.factory;

import com.derivedmed.proj.services.*;
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
    public ConfService getConfService() {
        if (checkForTransactional(ConfService.class)) {
            ProxyService<ConfService> userServ = new ProxyService<>(ConfServiceImpl.getInstance());
            return userServ.getProxy();
        } else {
            return ConfServiceImpl.getInstance();
        }
    }
    public ReportService getReportService() {
        if (checkForTransactional(ReportService.class)) {
            ProxyService<ReportService> userServ = new ProxyService<>(ReportServiceImpl.getInstance());
            return userServ.getProxy();
        } else {
            return ReportServiceImpl.getInstance();
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

package com.derivedmed.proj.factory;


import com.derivedmed.proj.services.ConfService;
import com.derivedmed.proj.services.ConfServiceImpl;
import com.derivedmed.proj.services.ProxyService;
import com.derivedmed.proj.services.ReportService;
import com.derivedmed.proj.services.ReportServiceImpl;
import com.derivedmed.proj.services.UserService;
import com.derivedmed.proj.services.UserServiceImpl;
import com.derivedmed.proj.util.annotations.Transactional;

import java.util.Arrays;

public class ServiceFactory {

    private static ServiceFactory ourInstance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private ServiceFactory() {
    }

    public UserService getUserService() {
        if (isTransactional(UserService.class)) {
            ProxyService<UserService> userServ = new ProxyService<>(UserServiceImpl.getInstance());
            return userServ.getProxy();
        } else {
            return UserServiceImpl.getInstance();
        }
    }
    public ConfService getConfService() {
        if (isTransactional(ConfService.class)) {
            ProxyService<ConfService> userServ = new ProxyService<>(ConfServiceImpl.getInstance());
            return userServ.getProxy();
        } else {
            return ConfServiceImpl.getInstance();
        }
    }
    public ReportService getReportService() {
        if (isTransactional(ReportService.class)) {
            ProxyService<ReportService> userServ = new ProxyService<>(ReportServiceImpl.getInstance());
            return userServ.getProxy();
        } else {
            return ReportServiceImpl.getInstance();
        }
    }

    private boolean isTransactional(Class clazz) {
        return Arrays.stream(clazz.getMethods()).anyMatch(m->m.isAnnotationPresent(Transactional.class));
    }
}

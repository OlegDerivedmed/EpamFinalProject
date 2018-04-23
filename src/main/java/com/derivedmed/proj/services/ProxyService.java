package com.derivedmed.proj.services;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyService<T> implements Service{
    private Object proxy;

    public ProxyService(Object o) {
        InvocationHandler invocationHandler = new ServiceTransactionalProxy(o);
        proxy = Proxy.newProxyInstance(Service.class.getClassLoader(), new Class[]{UserService.class}, invocationHandler);
    }

    public T getProxy() {
        return (T) proxy;
    }

}

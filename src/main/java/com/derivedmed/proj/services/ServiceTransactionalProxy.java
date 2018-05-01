package com.derivedmed.proj.services;

import com.derivedmed.proj.dao.TransactionManager;
import com.derivedmed.proj.util.annotations.Transactional;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceTransactionalProxy implements InvocationHandler {

    private TransactionManager transactionManager = TransactionManager.getInstance();

    private Object object;

    public ServiceTransactionalProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Transactional.class)) {
            System.out.println("transactional!");
            transactionManager.beginTransaction();
            Object result = method.invoke(object, args);
            transactionManager.commit();
            return result;
        }
        return method.invoke(object, args);
    }
}

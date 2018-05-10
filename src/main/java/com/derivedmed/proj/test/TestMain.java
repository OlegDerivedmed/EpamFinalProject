package com.derivedmed.proj.test;

import com.derivedmed.proj.factory.ServiceFactory;

public class TestMain {
    public static void main(String[] args){
        ServiceFactory.getUserService().registerUserToReport(1,2);

    }
}

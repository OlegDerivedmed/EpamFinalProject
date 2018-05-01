package com.derivedmed.proj.test;

import com.derivedmed.proj.factory.ServiceFactory;
import com.derivedmed.proj.model.User;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(ServiceFactory.getInstance().getRegistrationService().Register(new User(18,4,"moder","HelloMello11",0)));
    }
}

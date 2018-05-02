package com.derivedmed.proj.test;

import com.derivedmed.proj.factory.ServiceFactory;
import com.derivedmed.proj.model.User;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {


    }

    static class Thready implements Runnable {

        private final String email;
        private final int id;

        Thready(int id, String email) {
            this.id = id;
            this.email = email;
        }

        @Override
        public void run() {
            ServiceFactory.getRegistrationService().register(new User(id,4,email,"root",0));
        }
    }
}

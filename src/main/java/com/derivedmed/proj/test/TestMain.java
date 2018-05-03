package com.derivedmed.proj.test;

import com.derivedmed.proj.dao.UserDao;
import com.derivedmed.proj.factory.ServiceFactory;
import com.derivedmed.proj.model.User;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
            new Thread(()-> new UserDao().createUser(new User(4,"root","pass",2))).start();
            new Thread(()-> new UserDao().createUser(new User(4,"root","pass",2))).start();
            new Thread(()-> new UserDao().createUser(new User(4,"root","pass",2))).start();
            new Thread(()-> new UserDao().createUser(new User(4,"root","pass",2))).start();
            new Thread(()-> new UserDao().createUser(new User(4,"root","pass",2))).start();
            new Thread(()-> new UserDao().createUser(new User(4,"root","pass",2))).start();

    }

    private static void checker(int id) {

    }

    static class Thready implements Runnable {
        private final User user;
        public Thready(User user) {
            this.user = user;
        }
        @Override
        public void run() {
            user.setEmail("newEmail");
            try {
                ServiceFactory.getUserService().updateUser(user);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

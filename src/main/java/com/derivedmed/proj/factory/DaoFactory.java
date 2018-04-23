package com.derivedmed.proj.factory;

import com.derivedmed.proj.dao.UserDao;

public class DaoFactory {
    private static final UserDao userDao = new UserDao();
    private static DaoFactory ourInstance = new DaoFactory();

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    private DaoFactory() {
    }

    public static UserDao getUserDao() {
        return userDao;
    }
}

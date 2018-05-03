package com.derivedmed.proj.services;

import com.derivedmed.proj.dao.TransactionManager;
import com.derivedmed.proj.dao.UserDao;
import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.model.User;

public class RegistrationServiceImpl implements RegistrationService {
    private final UserDao userDao = DaoFactory.getInstance().getUserDao();
    private static RegistrationServiceImpl ourInstance = new RegistrationServiceImpl();

    public static RegistrationServiceImpl getInstance() {
        return ourInstance;
    }

    private RegistrationServiceImpl() {
    }

    @Override
    public int register(User user) {
        TransactionManager.getInstance().beginTransaction();
        userDao.create(user);
        TransactionManager.getInstance().commit();
        return 0;
    }

    private boolean isUserExist(User user) {
        return userDao.checkUser(user);
    }
}

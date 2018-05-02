package com.derivedmed.proj.services;

import com.derivedmed.proj.dao.UserDao;
import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.model.User;
import com.derivedmed.proj.util.annotations.Transactional;

public class RegistrationServiceImpl implements RegistrationService {
    private final UserDao userDao = DaoFactory.getInstance().getUserDao();
    private static RegistrationServiceImpl ourInstance = new RegistrationServiceImpl();

    public static RegistrationServiceImpl getInstance() {
        return ourInstance;
    }

    private RegistrationServiceImpl() {
    }

    @Transactional
    @Override
    public boolean register(User user) {
        if (!checkUser(user,userDao)){
            userDao.create(user);
            return true;
        }
        return false;
    }

    private boolean checkUser(User user, UserDao userDao) {
        return userDao.checkUser(user);
    }
}

package com.derivedmed.proj.services;

import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.model.User;

public class RegistrationServiceImpl implements RegistrationService {
    private static RegistrationServiceImpl ourInstance = new RegistrationServiceImpl();

    public static RegistrationServiceImpl getInstance() {
        return ourInstance;
    }

    private RegistrationServiceImpl() {
    }

    @Override
    public boolean Register(User user) {
        if (UserCheckerServiceImpl.getInstance().checkUser(user)){
            DaoFactory.getInstance().getUserDao().create(user);
            return true;
        }
        return false;
    }
}

package com.derivedmed.proj.services;

import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.model.User;

public class UserCheckerServiceImpl implements UserCheckerService {
    private static UserCheckerServiceImpl ourInstance = new UserCheckerServiceImpl();

    public static UserCheckerServiceImpl getInstance() {
        return ourInstance;
    }

    private UserCheckerServiceImpl() {
    }

    @Override
    public boolean checkUser(User user) {
        boolean result = true;
        try {
            for (User user1 : DaoFactory.getInstance().getUserDao().getAll()){
                if (user.getEmail().equals(user1.getEmail())){
                    result = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

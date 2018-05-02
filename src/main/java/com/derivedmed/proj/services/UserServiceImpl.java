package com.derivedmed.proj.services;

import com.derivedmed.proj.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl ourInstance = new UserServiceImpl();

    public static UserServiceImpl getInstance() {
        return ourInstance;
    }

    private UserServiceImpl() {
    }

    @Override
    public void createUser(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public User getUserByID(int id) throws NoSuchMethodException, InvocationTargetException {
        return null;
    }

    @Override
    public List<User> getAll() throws NoSuchMethodException, InvocationTargetException {
        return null;
    }

    @Override
    public boolean clearAll() {
        return false;
    }
}

package com.derivedmed.proj.services;

import com.derivedmed.proj.dao.UserDao;
import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.model.User;
import com.derivedmed.proj.util.annotations.Transactional;

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

    @Transactional
    @Override
    public boolean updateUser(User user) throws InterruptedException {
        Thread.sleep(1000);
        return DaoFactory.getInstance().getUserDao().update(user);
    }

    @Transactional
    @Override
    public boolean createAndUpdate(User user, String email) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        user.setId(userDao.create(user));
        user.setEmail(email);
        return userDao.update(user);
    }
}

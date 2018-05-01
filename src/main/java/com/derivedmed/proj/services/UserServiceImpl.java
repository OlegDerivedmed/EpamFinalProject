package com.derivedmed.proj.services;

import com.derivedmed.proj.dao.UserDao;
import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.model.User;
import com.derivedmed.proj.util.IdGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        UserDao userDao = DaoFactory.getUserDao();
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        userDao.create(new User(IdGenerator.generateID(), 4, name, password,0));
        try {
            resp.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByID(int id) throws NoSuchMethodException, InvocationTargetException {
        UserDao userDao = DaoFactory.getUserDao();
        return userDao.get(id);
    }

    @Override
    public List<User> getAll() throws NoSuchMethodException, InvocationTargetException {
        UserDao userDao = DaoFactory.getUserDao();
        return userDao.getAll();
    }

    @Override
    public boolean clearAll() {
        return DaoFactory.getUserDao().clearAll();
    }
}

package com.derivedmed.proj.services;

import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl ourInstance = new UserServiceImpl();

    public static UserServiceImpl getInstance() {
        return ourInstance;
    }

    private UserServiceImpl() {
    }

    @Override
    public int createUser(User user) {
        return DaoFactory.getInstance().getUserDao().create(user);
    }

    @Override
    public User getUserByID(int id) {
        return DaoFactory.getInstance().getUserDao().getByID(id);
    }

    @Override
    public List<User> getAll() {
        return DaoFactory.getInstance().getUserDao().getAll();
    }

    @Override
    public boolean clearAll() {
        return DaoFactory.getInstance().getUserDao().clearAll();
    }

    @Override
    public boolean updateUser(User user) {
        return DaoFactory.getInstance().getUserDao().update(user);
    }

    @Override
    public boolean delete(int id) {
        return DaoFactory.getInstance().getUserDao().delete(id);
    }

    @Override
    public boolean registerUserToReport(int userId, int reportId) {
        return DaoFactory.getInstance().getUserDao().registerUserToReport(userId,reportId);
    }

    @Override
    public List<User> getSpeakersByRating() {
        return DaoFactory.getInstance().getUserDao().getSpeakersByRating();    }

    @Override
    public boolean checkUser(String login, String password) {
        return DaoFactory.getInstance().getUserDao().authUser(login,password);
    }

    @Override
    public User getByLogin(String login) {
        return DaoFactory.getInstance().getUserDao().getByLogin(login);
    }
}

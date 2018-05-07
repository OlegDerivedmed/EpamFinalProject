package com.derivedmed.proj.services;

import com.derivedmed.proj.model.User;

import java.util.List;

public interface UserService extends Service{

    int createUser(User user);

    User getUserByID(int id);

    List<User> getAll();

    boolean clearAll();

    boolean updateUser(User user);

    boolean delete(int id);

    boolean registerUserToReport(int userId, int reportId);

    List<User> getSpeakersByRating();
}

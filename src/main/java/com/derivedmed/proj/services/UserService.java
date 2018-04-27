package com.derivedmed.proj.services;

import com.derivedmed.proj.model.User;
import com.derivedmed.proj.util.annotations.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface UserService extends Service{

    @Transactional
    void createUser(HttpServletRequest req, HttpServletResponse resp);

    User getUserByID(int id) throws NoSuchMethodException, InvocationTargetException;

    List<User> getAll() throws NoSuchMethodException, InvocationTargetException;

    boolean clearAll();
}

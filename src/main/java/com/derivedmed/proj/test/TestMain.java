package com.derivedmed.proj.test;

import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.factory.ServiceFactory;
import com.derivedmed.proj.model.User;
import com.derivedmed.proj.services.ProxyService;
import com.derivedmed.proj.services.UserService;
import com.derivedmed.proj.services.UserServiceImpl;

import java.beans.PropertyVetoException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) throws SQLException, PropertyVetoException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        for (User u :DaoFactory.getUserDao().getSpeakersByRating()){
            System.out.println(u);
        }
    }
}

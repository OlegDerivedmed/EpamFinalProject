package com.derivedmed.proj.test;

import com.derivedmed.proj.factory.ServiceFactory;
import com.derivedmed.proj.model.User;
import com.derivedmed.proj.services.ProxyService;
import com.derivedmed.proj.services.UserService;
import com.derivedmed.proj.services.UserServiceImpl;

import java.beans.PropertyVetoException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) throws SQLException, PropertyVetoException, IllegalAccessException, InstantiationException {
        ServiceFactory.getInstance().getUserService();
//        System.out.println(UserServiceImpl.getInstance().getUserByID(777).toString());
//        System.out.println(UserServiceImpl.getInstance().getUserByID(428).toString());
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        List<User> list = UserServiceImpl.getInstance().getAll();
//        for (User u : list){
//            System.out.println(u);
//        }
//        TestClass tc = new TestClass();
//        fs(tc);
//        ProxyService<UserService> userService = new ProxyService<>(UserServiceImpl.getInstance());
//        System.out.println(userService.getProxy().toString());
//        Connection connection = DbConnector.getInstance().getConnection().get();
//        Statement statement = connection.createStatement();
//        String sql = "REPLACE INTO users (user_id, role_id ,email, password) VALUES (?, ?, ?, ?)";
//        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
//        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/fp_db?autoReconnect=true&useSSL=false");
//        comboPooledDataSource.setUser("root");
//        comboPooledDataSource.setPassword("root");
//        Connection connection = comboPooledDataSource.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, 1);
//        preparedStatement.setInt(2, 4);
//        preparedStatement.setString(3, "email");
//        preparedStatement.setString(4, "pass");
//        preparedStatement.executeUpdate();
//        connection.close();
    }

    public static void fs(Object obj) throws IllegalAccessException {
        HashMap<String, String> classStringHashMap = new HashMap<>();
        Class cl = obj.getClass();
        //Field[] fields = cl.getDeclaredFields();
        for (Field f : cl.getDeclaredFields()) {
            classStringHashMap.put(f.getType().getSimpleName(), f.getName());
        }
        for (Map.Entry entry : classStringHashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

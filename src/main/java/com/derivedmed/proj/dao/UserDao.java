package com.derivedmed.proj.dao;

import com.derivedmed.proj.model.User;
import com.derivedmed.proj.util.ResultSetParser;
import com.derivedmed.proj.util.annotations.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements CrudDao<User> {

    @Override
    public boolean create(User user) {
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy
                     .prepareStatement("INSERT INTO users (user_id, role_id, email, password) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(2, user.getRole_id());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public User get(int id) {
        User user = new User();
        String SQL = "SELECT * from users where user_id = ?";
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy
                     .prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);
            user = (User) ResultSetParser.getInstance().parse(preparedStatement.executeQuery(), User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean update(User user) {
        return create(user);
    }

    @Override
    public boolean delete(int id) {
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy.prepareStatement("delete from users where user_id =?")) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        ArrayList<User> resultList = new ArrayList<>();
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
        PreparedStatement preparedStatement = connectionProxy.prepareStatement("select * from users")){
            resultList = (ArrayList<User>) ResultSetParser.getInstance().parse(preparedStatement.executeQuery(),User.class);
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public boolean clearAll() {
        try(ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
            Statement statement = connectionProxy.createStatement()) {
            statement.executeUpdate("DELETE FROM users");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

package com.derivedmed.proj.dao;

import com.derivedmed.proj.model.User;
import com.derivedmed.proj.util.rsparser.ResultSetParser;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
    public User getByID(int id) throws NoSuchMethodException, InvocationTargetException {
        User user = new User();
        String SQL = "SELECT * from users where user_id = ?";
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy
                     .prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);
            ArrayList<User> resultList = ResultSetParser.getInstance().parse(preparedStatement.executeQuery(), user);
            if (resultList.size()!=0){
                user =resultList.get(0);
            }else {
                System.out.println("No user with such id");
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean update(User user) {
        String SQL = "UPDATE users SET email = ?, password = ?, role_id = ? WHERE user_id = ?";
        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getRole_id());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy.prepareStatement("delete from users where user_id =?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<User> getAll() throws NoSuchMethodException, InvocationTargetException {
        ArrayList<User> resultList = new ArrayList<>();
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy.prepareStatement("select * from users")) {
            Object parserResult = ResultSetParser.getInstance().parse(preparedStatement.executeQuery(), User.class);
            if (parserResult instanceof User) {
                resultList.add((User) parserResult);
            } else {
                resultList = (ArrayList<User>) parserResult;
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public boolean clearAll() {
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             Statement statement = connectionProxy.createStatement()) {
            statement.executeUpdate("DELETE FROM users");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean checkUser(User user){
        boolean result = false;
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
        PreparedStatement preparedStatement = connectionProxy.prepareStatement("select * from users where email = ?")){
            preparedStatement.setString(1,user.getEmail());
            result = preparedStatement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean registerUserToReport(int user_id, int report_id) {
        try {
            try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
                 PreparedStatement preparedStatement = connectionProxy.prepareStatement("insert into users_reports (user_id, report_id) values(?, ?)")) {
                preparedStatement.setInt(1, user_id);
                preparedStatement.setInt(2, report_id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<User> getSpeakersByRating() throws NoSuchMethodException, InvocationTargetException {
        ArrayList<User> resultList = new ArrayList<>();
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy.prepareStatement("select * from users order by rating desc")) {
            resultList = ResultSetParser.getInstance().parse(preparedStatement.executeQuery(), new User());
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}

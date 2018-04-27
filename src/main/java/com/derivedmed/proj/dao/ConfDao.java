package com.derivedmed.proj.dao;

import com.derivedmed.proj.model.Conf;
import com.derivedmed.proj.rsparser.ResultSetParser;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConfDao implements CrudDao<Conf> {
    @Override
    public boolean create(Conf conf) {
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy
                     .prepareStatement("insert into confs (conf_id,conf_name,conf_place,conf_date) " +
                             "values(?,?,?,?")) {
            preparedStatement.setInt(1, conf.getId());
            preparedStatement.setString(2, conf.getName());
            preparedStatement.setString(3, conf.getPlace());
            preparedStatement.setTimestamp(4, conf.getDate());
            preparedStatement.executeUpdate();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Conf get(int id) throws NoSuchMethodException, InvocationTargetException {
        Conf conf = new Conf();
        String SQL = "SELECT * from confs where conf_id = ?";
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy
                     .prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);
            conf = (Conf) ResultSetParser.getInstance().parse(preparedStatement.executeQuery(), Conf.class);
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return conf;
    }

    @Override
    public boolean update(Conf conf) {
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy
                     .prepareStatement("UPDATE confs SET conf_name = ?, conf_place = ?, conf_date = ? where conf_id = ?")) {
            preparedStatement.setString(1,conf.getName());
            preparedStatement.setString(2,conf.getPlace());
            preparedStatement.setTimestamp(3,conf.getDate());
            preparedStatement.setInt(4,conf.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy.prepareStatement("delete from confs where conf_id =?")) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Conf> getAll() throws NoSuchMethodException, InvocationTargetException {
        ArrayList<Conf> resultList = new ArrayList<>();
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy.prepareStatement("select * from confs")){
            resultList = (ArrayList<Conf>) ResultSetParser.getInstance().parse(preparedStatement.executeQuery(),Conf.class);
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public boolean clearAll() {
        try(ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
            Statement statement = connectionProxy.createStatement()) {
            statement.executeUpdate("DELETE FROM confs");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

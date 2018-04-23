package com.derivedmed.proj.dao;

import com.derivedmed.proj.model.Conf;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public Conf get(int id) {
        return null;
    }

    @Override
    public boolean update(Conf conf) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Conf> getAll() {
        return null;
    }

    @Override
    public boolean clearAll() {
        return false;
    }
}

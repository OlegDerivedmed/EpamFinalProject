package com.derivedmed.proj.dao;

import com.derivedmed.proj.model.Report;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReportDao implements CrudDao<Report> {
    @Override
    public boolean create(Report report) {
        try(ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connectionProxy
                    .prepareStatement("insert into reports (report_id,conf_id,user_id,report_name,report_desk,is_offered) values(?,?,?,?,?,?)")) {
            preparedStatement.setInt(1,report.getId());
            preparedStatement.setInt(2,report.getConf_id());
            preparedStatement.setInt(3,report.getUser().getId());
            preparedStatement.setString(4,report.getReport_name());
            preparedStatement.setString(5,report.getReport_description());
            preparedStatement.setBoolean(6,report.getOffered());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Report get(int id) {
        return null;
    }

    @Override
    public boolean update(Report report) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Report> getAll() {
        return null;
    }

    @Override
    public boolean clearAll() {
        return false;
    }
}

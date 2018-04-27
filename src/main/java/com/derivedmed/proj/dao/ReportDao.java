package com.derivedmed.proj.dao;

import com.derivedmed.proj.model.Report;
import com.derivedmed.proj.rsparser.ResultSetParser;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
    public Report get(int id) throws NoSuchMethodException, InvocationTargetException {
        Report report = new Report();
        String SQL = "SELECT * from reports where report_id = ?";
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy.prepareStatement(SQL)){
            preparedStatement.setInt(1,id);
            report = (Report) ResultSetParser.getInstance().parse(preparedStatement.executeQuery(),Report.class);
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return report;
    }

    @Override
    public boolean update(Report report) {
        String SQL = "UPDATE reports SET conf_id = ?, user_id = ?, report_name = ?, report_desk = ?, is_offered = ? WHERE report_id = ?";
        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1,report.getConf_id());
            preparedStatement.setInt(2,report.getUser().getId());
            preparedStatement.setString(3,report.getReport_name());
            preparedStatement.setString(4,report.getReport_description());
            preparedStatement.setBoolean(5,report.getOffered());
            preparedStatement.setInt(6,report.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy.prepareStatement("delete from reports where report_id =?")) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Report> getAll() throws NoSuchMethodException, InvocationTargetException {
        ArrayList<Report> resultList = new ArrayList<>();
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy.prepareStatement("select * from reports")){
            resultList = (ArrayList<Report>) ResultSetParser.getInstance().parse(preparedStatement.executeQuery(),Report.class);
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public boolean clearAll() {
        try(ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
            Statement statement = connectionProxy.createStatement()) {
            statement.executeUpdate("DELETE FROM reports");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Report> getReportsByUserId(int id){
        ArrayList<Report> reports = new ArrayList<>();
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy.prepareStatement("SELECT reports.report_id,conf_id, report_name,report_desk FROM reports JOIN users_reports u ON reports.report_id = u.report_id WHERE u.user_id = ?;")) {
            preparedStatement.setInt(1,id);
            reports = (ArrayList<Report>) ResultSetParser.getInstance().parse(preparedStatement.executeQuery(),Report.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return reports;
    }
    public List<Report> getPastReports(){
        ArrayList<Report> reports = new ArrayList<>();
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy.prepareStatement("SELECT reports.report_id,conf_id, report_name,report_desk FROM reports JOIN confs c ON reports.conf_id = c.conf_id WHERE c.conf_date < ?;")) {
            preparedStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
            reports = (ArrayList<Report>) ResultSetParser.getInstance().parse(preparedStatement.executeQuery(),Report.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return reports;
    }
    public List<Report> getUpcomingReports(){
        ArrayList<Report> reports = new ArrayList<>();
        try (ConnectionProxy connectionProxy = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connectionProxy.prepareStatement("SELECT reports.report_id,conf_id, report_name,report_desk FROM reports JOIN confs c ON reports.conf_id = c.conf_id WHERE c.conf_date > ?;")) {
            preparedStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
            reports = (ArrayList<Report>) ResultSetParser.getInstance().parse(preparedStatement.executeQuery(),Report.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return reports;
    }


}

package com.derivedmed.proj.services;

import com.derivedmed.proj.dao.ConfDao;
import com.derivedmed.proj.dao.ReportDao;
import com.derivedmed.proj.dao.UserDao;
import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.model.Conf;
import com.derivedmed.proj.model.Report;
import com.derivedmed.proj.model.User;

import java.sql.Timestamp;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static ReportServiceImpl ourInstance = new ReportServiceImpl();

    public static ReportServiceImpl getInstance() {
        return ourInstance;
    }

    private ReportServiceImpl() {
    }

    @Override
    public int create(Report report) {
        return DaoFactory.getInstance().getReportDao().create(report);
    }

    @Override
    public Report getById(int id) {
        return DaoFactory.getInstance().getReportDao().getByID(id);
    }

    @Override
    public boolean update(Report report) {
        return DaoFactory.getInstance().getReportDao().update(report);
    }

    @Override
    public boolean delete(int id) {
        return DaoFactory.getInstance().getReportDao().delete(id);
    }

    @Override
    public boolean clearAll() {
        return DaoFactory.getInstance().getReportDao().clearAll();
    }

    @Override
    public List<Report> getAll() {
        return DaoFactory.getInstance().getReportDao().getAll();
    }

    @Override
    public List<Report> getByUserId(int id) {
        return DaoFactory.getInstance().getReportDao().getReportsByUserId(id);
    }

    @Override
    public boolean offerReport(int speakerId, int reportId, int roleId) {
        ReportDao reportDao = DaoFactory.getInstance().getReportDao();
        boolean result = false;
        if (roleId == 2){
            result = reportDao.offerReport(speakerId,reportId,false);
        }
        if (roleId == 3){
            result = reportDao.offerReport(speakerId,reportId,true);
        }
        return result;
    }

    @Override
    public boolean confirmOffer(int userId, int reportId) {
        return DaoFactory.getInstance().getReportDao().confirmOffer(userId,reportId);
    }

    @Override
    public synchronized boolean setReportToSpeaker(int speakerId, int reportId) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        ConfDao confDao = DaoFactory.getInstance().getConfDao();
        ReportDao reportDao = DaoFactory.getInstance().getReportDao();
        User user = userDao.getByID(speakerId);
        Report report = reportDao.getByID(reportId);
        Conf conf = confDao.getByID(report.getConf_id());
        Timestamp timestamp = conf.getDate();
        if (userDao.isSpeakerFreeThisDate(user,timestamp)){
            return reportDao.confirmOffer(speakerId,reportId);
        }
        return false;
    }
}

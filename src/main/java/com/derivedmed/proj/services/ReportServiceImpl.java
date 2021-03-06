package com.derivedmed.proj.services;

import com.derivedmed.proj.dao.ConfDao;
import com.derivedmed.proj.dao.ReportDao;
import com.derivedmed.proj.dao.UserDao;
import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.model.Conf;
import com.derivedmed.proj.model.Report;
import com.derivedmed.proj.model.Role;
import com.derivedmed.proj.model.User;

import java.sql.Timestamp;
import java.util.HashMap;
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
    public List<Integer> votedByUser(int user_id) {
        return DaoFactory.getInstance().getReportDao().votedByUser(user_id);
    }

    @Override
    public boolean offerReport(int speakerId, int reportId, Role role) {
        ReportDao reportDao = DaoFactory.getInstance().getReportDao();
        boolean result = false;
        if (role == Role.MODERATOR) {
            result = reportDao.offerReport(speakerId, reportId, false);
        }
        if (role == Role.SPEAKER) {
            result = reportDao.offerReport(speakerId, reportId, true);
        }
        return result;
    }

    @Override
    public boolean confirmOffer(int userId, int reportId) {
        return DaoFactory.getInstance().getReportDao().confirmOffer(userId, reportId);
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
        if (userDao.isSpeakerFreeThisDate(user, timestamp)) {
            return reportDao.confirmOffer(speakerId, reportId);
        }
        return false;
    }
    @Override
    public HashMap<String,Report> getReportsOfferedBySpeakerOrModer(int speakerid, boolean bySpeaker){
        ReportDao reportDao = DaoFactory.getInstance().getReportDao();
        ConfDao confDao = DaoFactory.getInstance().getConfDao();
        HashMap<String,Report> result = new HashMap<>();
        List<Report> reports = reportDao.getReportsOfferedBySpeakerOrModer(speakerid,bySpeaker);
        for (Report report : reports){
            String confName = confDao.getByID(report.getConf_id()).getName();
            result.put(confName,report);
        }
        return result;
    }
}

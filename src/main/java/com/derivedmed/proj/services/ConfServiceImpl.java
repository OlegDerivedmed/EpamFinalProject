package com.derivedmed.proj.services;

import com.derivedmed.proj.dao.ConfDao;
import com.derivedmed.proj.dao.ReportDao;
import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.model.Conf;
import com.derivedmed.proj.model.Report;
import com.derivedmed.proj.model.Role;
import com.derivedmed.proj.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ConfServiceImpl implements ConfService {
    private static ConfServiceImpl ourInstance = new ConfServiceImpl();

    public static ConfServiceImpl getInstance() {
        return ourInstance;
    }

    private ConfServiceImpl() {
    }

    @Override
    public int createConf(Conf conf) {
        return DaoFactory.getInstance().getConfDao().create(conf);
    }

    @Override
    public Conf getById(int id) {
        return DaoFactory.getInstance().getConfDao().getByID(id);
    }

    @Override
    public boolean update(Conf conf) {
        return DaoFactory.getInstance().getConfDao().update(conf);
    }

    @Override
    public List<Conf> getAll() {
        ConfDao confDao = DaoFactory.getInstance().getConfDao();
        ReportDao reportDao = DaoFactory.getInstance().getReportDao();
        List<Conf> confs = confDao.getAll();
        for (Conf conf : confs) {
            conf.setReports(reportDao.getByConf(conf.getId()));
        }
        return confs;
    }

    @Override
    public List<Conf> getUpcoming(User user) {
        List<Conf> confs = getAll().stream()
                .filter(conf -> conf.getDate().getTime() > new Date().getTime())
                .collect(Collectors.toList());

        if (user.getRole() == Role.MODERATOR || user.getRole() == Role.ADMINISTRATOR || user.getRole() == Role.SPEAKER) {
            return confs;
        }
        List<Conf> result = new ArrayList<>();
        for (Conf conf : confs) {
            List<Report> reports = new ArrayList<>();
            for (Report report : conf.getReports()) {
                if (report.getSpeakerName() != null) {
                    reports.add(report);
                }
            }
            conf.setReports(reports);
            if (!reports.isEmpty()) {
                result.add(conf);
            }
        }
        return result;
    }

    @Override
    public List<Conf> getPast() {
        List<Conf> result = getAll().stream()
                .filter(conf -> conf.getDate().getTime() < new Date().getTime())
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public boolean delete(int id) {
        return DaoFactory.getInstance().getConfDao().delete(id);
    }

    @Override
    public boolean deleteAll() {
        return DaoFactory.getInstance().getConfDao().clearAll();
    }
}

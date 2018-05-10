package com.derivedmed.proj.services;

import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.factory.ServiceFactory;
import com.derivedmed.proj.model.Conf;
import com.derivedmed.proj.model.Report;
import com.derivedmed.proj.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl ourInstance = new UserServiceImpl();

    public static UserServiceImpl getInstance() {
        return ourInstance;
    }

    private UserServiceImpl() {
    }

    @Override
    public int createUser(User user) {
        return DaoFactory.getInstance().getUserDao().create(user);
    }

    @Override
    public User getUserByID(int id) {
        return DaoFactory.getInstance().getUserDao().getByID(id);
    }

    @Override
    public List<User> getAll() {
        return DaoFactory.getInstance().getUserDao().getAll();
    }

    @Override
    public boolean clearAll() {
        return DaoFactory.getInstance().getUserDao().clearAll();
    }

    @Override
    public boolean updateUser(User user) {
        return DaoFactory.getInstance().getUserDao().update(user);
    }

    @Override
    public boolean delete(int id) {
        return DaoFactory.getInstance().getUserDao().delete(id);
    }

    @Override
    public boolean registerUserToReport(int userId, int reportId) {
        return DaoFactory.getInstance().getUserDao().registerUserToReport(userId, reportId);
    }

    @Override
    public List<User> getSpeakersByRating() {
        return DaoFactory.getInstance().getUserDao().getSpeakersByRating();
    }

    @Override
    public boolean checkUser(String login, String password) {
        return DaoFactory.getInstance().getUserDao().authUser(login, password);
    }

    @Override
    public User getByLogin(String login) {
        return DaoFactory.getInstance().getUserDao().getByLogin(login);
    }

    @Override
    public HashMap<Integer, String> isUserRegistered(int userId, List<Conf> confs) {
        ReportService reportService = ServiceFactory.getReportService();
        List<Report> usersReports = reportService.getByUserId(userId);
        List<Integer> reportsIds = new ArrayList<>();
        for (Report r : usersReports) {
            reportsIds.add(r.getId());
        }
        HashMap<Integer, String> isRegistered = new HashMap<>();
        for (Conf conf : confs) {
            for (Report report : conf.getReports()) {
                int id = report.getId();
                if (reportsIds.contains(id)) {
                    isRegistered.put(id, "disabled");
                } else {
                    isRegistered.put(id, "");
                }
            }
        }
        return isRegistered;
    }
}

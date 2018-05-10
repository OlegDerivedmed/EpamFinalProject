package com.derivedmed.proj.services;

import com.derivedmed.proj.dao.ConfDao;
import com.derivedmed.proj.dao.ReportDao;
import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.model.Conf;

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
        for (Conf conf:confs){
            conf.setReports(reportDao.getByConf(conf.getId()));
        }
//        List<Conf> result = new ArrayList<>();
//        for (Conf conf : confs){
//            if (conf.getDate().getTime()>new Date().getTime()){
//                result.add(conf);
//            }
//        }
        return confs.stream()
                .filter(conf -> conf.getDate().getTime()>new Date().getTime())
                .collect(Collectors.toList());
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

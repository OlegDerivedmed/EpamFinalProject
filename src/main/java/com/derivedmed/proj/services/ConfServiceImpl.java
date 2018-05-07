package com.derivedmed.proj.services;

import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.model.Conf;

import java.util.List;

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
        return DaoFactory.getInstance().getConfDao().getAll();
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

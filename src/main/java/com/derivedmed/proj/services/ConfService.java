package com.derivedmed.proj.services;

import com.derivedmed.proj.model.Conf;

import java.util.List;

public interface ConfService extends Service {

    int createConf(Conf conf);

    Conf getById(int id);

    boolean update(Conf conf);

    List<Conf> getAll();

    boolean delete(int id);

    boolean deleteAll();
}

package com.derivedmed.proj.dao;

import java.util.List;

public interface CrudDao<T> extends Dao{

    boolean create(T t);

    T get(int id);

    boolean update(T t);

    boolean delete(int id);

    List<T> getAll();

    boolean clearAll();
}

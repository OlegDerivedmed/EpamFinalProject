package com.derivedmed.proj.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CrudDao<T> extends Dao{

    boolean create(T t);

    T get(int id) throws NoSuchMethodException, InvocationTargetException;

    boolean update(T t);

    boolean delete(int id);

    List<T> getAll() throws NoSuchMethodException, InvocationTargetException;

    boolean clearAll();
}

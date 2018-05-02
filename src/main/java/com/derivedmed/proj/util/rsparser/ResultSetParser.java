package com.derivedmed.proj.util.rsparser;

import com.derivedmed.proj.util.annotations.Column;
import com.derivedmed.proj.util.annotations.Model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultSetParser {
    private static ResultSetParser ourInstance = new ResultSetParser();

    public static ResultSetParser getInstance() {
        return ourInstance;
    }

    private ResultSetParser() {
    }

    public <T> ArrayList<T> parse(ResultSet rs, T instance) throws IllegalAccessException, SQLException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ArrayList<T> result = new ArrayList<>();
        Class clazz = instance.getClass();
        T resultUnit = instance;
        if (!resultUnit.getClass().isAnnotationPresent(Model.class)) {
            throw new IllegalAccessException();
        }
        while (rs.next()) {
            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(Column.class)) {
                    String name = f.getAnnotation(Column.class).name();
                    f.setAccessible(true);
                    f.set(resultUnit, rs.getObject(name));
                }
            }
            result.add(resultUnit);
            resultUnit = (T) clazz.getConstructor().newInstance();
        }
        return result;
    }
}

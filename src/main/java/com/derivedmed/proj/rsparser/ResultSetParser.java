package com.derivedmed.proj.rsparser;

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

    public Object parse(ResultSet rs, Class clazz) throws IllegalAccessException, SQLException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ArrayList<Object> result = new ArrayList<>();
        Object obj = clazz.getConstructor().newInstance();
        if (!clazz.isAnnotationPresent(Model.class)) {
            throw new IllegalAccessException();
        }
        while (rs.next()) {
            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(Column.class)) {
                    String name = f.getAnnotation(Column.class).name();
                    f.setAccessible(true);
                    f.set(obj, rs.getObject(name));
                }
            }
            result.add(obj);
            obj = clazz.getConstructor().newInstance();
        }
        if (result.size()==1) {
            return result.get(0);
        }
        else return result;
    }
}

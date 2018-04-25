package com.derivedmed.proj.util;

import com.derivedmed.proj.util.annotations.Column;
import com.derivedmed.proj.util.annotations.Model;

import java.lang.reflect.Field;
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

    public Object parse(ResultSet rs, Class cl) throws IllegalAccessException, SQLException, InstantiationException {
        ArrayList<Object> result = new ArrayList<>();
        Object obj = cl.newInstance();
        if (!cl.isAnnotationPresent(Model.class)) {
            throw new IllegalAccessException();
        }
        while (rs.next()) {
            for (Field f : cl.getDeclaredFields()) {
                if (f.isAnnotationPresent(Column.class)) {
                    String name = f.getAnnotation(Column.class).name();
                    f.setAccessible(true);
                    f.set(obj, rs.getObject(name));
                }
            }
            result.add(obj);
            obj = cl.newInstance();
        }
        if (result.size()==1) {
            return result.get(0);
        }
        else return result;
    }
}

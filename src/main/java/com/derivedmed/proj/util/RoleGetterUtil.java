package com.derivedmed.proj.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RoleGetterUtil {
    private static Logger LOGGER = LogManager.getLogger(RoleGetterUtil.class);
    private static RoleGetterUtil ourInstance = new RoleGetterUtil();

    public static RoleGetterUtil getInstance() {
        return ourInstance;
    }

    private RoleGetterUtil() {
    }
    public static String getRole(int id){
        Properties properties = new Properties();
        try (InputStream is = new FileInputStream("src/main/resources/role.properties")){
            properties.load(is);
        } catch (IOException e) {
            LOGGER.error("can`t read properties file",e);
        }
        return properties.getProperty(""+id);
    }
}

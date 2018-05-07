package com.derivedmed.proj.test;

import com.derivedmed.proj.dao.ConfDao;
import com.derivedmed.proj.dao.ReportDao;
import com.derivedmed.proj.dao.UserDao;
import com.derivedmed.proj.factory.DaoFactory;
import com.derivedmed.proj.model.Report;

public class TestMain {
    public static void main(String[] args){
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        ReportDao reportDao = DaoFactory.getInstance().getReportDao();
        ConfDao confDao = DaoFactory.getInstance().getConfDao();
        for (Report report : reportDao.getReportsByUserId(1)){
            System.out.println(report);
        }

    }
}

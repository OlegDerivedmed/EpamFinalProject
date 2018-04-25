package com.derivedmed.proj.services;

public class ReportServiceImpl implements ReportService {
    private static ReportServiceImpl ourInstance = new ReportServiceImpl();

    public static ReportServiceImpl getInstance() {
        return ourInstance;
    }

    private ReportServiceImpl() {
    }
}

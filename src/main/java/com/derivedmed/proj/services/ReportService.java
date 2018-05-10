package com.derivedmed.proj.services;

import com.derivedmed.proj.model.Report;

import java.util.List;

public interface ReportService extends Service {

    int create(Report report);

    Report getById(int id);

    boolean update(Report report);

    boolean delete(int id);

    boolean clearAll();

    List<Report> getAll();

    List<Report> getByUserId(int id);

    boolean offerReport(int speakerId, int reportId, int roleId);

    boolean confirmOffer(int userId,int reportId);

    boolean setReportToSpeaker(int speakerId, int reportId);
}

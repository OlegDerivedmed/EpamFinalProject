package com.derivedmed.proj.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Conf {
    private int id;
    private String name;
    private String place;
    private Timestamp date;
    private ArrayList<Report> reports;

    public Conf(int id, String name, String place, Timestamp date) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.date = date;
        reports = new ArrayList<>();
    }

    public void addReport(Report report){
        reports.add(report);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public Timestamp getDate() {
        return date;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }
}

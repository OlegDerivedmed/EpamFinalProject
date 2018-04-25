package com.derivedmed.proj.model;

import com.derivedmed.proj.util.annotations.Column;
import com.derivedmed.proj.util.annotations.Model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

@Model
public class Conf {

    @Column(name = "conf_id")
    private int id;

    @Column(name = "conf_name")
    private String name;

    @Column(name = "conf_place")
    private String place;

    @Column(name = "conf_date")
    private Timestamp date;

    private ArrayList<Report> reports;

    public Conf(int id, String name, String place, Timestamp date) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.date = date;
        reports = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public Conf() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conf)) return false;
        Conf conf = (Conf) o;
        return id == conf.id &&
                Objects.equals(name, conf.name) &&
                Objects.equals(place, conf.place) &&
                Objects.equals(date, conf.date) &&
                Objects.equals(reports, conf.reports);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, place, date, reports);
    }

    @Override
    public String toString() {
        return "Conf{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", date=" + date +
                ", reports=" + reports +
                '}';
    }
}

package com.derivedmed.proj.model;

import com.derivedmed.proj.util.annotations.Column;
import com.derivedmed.proj.util.annotations.Model;

import java.util.Objects;

@Model
public class Report {
    @Column(name = "report_id")
    private int id;

    @Column(name = "conf_id")
    private int conf_id;

    @Column(name = "report_name")
    private String report_name;

    @Column(name = "report_desk")
    private String report_description;

    public Report() {
    }

    public Report(int id, int conf_id, String report_name, String report_description) {
        this.id = id;
        this.conf_id = conf_id;
        this.report_name = report_name;
        this.report_description = report_description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConf_id() {
        return conf_id;
    }

    public void setConf_id(int conf_id) {
        this.conf_id = conf_id;
    }

    public String getReport_name() {
        return report_name;
    }

    public void setReport_name(String report_name) {
        this.report_name = report_name;
    }

    public String getReport_description() {
        return report_description;
    }

    public void setReport_description(String report_description) {
        this.report_description = report_description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Report)) return false;
        Report report = (Report) o;
        return id == report.id &&
                conf_id == report.conf_id &&
                Objects.equals(report_name, report.report_name) &&
                Objects.equals(report_description, report.report_description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, conf_id, report_name, report_description);
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", conf_id=" + conf_id +
                ", report_name='" + report_name + '\'' +
                ", report_description='" + report_description + '\'' +
                '}';
    }
}

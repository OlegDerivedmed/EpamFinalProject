package com.derivedmed.proj.model;

import java.util.Objects;

public class Report {
    private int id;
    private int conf_id;
    private String report_name;
    private String report_description;
    private Boolean isOffered;
    private User user;

    public int getConf_id() {
        return conf_id;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;

    }

    public void setConf_id(int conf_id) {
        this.conf_id = conf_id;
    }

    public void setReport_name(String report_name) {
        this.report_name = report_name;
    }

    public void setReport_description(String report_description) {
        this.report_description = report_description;
    }

    public void setOffered(Boolean offered) {
        isOffered = offered;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReport_name() {
        return report_name;
    }

    public String getReport_description() {
        return report_description;
    }

    public Boolean getOffered() {
        return isOffered;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Report)) return false;
        Report report = (Report) o;
        return id == report.id &&
                conf_id == report.conf_id &&
                Objects.equals(report_name, report.report_name) &&
                Objects.equals(report_description, report.report_description) &&
                Objects.equals(isOffered, report.isOffered) &&
                Objects.equals(user, report.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, conf_id, report_name, report_description, isOffered, user);
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", conf_id=" + conf_id +
                ", report_name='" + report_name + '\'' +
                ", report_description='" + report_description + '\'' +
                ", isOffered=" + isOffered +
                ", user=" + user +
                '}';
    }
}

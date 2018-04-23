package com.derivedmed.proj.model;

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
}

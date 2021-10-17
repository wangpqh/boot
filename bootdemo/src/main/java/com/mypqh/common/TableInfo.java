package com.mypqh.common;

public class TableInfo {
    String date;
    String week;
    int isWork;//holiday 0 ;work 1;
    int status;//early 0;normal 1;late 2;
    String other;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public int getIsWork() {
        return isWork;
    }

    public void setIsWork(int isWork) {
        this.isWork = isWork;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}

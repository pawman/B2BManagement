package com.pawman.b2bmanagement.model;

import java.time.LocalDateTime;

public class DataModel {
    private int day;
    private int month;
    private int year;

    public DataModel() {
    }

    public DataModel(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public DataModel(LocalDateTime localDateTime) {
        this.day = localDateTime.getDayOfMonth();
        this.month = localDateTime.getMonthValue();
        this.year = localDateTime.getYear();
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

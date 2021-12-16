package com.cs348.cbnb.model;

public class Details {
    private String university;

    private String date;

    private String sort;

    public Details() {
    }

    public Details(String university, String date) {
        this.university = university;
        this.date = date;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}

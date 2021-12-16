package com.cs348.cbnb.model;

import javax.persistence.*;

@Entity
@Table(name = "University")
public class University {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "building_cnt")
    private int buildingCnt;

    @Column(name = "guest_cnt")
    private int guestCnt;

    public University() {

    }

    public University(String name, String city, String state, String country, int buildingCnt, int guestCnt) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
        this.buildingCnt = buildingCnt;
        this.guestCnt = guestCnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBuildingCnt() {
        return buildingCnt;
    }

    public void setBuildingCnt(int buildingCnt) {
        this.buildingCnt = buildingCnt;
    }

    public int getGuestCnt() {
        return guestCnt;
    }

    public void setGuestCnt(int guestCnt) {
        this.guestCnt = guestCnt;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", buildingCnt=" + buildingCnt +
                ", guestCnt=" + guestCnt +
                '}';
    }
}

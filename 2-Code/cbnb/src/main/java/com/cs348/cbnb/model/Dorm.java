package com.cs348.cbnb.model;

import javax.persistence.*;

@Entity
@Table(name = "Dorm")
public class Dorm {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "uID")
    private String uid;

    @Column(name = "total_guests")
    private int totalGuests;

    @Column(name = "rooms_available")
    private int roomsAvail;

    @Column(name = "dorm_type")
    private String dormType;

    public Dorm() {
    }

    public Dorm(String name, String address, String uid, int totalGuests, int roomsAvail, String dormType) {
        this.name = name;
        this.address = address;
        this.uid = uid;
        this.totalGuests = totalGuests;
        this.roomsAvail = roomsAvail;
        this.dormType = dormType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getTotalGuests() {
        return totalGuests;
    }

    public void setTotalGuests(int totalGuests) {
        this.totalGuests = totalGuests;
    }

    public int getRoomsAvail() {
        return roomsAvail;
    }

    public void setRoomsAvail(int roomsAvail) {
        this.roomsAvail = roomsAvail;
    }

    public String getDormType() {
        return dormType;
    }

    public void setDormType(String dormType) {
        this.dormType = dormType;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", uid=" + uid +
                ", totalGuests=" + totalGuests +
                ", roomsAvail=" + roomsAvail +
                ", dormType='" + dormType + '\'' +
                '}';
    }
}

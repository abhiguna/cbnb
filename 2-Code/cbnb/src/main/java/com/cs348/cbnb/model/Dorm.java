package com.cs348.cbnb.model;

import javax.persistence.*;

@Entity
@Table(name = "Dorm")
public class Dorm {
    @Id
    @Column(name = "dorm_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "uID")
    private Long uid;

    @Column(name = "total_guests")
    private int totalGuests;

    @Column(name = "rooms_available")
    private int roomsAvail;

    @Column(name = "dorm_type")
    private String dormType;

    public Dorm() {
    }

    public Dorm(Long id, String name, String address, Long uid, int totalGuests, int roomsAvail, String dormType) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.uid = uid;
        this.totalGuests = totalGuests;
        this.roomsAvail = roomsAvail;
        this.dormType = dormType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", uid=" + uid +
                ", totalGuests=" + totalGuests +
                ", roomsAvail=" + roomsAvail +
                ", dormType='" + dormType + '\'' +
                '}';
    }
}
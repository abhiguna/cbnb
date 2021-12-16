package com.cs348.cbnb.model;

import javax.persistence.*;

@Entity
@Table(name = "Guest")
public class Guest {
    @Id
    @Column(name = "guest_id")
    private String guestID;

    @Column(name = "name")
    private String name;

    public Guest() {
    }

    public Guest(String guestID, String name) {
        this.guestID = guestID;
        this.name = name;
    }

    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

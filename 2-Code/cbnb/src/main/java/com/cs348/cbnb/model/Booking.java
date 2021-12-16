package com.cs348.cbnb.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Booking")
@IdClass(CompositeKey.class)
public class Booking {
    @Id
    @Column(name = "gID")
    private String gID;

    @Id
    @Column(name = "rID")
    private String rID;

    @Id
    @Column(name = "dID")
    private String dID;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "num_guests")
    private int numGuests;

    public Booking() {
    }

    public Booking(String gID, String rID, String dID, LocalDate bookingDate, int numGuests) {
        this.gID = gID;
        this.rID = rID;
        this.dID = dID;
        this.bookingDate = bookingDate;
        this.numGuests = numGuests;
    }

    public String getgID() {
        return gID;
    }

    public void setgID(String gID) {
        this.gID = gID;
    }

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
    }

    public String getdID() {
        return dID;
    }

    public void setdID(String dID) {
        this.dID = dID;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }
}

package com.cs348.cbnb.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Room")
public class Room {
    @Id
    @Column(name = "room_id")
    private Long id;

    @Column(name = "dID")
    private Long dormId;

    @Column(name = "open_date")
    private LocalDate openDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "next_available_date")
    private LocalDate nextAvailDate;

    @Column(name = "max_capacity")
    private int maxCapacity;

    public Room() {
    }

    public Room(Long id, Long dormId, LocalDate openDate, LocalDate endDate, LocalDate nextAvailDate, int maxCapacity) {
        this.id = id;
        this.dormId = dormId;
        this.openDate = openDate;
        this.endDate = endDate;
        this.nextAvailDate = nextAvailDate;
        this.maxCapacity = maxCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDormId() {
        return dormId;
    }

    public void setDormId(Long dormId) {
        this.dormId = dormId;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getNextAvailDate() {
        return nextAvailDate;
    }

    public void setNextAvailDate(LocalDate nextAvailDate) {
        this.nextAvailDate = nextAvailDate;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", dormId=" + dormId +
                ", openDate=" + openDate +
                ", endDate=" + endDate +
                ", nextAvailDate=" + nextAvailDate +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}

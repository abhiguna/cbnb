package com.cs348.cbnb.model;

public class BookingInfo {
    private String university;

    private String dormName;

    private String address;

    private int roomCap;

    private String roomNum;

    private String bookingDate;

    private String guestName;

    private String guestEmail;

    public BookingInfo() {
    }

    public BookingInfo(String university, String dormName, String address, int roomCap, String roomNum, String bookingDate, String guestName, String guestEmail) {
        this.university = university;
        this.dormName = dormName;
        this.address = address;
        this.roomCap = roomCap;
        this.roomNum = roomNum;
        this.bookingDate = bookingDate;
        this.guestName = guestName;
        this.guestEmail = guestEmail;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoomCap() {
        return roomCap;
    }

    public void setRoomCap(int roomCap) {
        this.roomCap = roomCap;
    }

    public String getRoomType() {
        return roomNum;
    }

    public void setRoomType(String roomType) {
        this.roomNum = roomType;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    @Override
    public String toString() {
        return "BookingInfo{" +
                "university='" + university + '\'' +
                ", dormName='" + dormName + '\'' +
                ", address='" + address + '\'' +
                ", roomCap=" + roomCap +
                ", roomType='" + roomNum + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", guestName='" + guestName + '\'' +
                ", guestEmail='" + guestEmail + '\'' +
                '}';
    }
}

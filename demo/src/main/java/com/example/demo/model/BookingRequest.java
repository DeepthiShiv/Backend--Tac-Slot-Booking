package com.example.demo.model;

public class BookingRequest {
    private String tacId;
    private String slotDate;
    private String slotTime;

    // Getters and Setters
    public String getTacId() {
        return tacId;
    }

    public void setTacId(String tacId) {
        this.tacId = tacId;
    }

    public String getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(String slotDate) {
        this.slotDate = slotDate;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }
}
package com.pgytl_pglogin.Model.Holiday;
import com.google.gson.annotations.SerializedName;
public class HolidayResult {
    @SerializedName("id")
    private String id;
    @SerializedName("CheckInDate")
    private String checkInDate;
    @SerializedName("CheckOutDate")
    private String checkOutDate;
    @SerializedName("NoofPerson")
    private String noofPerson;
    @SerializedName("ExtraBed")
    private String extraBed;
    @SerializedName("HolidayDestination")
    private String holidayDestination;
    @SerializedName("TotalNights")
    private String totalNights;
    @SerializedName("email")
    private String email;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCheckInDate() {
        return checkInDate;
    }
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }
    public String getCheckOutDate() {
        return checkOutDate;
    }
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    public String getNoofPerson() {
        return noofPerson;
    }
    public void setNoofPerson(String noofPerson) {
        this.noofPerson = noofPerson;
    }
    public String getExtraBed() {
        return extraBed;
    }
    public void setExtraBed(String extraBed) {
        this.extraBed = extraBed;
    }
    public String getHolidayDestination() {
        return holidayDestination;
    }
    public void setHolidayDestination(String holidayDestination) {
        this.holidayDestination = holidayDestination;
    }
    public String getTotalNights() {
        return totalNights;
    }
    public void setTotalNights(String totalNights) {
        this.totalNights = totalNights;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

package com.pgytl_pglogin.Model.Point;
import com.google.gson.annotations.SerializedName;
public class PointResult {
    @SerializedName("id")
    private String id;
    @SerializedName("Yearly_Point")
    private String yearlyPoint;
    @SerializedName("Years_Number")
    private String yearsNumber;
    @SerializedName("Total_point_number")
    private String totalPointNumber;
    @SerializedName("Add_ons_status")
    private String addOnsStatus;
    @SerializedName("email")
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYearlyPoint() {
        return yearlyPoint;
    }

    public void setYearlyPoint(String yearlyPoint) {
        this.yearlyPoint = yearlyPoint;
    }

    public String getYearsNumber() {
        return yearsNumber;
    }

    public void setYearsNumber(String yearsNumber) {
        this.yearsNumber = yearsNumber;
    }

    public String getTotalPointNumber() {
        return totalPointNumber;
    }

    public void setTotalPointNumber(String totalPointNumber) {
        this.totalPointNumber = totalPointNumber;
    }

    public String getAddOnsStatus() {
        return addOnsStatus;
    }

    public void setAddOnsStatus(String addOnsStatus) {
        this.addOnsStatus = addOnsStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

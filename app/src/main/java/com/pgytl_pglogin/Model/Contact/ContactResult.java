package com.pgytl_pglogin.Model.Contact;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactResult {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("OfficeAddress")
    @Expose
    private String officeAddress;
    @SerializedName("PermanentAddress")
    @Expose
    private String permanentAddress;
    @SerializedName("PresentAddress")
    @Expose
    private String presentAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

}


package com.pgytl_pglogin.Model.PG_Info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("PrivilegedGuestID")
    @Expose
    private String privilegedGuestID;
    @SerializedName("StartsFrom")
    @Expose
    private String startsFrom;
    @SerializedName("Anniversary")
    @Expose
    private String anniversary;
    @SerializedName("NoofDepedndents")
    @Expose
    private String noofDepedndents;
    @SerializedName("NoOfYears")
    @Expose
    private String noOfYears;
    @SerializedName("DateofBirth")
    @Expose
    private String dateofBirth;
    @SerializedName("Age")
    @Expose
    private String age;
    @SerializedName("DateOfJoining")
    @Expose
    private String dateOfJoining;
    @SerializedName("END")
    @Expose
    private String end;
    @SerializedName("Boys")
    @Expose
    private String boys;
    @SerializedName("Girls")
    @Expose
    private String girls;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivilegedGuestID() {
        return privilegedGuestID;
    }

    public void setPrivilegedGuestID(String privilegedGuestID) {
        this.privilegedGuestID = privilegedGuestID;
    }

    public String getStartsFrom() {
        return startsFrom;
    }

    public void setStartsFrom(String startsFrom) {
        this.startsFrom = startsFrom;
    }

    public String getAnniversary() {
        return anniversary;
    }

    public void setAnniversary(String anniversary) {
        this.anniversary = anniversary;
    }

    public String getNoofDepedndents() {
        return noofDepedndents;
    }

    public void setNoofDepedndents(String noofDepedndents) {
        this.noofDepedndents = noofDepedndents;
    }

    public String getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(String noOfYears) {
        this.noOfYears = noOfYears;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getBoys() {
        return boys;
    }

    public void setBoys(String boys) {
        this.boys = boys;
    }

    public String getGirls() {
        return girls;
    }

    public void setGirls(String girls) {
        this.girls = girls;
    }

}

package com.pgytl_pglogin.Model.Booking;
import com.google.gson.annotations.SerializedName;
public class BookingResult {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("pg_id")
    private String pgId;
    @SerializedName("destination")
    private String destination;
    @SerializedName("date")
    private String date;
    @SerializedName("email")
    private String email;

    public BookingResult(String id, String name, String pgId, String destination, String date, String email) {
        this.id = id;
        this.name = name;
        this.pgId = pgId;
        this.destination = destination;
        this.date = date;
        this.email = email;
    }

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
    public String getPgId() {
        return pgId;
    }
    public void setPgId(String pgId) {
        this.pgId = pgId;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

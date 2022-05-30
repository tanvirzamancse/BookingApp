package com.pgytl_pglogin.Model.Holiday;

public class HolidayRequest {
    private String email;

    public HolidayRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

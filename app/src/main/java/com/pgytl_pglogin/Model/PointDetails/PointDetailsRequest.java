package com.pgytl_pglogin.Model.PointDetails;

public class PointDetailsRequest {
    private String email;

    public PointDetailsRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

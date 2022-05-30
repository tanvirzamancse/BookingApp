package com.pgytl_pglogin.Model.Point;

public class PointRequest {
    private String email;

    public PointRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

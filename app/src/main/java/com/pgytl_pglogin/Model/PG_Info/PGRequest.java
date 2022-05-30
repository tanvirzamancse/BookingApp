package com.pgytl_pglogin.Model.PG_Info;

public class PGRequest {
    private String email;

    public PGRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

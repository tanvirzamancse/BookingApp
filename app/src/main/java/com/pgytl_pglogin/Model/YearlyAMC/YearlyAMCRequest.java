package com.pgytl_pglogin.Model.YearlyAMC;

public class YearlyAMCRequest {
    private String email;

    public YearlyAMCRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

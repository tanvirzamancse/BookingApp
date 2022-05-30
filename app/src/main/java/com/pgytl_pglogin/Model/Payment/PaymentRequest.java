package com.pgytl_pglogin.Model.Payment;

public class PaymentRequest {
    private String email;

    public PaymentRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

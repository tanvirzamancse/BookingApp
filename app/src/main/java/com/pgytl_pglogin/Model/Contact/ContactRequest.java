package com.pgytl_pglogin.Model.Contact;

public class ContactRequest {
    private String email;

    public ContactRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

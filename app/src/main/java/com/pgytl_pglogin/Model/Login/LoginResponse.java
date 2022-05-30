package com.pgytl_pglogin.Model.Login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("email")
    private String email;
    @SerializedName("success")
    private Integer success;
    @SerializedName("status")
    private Integer status;
    @SerializedName("message")
    private String message;

    public LoginResponse(String email, Integer success, Integer status, String message) {
        this.email = email;
        this.success = success;
        this.status = status;
        this.message = message;
    }

    public LoginResponse() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

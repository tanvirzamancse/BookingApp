package com.pgytl_pglogin.Model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentResult {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("Privilegedguestamount")
    @Expose
    private String privilegedguestamount;
    @SerializedName("AdminAndLegalFees")
    @Expose
    private String adminAndLegalFees;
    @SerializedName("TotalCost")
    @Expose
    private String totalCost;
    @SerializedName("PaidAmount")
    @Expose
    private String paidAmount;
    @SerializedName("Methodofpayment")
    @Expose
    private String methodofpayment;
    @SerializedName("BalanceAmount")
    @Expose
    private String balanceAmount;
    @SerializedName("email")
    @Expose
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrivilegedguestamount() {
        return privilegedguestamount;
    }

    public void setPrivilegedguestamount(String privilegedguestamount) {
        this.privilegedguestamount = privilegedguestamount;
    }

    public String getAdminAndLegalFees() {
        return adminAndLegalFees;
    }

    public void setAdminAndLegalFees(String adminAndLegalFees) {
        this.adminAndLegalFees = adminAndLegalFees;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getMethodofpayment() {
        return methodofpayment;
    }

    public void setMethodofpayment(String methodofpayment) {
        this.methodofpayment = methodofpayment;
    }

    public String getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(String balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

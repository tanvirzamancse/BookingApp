
package com.pgytl_pglogin.Model.Payment;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentResponse {
    @SerializedName("result")
    private List<PaymentResult> result = null;

    public PaymentResponse(List<PaymentResult> result) {
        this.result = result;
    }

    public List<PaymentResult> getResult() {
        return result;
    }

    public void setResult(List<PaymentResult> result) {
        this.result = result;
    }
}

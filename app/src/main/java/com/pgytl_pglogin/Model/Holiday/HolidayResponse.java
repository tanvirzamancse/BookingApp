package com.pgytl_pglogin.Model.Holiday;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HolidayResponse {
    @SerializedName("result")
    private List<HolidayResult> result = null;

    public HolidayResponse(List<HolidayResult> result) {
        this.result = result;
    }

    public List<HolidayResult> getResult() {
        return result;
    }

    public void setResult(List<HolidayResult> result) {
        this.result = result;
    }
}

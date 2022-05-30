package com.pgytl_pglogin.Model.PG_Info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pgytl_pglogin.Model.PG_Info.Result;

import java.util.List;

public class PGResponse {
    @SerializedName("result")
    @Expose
    private List<Result> result = null;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
}

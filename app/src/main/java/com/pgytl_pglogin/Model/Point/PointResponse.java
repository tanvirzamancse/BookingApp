package com.pgytl_pglogin.Model.Point;
import java.util.List;
import com.google.gson.annotations.SerializedName;
public class PointResponse {
    @SerializedName("result")
    private List<PointResult> result = null;

    public PointResponse(List<PointResult> result) {
        this.result = result;
    }
    public List<PointResult> getResult() {
        return result;
    }
    public void setResult(List<PointResult> result) {
        this.result = result;
    }
}

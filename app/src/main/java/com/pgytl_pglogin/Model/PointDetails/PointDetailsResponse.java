package com.pgytl_pglogin.Model.PointDetails;
import java.util.List;
import com.google.gson.annotations.SerializedName;
public class PointDetailsResponse {
    @SerializedName("result")
    private List<PointDetailsRresult> result = null;
    public List<PointDetailsRresult> getResult() {
        return result;
    }
    public void setResult(List<PointDetailsRresult> result) {
        this.result = result;
    }

}

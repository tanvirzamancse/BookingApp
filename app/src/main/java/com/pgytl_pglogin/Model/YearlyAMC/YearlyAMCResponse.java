
package com.pgytl_pglogin.Model.YearlyAMC;
import com.google.gson.annotations.SerializedName;
import java.util.List;
public class YearlyAMCResponse {
    @SerializedName("result")
    private List<YearlyAMCResult> result = null;
    public List<YearlyAMCResult> getResult() {
        return result;
    }
    public void setResult(List<YearlyAMCResult> result) {
        this.result = result;
    }

}

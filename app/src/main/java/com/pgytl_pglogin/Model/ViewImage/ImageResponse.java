package com.pgytl_pglogin.Model.ViewImage;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
public class ImageResponse {

    @SerializedName("result")
    @Expose
    private List<ImageResult> result = null;

    public ImageResponse(List<ImageResult> result) {
        this.result = result;
    }

    public List<ImageResult> getResult() {
        return result;
    }

    public void setResult(List<ImageResult> result) {
        this.result = result;
    }
}

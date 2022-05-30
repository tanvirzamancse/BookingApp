package com.pgytl_pglogin.Model.ViewImage;
import android.net.Uri;
import com.google.gson.annotations.SerializedName;

public class ImageResult {
    @SerializedName("image_url")
    private String imageUrl;
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}

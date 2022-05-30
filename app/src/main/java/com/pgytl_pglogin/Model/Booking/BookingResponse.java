
package com.pgytl_pglogin.Model.Booking;
import java.util.List;
import com.google.gson.annotations.SerializedName;
public class BookingResponse {
    @SerializedName("result")
    private List<BookingResult> result = null;

    public BookingResponse(List<BookingResult> result) {
        this.result = result;
    }

    public List<BookingResult> getResult() {
        return result;
    }

    public void setResult(List<BookingResult> result) {
        this.result = result;
    }

}


package com.pgytl_pglogin.Model.Contact;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.pgytl_pglogin.Model.PG_Info.Result;

public class ContactResponse {

    @SerializedName("result")

    private List<ContactResult> result = null;

    public ContactResponse(List<ContactResult> result) {
        this.result = result;
    }

    public List<ContactResult> getResult() {
        return result;
    }

    public void setResult(List<ContactResult> result) {
        this.result = result;
    }
}

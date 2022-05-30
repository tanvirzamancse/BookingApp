package com.pgytl_pglogin.View.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.pgytl_pglogin.Model.PointDetails.PointDetailsRequest;
import com.pgytl_pglogin.Model.PointDetails.PointDetailsResponse;
import com.pgytl_pglogin.Model.PointDetails.PointDetailsRresult;
import com.pgytl_pglogin.Model.YearlyAMC.YearlyAMCRequest;
import com.pgytl_pglogin.Model.YearlyAMC.YearlyAMCResult;
import com.pgytl_pglogin.R;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.ApiService;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class PointDetails extends AppCompatActivity {
    private TextView y1,y2,y3,y4,y5,y6,y7,y8,y9,y10;
    private TextView tp1,tp2,tp3,tp4,tp5,tp6,tp7,tp8,tp9,tp10;
    private TextView up1,up2,up3,up4,up5,up6,up7,up8,up9,up10;
    private TextView bp1,bp2,bp3,bp4,bp5,bp6,bp7,bp8,bp9,bp10;
    private TextView pa1,pa2,pa3,pa4,pa5,pa6,pa7,pa8,pa9,pa10;
    private ApiService apiServicePointDetails;
    public static String  a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_details);
        findView();
        apiServicePointDetails= RetrofitClient.getPointDetails().create(ApiService.class);
        Intent intent=getIntent();
        a=intent.getStringExtra("email");
        PointDetailsRequest pointDetailsRequest=new PointDetailsRequest(a);
        apiServicePointDetails.getPointDetailsResponse(pointDetailsRequest).enqueue(new Callback<PointDetailsResponse>() {
            @Override
            public void onResponse(Call<PointDetailsResponse> call, Response<PointDetailsResponse> response) {
                List<PointDetailsRresult> list=response.body().getResult();
                y1.setText(list.get(0).getTotalPointYear1());
                y2.setText(list.get(0).getTotalPointYear2());
                y3.setText(list.get(0).getTotalPointYear3());
                y4.setText(list.get(0).getTotalPointYear4());
                y5.setText(list.get(0).getTotalPointYear5());
                y6.setText(list.get(0).getTotalPointYear6());
                y7.setText(list.get(0).getTotalPointYear7());
                y8.setText(list.get(0).getTotalPointYear8());
                y9.setText(list.get(0).getTotalPointYear9());
                y10.setText(list.get(0).getTotalPointYear10());

                tp1.setText(list.get(0).getTotalPointTotalPoint1());
                tp2.setText(list.get(0).getTotalPointTotalPoint2());
                tp3.setText(list.get(0).getTotalPointTotalPoint3());
                tp4.setText(list.get(0).getTotalPointTotalPoint4());
                tp5.setText(list.get(0).getTotalPointTotalPoint5());
                tp6.setText(list.get(0).getTotalPointTotalPoint6());
                tp7.setText(list.get(0).getTotalPointTotalPoint7());
                tp8.setText(list.get(0).getTotalPointTotalPoint8());
                tp9.setText(list.get(0).getTotalPointTotalPoint9());
                tp10.setText(list.get(0).getTotalPointTotalPoint10());

                up1.setText(list.get(0).getTotalPointUsedPoint1());
                up2.setText(list.get(0).getTotalPointUsedPoint2());
                up3.setText(list.get(0).getTotalPointUsedPoint3());
                up4.setText(list.get(0).getTotalPointUsedPoint4());
                up5.setText(list.get(0).getTotalPointUsedPoint5());
                up6.setText(list.get(0).getTotalPointUsedPoint6());
                up7.setText(list.get(0).getTotalPointUsedPoint7());
                up8.setText(list.get(0).getTotalPointUsedPoint8());
                up9.setText(list.get(0).getTotalPointUsedPoint9());
                up10.setText(list.get(0).getTotalPointUsedPoint10());


                bp1.setText(list.get(0).getTotalPointBalancePoint1());
                bp2.setText(list.get(0).getTotalPointBalancePoint2());
                bp3.setText(list.get(0).getTotalPointBalancePoint3());
                bp4.setText(list.get(0).getTotalPointBalancePoint4());
                bp5.setText(list.get(0).getTotalPointBalancePoint5());
                bp6.setText(list.get(0).getTotalPointBalancePoint6());
                bp7.setText(list.get(0).getTotalPointBalancePoint7());
                bp8.setText(list.get(0).getTotalPointBalancePoint8());
                bp9.setText(list.get(0).getTotalPointBalancePoint9());
                bp10.setText(list.get(0).getTotalPointBalancePoint10());
                pa1.setText(list.get(0).getTotalPointPayAMC1());
                pa2.setText(list.get(0).getTotalPointPayAMC2());
                pa3.setText(list.get(0).getTotalPointPayAMC3());
                pa4.setText(list.get(0).getTotalPointPayAMC4());
                pa5.setText(list.get(0).getTotalPointPayAMC5());
                pa6.setText(list.get(0).getTotalPointPayAMC6());
                pa7.setText(list.get(0).getTotalPointPayAMC7());
                pa8.setText(list.get(0).getTotalPointPayAMC8());
                pa9.setText(list.get(0).getTotalPointPayAMC9());
                pa10.setText(list.get(0).getTotalPointPayAMC10());
            }
            @Override
            public void onFailure(Call<PointDetailsResponse> call, Throwable t) {

            }
        });

    }

    private void findView() {
        pa1=findViewById(R.id.pa1);
        pa2=findViewById(R.id.pa2);
        pa3=findViewById(R.id.pa3);
        pa4=findViewById(R.id.pa4);
        pa5=findViewById(R.id.pa5);
        pa6=findViewById(R.id.pa6);
        pa7=findViewById(R.id.pa7);
        pa8=findViewById(R.id.pa8);
        pa9=findViewById(R.id.pa9);
        pa10=findViewById(R.id.pa10);
        bp1=findViewById(R.id.bp1);
        bp2=findViewById(R.id.bp2);
        bp3=findViewById(R.id.bp3);
        bp4=findViewById(R.id.bp4);
        bp5=findViewById(R.id.bp5);
        bp6=findViewById(R.id.bp6);
        bp7=findViewById(R.id.bp7);
        bp8=findViewById(R.id.bp8);
        bp9=findViewById(R.id.bp9);
        bp10=findViewById(R.id.bp10);
        up1=findViewById(R.id.up1);
        up2=findViewById(R.id.up2);
        up3=findViewById(R.id.up3);
        up4=findViewById(R.id.up4);
        up5=findViewById(R.id.up5);
        up6=findViewById(R.id.up6);
        up7=findViewById(R.id.up7);
        up8=findViewById(R.id.up8);
        up9=findViewById(R.id.up9);
        up10=findViewById(R.id.up10);
        tp1=findViewById(R.id.tp1);
        tp2=findViewById(R.id.tp2);
        tp3=findViewById(R.id.tp3);
        tp4=findViewById(R.id.tp4);
        tp5=findViewById(R.id.tp5);
        tp6=findViewById(R.id.tp6);
        tp7=findViewById(R.id.tp7);
        tp8=findViewById(R.id.tp8);
        tp9=findViewById(R.id.tp9);
        tp10=findViewById(R.id.tp10);
        y1=findViewById(R.id.y1);
        y2=findViewById(R.id.y2);
        y3=findViewById(R.id.y3);
        y4=findViewById(R.id.y4);
        y5=findViewById(R.id.y5);
        y6=findViewById(R.id.y6);
        y7=findViewById(R.id.y7);
        y8=findViewById(R.id.y8);
        y9=findViewById(R.id.y9);
        y10=findViewById(R.id.y10);
    }
}
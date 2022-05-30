package com.pgytl_pglogin.View.Activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.pgytl_pglogin.Model.YearlyAMC.YearlyAMCRequest;
import com.pgytl_pglogin.Model.YearlyAMC.YearlyAMCResponse;
import com.pgytl_pglogin.Model.YearlyAMC.YearlyAMCResult;
import com.pgytl_pglogin.R;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.ApiService;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class YearlyAMC extends AppCompatActivity {
    private TextView y2019,y2020,y2021,y2022,y2023;
    private TextView amc1,amc2,amc3,amc4,amc5;
    private TextView status1,status2,status3,status4,status5;
    private ApiService apiServiceYearlyAMC;
    public static String  a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yearly_amc);

        status1=findViewById(R.id.status1);
        status2=findViewById(R.id.status2);
        status3=findViewById(R.id.status3);
        status4=findViewById(R.id.status4);
        status5=findViewById(R.id.status5);

        amc1=findViewById(R.id.amc1);
        amc2=findViewById(R.id.amc2);
        amc3=findViewById(R.id.amc3);
        amc4=findViewById(R.id.amc4);
        amc5=findViewById(R.id.amc5);

        y2019=findViewById(R.id.y2019);
        y2020=findViewById(R.id.y2020);
        y2021=findViewById(R.id.y2021);
        y2022=findViewById(R.id.y2022);
        y2023=findViewById(R.id.y2023);

        apiServiceYearlyAMC= RetrofitClient.getYearlyAMC().create(ApiService.class);
        Intent intent=getIntent();
        a=intent.getStringExtra("email");
        YearlyAMCRequest yearlyAMCRequest=new YearlyAMCRequest(a);
        apiServiceYearlyAMC.getYearlyAMCResponse(yearlyAMCRequest).enqueue(new Callback<YearlyAMCResponse>() {
            @Override
            public void onResponse(Call<YearlyAMCResponse> call, Response<YearlyAMCResponse> response) {
                List<YearlyAMCResult> list=response.body().getResult();

                y2019.setText(list.get(0).getYearlyAMCYears1());
                y2020.setText(list.get(0).getYearlyAMCYears2());
                y2021.setText(list.get(0).getYearlyAMCYears3());
                y2022.setText(list.get(0).getYearlyAMCYears4());
                y2023.setText(list.get(0).getYearlyAMCYears5());

                amc1.setText(list.get(0).getYearlyAMCAWC1());
                amc2.setText(list.get(0).getYearlyAMCAWC2());
                amc3.setText(list.get(0).getYearlyAMCAWC3());
                amc4.setText(list.get(0).getYearlyAMCAWC4());
                amc5.setText(list.get(0).getYearlyAMCAWC5());

                status1.setText(list.get(0).getYearlyAMCStatus1());
                status2.setText(list.get(0).getYearlyAMCStatus2());
                status3.setText(list.get(0).getYearlyAMCStatus3());
                status4.setText(list.get(0).getYearlyAMCStatus4());
                status5.setText(list.get(0).getYearlyAMCStatus5());
            }
            @Override
            public void onFailure(Call<YearlyAMCResponse> call, Throwable t) {
            }
        });


    }
}
package com.pgytl_pglogin.View.Fragment;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pgytl_pglogin.Model.PG_Info.PGRequest;
import com.pgytl_pglogin.Model.PG_Info.Result;
import com.pgytl_pglogin.Model.Point.PointRequest;
import com.pgytl_pglogin.Model.Point.PointResponse;
import com.pgytl_pglogin.Model.Point.PointResult;
import com.pgytl_pglogin.R;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.ApiService;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.RetrofitClient;
import com.pgytl_pglogin.View.Activity.PointDetails;
import com.pgytl_pglogin.View.Activity.YearlyAMC;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Point_Details extends Fragment {
    private TextView  Yearly_Point,Years,Total_Point,Yearly_AMC,Point_Details,Add_ons_Status;
    private ApiService apiService;
    public static String a;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_point_details, container, false);
        Yearly_Point=view.findViewById(R.id.Yearly_Point);
        Years=view.findViewById(R.id.Years);
        Total_Point=view.findViewById(R.id.Total_Point);
        Yearly_AMC=view.findViewById(R.id.Yearly_AMC);
        Point_Details=view.findViewById(R.id.Point_Details);
        Add_ons_Status=view.findViewById(R.id.Add_ons_Status);

        Yearly_AMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten=new Intent(getContext(), YearlyAMC.class);
                inten.putExtra("email",a);
                startActivity(inten);
            }
        });
        Point_Details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten=new Intent(getContext(), PointDetails.class);
                inten.putExtra("email",a);
                startActivity(inten);
            }
        });

        apiService= RetrofitClient.getPointRetrofit().create(ApiService.class);

        Intent intent=getActivity().getIntent();
         a=intent.getStringExtra("email");
        PointRequest pointRequest=new PointRequest(a);

        apiService.getPointResponse(pointRequest).enqueue(new Callback<PointResponse>() {
            @Override
            public void onResponse(Call<PointResponse> call, Response<PointResponse> response) {
                List<PointResult> list=response.body().getResult();
                Yearly_Point.setText(list.get(0).getYearlyPoint());
                Years.setText(list.get(0).getYearsNumber());
                Total_Point.setText(list.get(0).getTotalPointNumber());
//                Yearly_AMC.setText(list.get(0).);
//                Point_Details.setText(list.get(0).);
                Add_ons_Status.setText(list.get(0).getAddOnsStatus());
            }
            @Override
            public void onFailure(Call<PointResponse> call, Throwable t) {
            }
        });
        return view;
    }
}
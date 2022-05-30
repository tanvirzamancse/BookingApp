package com.pgytl_pglogin.View.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pgytl_pglogin.Model.Contact.ContactRequest;
import com.pgytl_pglogin.Model.Contact.ContactResult;
import com.pgytl_pglogin.Model.Holiday.HolidayRequest;
import com.pgytl_pglogin.Model.Holiday.HolidayResponse;
import com.pgytl_pglogin.Model.Holiday.HolidayResult;
import com.pgytl_pglogin.R;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.ApiService;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Holiday extends Fragment {
  private TextView Check_in_date,Check_out_date,No_of_person,Extra_Bed,Holiday_Destination,Total_Nights;
    private ApiService apiService;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_holiday, container, false);
        Check_in_date=view.findViewById(R.id.Check_in_date);
        Check_out_date=view.findViewById(R.id.Check_out_date);
        No_of_person=view.findViewById(R.id.No_of_person);
        Extra_Bed=view.findViewById(R.id.Extra_Bed);
        Holiday_Destination=view.findViewById(R.id.Holiday_Destination);
        Total_Nights=view.findViewById(R.id.Total_Nights);

        apiService= RetrofitClient.getHolidayretrofit().create(ApiService.class);

        Intent intent=getActivity().getIntent();
        String a=intent.getStringExtra("email");
        HolidayRequest holidayRequest=new HolidayRequest(a);

        apiService.getHolidayResponse(holidayRequest).enqueue(new Callback<HolidayResponse>() {
            @Override
            public void onResponse(Call<HolidayResponse> call, Response<HolidayResponse> response) {
                List<HolidayResult> list=response.body().getResult();
                Check_in_date.setText(list.get(0).getCheckInDate());
                Check_out_date.setText(list.get(0).getCheckOutDate());
                No_of_person.setText(list.get(0).getNoofPerson());
                Extra_Bed.setText(list.get(0).getExtraBed());
                Holiday_Destination.setText(list.get(0).getHolidayDestination());
                Total_Nights.setText(list.get(0).getTotalNights());
            }

            @Override
            public void onFailure(Call<HolidayResponse> call, Throwable t) {

            }
        });
        return view;
    }
}
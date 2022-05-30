package com.pgytl_pglogin.View.Fragment;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pgytl_pglogin.Model.Booking.BookingResponse;
import com.pgytl_pglogin.Model.Booking.BookingResult;
import com.pgytl_pglogin.Model.Holiday.HolidayRequest;
import com.pgytl_pglogin.R;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.ApiService;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.RetrofitClient;
import com.pgytl_pglogin.View.Activity.MainActivity;
import com.pgytl_pglogin.View.Adapter.BookingRequestAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Booking_Request extends Fragment {
    private RecyclerView recyclerView;
    private ApiService apiService;
    private BookingRequestAdapter bookingRequestAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_booking_request, container, false);
        recyclerView=view.findViewById(R.id.booking_recycler);

        apiService= RetrofitClient.getBookingretrofit().create(ApiService.class);

        apiService.getBookingResponse().enqueue(new Callback<BookingResponse>() {
            @Override
            public void onResponse(Call<BookingResponse> call, Response<BookingResponse> response) {
                List<BookingResult> mainresponse=response.body().getResult();
                LinearLayoutManager lm=new LinearLayoutManager(getActivity());
                bookingRequestAdapter=new BookingRequestAdapter(getActivity(),mainresponse);
                recyclerView.setLayoutManager(lm);
                recyclerView.setAdapter(bookingRequestAdapter);

            }
            @Override
            public void onFailure(Call<BookingResponse> call, Throwable t) {
            }
        });
        return view;
    }
}
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
import com.pgytl_pglogin.Model.Payment.PaymentRequest;
import com.pgytl_pglogin.Model.Payment.PaymentResponse;
import com.pgytl_pglogin.Model.Payment.PaymentResult;
import com.pgytl_pglogin.R;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.ApiService;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Payment_Details extends Fragment {
    private TextView pg_amount,fee,cost,paid_amount,payment_method,balance_amount;
    private ApiService apiService;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_payment_details, container, false);

        pg_amount=view.findViewById(R.id.pg_amount);
        fee=view.findViewById(R.id.fee);
        cost=view.findViewById(R.id.cost);
        paid_amount=view.findViewById(R.id.paid_amount);
        payment_method=view.findViewById(R.id.payment_method);
        balance_amount=view.findViewById(R.id.balance_amount);

        apiService= RetrofitClient.getPaymentretrofit().create(ApiService.class);

        Intent intent=getActivity().getIntent();
        String a=intent.getStringExtra("email");
        PaymentRequest paymentRequest=new PaymentRequest(a);

        apiService.getPymentResponse(paymentRequest).enqueue(new Callback<PaymentResponse>() {
            @Override
            public void onResponse(Call<PaymentResponse> call, Response<PaymentResponse> response) {
                List<PaymentResult> list=response.body().getResult();
                pg_amount.setText(list.get(0).getPrivilegedguestamount());
                fee.setText(list.get(0).getAdminAndLegalFees());
                cost.setText(list.get(0).getTotalCost());
                paid_amount.setText(list.get(0).getPaidAmount());
                payment_method.setText(list.get(0).getMethodofpayment());
                balance_amount.setText(list.get(0).getBalanceAmount());
            }
            @Override
            public void onFailure(Call<PaymentResponse> call, Throwable t) {
            }
        });
        return view;
    }
}
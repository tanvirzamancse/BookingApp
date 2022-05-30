package com.pgytl_pglogin.View.Fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.pgytl_pglogin.Model.Contact.ContactRequest;
import com.pgytl_pglogin.Model.Contact.ContactResponse;
import com.pgytl_pglogin.Model.Contact.ContactResult;
import com.pgytl_pglogin.R;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.ApiService;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Contact extends Fragment {
    private TextView Phone,Email,Office_Address,Permanent_address,Present_Address;
    private ApiService apiService;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_contact, container, false);
        Phone=view.findViewById(R.id.phone);
        Email=view.findViewById(R.id.email);
        Office_Address=view.findViewById(R.id.office_address);
        Permanent_address=view.findViewById(R.id.permanent_address);
        Present_Address=view.findViewById(R.id.present_address);

        apiService= RetrofitClient.getContactRetrofit().create(ApiService.class);

        Intent intent=getActivity().getIntent();
        String a=intent.getStringExtra("email");
        ContactRequest contactRequest=new ContactRequest(a);

        apiService.getContactResponse(contactRequest).enqueue(new Callback<ContactResponse>() {
            @Override
            public void onResponse(Call<ContactResponse> call, Response<ContactResponse> response) {

               List<ContactResult> list=response.body().getResult();
                Phone.setText(list.get(0).getPhone());
                Email.setText(list.get(0).getEmail());
                Office_Address.setText(list.get(0).getOfficeAddress());
                Permanent_address.setText(list.get(0).getPermanentAddress());
                Present_Address.setText(list.get(0).getPresentAddress());
            }
            @Override
            public void onFailure(Call<ContactResponse> call, Throwable t) {
            }
        });
        return view;



    }
}
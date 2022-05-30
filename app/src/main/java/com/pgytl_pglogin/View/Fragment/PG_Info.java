package com.pgytl_pglogin.View.Fragment;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pgytl_pglogin.Model.PG_Info.PGRequest;
import com.pgytl_pglogin.Model.PG_Info.PGResponse;
import com.pgytl_pglogin.Model.PG_Info.Result;
import com.pgytl_pglogin.R;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.ApiService;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PG_Info extends Fragment {
    private TextView pg_id,pg_name,pg_dob,pg_age,pg_doj,end,boys,girls,startform,anniversary,n_o_deperment,n_o_year;
    private ApiService apiService;

 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.fragment_pg_info, container, false);
             pg_id=view.findViewById(R.id.pg_id);
             pg_name=view.findViewById(R.id.pg_name);
             pg_dob=view.findViewById(R.id.dob);
             pg_age=view.findViewById(R.id.age);
             pg_doj=view.findViewById(R.id.doj);
             end=view.findViewById(R.id.end);
             boys=view.findViewById(R.id.Boys);
             girls=view.findViewById(R.id.Girls);
             startform=view.findViewById(R.id.StartsFrom);
             anniversary=view.findViewById(R.id.Anniversary);
             n_o_deperment=view.findViewById(R.id.No_of_Depedndents);
             n_o_year=view.findViewById(R.id.No_Of_Years);
         apiService= RetrofitClient.getPGRetrofit().create(ApiService.class);

         Intent intent=getActivity().getIntent();
         String a=intent.getStringExtra("email");
         PGRequest pgRequest=new PGRequest(a);

         apiService.getPGResponse(pgRequest).enqueue(new Callback<PGResponse>() {
             @SuppressLint("SetTextI18n")
             @Override
             public void onResponse(Call<PGResponse> call, Response<PGResponse> response) {
                 List<Result> list=response.body().getResult();
                 pg_id.setText(list.get(0).getPrivilegedGuestID());
                 pg_name.setText(list.get(0).getName());
                 pg_dob.setText(list.get(0).getDateofBirth());
                 pg_age.setText(list.get(0).getAge());
                 pg_doj.setText(list.get(0).getDateOfJoining());
                 end.setText(list.get(0).getEnd());
                 boys.setText(list.get(0).getBoys());
                 girls.setText(list.get(0).getGirls());
                 startform.setText(list.get(0).getStartsFrom());
                 anniversary.setText(list.get(0).getAnniversary());
                 n_o_deperment.setText(list.get(0).getNoofDepedndents());
                 n_o_year.setText(list.get(0).getNoOfYears());

             }

             @Override
             public void onFailure(Call<PGResponse> call, Throwable t) {

             }
         });

        return view;
    }
}
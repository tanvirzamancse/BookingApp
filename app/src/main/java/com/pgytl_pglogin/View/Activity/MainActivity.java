package com.pgytl_pglogin.View.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.pgytl_pglogin.Model.PG_Info.PGRequest;
import com.pgytl_pglogin.Model.PG_Info.PGResponse;
import com.pgytl_pglogin.Model.PG_Info.Result;
import com.pgytl_pglogin.Model.Point.PointRequest;
import com.pgytl_pglogin.Model.Point.PointResponse;
import com.pgytl_pglogin.Model.Point.PointResult;
import com.pgytl_pglogin.Model.ViewImage.ImageRequest;
import com.pgytl_pglogin.Model.ViewImage.ImageResponse;
import com.pgytl_pglogin.Model.ViewImage.ImageResult;
import com.pgytl_pglogin.R;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.ApiService;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.RetrofitClient;
import com.pgytl_pglogin.UserAuth.UserAuthPreference;
import com.pgytl_pglogin.View.Fragment.Contact;
import com.pgytl_pglogin.View.Fragment.Holiday;
import com.pgytl_pglogin.View.Fragment.PG_Info;
import com.pgytl_pglogin.View.Fragment.Payment_Details;
import com.pgytl_pglogin.View.Fragment.Point_Details;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity{
    private TextView pg,con,point,pay,holiday,PG_Name,PG_ID,yerlypoint;
    FloatingActionButton floatingActionButton1,floatingActionButton2;
    UserAuthPreference userAuthPreference;
    private FirebaseAuth mAuth;
    private ApiService apiService;
    private ApiService apiService1;
    private ApiService apiService2;
    private CircleImageView profile_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Profile();
        con=findViewById(R.id.home_item_share);
        pg=findViewById(R.id.home_item_rate);
        point=findViewById(R.id.home_item_twitter);
        pay=findViewById(R.id.home_item_fb_like);
        holiday=findViewById(R.id.Holiday);
        floatingActionButton1= findViewById(R.id.fab1);
        floatingActionButton2= findViewById(R.id.custom_fab2);
        PG_Name= findViewById(R.id.name);
        PG_ID= findViewById(R.id.pg_ID);
        PG_ID= findViewById(R.id.pg_ID);
        yerlypoint= findViewById(R.id.point);
        profile_image= findViewById(R.id.profile_image);
        mAuth=FirebaseAuth.getInstance();
        userAuthPreference = new UserAuthPreference(getApplicationContext());
        floatingActionButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                userAuthPreference.setLoginStatus(false);
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        floatingActionButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://api.whatsapp.com/send?phone=+8801877722277");
                Intent i=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });

        FragmentManager fm = getSupportFragmentManager();
        pg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                PG_Info l1 = new PG_Info();
                ft.replace(R.id.fm, l1);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                Contact l2 = new Contact();
                ft.replace(R.id.fm, l2);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                Point_Details l3 = new Point_Details();
                ft.replace(R.id.fm, l3);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                Payment_Details l4 = new Payment_Details();
                ft.replace(R.id.fm, l4);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
//        booking.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentTransaction ft = fm.beginTransaction();
//                Booking_Request l5 = new Booking_Request();
//                ft.replace(R.id.fm, l5);
//                ft.addToBackStack(null);
//                ft.commit();
//            }
//        });
        holiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                Holiday l6 = new Holiday();
                ft.replace(R.id.fm, l6);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }
    private void Profile() {
        apiService= RetrofitClient.getPGRetrofit().create(ApiService.class);
        apiService1= RetrofitClient.getPointRetrofit().create(ApiService.class);
        apiService2= RetrofitClient.getImageViewRetrofit().create(ApiService.class);
        Intent intent=getIntent();
        String a=intent.getStringExtra("email");
        PGRequest pgRequest=new PGRequest(a);
        PointRequest pointRequest=new PointRequest(a);
        ImageRequest imageRequest=new ImageRequest(a);
        apiService2.getImageViewResponse(imageRequest).enqueue(new Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                List<ImageResult> resultlist=response.body().getResult();

                Glide.with(MainActivity.this)
                        .load(resultlist.get(0).getImageUrl())
                        .into(profile_image);
            }
            @Override
            public void onFailure(Call<ImageResponse> call, Throwable t) {

            }
        });

        apiService.getPGResponse(pgRequest).enqueue(new Callback<PGResponse>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<PGResponse> call, Response<PGResponse> response) {
                List<Result> list=response.body().getResult();
                PG_Name.setText(list.get(0).getName());
                PG_ID.setText(list.get(0).getPrivilegedGuestID());
            }
            @Override
            public void onFailure(Call<PGResponse> call, Throwable t) {
            }
        });

        apiService1.getPointResponse(pointRequest).enqueue(new Callback<PointResponse>() {
            @Override
            public void onResponse(Call<PointResponse> call, Response<PointResponse> response) {
                List<PointResult> list=response.body().getResult();
                yerlypoint.setText("Yearly Point : "+list.get(0).getYearlyPoint());
            }
            @Override
            public void onFailure(Call<PointResponse> call, Throwable t) {

            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        PG_Info l1 = new PG_Info();
        ft.replace(R.id.fm, l1);
        ft.addToBackStack(null);
        ft.commit();


    }


}
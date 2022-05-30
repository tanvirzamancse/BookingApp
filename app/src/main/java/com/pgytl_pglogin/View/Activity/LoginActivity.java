package com.pgytl_pglogin.View.Activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.pgytl_pglogin.Model.Login.LoginRequest;
import com.pgytl_pglogin.Model.Login.LoginResponse;
import com.pgytl_pglogin.R;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.ApiService;
import com.pgytl_pglogin.Repository.RemoteServer.WebService.RetrofitClient;
import com.pgytl_pglogin.UserAuth.UserAuthPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class LoginActivity extends AppCompatActivity {
    private Button login;
    private UserAuthPreference userAuthPreference;
    private EditText Email,Password;
    private ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userAuthPreference = new UserAuthPreference(LoginActivity.this);
        if (userAuthPreference.getLoginStatus()){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);
        Email=findViewById(R.id.userName);
        Password=findViewById(R.id.userpassword);
        login=findViewById(R.id.login);
        apiService = RetrofitClient.getRetrofit().create(ApiService.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Login();
            }
        });
    }
    private void Login() {
        String email=Email.getText().toString().trim();
        String password=Password.getText().toString().trim();

        if(email.isEmpty()){
            Email.setError("Enter Email");
            Email.requestFocus();
            return;
        }
        if(password.isEmpty()){
            Password.setError("Enter Password");
            Password.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Enter Valid Email Addres");
            Email.requestFocus();
            return;
        }
        if (password.length()<8) {
            Password.setError("At least 8 Number");
            Password.requestFocus();
        }
        LoginRequest loginRequest=new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);
        Call<LoginResponse> userResponseCall = apiService.getLoginResponse(loginRequest);
        userResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse=response.body();
                if (loginResponse.getStatus()==200){
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("email",email);
                    startActivity(intent);
                    finish();
                    Password.setText("");
                    Email.setText("");
                }else {
                    Toast.makeText(getApplicationContext(), "Wrong Email or Password", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
            }
        });
        
         }
  }
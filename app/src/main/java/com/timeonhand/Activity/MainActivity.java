package com.timeonhand.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.timeonhand.AsyncTask.ApiClient;
import com.timeonhand.AsyncTask.ApiInterface;
import com.timeonhand.Pojo.LoginResponseModel.LoginModel;
import com.timeonhand.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    TextView txtCreate;
    Button btnLogin;

    private ProgressDialog progressDialog;

    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bind();
        addListener();

        pref = getSharedPreferences("user_details", MODE_PRIVATE);

        Intent intent = new Intent(MainActivity.this, NavigationActivity.class);
        if (pref.contains("username") && pref.contains("password")) {
            startActivity(intent);
            finish();
        }

    }

    private void bind() {
        txtCreate = (TextView) findViewById(R.id.txtCreate);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

    }

    private void addListener() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                callLoginService();

            }
        });


        txtCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);

            }
        });


    }

    private void callLoginService() {


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        //Call<TestPojo> login = apiService.callTestService("2");
        final Call<LoginModel> login = apiService.callLoginService(edtUsername.getText().toString().trim(), edtPassword.getText().toString().trim());
        login.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                progressDialog.dismiss();
//                Toast.makeText(MainActivity.this, response.body().getStatus(), Toast.LENGTH_LONG).show();
                Log.e("TAG", "onResponse: " + response.body().toString());

                LoginModel loginModel = response.body();
                if (loginModel.getStatusCode().equalsIgnoreCase("1")) {

                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username", edtUsername.getText().toString());
                    editor.putString("password", edtPassword.getText().toString());
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this, NavigationActivity.class);
                    startActivity(intent);
                    finish();


                    Toast.makeText(MainActivity.this, "login successfully", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "login failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

            }

        });

    }


}
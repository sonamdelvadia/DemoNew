package com.timeonhand.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.timeonhand.AsyncTask.ApiClient;
import com.timeonhand.AsyncTask.ApiInterface;
import com.timeonhand.Pojo.LoginResponseModel.LoginModel;
import com.timeonhand.R;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    TextView txtLogin;
    EditText edtFirstName,edtLastName,edtEmail,edtPassword,edtContact,edtAddress;
    ProgressDialog progressDialog;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bind();
        addListener();
    }



    private void addListener() {
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edtFirstName.getText().toString().trim())) {
                    edtFirstName.setError("please enter first name");

                } else if (TextUtils.isEmpty(edtLastName.getText().toString().trim())) {
                    edtLastName.setError("please enter last name");
                }
                else if (TextUtils.isEmpty(edtEmail.getText().toString().trim())) {
                    edtEmail.setError("please enter Email");
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString().trim()).matches()) {
                    edtEmail.setError("invalid Email");
                }
                else if (TextUtils.isEmpty(edtPassword.getText().toString().trim())) {
                    edtPassword.setError("please enter password");
                }
                else if (TextUtils.isEmpty(edtContact.getText().toString().trim())) {
                    edtContact.setError("please enter contact number");
                }
                else if (!Patterns.PHONE.matcher(edtContact.getText().toString().trim()).matches())

                {
                    edtContact.setError("enter valid phone number");
                } else {
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    intent.putExtra("FirstName", edtFirstName.getText().toString().trim());
                    intent.putExtra("LastName", edtLastName.getText().toString().trim());
                    intent.putExtra("Email", edtEmail.getText().toString().trim());
                    intent.putExtra("Contact", edtContact.getText().toString().trim());

                    startActivity(intent);
                }
















                progressDialog = new ProgressDialog(SignUpActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();

                callSignUpService();
            }
        });
    }

    private void bind() {
        txtLogin=(TextView)findViewById(R.id.txtLogin);
        edtFirstName=findViewById(R.id.edtFirstName);
        edtLastName=findViewById(R.id.edtLastName);
        edtEmail=findViewById(R.id.edtEmail);
        edtPassword=findViewById(R.id.edtPassword);
        edtContact=findViewById(R.id.edtContact);
        edtAddress=findViewById(R.id.edtAddress);
        btnSignUp=findViewById(R.id.btnSignUp);
    }


    private void callSignUpService() {


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        HashMap<String,String> map = new HashMap<>();
        map.put("firstName",edtFirstName.getText().toString().trim());
        map.put("lastName",edtLastName.getText().toString().trim());
        map.put("userName",edtFirstName.getText().toString().trim()+" "+edtLastName.getText().toString().trim());
        map.put("email",edtEmail.getText().toString().trim());
        map.put("password",edtPassword.getText().toString().trim());
        map.put("address",edtAddress.getText().toString().trim());
        map.put("phone",edtContact.getText().toString().trim());

        //Call<TestPojo> login = apiService.callTestService("2");
        final Call<LoginModel> login = apiService.callSignUpService(map);

        login.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                progressDialog.dismiss();
//                Toast.makeText(MainActivity.this, response.body().getStatus(), Toast.LENGTH_LONG).show();
                Log.e("TAG", "onResponse: " + response.body().toString());

                LoginModel loginModel = response.body();
                if (loginModel.getStatusCode().equalsIgnoreCase("1")) {
                    onBackPressed();
                    Toast.makeText(SignUpActivity.this, "sign up succesfully successfully", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(SignUpActivity.this, "login failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

            }

        });

    }

}

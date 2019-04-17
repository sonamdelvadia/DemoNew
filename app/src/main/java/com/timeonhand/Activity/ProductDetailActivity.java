package com.timeonhand.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.timeonhand.AsyncTask.ApiClient;
import com.timeonhand.AsyncTask.ApiInterface;
import com.timeonhand.Pojo.ProductDetailModel.ProductDetailModel;
import com.timeonhand.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView ivSelectedproduct;
    TextView txtProductPrice, txtDescription;
    ProgressDialog progressDialog;
    ArrayList<ProductDetailModel> arrayList;
    Activity mActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        bind();
        init();
        addlistner();


    }

    private void init() {
        arrayList=new ArrayList<>();
        callProductDetailService();
    }

    private void addlistner() {
    }

    private void bind() {
        ivSelectedproduct = findViewById(R.id.ivSelectedproduct);
        txtProductPrice = findViewById(R.id.txtProductPrice);
        txtDescription = findViewById(R.id.txtDescription);

        mActivity = this;
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    private void callProductDetailService() {


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ProductDetailModel> call = apiService.callProductDetailService(getIntent().getStringExtra("categoryId"));
        call.enqueue(new Callback<ProductDetailModel>() {
            @Override
            public void onResponse(Call<ProductDetailModel> call, Response<ProductDetailModel> response) {

                ProductDetailModel productDetailModel = response.body();
                if (productDetailModel != null && productDetailModel.getProductImages().size() > 0) {
                    progressDialog.dismiss();

                    if (productDetailModel.getStatusCode().equalsIgnoreCase("1")) {
                        Toast.makeText(ProductDetailActivity.this, "get response", Toast.LENGTH_SHORT).show();

                      List<String> s =   productDetailModel.getProductImages().get(0);

                      String s1 = s.get(0);

                        Glide.with(ProductDetailActivity.this).load(s1).into(ivSelectedproduct);


                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<ProductDetailModel> call, Throwable t) {

            }


        });
    }

}


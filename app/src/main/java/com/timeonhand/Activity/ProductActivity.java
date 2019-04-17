package com.timeonhand.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.timeonhand.Adapter.ProductListAdapter;
import com.timeonhand.AsyncTask.ApiClient;
import com.timeonhand.AsyncTask.ApiInterface;
import com.timeonhand.Pojo.ProductListPojo;
import com.timeonhand.Pojo.ProductResponseModel.ProductModel;
import com.timeonhand.Pojo.ProductResponseModel.ProductsItem;
import com.timeonhand.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {
    RecyclerView rvProductList;
    ProductListAdapter productListAdapter;
    ArrayList<ProductsItem> arPojo;
    ProductListPojo productListPojo;
    ProgressDialog progressDialog;
    Activity mActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        bind();

        rvProductList.setLayoutManager(new GridLayoutManager(this, 2));
        productListAdapter = new ProductListAdapter(this, arPojo);
        rvProductList.setAdapter(productListAdapter);
        mActivity=this;
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        callProductListService();


    }




    private void bind() {
        rvProductList = findViewById(R.id.rvProductList);
        arPojo = new ArrayList<>();
    }

    private void callProductListService() {


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ProductModel> call = apiService.callProductListService(getIntent().getStringExtra("subcategoryId"));
        call.enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {

                ProductModel productModel = response.body();
                if(productModel != null && productModel.getProducts().size() > 0) {
                    progressDialog.dismiss();

                    if(productModel.getTotal() == 0)  {
                        Toast.makeText(ProductActivity.this, "No Product found", Toast.LENGTH_SHORT).show();
                    }else {
                        arPojo.addAll(productModel.getProducts());
                        productListAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {

            }
        });
    }
}

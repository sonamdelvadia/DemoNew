package com.timeonhand.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.timeonhand.Adapter.SubCategoryAdapter;
import com.timeonhand.AsyncTask.ApiClient;
import com.timeonhand.AsyncTask.ApiInterface;
import com.timeonhand.Pojo.CategoryModel.CategoryModel;
import com.timeonhand.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubCategoryActivity extends AppCompatActivity {

    RecyclerView rvCat;
    SubCategoryAdapter subcategoryAdapter;
    ArrayList<CategoryModel> arPojo;
    ProgressDialog progressDialog;
    Activity mActivity;
    Toolbar toolCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        bind();
        addListener();
    }


    private void addListener() {


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.product1:

                Toast.makeText(getApplicationContext(), "product1 Selected", Toast.LENGTH_LONG).show();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void bind() {

        toolCat = (Toolbar) findViewById(R.id.toolCat);
        toolCat.setTitle("SubCategory");
        setSupportActionBar(toolCat);

        mActivity = this;
        rvCat = (RecyclerView) findViewById(R.id.rvCat);
        arPojo = new ArrayList<>();

        rvCat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        subcategoryAdapter = new SubCategoryAdapter(this, arPojo);
        rvCat.setAdapter(subcategoryAdapter);
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        callSubCategoryService();


    }


    private void callSubCategoryService() {


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<CategoryModel>> call = apiService.callSubCategoryService(getIntent().getStringExtra("categoryId"));
        call.enqueue(new Callback<List<CategoryModel>>() {
            @Override
            public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {

                List<CategoryModel> categoryModel = response.body();
                if (categoryModel != null && categoryModel.size() > 0) {
                    progressDialog.dismiss();

                    CategoryModel catModel = categoryModel.get(0);
                    categoryModel.remove(0);
                    if (catModel.getStatusCode().equalsIgnoreCase("1")) {

                        arPojo.addAll(categoryModel);
                        subcategoryAdapter.notifyDataSetChanged();


                    }
                }
            }

            @Override
            public void onFailure(Call<List<CategoryModel>> call, Throwable t) {

            }
        });
    }


}

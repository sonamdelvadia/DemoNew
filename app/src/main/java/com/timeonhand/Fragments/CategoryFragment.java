package com.timeonhand.Fragments;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.timeonhand.Adapter.CategoryAdapter;
import com.timeonhand.AsyncTask.ApiClient;
import com.timeonhand.AsyncTask.ApiInterface;
import com.timeonhand.Pojo.CategoryModel.CategoryModel;
import com.timeonhand.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    private RecyclerView rvCat;
    private Activity mActivity;
    private ArrayList<CategoryModel> categoryModels;
    private CategoryAdapter categoryAdapter;
    ProgressDialog progressDialog;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View catview = inflater.inflate(R.layout.fragment_category, container, false);

        bind(catview);
        addListener();
        return catview;
        // Inflate the layout for this fragment


    }


    private void bind(View catview) {
        mActivity = getActivity();
        rvCat = catview.findViewById(R.id.rvCat);
        categoryModels = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(mActivity, categoryModels);
        rvCat.setAdapter(categoryAdapter);
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        callCategoryService();
    }

    private void callCategoryService() {


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);


        Call<List<CategoryModel>> call = apiService.callCategoryService();
        call.enqueue(new Callback<List<CategoryModel>>() {
            @Override
            public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {

                List<CategoryModel> categoryModel = response.body();

                if (categoryModel != null && categoryModel.size() > 0) {
                    progressDialog.dismiss();

                    CategoryModel catModel = categoryModel.get(0);

                    if (catModel.getStatusCode().equalsIgnoreCase("1")) {
                        categoryModel.remove(0);

                        categoryModels.addAll(categoryModel);
                        categoryAdapter.notifyDataSetChanged();


                    }
                }
            }

            @Override
            public void onFailure(Call<List<CategoryModel>> call, Throwable t) {

            }
        });
    }

    private void addListener() {


    }


}
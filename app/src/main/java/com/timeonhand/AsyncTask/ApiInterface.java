package com.timeonhand.AsyncTask;

import com.timeonhand.Pojo.CategoryModel.CategoryModel;
import com.timeonhand.Pojo.LoginResponseModel.LoginModel;
import com.timeonhand.Pojo.ProductDetailModel.ProductDetailModel;
import com.timeonhand.Pojo.ProductResponseModel.ProductModel;
import com.timeonhand.Pojo.Test.TestPojo;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/users")
    Call<TestPojo> callTestService(@Query("email") String page,@Query("password") String password);

    @GET("web-services/login.php")
    Call<LoginModel> callLoginService(@Query("email") String email, @Query("password") String password);

    @FormUrlEncoded
    @POST("web-services/register.php")
    Call<LoginModel> callSignUpService(@FieldMap HashMap<String,String> map);

    @GET("web-services/home_product.php?action=category")
    Call<List<CategoryModel>> callCategoryService();

    @GET("web-services/home_product.php?action=subcategory")
    Call<List<CategoryModel>> callSubCategoryService(@Query("catId") String catId);

    @GET("web-services/home_product.php?action=product")
    Call<ProductModel> callProductListService(@Query("subcatId") String subCatId);

    @GET("web-services/product_detail.php")
    Call<ProductDetailModel> callProductDetailService(@Query("pId") String pId);



}

package com.timeonhand.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.timeonhand.Activity.ProductDetailActivity;
import com.timeonhand.Pojo.ProductResponseModel.ProductsItem;
import com.timeonhand.R;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {
    Activity activity;
    ArrayList<ProductsItem> arProductList;

    public ProductListAdapter(Activity activity, ArrayList<ProductsItem> arProductList) {
        this.activity = activity;
        this.arProductList = arProductList;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_product, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final ProductsItem productsItem = arProductList.get(i);
        myViewHolder.txtProductName.setText(productsItem.getProductName());
        myViewHolder.txtProductPrice.setText(productsItem.getAmount());


        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity,ProductDetailActivity.class);
                intent.putExtra("categoryId",productsItem.getId());
                activity.startActivity(intent);

            }
        });



        Log.e("subcatid","subcatid"+productsItem.getId().toString());





        Glide.with(activity).load(productsItem.getImage()).into(myViewHolder.ivProduct);



    }

    @Override
    public int getItemCount() {
        return arProductList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProduct;
        TextView txtProductName;
        TextView txtProductPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProduct = itemView.findViewById(R.id.ivProduct);
            txtProductName = itemView.findViewById(R.id.txtProductName);
            txtProductPrice = itemView.findViewById(R.id.txtProductPrice);
        }
    }
}

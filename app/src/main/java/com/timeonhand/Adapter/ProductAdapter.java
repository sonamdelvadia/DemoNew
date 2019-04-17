package com.timeonhand.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.timeonhand.Pojo.ProductPojo;
import com.timeonhand.R;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    Activity activity;
    ArrayList<ProductPojo> arProduct;
    public ProductAdapter(Activity activity, ArrayList<ProductPojo> arProduct){
        this.activity=activity;
        this.arProduct=arProduct;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_product,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        ProductPojo  productPojo= arProduct.get(i);
        myViewHolder.txtProductName.setText(productPojo.getProductName());
        myViewHolder.txtProductPrice.setText(productPojo.getProductPrice());
        Glide.with(activity).load(productPojo.getProductImage()).into(myViewHolder.ivProduct);

        productPojo.getSubcategoryid();


    }

    @Override
    public int getItemCount()
    {
        return arProduct.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProduct;
        TextView txtProductName;
        TextView txtProductPrice;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProduct=itemView.findViewById(R.id.ivProduct);
            txtProductName=itemView.findViewById(R.id.txtProductName);
            txtProductPrice=itemView.findViewById(R.id.txtProductPrice);
        }
    }
}

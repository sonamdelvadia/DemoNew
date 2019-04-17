package com.timeonhand.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.timeonhand.Activity.ProductActivity;
import com.timeonhand.Pojo.CategoryModel.CategoryModel;
import com.timeonhand.R;

import java.util.ArrayList;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.MyViewHolder> {
    Activity activity;
    ArrayList<CategoryModel> arCat;

 public SubCategoryAdapter(Activity activity, ArrayList<CategoryModel> arCat){
     this.activity= activity;
     this.arCat=arCat;
 }
    @NonNull   @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_subcategory,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final CategoryModel subcategoryPojo= arCat.get(i);
        myViewHolder.txtName.setText(subcategoryPojo.getCategoryName());
        Glide.with(activity).load(subcategoryPojo.getCategoryImage()).into(myViewHolder.ivCat);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity,ProductActivity.class);
                intent.putExtra("subcategoryId",subcategoryPojo.getCategoryId());
                activity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arCat.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCat;
        TextView txtName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCat=itemView.findViewById(R.id.ivCat);
            txtName=itemView.findViewById(R.id.txtName);

        }
    }
}

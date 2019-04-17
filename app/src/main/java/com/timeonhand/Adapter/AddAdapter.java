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
import com.timeonhand.Pojo.AddPojo;
import com.timeonhand.R;

import java.util.ArrayList;

public class AddAdapter extends RecyclerView.Adapter<AddAdapter.MyViewHolder> {
    Activity activity;
    ArrayList<AddPojo> arAdd;
    public AddAdapter(Activity activity, ArrayList<AddPojo> arAdd){
        this.activity=activity;
        this.arAdd=arAdd;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_add,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        AddPojo addPojo= arAdd.get(i);
        myViewHolder.txtName.setText(addPojo.getAddname());
        Glide.with(activity).load(addPojo.getAddImage()).into(myViewHolder.ivAdd);
    }

    @Override
    public int getItemCount() {
        return arAdd.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAdd;
        TextView txtName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAdd=itemView.findViewById(R.id.ivAdd);
            txtName=itemView.findViewById(R.id.txtName);
        }
    }
}

package com.timeonhand.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.timeonhand.Pojo.AddPojo;
import com.timeonhand.R;

import java.util.ArrayList;

public class CustomPagerAdapter extends PagerAdapter {

    ImageView ivAdd;

    private Activity activity;
    private ArrayList<AddPojo> addPojoArrayList;

    public CustomPagerAdapter(Activity activity, ArrayList<AddPojo> addPojoArrayList) {
        this.activity = activity;
        this.addPojoArrayList = addPojoArrayList;
    }

    @Override
    public int getCount() {
        return addPojoArrayList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ViewGroup view = (ViewGroup) LayoutInflater.from(container.getContext()).inflate(R.layout.item_row_add, container, false);

        ivAdd = view.findViewById(R.id.ivAdd);


        AddPojo addPojo = addPojoArrayList.get(position);
        Glide.with(activity).load(addPojo.getAddImage()).into(ivAdd);

        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

}

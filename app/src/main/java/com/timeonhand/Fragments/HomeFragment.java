package com.timeonhand.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.timeonhand.Adapter.CustomPagerAdapter;
import com.timeonhand.Adapter.ProductAdapter;
import com.timeonhand.Pojo.AddPojo;
import com.timeonhand.Pojo.ProductPojo;
import com.timeonhand.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    RecyclerView rvProduct;
    ViewPager viewPager;
    AddPojo addPojo;
    CustomPagerAdapter customPagerAdapter;
    ArrayList<AddPojo> arPojo;
    ProductPojo productPojo;
    ProductAdapter productAdapter;
    ArrayList<ProductPojo> prPojo;
    ImageView imgMenu;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        bind(rootView);
        init();
        return rootView;

    }

    private void bind(View rootView) {

        imgMenu = (ImageView) rootView.findViewById(R.id.imgMenu);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        rvProduct = (RecyclerView) rootView.findViewById(R.id.rvProduct);


    }

    private void init() {

        arPojo = new ArrayList<>();
        addPojo = new AddPojo();
        addPojo.setAddImage("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/11b778416abfa5dfe9522eb175fac47a.jpg?ts=1464004241");
        addPojo.setAddname("Advertise");
        arPojo.add(addPojo);

        addPojo = new AddPojo();
        addPojo.setAddImage("http://www.designbolts.com/wp-content/uploads/2015/04/BCAA-Assorted-Pamphlet-Design-2.jpg");
        addPojo.setAddname("Advertise");
        arPojo.add(addPojo);

        addPojo = new AddPojo();
        addPojo.setAddImage("http://www.designbolts.com/wp-content/uploads/2015/04/BCAA-Assorted-Pamphlet-Design-2.jpg");
        addPojo.setAddname("Advertise");
        arPojo.add(addPojo);

        addPojo = new AddPojo();
        addPojo.setAddImage("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/11b778416abfa5dfe9522eb175fac47a.jpg?ts=1464004241");
        addPojo.setAddname("Advertise");
        arPojo.add(addPojo);
        addPojo = new AddPojo();
        addPojo.setAddImage("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/11b778416abfa5dfe9522eb175fac47a.jpg?ts=1464004241");
        addPojo.setAddname("Advertise");
        arPojo.add(addPojo);
        addPojo = new AddPojo();
        addPojo.setAddImage("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/11b778416abfa5dfe9522eb175fac47a.jpg?ts=1464004241");
        addPojo.setAddname("Advertise");
        arPojo.add(addPojo);
        addPojo = new AddPojo();
        addPojo.setAddImage("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/11b778416abfa5dfe9522eb175fac47a.jpg?ts=1464004241");
        addPojo.setAddname("Advertise");
        arPojo.add(addPojo);
        addPojo = new AddPojo();
        addPojo.setAddImage("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/11b778416abfa5dfe9522eb175fac47a.jpg?ts=1464004241");
        addPojo.setAddname("Advertise");
        arPojo.add(addPojo);
        addPojo = new AddPojo();
        addPojo.setAddImage("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/11b778416abfa5dfe9522eb175fac47a.jpg?ts=1464004241");
        addPojo.setAddname("Advertise");
        arPojo.add(addPojo);
        addPojo = new AddPojo();
        addPojo.setAddImage("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/11b778416abfa5dfe9522eb175fac47a.jpg?ts=1464004241");
        addPojo.setAddname("Advertise");
        arPojo.add(addPojo);

        customPagerAdapter = new CustomPagerAdapter(getActivity(), arPojo);
        viewPager.setAdapter(customPagerAdapter);


        rvProduct.setLayoutManager(new GridLayoutManager(getContext(), 2));

        prPojo = new ArrayList<>();

        productPojo = new ProductPojo();
        productPojo.setProductImage("http://assets.myntassets.com/assets/images/1488038/2016/11/29/11480400680379-Mast--Harbour-Men-Black-Dial-Analogue-Watch-MH4-A-7091480400680232-1.jpg");
        productPojo.setProductName("Jeants watch");
        productPojo.setProductPrice("1350");
        prPojo.add(productPojo);

        productPojo = new ProductPojo();
        productPojo.setProductImage("https://www.hauve.co.uk/wp-content/uploads/2017/11/hauve-notting-hill-silver-front.jpg");
        productPojo.setProductName("newest");
        productPojo.setProductPrice("1500");
        prPojo.add(productPojo);

        productPojo = new ProductPojo();
        productPojo.setProductImage("https://images-na.ssl-images-amazon.com/images/I/41VloMir72L.jpg");
        productPojo.setProductName("blue black");
        productPojo.setProductPrice("1255");
        prPojo.add(productPojo);

        productPojo = new ProductPojo();
        productPojo.setProductImage("https://d1rkccsb0jf1bk.cloudfront.net/products/99953400/main/medium/ax2104oko.jpg");
        productPojo.setProductName("couple");
        productPojo.setProductPrice("1480");
        prPojo.add(productPojo);

        productPojo = new ProductPojo();
        productPojo.setProductImage("https://cdn.shopify.com/s/files/1/0238/6181/products/Weiss_Watch_Company_Automatic_Issue_Field_Watch_White_Dial_2048x2048.jpg?v=1545033364");
        productPojo.setProductName("rado");
        productPojo.setProductPrice("1478");
        prPojo.add(productPojo);

        productPojo = new ProductPojo();
        productPojo.setProductImage("http://assets.myntassets.com/assets/images/2048527/2017/10/31/11509446168515-Roadster-Unisex-Charcoal-Analogue-and-Digital-Watch-3091509446168278-1.jpg");
        productPojo.setProductName("brand");
        productPojo.setProductPrice("1000");
        prPojo.add(productPojo);

        productPojo = new ProductPojo();
        productPojo.setProductImage("http://assets.myntassets.com/assets/images/2048527/2017/10/31/11509446168515-Roadster-Unisex-Charcoal-Analogue-and-Digital-Watch-3091509446168278-1.jpg");
        productPojo.setProductName("leather");
        productPojo.setProductPrice("2345");
        prPojo.add(productPojo);

        productPojo = new ProductPojo();
        productPojo.setProductImage("https://n3.sdlcdn.com/imgs/e/v/o/SDL044502225_1-6ee47.jpg");
        productPojo.setProductName("new brand");
        productPojo.setProductPrice("7894");
        prPojo.add(productPojo);

        productPojo = new ProductPojo();
        productPojo.setProductImage("https://images-na.ssl-images-amazon.com/images/I/71QHGTKiwAL._UX342_.jpg");
        productPojo.setProductName("causual watch");
        productPojo.setProductPrice("1480");
        prPojo.add(productPojo);

        productPojo = new ProductPojo();
        productPojo.setProductImage("https://images-na.ssl-images-amazon.com/images/I/71gdBQP%2BqGL._UL1500_.jpg");
        productPojo.setProductName("jeants watch");
        productPojo.setProductPrice("1500");
        prPojo.add(productPojo);

        productAdapter = new ProductAdapter(getActivity(), prPojo);
        rvProduct.setAdapter(productAdapter);
    }


}

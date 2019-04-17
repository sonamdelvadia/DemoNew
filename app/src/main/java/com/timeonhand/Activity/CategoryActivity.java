package com.timeonhand.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.timeonhand.Fragments.CategoryFragment;
import com.timeonhand.R;

public class CategoryActivity extends AppCompatActivity {
    ImageView imgMenu;


    private View layoutNavigation;
    private DrawerLayout drawerLayout;
    private String idCategory;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        toolbar.setTitle("Time Always OnHand");


        bind();



        //placing toolbar in place of actionbar

        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nvView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                drawerLayout.closeDrawer(GravityCompat.START);

                switch (item.getItemId()) {


                    case R.id.navCategory:
                        updateDisplay(new CategoryFragment());
                        Toast.makeText(CategoryActivity.this, "category is selected", Toast.LENGTH_SHORT).show();
                        return true;




                    default:
                        return true;
                }

            }
        });



        addListener();


    }



    private void bind() {
        imgMenu=(ImageView) findViewById(R.id.imgMenu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    private void updateDisplay(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameContent, fragment)
                .commit();
    }



    private void addListener() {

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }

            }
        });



    }




}





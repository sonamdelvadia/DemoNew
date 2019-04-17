package com.timeonhand.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.timeonhand.Fragments.CategoryFragment;
import com.timeonhand.Fragments.HomeFragment;
import com.timeonhand.R;

public class NavigationActivity extends AppCompatActivity {
    ImageView imgMenu;
    SharedPreferences prf;
    private View layoutNavigation;
    private DrawerLayout drawerLayout;
    NavigationView navigationView;

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //setting the title
        toolbar.setTitle("TimeOnHand");
        bind();
        init();
        addListener();


        //placing toolbar in place of actionbar

        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

    private void init() {

        navigationView = (NavigationView) findViewById(R.id.nvView);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                drawerLayout.closeDrawer(GravityCompat.START);
                switch (item.getItemId()) {

                    case R.id.navHome:
                        updateDisplay(new HomeFragment());
                        Toast.makeText(NavigationActivity.this, "home is selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navCategory:
                        updateDisplay(new CategoryFragment());
                        return true;

                    case R.id.navLogOut:
                        SharedPreferences.Editor editor = prf.edit();
                        editor.clear();
                        editor.commit();
                        Intent intent = new Intent(NavigationActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();


                    default:

                        return true;
                }


            }
        });
        navigationView.getMenu().getItem(0).setChecked(true);
        updateDisplay(new HomeFragment());

        prf = getSharedPreferences("user_details", MODE_PRIVATE);

    }

    private void addlistner() {
    }

    private void bind() {
        imgMenu = (ImageView) findViewById(R.id.imgMenu);
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


}


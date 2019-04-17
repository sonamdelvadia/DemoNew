package com.timeonhand.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.timeonhand.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bind();
        addlistner();
        init();
    }

    private void bind() {

    }

    private void addlistner() {

    }

    private void init() {

       /* new Handler().postDelayed(new Runnable() {

            @Override

            public void run() {

                }
                }, 5 * 1000);
 */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 2* 1000);
    }
}


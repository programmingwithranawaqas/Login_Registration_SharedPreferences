package com.example.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sPref = getSharedPreferences("userdata", MODE_PRIVATE);
                String text = sPref.getString("USERNAME_KEY", "");
                Intent intent;
                if(text.isEmpty())
                {
                    intent = new Intent(MainActivity.this, Registration.class);
                }
                else {
                    intent = new Intent(MainActivity.this, Home.class);
                }
                startActivity(intent);
                finish();

            }
        }, 4000);

    }
}
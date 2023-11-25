package com.example.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    Button btnLogout;
    TextView tvWelcomeHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();

        SharedPreferences sPref = getSharedPreferences("userdata", MODE_PRIVATE);
        String text = sPref.getString("USERNAME_KEY", "");
        tvWelcomeHeader.setText("Welcome "+text);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    SharedPreferences.Editor editor = sPref.edit();
                    editor.remove("USERNAME_KEY");
                    editor.commit();

                startActivity(new Intent(Home.this, Login.class));
                finish();
            }
        });

    }

    public void init()
    {
        btnLogout = findViewById(R.id.btnLogout);
        tvWelcomeHeader =findViewById(R.id.tvWelcomeHeader);
    }
}
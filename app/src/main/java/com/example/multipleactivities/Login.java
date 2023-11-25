package com.example.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    TextInputEditText etLoginUsername, etLoginPassword;
    Button btnLoginCancel, btnLogin;
    TextView tvNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent comingIntent = getIntent();

        String username = comingIntent.getStringExtra("USERNAME_KEY");
        String password = comingIntent.getStringExtra("PASSWORD_KEY");

        init();

        btnLoginCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userUsername = etLoginUsername.getText().toString().trim();
                String userPassword = etLoginPassword.getText().toString();

                if(userUsername.equals(username) && userPassword.equals(password))
                {
                    // write the username into a file
                    SharedPreferences sPref = getSharedPreferences("userdata", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sPref.edit();
                    editor.putString("USERNAME_KEY",username);
                    editor.commit();

                    // move towards Home activity
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                    finish();

                }

            }
        });

        tvNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Registration.class));
                finish();
            }
        });
    }

    public void init()
    {
        etLoginUsername = findViewById(R.id.etLoginUsername);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLoginCancel = findViewById(R.id.btnLoginCancel);
        tvNewUser = findViewById(R.id.tvNewUser);

    }
}
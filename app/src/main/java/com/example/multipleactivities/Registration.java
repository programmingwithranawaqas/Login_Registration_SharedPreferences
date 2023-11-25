package com.example.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Registration extends AppCompatActivity {

    // hooks
    TextInputEditText etUsername, etPassword, etConfirmPassword;
    Button btnCancel, btnSignup;
    TextView tvAlreadyHaveAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        init();

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                // dispose();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString();
                String cPassword = etConfirmPassword.getText().toString();


                if(uname.isEmpty())
                {
                    etUsername.setError("Username can't be empty");
                    //Toast.makeText(Registration.this, "", Toast.LENGTH_SHORT).show();
                }
                if(password.isEmpty())
                {
                    etPassword.setError("Password can't be empty");
                }
                if(cPassword.isEmpty())
                {
                    etConfirmPassword.setError("Confirm Password can't be empty");
                }

                if(!password.isEmpty() &&
                        !cPassword.isEmpty() &&
                        !password.equals(cPassword))
                {
                    Toast.makeText(Registration.this,
                            "Password mis-matched",
                            Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Intent intent = new Intent(Registration.this, Login.class);
                    intent.putExtra("USERNAME_KEY",uname);
                    intent.putExtra("PASSWORD_KEY", password);

                    startActivity(intent);
                    finish();
                }
            }
        });

        tvAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init()
    {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnCancel = findViewById(R.id.btnCancel);
        btnSignup = findViewById(R.id.btnSignup);
        tvAlreadyHaveAccount = findViewById(R.id.tvAlreadyHaveAccount);
    }
}
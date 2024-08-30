package com.example.personalassistantmanagementapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class secLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_login);
        TextView username = findViewById(R.id.emailaddress);
        TextView password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);

        //Admin and 12345678

        login.setOnClickListener(view -> {
            if (username.getText().toString().equals("Admin") && password.getText().toString().equals("12345678")) {
              //  correct
              Toast.makeText(secLoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();

                Intent intentLogIn = new Intent(secLoginActivity.this, homePage.class);
               startActivity(intentLogIn);
                finish();

            } else
                //incorrect
               Toast.makeText(secLoginActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
       });
    }
}

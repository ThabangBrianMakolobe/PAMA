package com.example.personalassistantmanagementapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String name = "PAMA USER";
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        findViewById(R.id.logoImageView);
        findViewById(R.id.logoTextView);

        handler.postDelayed(() -> {
            Toast.makeText(MainActivity.this, "Hello " + name, Toast.LENGTH_SHORT).show();

            Intent intentSplash = new Intent(MainActivity.this, secLoginActivity.class);
            startActivity(intentSplash);
            finish();
        }, 3000);
    }
}


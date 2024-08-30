package com.example.personalassistantmanagementapplication;

import  androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Call extends AppCompatActivity {

    public EditText editTextPhone;
    public Button button;
    static int PERMISSION_CODE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call);
        editTextPhone=findViewById(R.id.editTextPhone);
        button=findViewById(R.id.button);
        if (ContextCompat.checkSelfPermission(Call.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(Call.this,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber=editTextPhone.getText().toString();
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+ phoneNumber));
                startActivity(intent);
            }
        });
    }
}


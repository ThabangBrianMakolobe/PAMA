package com.example.personalassistantmanagementapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Message extends AppCompatActivity {

    EditText editTextNum, editTextMessage;
    Button btnsent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

        editTextNum = findViewById(R.id.editTextNum);
        editTextMessage = findViewById(R.id.editTextMessage);
        btnsent = findViewById(R.id.btnsent);

        btnsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Message.this, Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_GRANTED){
                    sendSMS();
                }else{
                    ActivityCompat.requestPermissions(Message.this, new String[]{Manifest.permission.SEND_SMS},
                            100);
                }
            }
        });
    }
  
    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        if (requestCode==100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            sendSMS();

        }else {
            Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
        }


    }


    private void sendSMS(){
        String phone = editTextNum.getText().toString();
        String message = editTextMessage.getText().toString();

        if(!phone.isEmpty() && !message.isEmpty()){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone,null,message,null,null);
            Toast.makeText(this, "SMS sent successfully", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Please Enter Phone & Message", Toast.LENGTH_SHORT).show();
        }

    }
}

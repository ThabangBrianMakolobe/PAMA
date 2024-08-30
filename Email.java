package com.example.personalassistantmanagementapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Email extends AppCompatActivity {

    EditText sendTo;
    EditText subject;
    EditText body;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);

        sendTo= findViewById(R.id.sendTo);
        subject= findViewById(R.id.subject);
        body=findViewById(R.id.body);

        button2=findViewById(R.id.button2);

      button2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              sendmail();
          }
      });
}
    public void sendmail(){
        String recipientList=sendTo.getText().toString();
        String[] recipients=recipientList.split(",");

        String Subject=subject.getText().toString();
        String Body=body.getText().toString();

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,Subject);
        intent.putExtra(Intent.EXTRA_TEXT,Body);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose email recipient"));
    }
}


package com.example.personalassistantmanagementapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import java.io.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class homePage extends AppCompatActivity  {

    TextView MenuCalls;
    TextView MenuMessages;
    TextView MenuEmails;
    TextView MenuMusic;
    TextView MenuBrowser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        MenuCalls = findViewById(R.id.MenuCalls);
        MenuMessages = findViewById(R.id.MenuMessages);
        MenuEmails = findViewById(R.id.MenuEmails);
        MenuMusic = findViewById(R.id.MenuMusic);
        MenuBrowser = findViewById(R.id.MenuBrowser);


        MenuCalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call();
                showToast("Calls clicked");
            }
        });

        MenuMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message();
                showToast("Messages clicked");
            }
        });

        MenuEmails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Emails();
                showToast("Emails clicked");
            }
        });

        MenuMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Music();
                showToast("Music clicked");
            }
        });

        MenuBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Browser();
                showToast("Browser clicked");
            }
        });

        //bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //bottomNavigationView.setSelectedItemId(R.id.person);
    }
    public void Call(){
        Intent intent=new Intent(this,Call.class);
        startActivity(intent);

    }
    public void Emails(){
        Intent intent=new Intent(this,Email .class);
        startActivity(intent);
    }

    public void Music(){
        Intent intent=new Intent(this,Music .class);
        startActivity(intent);
    }
    public void Message(){
        Intent intent=new Intent(this,Message .class);
        startActivity(intent);
    }
    public void Browser(){
        Intent intent=new Intent(this,Browser .class);
        startActivity(intent);
    }
   // FirstFragment firstFragment = new FirstFragment();
    //SecondFragment secondFragment = new SecondFragment();
    //ThirdFragment thirdFragment = new ThirdFragment();

   // @SuppressLint("NonConstantResourceId")
    //@Override
   // public boolean onNavigationItemSelected(@NonNull MenuItem item) {

      //  switch (item.getItemId()) {
     //       case R.id.person:
     //           getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
        //        return true;

         //   case R.id.home:
           //     getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
         //       return true;

           // case R.id.settings:
            //    getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
          //      return true;
        //}
      //  return false;
    //}
    private void  showToast(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
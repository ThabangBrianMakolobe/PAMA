package com.example.personalassistantmanagementapplication;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Music extends AppCompatActivity {

    ImageButton playbtn, pausebtn, stopbtn;
    MediaPlayer mediaPlayer;
    boolean isPlaying = false;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);

        playbtn = findViewById(R.id.playbtn);
        pausebtn = findViewById(R.id.pausebtn);
        stopbtn = findViewById(R.id.stopbtn);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);

      playbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if (!isPlaying){
                  mediaPlayer.start();
                  isPlaying = true;
              }
          }
      });
      pausebtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if (isPlaying){
                  mediaPlayer.pause();
                  isPlaying = false;
              }
          }
      });
      stopbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              mediaPlayer.stop();
              isPlaying=false;
          }
      });
    }
}

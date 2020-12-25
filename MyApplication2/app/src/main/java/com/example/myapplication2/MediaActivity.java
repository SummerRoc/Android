package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MediaActivity extends AppCompatActivity{

    private Button play;
    private Button pause;
    private Button stop;
    private Button jump;
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        play = findViewById(R.id.bt1);
        pause = findViewById(R.id.bt2);
        stop = findViewById(R.id.bt3);
        jump = findViewById(R.id.bt4);
//        play.setOnClickListener(this);
//        pause.setOnClickListener(this);
//        stop.setOnClickListener(this);
        if (ContextCompat.checkSelfPermission(MediaActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MediaActivity.this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            initMediaPlayer();
        }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()){

                    mediaPlayer.start();
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){

                    mediaPlayer.pause();
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    initMediaPlayer();
                }
            }
        });

        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initMediaPlayer() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(),"/sdcard/abc.mp3");
           // mediaPlayer.setDataSource(file.getPath());
             mediaPlayer.setDataSource("http://antiserver.kuwo.cn/anti.s?useless=/resource/&format=mp3&rid=MUSIC_439462&response=res&type=convert_url&");
//            // Log.d("TAG", "initMediaPlayer: "+);
            mediaPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions,int[] grantResults){
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initMediaPlayer();
                } else {
                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.bt1:
//                if (!mediaPlayer.isPlaying()) {
//                    mediaPlayer.start();
//                }
//                break;
//            case R.id.bt2:
//                if (mediaPlayer.isPlaying()) {
//                    mediaPlayer.pause();
//                }
//                break;
//            case R.id.bt3:
//                if (mediaPlayer.isPlaying()) {
//                    mediaPlayer.stop();
//                    initMediaPlayer();
//                }
//                break;
//            default:
//                break;
//        }
//    }
    protected void onDestroy() {

        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
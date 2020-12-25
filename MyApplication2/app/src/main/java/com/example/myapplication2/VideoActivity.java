package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
//import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
//import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener{
    private Button play1;
    private Button pause1;
    private Button reply;
    private VideoView videoView;
    //private MediaController mediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        play1 = findViewById(R.id.play_bt);
        pause1 = findViewById(R.id.pause_bt);
        reply = findViewById(R.id.reply_bt);
        videoView = findViewById(R.id.video_view);
        play1.setOnClickListener(this);
        pause1.setOnClickListener(this);
        reply.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(VideoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(VideoActivity.this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            initVideoPath();
        }
    }
    private void initVideoPath(){
       // String uri = "https://gslb.miaopai.com/stream/P4DnrjGZ7PzC2LfQK9k2cAKEIw39GiixIBpIHA__.mp4";
//        videoView.setVideoURI(Uri.parse(uri));
//        videoView.setMediaController(mediaController);
//        mediaController.setMediaPlayer(videoView);
//        videoView.requestFocus();
//        videoView.start();
        File file = new File(Environment.getExternalStorageDirectory(),"/sdcard/shengrikuaile.mp4");
        videoView.setVideoPath("https://gslb.miaopai.com/stream/P4DnrjGZ7PzC2LfQK9k2cAKEIw39GiixIBpIHA__.mp4");
        //videoView.setVideoPath(file.getPath());
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,int[] grantResults){
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initVideoPath();
                } else {
                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }
    @Override
        public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_bt:
                if (!videoView.isPlaying()) {
                    videoView.start();
                }
                break;
            case R.id.pause_bt:
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
                break;
            case R.id.reply_bt:
                if (videoView.isPlaying()) {
                    videoView.resume();
                    initVideoPath();
                }
                break;
            default:
                break;
        }
    }
    protected void onDestroy() {

        super.onDestroy();
        if (videoView != null){
            videoView.suspend();
        }
    }
}
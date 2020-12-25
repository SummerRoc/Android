package com.example.maptext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.baidu.mapapi.map.MapView;

public class MainActivity extends AppCompatActivity {
    private MapView MapView = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取地图控件引用
        MapView = (MapView) findViewById(R.id.mapView);
    }
    @Override
    protected void onResume () {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        MapView.onResume();
    }
    @Override
    protected void onPause () {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        MapView.onPause();
    }
    @Override
    protected void onDestroy () {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        MapView.onDestroy();
    }
}
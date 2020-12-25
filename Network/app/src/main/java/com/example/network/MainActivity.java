package com.example.network;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private Button b1;
    private TextView t1;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.send_request);
        t1=findViewById(R.id.response_text);
        b1.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.send_request)
            sendRequest();
    }

    public void sendRequest() {

        //1,创建OKHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = "http://www.baidu.com";
        //注意我这里用的是http而不是https

        //2,创建一个Request
        final Request request = new Request.Builder()
                .url(url)
                .build();

        //3,创建一个call对象
        Call call = okHttpClient.newCall(request);

        //4,将请求添加到调度中
        call.enqueue(new Callback() {

            @Override
            public void onResponse( Call call,  Response response) throws IOException {
                Log.d(TAG, "onResponse:response ");		//用来看是否有响应
                final String data=response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        t1.setText(data);
                    }
                });
            }
            @Override
            public void onFailure( Call call,  IOException e) {
                Log.d(TAG, "onFailure: failure");	//用来看是否失败
            }
        });

    }
}
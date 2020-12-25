package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private Button bt;
    private TextView text;
    private ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bt = findViewById(R.id.bt);
        text = findViewById(R.id.text);
        pb = findViewById(R.id.pb);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownLoadTask().execute();
            }
        });
    }
    public class DownLoadTask extends AsyncTask<Void,Integer,Boolean> {
        @Override
        protected Boolean doInBackground(Void... voids) {
            int a = 0;
            while(a<=100){
                publishProgress(a);
                a+=10;
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            text.setText("下载完成");
            bt.setText("下载完成");
        }

        @Override
        protected void onPreExecute() {
            bt.setText("正在下载");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            text.setText("当前进度"+values[0]+"%");
            pb.setProgress(values[0]);
        }
    }
}
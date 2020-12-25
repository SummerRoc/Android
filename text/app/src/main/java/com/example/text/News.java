package com.example.text;

import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.text.db.Student;

import org.litepal.LitePal;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class News extends AppCompatActivity {
    private List<String> news;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        textView=findViewById(R.id.news_url_id);
        sendRequestWithHttp();
        // LitePal.deleteAll(Simple.class);
        LitePal.getDatabase();
        Simple simple1=new Simple("","");
        simple1.save();
        Simple simple2=new Simple("","");
        simple2.save();
        Simple simple3=new Simple("","");
        simple3.save();
        Staff staff=new Staff("111111","111111","xp","517021910503","123",19);
        staff.save();
        LitePal.deleteAll(Student.class);
        LitePal.deleteAll(Book.class);
        Student student1=new Student("123","123","qjc","123","123",123);
        student1.save();
        Student student2=new Student("234","234","ds","234","234",234);
        student2.save();
        Student student3=new Student("345","345","hy","345","345",345);
        student3.save();
        Book book1=new Book("abc","abc","123","123","123",9);
        book1.save();
        Book book2=new Book("AAA","AAA","356","345","64",12);
        book2.save();
    }
    private void sendRequestWithHttp()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url("http://www.lib.sjtu.edu.cn").build();
                    Response response=client.newCall(request).execute();
                    String responsedate=response.body().string();
                    showResponse(responsedate);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private void showResponse(final String response)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(response);
            }
        });
    }

    @Override
    protected void onPause() {
        Intent intent=new Intent(News.this,MainActivity.class);
        startActivity(intent);
        super.onPause();
    }
}

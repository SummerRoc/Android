package com.example.text;

import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.text.login.Login_student;
import com.example.text.register.Register_student;

public class MainActivity extends AppCompatActivity {

    private Button button_introduce,button_information,button_ranking,button_newBooks,button_register_student;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.student_id:
                Intent intent_student=new Intent(MainActivity.this, Login_student.class);
                startActivity(intent_student);
                break;
            /*case R.id.teacher_id:
                Intent intent_teacher=new Intent(MainActivity.this,Login_teacher.class);
                startActivity(intent_teacher);
                break;*/
            case R.id.staff_id:
                Intent intent_staff=new Intent(MainActivity.this,Login_staff.class);
                startActivity(intent_staff);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_introduce=findViewById(R.id.introduce_id);
        button_register_student=findViewById(R.id.registerStudent_id);
        button_information=findViewById(R.id.news_id);
        button_ranking=findViewById(R.id.ranking_id);
        button_newBooks=findViewById(R.id.newBook_id);

        button_introduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Introduction.class);
                startActivity(intent);
                finish();
            }
        });
        button_register_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Register_student.class);
                startActivity(intent);
                finish();
            }
        });

        button_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,News.class);
                startActivity(intent);
                finish();
            }
        });
        button_ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Ranking.class);
                startActivity(intent);
                finish();
            }
        });
        button_newBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,New_Books.class);
                startActivity(intent);
                finish();
            }
        });

    }
}

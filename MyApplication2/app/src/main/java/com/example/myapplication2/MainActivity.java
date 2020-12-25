package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

//    private Button save;
//    private Button read;
//    private Button create;
    private TextView data;
    private Button add;
    private Button delete;
    private Button find;
    private Button updata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        save = findViewById(R.id.save);
//        read = findViewById(R.id.read);
        data = findViewById(R.id.data);
//        create = findViewById(R.id.create);
        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        find = findViewById(R.id.find);
        updata = findViewById(R.id.updata);
//
//        create.setOnClickListener(this);
        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        find.setOnClickListener(this);
        updata.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.create:
                create();
                break;
            case R.id.add:
                add();
                break;
            case R.id.delete:
                delete();
                break;
            case R.id.find:
                find();
                break;
            case R.id.updata:
                updata();
                break;
            default:
                break;
        }
    }

     void updata() {

    }

    void delete() {

    }


    void create(){
        Connector.getWritableDatabase();
    }

    void add(){
        Book book = new Book(125,"xp",20,256,"skyblue");
        book.save();
    }

    void find(){
        List<Book> books = DataSupport.findAll(Book.class);
        for(Book book: books){
            Log.d("MainActivity",book.getName());
            Toast.makeText(MainActivity.this,data.toString(),Toast.LENGTH_SHORT).show();
        }

//        save=findViewById(R.id.save);
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
//                editor.putString("name","Alex");
//                editor.putInt("age",20);
//                editor.apply();
//            }
//        });
//        read=findViewById(R.id.read);
//        data=findViewById(R.id.data);
//        read.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences sp =getSharedPreferences("data",MODE_PRIVATE);
//                String name = sp.getString("name","");
//                int age =sp.getInt("age",0);
//               data.setText("姓名为" + name +","+ "年龄为" +age);
//
//            }
//        });
//
//        create=findViewById(R.id.create);
//        create.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Connector.getDatabase();
//            }
//        });
//
//        add = findViewById(R.id.add);
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Book book =new Book(526,"ncx",22,20,"xznc");
//                book.save();
//            }
//        });
    }
}
package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;


public class Homepage extends AppCompatActivity implements View.OnClickListener{

    private Button add,update,search,delete;
    private TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        add = findViewById(R.id.add_books);
        update = findViewById(R.id.update);
        search = findViewById(R.id.find);
        delete = findViewById(R.id.delete);
        data = findViewById(R.id.data);

//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Book book = new Book(1,"xp",20.8,256,"skyblue");
//                book.save();
//            }
//        });
//
//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Book book = new Book(1,"xp",20.2,256,"skyblue");
////                book.save();
//            }
//        });
//
//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                List<Book> books = DataSupport.findAll(Book.class);
//                for (Book book : books) {
//                    Log.d("Homepage", book.getName());
//                    Toast.makeText(Homepage.this, data.toString(), Toast.LENGTH_SHORT).show();
//                }
//            }
//    });
//
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                DataSupport.deleteAll(Book.class,"price < ?","15");
//            }
//        });
        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        search.setOnClickListener(this);
        update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.add_books:
                add();
                break;
            case R.id.delete:
                delete();
                break;
            case R.id.find:
                search();
                break;
            case R.id.update:
                update();
                break;
            default:
                break;
        }
    }

    void update() {
//       Book book = new Book(1,"xp",20.2,256,"skyblue");
//       book.save();
//        Toast.makeText(Homepage.this,"修改成功",Toast.LENGTH_SHORT).show();
    }

    void delete() {
//       DataSupport.deleteAll(Book.class,"price < ?","15");
//        Toast.makeText(Homepage.this,"删除成功",Toast.LENGTH_SHORT).show();
    }


        void add(){
            Book book = new Book(2,"xp",22.2,100,"yitaqi");
            book.save();
        Toast.makeText(Homepage.this,"添加成功",Toast.LENGTH_SHORT).show();
    }

    void search() {
        List<Book> books = DataSupport.findAll(Book.class);
        String value = "";
        for (Book book : books) {
            Log.d("Homepage", book.getName());
            Toast.makeText(Homepage.this, data.toString(), Toast.LENGTH_SHORT).show();
            value = value + "作者"+book.getAuthor()+"书名："+book.getName() + "\n";

        }
        data.setText(value);
    }


}
package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class BooksView extends AppCompatActivity {
    private List<Book> bookList = new ArrayList<>();
    private SearchView searchView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booksview);

        initBooks();

        searchView=findViewById(R.id.sv);

        listView=findViewById(R.id.list_id);

        BookAdapter bookAdapter = new BookAdapter(BooksView.this,R.layout.activity_book_item,bookList);
        listView.setAdapter(bookAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = bookList.get(position);
            }
        });

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public void initBooks(){
        List<Book> books = DataSupport.findAll(Book.class);
        for (Book book:books){
            bookList.add(book);
        }
    }
}
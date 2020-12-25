package com.example.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    private  int resourceId;

    public BookAdapter(Context context, int textViewResourceId, List<Book> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book book = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        TextView bookName =(TextView) view.findViewById(R.id.name);
        bookName.setText(book.getName());

        TextView bookAuthor =(TextView) view.findViewById(R.id.author);
        bookAuthor.setText(book.getAuthor());

        TextView bookPages =(TextView) view.findViewById(R.id.pages);
        bookPages.setText(book.getPages() + "");

        TextView bookPrice =(TextView) view.findViewById(R.id.price);
        bookPrice.setText(book.getPrice() + "");
        return view;
    }
}

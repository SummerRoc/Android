package com.example.text;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class Book extends LitePalSupport{
    int id;
    private String name;
    private String writer,page,price,time;
    private int amount,in_shelf;
    public Book(String name,String writer,String page,String price,String time,int amount)
    {
        this.name=name;
        this.writer=writer;
        this.page=page;
        this.price=price;
        this.time=time;
        this.amount=amount;
        in_shelf=amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIn_shelf() {
        return in_shelf;
    }

    public void setIn_shelf(int in_shelf) {
        this.in_shelf = in_shelf;
    }
}

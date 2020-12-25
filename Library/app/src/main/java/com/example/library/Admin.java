package com.example.library;

import org.litepal.crud.DataSupport;

public class Admin extends DataSupport {
    private String account,password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Admin{" +
                "account=" + account +
                ", password='" + password + '\'' +
                '}';
    }
}

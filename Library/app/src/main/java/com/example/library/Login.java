package com.example.library;

import android.content.Context;
import android.content.Intent;


import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class Login extends AppCompatActivity {
    private boolean isRemeber = false;
    private EditText editAccount,editPassword;
    private CheckBox checkBox;
    private Button button_commit;
    private Button add;
    private String account,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        add=findViewById(R.id.add_id);
        editAccount=findViewById(R.id.account_id);
        editPassword=findViewById(R.id.password_id);
        checkBox=findViewById(R.id.rememberPass_id);
        button_commit=findViewById(R.id.commit_id);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Admin admin = new Admin();
                admin.setAccount("xp");
                admin.setPassword("123456");
                admin.save();
            }
        });

        Log.d("TAG", "account+password");


//        // 判断数据库是否有用户数据，有则不用登录
//        List<Admin> adminList = DataSupport.findAll(Admin.class);
//        if(adminList.size()>0){
//            Intent intent = new Intent(Login.this,MainActivity.class);
//            Toast.makeText(Login.this,"登录成功！",Toast.LENGTH_LONG).show();
//            startActivity(intent);
//        }


        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        account = pref.getString("account","");
        password = pref.getString("password","");
        Log.d("TAG", "onCreate: "+account+password);

        // 判断是否有记住保存的密码
//        assert password != null;
        if(!account.equals("") && !password.equals("")){
            editAccount.setText(account);
            editPassword.setText(password);
            checkBox.setChecked(true);
        }else {

        }


        button_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRemeber = checkBox.isChecked();
                List<Admin> admin_account = LitePal.findAll(Admin.class);
                boolean is_account_available = false;
                String account = editAccount.getText().toString();
                String password = editPassword.getText().toString();
                if(password.equals("")|| account.equals("")){
                    Toast.makeText(Login.this,"请输入账号密码！！",Toast.LENGTH_LONG).show();
                }
                for (int i = 0; i < admin_account.size(); ++i) {
                    if (account.equals(admin_account.get(i).getAccount())) {
                        is_account_available = true;
                        if (password.equals(admin_account.get(i).getPassword())) {
                            // setRemember();

                            SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                            editor.putString("account",account);
                            editor.putString("password",password);
                            editor.apply();

                            Intent intent = new Intent(Login.this, MainActivity.class);
                            intent.putExtra("extra_data", i+1);
                            Toast.makeText(Login.this,"登录成功！",Toast.LENGTH_LONG).show();
                            startActivity(intent);
                             finish();
                        } else {
                            Toast.makeText(Login.this, "密码错误", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                }
                if (is_account_available == false) {
                    Toast.makeText(Login.this, "账号不存在", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void setRemember(){

        // 选中记住密码
        if(isRemeber){
            SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
            editor.putString("account",account);
            editor.putString("password",password);
            editor.apply();
            Log.d("TAG", "保存");


        }
    }
}

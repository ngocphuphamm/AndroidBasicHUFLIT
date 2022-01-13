package com.android.foodorderapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    //    ImageView imageView2;
    EditText edtUsername, edtPassword;
    Button btnLogin, btnRegister;   SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

//        imageView2 = findViewById(R.id.imageView2);
        edtUsername = findViewById(R.id.edEmailDN);
        edtPassword= findViewById(R.id.edPasswordDN);
        btnLogin = findViewById(R.id.btnCreate);
        btnRegister = findViewById(R.id.btnAlready);
        sharedPreferences = getApplicationContext().getSharedPreferences("dataLogin", MODE_PRIVATE);
        String userName = sharedPreferences.getString("username", "ngocphupham682001");
        String passWord = sharedPreferences.getString("password", "1234567");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtUsername.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty())
                {
                    Toast.makeText(LoginActivity.this,"Nhap password hoac username vao di ",Toast.LENGTH_SHORT).show();
                }else if(edtPassword.getText().toString().length() <6)
                    edtPassword.setError("nhỏ hơn 6 số ");
                else if (!(edtUsername.getText().toString().equals(userName)))
                {
                    Toast.makeText(LoginActivity.this, "Tài khoản chưa tồn tại", Toast.LENGTH_SHORT).show();
                }
                else if (!(edtPassword.getText().toString().equals(passWord)))
                {
                    Toast.makeText(LoginActivity.this, "sai pasword", Toast.LENGTH_SHORT).show();
                }
                else if(edtUsername.getText().toString().equals(userName)&&(edtPassword.getText().toString().equals(passWord)))
                {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("username", edtUsername.getText().toString());
                    intent.putExtra("password", edtPassword.getText().toString());
                    edtUsername.setText(userName);
                    edtPassword.setText(passWord);
                    startActivity(intent);
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==101){
            edtUsername.setText(data.getStringExtra("mail"));
            edtPassword.setText(data.getStringExtra("pass"));
        }
    }
}
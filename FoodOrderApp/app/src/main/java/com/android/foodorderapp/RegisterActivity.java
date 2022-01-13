package com.android.foodorderapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edEmailDN, edPasswordDN, edConfirmPassword;
    Button btnCrate, btnAlready;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        edEmailDN = findViewById(R.id.edEmailDN);
        edPasswordDN = findViewById(R.id.edPasswordDN);
        edConfirmPassword = findViewById(R.id.edConfirmPassword);
        btnCrate = findViewById(R.id.btnCreate);
        btnAlready = findViewById(R.id.btnAlready);

        btnCrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = edEmailDN.getText().toString();
                String pass = edPasswordDN.getText().toString();
                String conform = edConfirmPassword.getText().toString();
                if(pass.compareToIgnoreCase(conform) == 0){
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("mail", mail);
                    intent.putExtra("pass", pass);
                    setResult(101,intent);
                    finish();
                    Toast.makeText(RegisterActivity.this, "Đăng ký thành công !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.android.foodorderapp;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
               onClickSignIn();
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
    private void onClickSignIn()
    {
        String email = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finishAffinity();
                        } else {

                            Toast.makeText(LoginActivity.this, "Đăng nhập thất bại.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}
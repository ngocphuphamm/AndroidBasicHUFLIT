package com.android.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    EditText edEmailDN, edPasswordDN, edConfirmPassword;
    Button btnCrate, btnAlready;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        edEmailDN = findViewById(R.id.edEmailDN);
        edPasswordDN = findViewById(R.id.edPasswordDN);
        edConfirmPassword = findViewById(R.id.edConfirmPassword);
        btnCrate = findViewById(R.id.btnCreate);
        btnAlready = findViewById(R.id.btnAlready);

        initListener();
        btnAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initListener()
    {
        btnCrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = edEmailDN.getText().toString();
                String pass = edPasswordDN.getText().toString();
                String conform = edConfirmPassword.getText().toString();
                if (edEmailDN.getText().toString().isEmpty() || edPasswordDN.getText().toString().isEmpty())
                {
                    Toast.makeText(RegisterActivity.this,"Nhap password hoac username vao di ",Toast.LENGTH_SHORT).show();
                }else if(edPasswordDN.getText().toString().length() <6)
                    edPasswordDN.setError("nhỏ hơn 6 số ");
                else
                if(pass.compareToIgnoreCase(conform) == 0){
                    onClickSignUp();

                }
            }
        });
    }
    private void onClickSignUp()
    {
        String email = edEmailDN.getText().toString().trim();
        String password = edPasswordDN.getText().toString().trim();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                             Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finishAffinity();
                        } else {

                            Toast.makeText(RegisterActivity.this, "Đăng ký thất bại.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}
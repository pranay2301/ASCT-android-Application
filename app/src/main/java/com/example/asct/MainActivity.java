package com.example.asct;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    TextView etEmail;
    TextView etPassword;
    TextView etRegister;
    Button   btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.Email);
        etPassword = findViewById(R.id.password);
        etRegister = findViewById(R.id.newAcc);
        btLogin = findViewById(R.id.loginbtn);

        mAuth = FirebaseAuth.getInstance();

        btLogin.setOnClickListener(view->{
            loginUser();
        });
        etRegister.setOnClickListener(view->{
            startActivity(new Intent(MainActivity.this,RegisterActivity.class));
        });
    }

    private void loginUser(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            etEmail.setError("Email cannot be empty");
            etEmail.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            etPassword.setError("Password cannot be empty");
            etPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "User Login Successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,MainScreen.class));
                    }else{
                        Toast.makeText(MainActivity.this,"Login Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}


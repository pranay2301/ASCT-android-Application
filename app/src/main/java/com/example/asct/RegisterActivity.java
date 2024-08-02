package com.example.asct;

import android  .content.Intent;
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

public class RegisterActivity extends AppCompatActivity {
    TextView etRegusername;
    TextView etRegemail;
    TextView etRegpassword;
    TextView etRegconfirmpassword;
    Button  btRegister;
    TextView etlogin;


    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etRegusername = findViewById(R.id.editTextTextPersonName);
        etRegemail = findViewById(R.id.inputEmailAddress);
        etRegpassword =findViewById(R.id.inputNumberPassword);
        etRegconfirmpassword=findViewById(R.id.ConfirmPassword2);
        btRegister=findViewById(R.id.button);
        etlogin = findViewById(R.id.loginHere);

        mAuth = FirebaseAuth.getInstance();

        btRegister.setOnClickListener(view->{
            CreateUser();
        });

        etlogin.setOnClickListener(view->{
            startActivity(new Intent(RegisterActivity.this,MainActivity.class));
        });
    }
    private void CreateUser(){
        String email = etRegemail.getText().toString();
        String password = etRegpassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            etRegemail.setError("Email cannot be empty");
            etRegemail.requestFocus();
        }else if (TextUtils.isEmpty(password)) {
            etRegpassword.setError("Password cannot be empty");
            etRegpassword.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "User Register Successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                    }else{
                        Toast.makeText(RegisterActivity.this,"Registartion Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}

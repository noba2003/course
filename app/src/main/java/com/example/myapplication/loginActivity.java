package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextInputLayout email, password;
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password_login);
        register=findViewById(R.id.btn_register_login);
        login=findViewById(R.id.btn_login_save);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginActivity.this,registerActivity.class);
                startActivity(intent);
                finish();
            }
        });
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String sendemail = email.getEditText().getText().toString();
               String sendpassword = password.getEditText().getText().toString();
               if (sendemail.isEmpty()) {
                   email.getEditText().setError("enter valid email address");
                   return;
               }
               if (sendpassword.isEmpty() && sendpassword.length() >8) {
                   password.getEditText().setError("enter valid password");
                   return;
               }
               mAuth.signInWithEmailAndPassword(sendemail, sendpassword)
                       .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {
                                   Intent intent=new Intent(loginActivity.this,MainActivity.class);
                                   startActivity(intent);
                                   finish();
                                   // Sign in success, update UI with the signed-in user's information
                               } else {
                                   // If sign in fails, display a message to the user.
                                   Toast.makeText(loginActivity.this, "Authentication failed.",
                                           Toast.LENGTH_SHORT).show();
                               }

                           }
                       });
           }
       });
    }
}
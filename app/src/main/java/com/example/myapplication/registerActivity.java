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
import com.google.firebase.auth.FirebaseUser;

public class registerActivity extends AppCompatActivity {
    TextInputLayout email, password, repassword;
    Button save, cancel;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password_login);
        repassword = findViewById(R.id.repassword);
        save = findViewById(R.id.btn_login_save);
        cancel = findViewById(R.id.cancel);
        mAuth = FirebaseAuth.getInstance();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendemail = email.getEditText().getText().toString();
                String sendpassword = password.getEditText().getText().toString();
                String sendrepassword = repassword.getEditText().getText().toString();
                if (sendemail.isEmpty()) {
                    email.getEditText().setError("enter valid email address");
                    return;
                }
                if (sendpassword.isEmpty() && sendrepassword.isEmpty()&&sendpassword.equals(sendrepassword)) {
                    password.getEditText().setError("enter valid password");
                    repassword.getEditText().setError("enter valid password");
                    return;
                }


                mAuth.createUserWithEmailAndPassword(sendemail, sendpassword)
                        .addOnCompleteListener(registerActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Intent intent=new Intent(registerActivity.this,loginActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(registerActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });


            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
}
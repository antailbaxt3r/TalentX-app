package com.example.rathorekaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private EditText password, confirmPassword;
    private EditText name, username, email, contact;
    private LinearLayout registerButton, content;
    private ShimmerFrameLayout shimmerFrameLayout;
    private String nameText, usernameText, passwordText, emailText, confirmPasswordText, contactText;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name_register);
        username= findViewById(R.id.username_register);
        email = findViewById(R.id.email_register);
        contact = findViewById(R.id.contact_register);
        password = findViewById(R.id.password_register);
        confirmPassword = findViewById(R.id.confirm_password_register);
        registerButton = findViewById(R.id.register_button);
        shimmerFrameLayout = findViewById(R.id.shimmer_container_register);
        shimmerFrameLayout.setVisibility(View.GONE);
        content = findViewById(R.id.content_register);

        firebaseAuth = FirebaseAuth.getInstance();

        nameText = name.getText().toString();
        usernameText = username.getText().toString();
        emailText = email.getText().toString();
        passwordText = password.getText().toString();
        confirmPasswordText = confirmPassword.getText().toString();
        contactText = contact.getText().toString();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(nameText == null) && !(usernameText == null) && !(emailText == null) && !(contactText == null) &&  !(passwordText == null) && !(confirmPasswordText.equals(""))){
                    if(passwordText == confirmPasswordText){

                        shimmerFrameLayout.startShimmerAnimation();
                        shimmerFrameLayout.setVisibility(View.VISIBLE);
                        content.setVisibility(View.INVISIBLE);

                        firebaseAuth.createUserWithEmailAndPassword(emailText, passwordText)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()){
                                            Intent intent = new Intent(Register.this, HomeActivity.class);
                                            startActivity(intent);
                                        }else{
                                            Toast.makeText(Register.this, "Could not register user", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                    }
                }else{
                    Toast.makeText(Register.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}

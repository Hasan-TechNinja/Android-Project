package com.example.finalapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class signup extends AppCompatActivity {

    EditText username1, email1,password1,confermpassword1;
    Button register1;
    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


                mAuth = FirebaseAuth.getInstance();

        username1 = findViewById(R.id.username);
        email1 = findViewById(R.id.email);
        password1 = findViewById(R.id.password);
        confermpassword1 = findViewById(R.id.repassword);
        register1 = findViewById(R.id.register);


        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email= email1.getText().toString().trim();
                String password = password1.getText().toString().trim();
                final String username=username1.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    email1.setError("Email is Required");
                    return ;

                }
                if (TextUtils.isEmpty(password)){
                    password1.setError("Password is Required");
                    return ;
            }

                if (password.length()<6){
                        password1.setError("Password Must be >=6 character");
                        return ;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();

                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(username)
                                            .build();

                                    user.updateProfile(profileUpdates)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Log.d(TAG, "User profile updated.");
                                                    }
                                                }
                                            });

                                    startActivity(new Intent(signup.this, Homepage.class));

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(signup.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });
    }


}
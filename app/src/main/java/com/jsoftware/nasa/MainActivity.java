package com.jsoftware.nasa;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    EditText email_editText;
    EditText password_editText;
    Button loginButton;
    TextView register_TextView, nameDTXT;

    Boolean log = true;
    String email, password;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        nameDTXT = findViewById(R.id.name_editText);
        email_editText = findViewById(R.id.email_editText);
        password_editText = findViewById(R.id.password_editText);
        loginButton = findViewById(R.id.login_button);
        register_TextView = findViewById(R.id.register_textView);

        register_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginButton.setText("Register");
                register_TextView.setVisibility(View.INVISIBLE);
                nameDTXT.setVisibility(View.VISIBLE);
                log = false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = email_editText.getText().toString();
                password = password_editText.getText().toString();
                if (!log){
                    createNewUser(email, password);
                }else if (log){
                    signInUser(email, password);
                }

            }
        });
    }

    private void createNewUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(MainActivity.this, UserInterface.class);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void signInUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(MainActivity.this, UserInterface.class);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

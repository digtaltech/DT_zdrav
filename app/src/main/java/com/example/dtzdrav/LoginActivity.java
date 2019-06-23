package com.example.dtzdrav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText login;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.editTextEmail);
        pass = findViewById(R.id.editTextPassword);
    }

    public void onButtonLogin(View view){
        if (true){
            startActivity(new Intent(LoginActivity.this, MenuActivity.class));
        } else {
            //error login
        }
    }

}

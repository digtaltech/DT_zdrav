package com.example.dtzdrav;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.editText);
        pass = findViewById(R.id.editText2);
    }

    public void onButtonLogin(View view){
        if (true){
            startActivity(new Intent(MainActivity.this, MenuActivity.class));
        } else {
            //error login
        }
    }
}

package com.example.panda;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText passwork;
    private Button sigb_in;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        passwork = findViewById(R.id.password);
        sigb_in = findViewById(R.id.sign_in);
        register = findViewById(R.id.register);



        sigb_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(username.getText().toString().equals("admin") && passwork.getText().toString().equals("123456")){
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Password or username is not correct",Toast.LENGTH_SHORT).show();
                }







            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });



    }
}

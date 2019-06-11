package com.example.panda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {

    private EditText username_register;
    private EditText password_register;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        username_register = findViewById(R.id.edt_chaneusername);
        password_register = findViewById(R.id.edt_chanepassword);
        Button register =  findViewById( R.id.register_accout);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (username_register.getText().toString().trim().equals("") || password_register.getText().toString().trim().equals("")) {
                        Toast.makeText(getApplicationContext(), "Fill in the username and password", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Register your account successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Register.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (Exception e) {

                }
            }
        });

    }
}

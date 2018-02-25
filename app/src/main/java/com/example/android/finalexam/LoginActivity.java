package com.example.android.finalexam;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "loginSharedPref";
    private EditText username, password;
    private Button submitButton;
    private SharedPreferences login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        submitButton = findViewById(R.id.submit_button);

        final String enteredUserName = username.getText().toString();
        final String enteredPassWord = password.getText().toString();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(enteredUserName)){
                    Toast.makeText(getApplicationContext(), "Please enter a username", Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(enteredPassWord)){
                    Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}

package com.example.android.finalexam;

import android.content.Intent;
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
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        submitButton = findViewById(R.id.submit_button);
        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        //sharedPrefCheck();
        start();

    }

//    private void sharedPrefCheck() {
//
//        SharedPreferences preferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
//        String checkUser = "username" + username.getText().toString();
//        String checkPassword = "password" + username.getText().toString();
//
//        if (checkUser == null) {
//
//            start();
////            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
////            intent.putExtra("currentUser", username.getText().toString());
////            startActivity(intent);
//        }
//        finish();
//    }


    private void start() {


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredUserName = username.getText().toString();
                String enteredPassWord = password.getText().toString();

                SharedPreferences.Editor editor = login.edit();

                if (TextUtils.isEmpty(enteredPassWord) || TextUtils.isEmpty(enteredUserName)) {
                    Toast.makeText(getApplicationContext(), "Please enter a password and username", Toast.LENGTH_SHORT).show();

                } else {
                    checkUsername(enteredPassWord, enteredUserName);
                    if (checkUsername(enteredPassWord, enteredUserName)) {
                        editor.putString("username", enteredUserName);
                        editor.putString("password", enteredPassWord);
                        editor.commit();

                        Intent intent = new Intent(LoginActivity.this, BreedsActivity.class);
                        intent.putExtra("username", SHARED_PREFS_KEY);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Password cannot contain username", Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });


    }


    public static boolean checkUsername(String userPassword, String userName) {

        if (userName == "" || userPassword == "") {
            return false;

        }

        if (userPassword.contains(userName)) {
            return false;
        } else {
            return true;
        }

    }

}

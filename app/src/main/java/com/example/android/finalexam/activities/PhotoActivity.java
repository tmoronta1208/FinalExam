package com.example.android.finalexam.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.android.finalexam.R;
import com.squareup.picasso.Picasso;

public class PhotoActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        imageView = findViewById(R.id.photo_image_view);

        Intent intent = getIntent();
        String message = intent.getStringExtra("url");

        Picasso.with(getApplicationContext()).load(message).into(imageView);
    }
}

package com.example.android.finalexam.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.android.finalexam.R;
import com.example.android.finalexam.controller.PuppyAdapter;
import com.example.android.finalexam.model.Breed;
import com.example.android.finalexam.model.Images;
import com.example.android.finalexam.model.Message;
import com.example.android.finalexam.network.PuppyService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView displayText;
    Images images;
    List<Images> messageList;
    final static String BASE_URL = "https://dog.ceo/api/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs);
        recyclerView = findViewById(R.id.rv);
        displayText = findViewById(R.id.display_name);
        Intent intent = getIntent();
        String displayString = "You chose: " + intent.getStringExtra("key");
        displayText.setText(displayString);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PuppyService puppyService = retrofit.create(PuppyService.class);
        Call<Images> call1 = puppyService.getPuppyImages(intent.getStringExtra("key"));
        call1.enqueue(new Callback<Images>() {
            @Override
            public void onResponse(Call<Images> call, Response<Images> response) {
                Log.d("CALLCHECK", "SUCCESS");
              //  images = response.body();
                //Log.d("CHECKING SIZE", response.body().getMessage().toString());
             //   messageList = images.getMessage();
              //  PuppyAdapter puppyAdapter = new PuppyAdapter(messageList);
//                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
//
//                recyclerView.setAdapter(puppyAdapter);
//                recyclerView.setLayoutManager(gridLayoutManager);


            }

            @Override
            public void onFailure(Call<Images> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}

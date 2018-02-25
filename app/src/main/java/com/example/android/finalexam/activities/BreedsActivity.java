package com.example.android.finalexam.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.finalexam.R;
import com.example.android.finalexam.model.Breed;
import com.example.android.finalexam.network.PuppyService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BreedsActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView terrierImage, spanielImage, retrieverImage, poodleImage;
    CardView terrierCard, spanielCard, retrieverCard, poodleCard;
    Breed breed;
    String image;
    final static String BASE_URL = "https://dog.ceo/api/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeds);


        textView = findViewById(R.id.welcome_textview);

        terrierImage = findViewById(R.id.breed_one_image);
        spanielImage = findViewById(R.id.breed_two_image);
        retrieverImage = findViewById(R.id.breed_three_image);
        poodleImage = findViewById(R.id.breed_four_image);

        terrierCard = findViewById(R.id.card_terrier);
        spanielCard = findViewById(R.id.card_spaniel);
        retrieverCard = findViewById(R.id.card_retriever);
        poodleCard = findViewById(R.id.card_poodle);


        terrierCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent terrierIntent = new Intent(BreedsActivity.this, DogsActivity.class);
                terrierIntent.putExtra("key", "terrier");
                startActivity(terrierIntent);

            }
        });

        spanielCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent spanielIntent = new Intent(BreedsActivity.this, DogsActivity.class);
                spanielIntent.putExtra("key", "spaniel");
                startActivity(spanielIntent);
            }
        });

        retrieverCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retrieverIntent = new Intent(BreedsActivity.this, DogsActivity.class);
                retrieverIntent.putExtra("key", "retriever");
                startActivity(retrieverIntent);
            }
        });

        poodleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent poodleIntent = new Intent(BreedsActivity.this, DogsActivity.class);
                poodleIntent.putExtra("key", "poodle");
                startActivity(poodleIntent);
            }
        });


        Intent intent = getIntent();
        intent.getExtras();
        if (intent.getExtras() == null) {
            Intent intent1 = new Intent(BreedsActivity.this, LoginActivity.class);
            startActivity(intent1);
        }
        String userWelcome = textView.getText().toString();
        textView.setText(userWelcome + intent.getStringExtra("username") + getString(R.string.question));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PuppyService puppyService = retrofit.create(PuppyService.class);
        Call<Breed> call1 = puppyService.getImage("terrier");
        Call<Breed> call2 = puppyService.getImage("spaniel");
        Call<Breed> call3 = puppyService.getImage("retriever");
        Call<Breed> call4 = puppyService.getImage("poodle");
        call1.enqueue(new Callback<Breed>() {
            @Override
            public void onResponse(Call<Breed> call, Response<Breed> response) {
                Log.d("CALLCHECK", "SUCCESS");

                breed = response.body();
                image = breed.getMessage();
                Picasso.with(getApplicationContext()).load(image).fit().into(terrierImage);

            }

            @Override
            public void onFailure(Call<Breed> call, Throwable t) {
                t.printStackTrace();
            }
        });
        call2.enqueue(new Callback<Breed>() {
            @Override
            public void onResponse(Call<Breed> call, Response<Breed> response) {
                breed = response.body();
                image = breed.getMessage();
                Picasso.with(getApplicationContext()).load(image).fit().into(spanielImage);

            }

            @Override
            public void onFailure(Call<Breed> call, Throwable t) {

            }
        });

        call3.enqueue(new Callback<Breed>() {
            @Override
            public void onResponse(Call<Breed> call, Response<Breed> response) {
                breed = response.body();
                image = breed.getMessage();
                Picasso.with(getApplicationContext()).load(image).fit().into(retrieverImage);

            }

            @Override
            public void onFailure(Call<Breed> call, Throwable t) {

            }
        });
        call4.enqueue(new Callback<Breed>() {
            @Override
            public void onResponse(Call<Breed> call, Response<Breed> response) {
                breed = response.body();
                image = breed.getMessage();
                Picasso.with(getApplicationContext()).load(image).fit().into(poodleImage);

            }

            @Override
            public void onFailure(Call<Breed> call, Throwable t) {

            }
        });


    }
}

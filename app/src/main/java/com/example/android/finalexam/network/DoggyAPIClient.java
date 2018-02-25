package com.example.android.finalexam.network;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.android.finalexam.R;
import com.example.android.finalexam.model.Breed;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TatianaM on 2/25/18.
 */

public class DoggyAPIClient implements retrofit2.Callback<Breed> {


    final static String BASE_URL = "https://dog.ceo/api/";
    Breed breed;


    public void serviceCall() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PuppyService puppyService = retrofit.create(PuppyService.class);
        Call<Breed> call = puppyService.getBreedImage();
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<Breed> call, Response<Breed> response) {

        Log.d("CALLCHECK","SUCCESS");

        String responseImage = response.body().toString();
    }

    @Override
    public void onFailure(Call<Breed> call, Throwable t) {
        t.printStackTrace();

    }
}

package com.example.android.finalexam.network;

import com.example.android.finalexam.model.Breed;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by TatianaM on 2/25/18.
 */

public interface PuppyService {

    @GET("/api/breed/terrier/images/random")
    Call<Breed> getBreedImage();
}

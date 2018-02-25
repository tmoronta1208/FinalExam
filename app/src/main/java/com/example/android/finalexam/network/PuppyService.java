package com.example.android.finalexam.network;

import com.example.android.finalexam.model.Breed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by TatianaM on 2/25/18.
 */

public interface PuppyService {



    @GET("/api/breed/{breed-name}/images/random")
    Call<Breed> getImage(@Path("breed-name")String terrier);


//    @GET("/api/breed/{breed-name}/images/random")
//    Call<Breed> getTerrierImage(@Path("breed-name")String spaniel);
//
//    @GET("/api/breed/retriever/images/random")
//    Call<Breed> getRetriever();
//
//    @GET("/api/breed/poodle/images/random")
//    Call<Breed> getPoodleImage();
}

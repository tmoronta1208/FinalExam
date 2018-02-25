package com.example.android.finalexam.network;

import com.example.android.finalexam.model.Breed;
import com.example.android.finalexam.model.Images;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by TatianaM on 2/25/18.
 */

public interface PuppyService {



    @GET("/api/breed/{breed-name}/images/random")
    Call<Breed> getImage(@Path("breed-name")String puppy);




    @GET("/breed/{breed-name}/images")
    Call<Images> getPuppyImages(@Path("breed-name")String puppies);
//
//    @GET("/api/breed/retriever/images/random")
//    Call<Breed> getRetriever();
//
//    @GET("/api/breed/poodle/images/random")
//    Call<Breed> getPoodleImage();
}

package com.delaroystudios.javadevelopers.api;

import com.delaroystudios.javadevelopers.model.ItemResponse;
import com.delaroystudios.javadevelopers.model.YouTubeItems;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by delaroy on 3/22/17.
 */
public interface Service {
    @GET("/search/users")
    Call<ItemResponse> getItems(@Query("q") String q);


}

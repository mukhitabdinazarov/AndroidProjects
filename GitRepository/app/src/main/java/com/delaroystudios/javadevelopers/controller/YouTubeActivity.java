package com.delaroystudios.javadevelopers.controller;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.delaroystudios.javadevelopers.api.ApiService;
import com.delaroystudios.javadevelopers.api.Service;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import com.delaroystudios.javadevelopers.R;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YouTubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    public static final String BASE_URL = "https://www.googleapis.com";
    public static final String KEY = "AIzaSyBqBEHFN6wdPVFuimqERu-usXHbbAavy_4";
    public  String VIDEO_ID ="";
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    YouTubePlayerFragment youTubePlayerFragment;

    Service apiService;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_activity);

        youTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager().findFragmentById(R.id.youtube_player_fragment);
        youTubePlayerFragment.initialize(KEY,this);

        VIDEO_ID = getIntent().getStringExtra("id");


/*
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!TextUtils.isEmpty(searchYoutube.getText().toString())){
                    final ApiService apiService = retrofit.create(ApiService.class);
                    final Call<JSONObject> resp = apiService.getYoutubeItems(searchYoutube.getText().toString());
                    resp.enqueue(new Callback<JSONObject>() {
                        @Override
                        public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {



                            Toast.makeText(YouTubeActivity.this, response.body().toString(), Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<JSONObject> call, Throwable t) {

                        }
                    });

                }
                else {
                    Toast.makeText(YouTubeActivity.this, "asda", Toast.LENGTH_SHORT).show();
                }
            }
        });
*/


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if(!b){
            youTubePlayer.cueVideo(VIDEO_ID);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,RECOVERY_DIALOG_REQUEST).show();
        }
        else{
            String formatMessages = "There was an error initializing the youtube player";
            Toast.makeText(this, formatMessages, Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {

            getYouTubePlayerProvider().initialize(KEY, this);
        }
    }
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView)findViewById(R.id.youtube_player_fragment);

    }
}



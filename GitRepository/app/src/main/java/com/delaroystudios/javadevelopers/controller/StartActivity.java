package com.delaroystudios.javadevelopers.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.delaroystudios.javadevelopers.R;
public class StartActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText;
    Button searchGit;
    Button searchYoutube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        editText = (EditText) findViewById(R.id.editText);
        searchGit = (Button) findViewById(R.id.gitSearch);
        searchYoutube = (Button) findViewById(R.id.youtubeSearch);
        searchGit.setOnClickListener(this);
        searchYoutube.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(!TextUtils.isEmpty(editText.getText().toString())) {
            Intent intent;
            switch (view.getId()) {
                case R.id.gitSearch:
                    intent = new Intent(StartActivity.this, GitActivity.class);
                    intent.putExtra("name", editText.getText().toString());
                    startActivity(intent);
                    break;
                case R.id.youtubeSearch:
                    intent = new Intent(StartActivity.this, YouTubeActivity.class);
                    intent.putExtra("id", editText.getText().toString());
                    startActivity(intent);
                    break;
            }
        }
        else{
            Toast.makeText(this, "Please fill in the text", Toast.LENGTH_SHORT).show();
        }
    }


}

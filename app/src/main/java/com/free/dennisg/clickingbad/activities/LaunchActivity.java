package com.free.dennisg.clickingbad.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

/**
 * Created by Dennis Gimbergsson on 2017-09-30.
 **/

public class LaunchActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Gson gson;
    boolean isFirstStart;
    boolean mServiceBound = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Delay is to remove flicker in fade animation between activities
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                continueToNextActivity();
            }
        }, 750);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void continueToNextActivity() {
        startActivity(new Intent(this, MainActivity.class));

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
}

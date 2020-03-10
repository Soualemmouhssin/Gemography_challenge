package com.example.gemography_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new getData().execute() ;
    }




    private class getData extends AsyncTask<String, Void, String> {

        String ret = null ;
        // onPreExecute called before the doInBackgroud start for display
        // progress dialog.
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected String doInBackground(String... urls) {
            Repo repos[] = Repo.getReposFromStr(1) ;
            return null;

        }

        // onPostExecute displays the results of the doInBackgroud and also we
        // can hide progress dialog.
        @Override
        protected void onPostExecute(String result) {
            Log.d("debug", "repos execution done") ;

        }
    }


}



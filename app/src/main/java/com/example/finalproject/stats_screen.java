package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class stats_screen extends AppCompatActivity {

    TextView stat1, stat2, stat3, stat4, stat5, stat6, stat7, stat8;

    int win1 = 0;
    int win2 = 0;
    int win3 = 0;
    int win4 = 0;
    int win5 = 0;
    int win6 = 0;
    int winNull = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_screen);

        //Log.d("stats_screen", "WIN 1: " + win1);

        stat1 = findViewById(R.id.stat1);
        stat2 = findViewById(R.id.stat2);
        stat3 = findViewById(R.id.stat3);
        stat4 = findViewById(R.id.stat4);
        stat5 = findViewById(R.id.stat5);
        stat6 = findViewById(R.id.stat6);
        stat7 = findViewById(R.id.stat7);
        stat8 = findViewById(R.id.stat8);

        stat1.setText(win1 + "");
        stat2.setText(win2 + "");
        stat3.setText(win3 + "");
        stat4.setText(win4 + "");
        stat5.setText(win5 + "");
        stat6.setText(win6 + "");
        stat7.setText(winNull + "");
        stat8.setText(win1+win2+win3+win4+win5+win6+winNull + "");
    }

    private void updateStats() {
        SharedPreferences sp = getSharedPreferences("shared", MODE_PRIVATE);
        win1 = sp.getInt("wins in 1 guess", 0);
        win2 = sp.getInt("wins in 2 guesses", 0);
        win3 = sp.getInt("wins in 3 guesses", 0);
        win4 = sp.getInt("wins in 4 guesses", 0);
        win5 = sp.getInt("wins in 5 guesses", 0);
        win6 = sp.getInt("wins in 6 guesses", 0);
        winNull = sp.getInt("losses", 0);

        stat1.setText(win1 + "");
        stat2.setText(win2 + "");
        stat3.setText(win3 + "");
        stat4.setText(win4 + "");
        stat5.setText(win5 + "");
        stat6.setText(win6 + "");
        stat7.setText(winNull + "");
        stat8.setText(win1+win2+win3+win4+win5+win6+winNull + "");
    }

    @Override
    public void onResume() {
        super.onResume();
        updateStats();
    }
}
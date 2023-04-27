package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button enterButton;
    Button playAgainButton;
    Button howToPlayButton;
    Button statsButton;
    EditText guessText;

    TextView letter1, letter2, letter3, letter4, letter5, letter6, letter7, letter8, letter9,
    letter10, letter11, letter12, letter13, letter14, letter15, letter16, letter17, letter18,
    letter19, letter20, letter21, letter22, letter23, letter24, letter25, letter26, letter27,
    letter28, letter29, letter30;
    TextView winStreakNum;

    private StringBuilder text = new StringBuilder();

    // Which guess the user is on
    int guessNum = 1;
    int winStreakNumInt = 0;

    int win1 = 0;
    int win2 = 0;
    int win3 = 0;
    int win4 = 0;
    int win5 = 0;
    int win6 = 0;
    int winNull = 0;

    String word;

    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterButton = findViewById(R.id.button);
        playAgainButton = findViewById(R.id.playAgainButton);
        howToPlayButton = findViewById(R.id.howToPlayButton);
        statsButton = findViewById(R.id.statsButton);
        guessText = findViewById(R.id.guessText);

        letter1 = findViewById(R.id.letter1);
        letter2 = findViewById(R.id.letter2);
        letter3 = findViewById(R.id.letter3);
        letter4 = findViewById(R.id.letter4);
        letter5 = findViewById(R.id.letter5);
        letter6 = findViewById(R.id.letter6);
        letter7 = findViewById(R.id.letter7);
        letter8 = findViewById(R.id.letter8);
        letter9 = findViewById(R.id.letter9);
        letter10 = findViewById(R.id.letter10);
        letter11 = findViewById(R.id.letter11);
        letter12 = findViewById(R.id.letter12);
        letter13 = findViewById(R.id.letter13);
        letter14 = findViewById(R.id.letter14);
        letter15 = findViewById(R.id.letter15);
        letter16 = findViewById(R.id.letter16);
        letter17 = findViewById(R.id.letter17);
        letter18 = findViewById(R.id.letter18);
        letter19 = findViewById(R.id.letter19);
        letter20 = findViewById(R.id.letter20);
        letter21 = findViewById(R.id.letter21);
        letter22 = findViewById(R.id.letter22);
        letter23 = findViewById(R.id.letter23);
        letter24 = findViewById(R.id.letter24);
        letter25 = findViewById(R.id.letter25);
        letter26 = findViewById(R.id.letter26);
        letter27 = findViewById(R.id.letter27);
        letter28 = findViewById(R.id.letter28);
        letter29 = findViewById(R.id.letter29);
        letter30 = findViewById(R.id.letter30);

        winStreakNum = findViewById(R.id.winStreakNum);


        // This is to read the text file of 5-letter words and turn it into a list
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("5_letter_words.txt")));

            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        // The actual list of 5-letter words
        List<String> wordsList = new ArrayList<String>(Arrays.asList(text.toString().split("\n")));

        word = wordsList.get(r.nextInt(1855 - 0)).toUpperCase();

        //Log.d("MainActivity", "chosen word: " + word);

        howToPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), how_to_play_activity.class);
                startActivity(i);
            }
        });

        statsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), stats_screen.class);
                startActivity(i);
            }
        });

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.super.recreate();
                onPause();
            }
        });

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Checks if guess is 5 letters
                if(guessText.length() == 5) {
                    List<TextView> letterList = Arrays.asList();
                    // For first guess letters
                    if(guessNum == 1) {
                        String let1 = guessText.getText().toString().toUpperCase().substring(0, 1);
                        String let2 = guessText.getText().toString().toUpperCase().substring(1, 2);
                        String let3 = guessText.getText().toString().toUpperCase().substring(2, 3);
                        String let4 = guessText.getText().toString().toUpperCase().substring(3, 4);
                        String let5 = guessText.getText().toString().toUpperCase().substring(4, 5);

                        letter1.setText(let1);
                        letter2.setText(let2);
                        letter3.setText(let3);
                        letter4.setText(let4);
                        letter5.setText(let5);

                        List<TextView> letterList1 = Arrays.asList(letter1, letter2, letter3, letter4, letter5);
                        letterList = letterList1;
                    }

                    else if(guessNum == 2) {
                        String let1 = guessText.getText().toString().toUpperCase().substring(0, 1);
                        String let2 = guessText.getText().toString().toUpperCase().substring(1, 2);
                        String let3 = guessText.getText().toString().toUpperCase().substring(2, 3);
                        String let4 = guessText.getText().toString().toUpperCase().substring(3, 4);
                        String let5 = guessText.getText().toString().toUpperCase().substring(4, 5);

                        letter6.setText(let1);
                        letter7.setText(let2);
                        letter8.setText(let3);
                        letter9.setText(let4);
                        letter10.setText(let5);

                        List<TextView> letterList1 = Arrays.asList(letter6, letter7, letter8, letter9, letter10);
                        letterList = letterList1;
                    }

                    else if(guessNum == 3) {
                        String let1 = guessText.getText().toString().toUpperCase().substring(0, 1);
                        String let2 = guessText.getText().toString().toUpperCase().substring(1, 2);
                        String let3 = guessText.getText().toString().toUpperCase().substring(2, 3);
                        String let4 = guessText.getText().toString().toUpperCase().substring(3, 4);
                        String let5 = guessText.getText().toString().toUpperCase().substring(4, 5);

                        letter11.setText(let1);
                        letter12.setText(let2);
                        letter13.setText(let3);
                        letter14.setText(let4);
                        letter15.setText(let5);

                        List<TextView> letterList1 = Arrays.asList(letter11, letter12, letter13, letter14, letter15);
                        letterList = letterList1;
                    }

                    else if(guessNum == 4) {
                        String let1 = guessText.getText().toString().toUpperCase().substring(0, 1);
                        String let2 = guessText.getText().toString().toUpperCase().substring(1, 2);
                        String let3 = guessText.getText().toString().toUpperCase().substring(2, 3);
                        String let4 = guessText.getText().toString().toUpperCase().substring(3, 4);
                        String let5 = guessText.getText().toString().toUpperCase().substring(4, 5);

                        letter16.setText(let1);
                        letter17.setText(let2);
                        letter18.setText(let3);
                        letter19.setText(let4);
                        letter20.setText(let5);

                        List<TextView> letterList1 = Arrays.asList(letter16, letter17, letter18, letter19, letter20);
                        letterList = letterList1;
                    }

                    else if(guessNum == 5) {
                        String let1 = guessText.getText().toString().toUpperCase().substring(0, 1);
                        String let2 = guessText.getText().toString().toUpperCase().substring(1, 2);
                        String let3 = guessText.getText().toString().toUpperCase().substring(2, 3);
                        String let4 = guessText.getText().toString().toUpperCase().substring(3, 4);
                        String let5 = guessText.getText().toString().toUpperCase().substring(4, 5);

                        letter21.setText(let1);
                        letter22.setText(let2);
                        letter23.setText(let3);
                        letter24.setText(let4);
                        letter25.setText(let5);

                        List<TextView> letterList1 = Arrays.asList(letter21, letter22, letter23, letter24, letter25);
                        letterList = letterList1;
                    }

                    else if(guessNum == 6) {
                        String let1 = guessText.getText().toString().toUpperCase().substring(0, 1);
                        String let2 = guessText.getText().toString().toUpperCase().substring(1, 2);
                        String let3 = guessText.getText().toString().toUpperCase().substring(2, 3);
                        String let4 = guessText.getText().toString().toUpperCase().substring(3, 4);
                        String let5 = guessText.getText().toString().toUpperCase().substring(4, 5);

                        letter26.setText(let1);
                        letter27.setText(let2);
                        letter28.setText(let3);
                        letter29.setText(let4);
                        letter30.setText(let5);

                        List<TextView> letterList1 = Arrays.asList(letter26, letter27, letter28, letter29, letter30);
                        letterList = letterList1;
                    }

                    int j = 0;
                    int k = 1;

                    for(int i = 0; i < 5; i++) {
                        if(letterList.get(i).getText().equals(word.substring(j, k))) {
                            letterList.get(i).setBackgroundColor(getColor(R.color.green));
                        }
                        else if(word.contains(letterList.get(i).getText())) {
                            letterList.get(i).setBackgroundColor(getColor(R.color.yellow));
                        }
                        j++;
                        k++;
                    }

                    if(guessText.getText().toString().toUpperCase().equals(word)) {
                        if(guessNum == 1)  {
                            win1++;
                        }
                        else if(guessNum == 2) {
                            win2++;
                        }
                        else if(guessNum == 3) {
                            win3++;
                        }
                        else if(guessNum == 4) {
                            win4++;
                        }
                        else if(guessNum == 5) {
                            win5++;
                        }
                        else if(guessNum == 6) {
                            win6++;
                        }

                        guessNum = 0;
                        winStreakNumInt++;
                        winStreakNum.setText(String.valueOf(winStreakNumInt));
                        Toast.makeText(getApplicationContext(), "You guessed the word!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        guessNum++;
                    }
                    if(guessNum > 6) {
                        winNull++;
                        winStreakNumInt = 0;
                        winStreakNum.setText(String.valueOf(winStreakNumInt));
                        Toast.makeText(getApplicationContext(), "You ran out of guesses! The word was " + word, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Guess must be 5 letters", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putInt("win streak", winStreakNumInt);
        saveInstanceState.putInt("wins in 1 guess", win1);
        saveInstanceState.putInt("wins in 2 guesses", win2);
        saveInstanceState.putInt("wins in 3 guesses", win3);
        saveInstanceState.putInt("wins in 4 guesses", win4);
        saveInstanceState.putInt("wins in 5 guesses", win5);
        saveInstanceState.putInt("wins in 6 guesses", win6);
        saveInstanceState.putInt("losses", winNull);
        super.onSaveInstanceState(saveInstanceState);
    }

    @Override
    public  void onPause() {
        super.onPause();
        updateSharedPreferences();
    }

    @Override
    public void onResume() { // called whenever the user changes
        super.onResume();
        SharedPreferences sp = getSharedPreferences("shared", MODE_PRIVATE);
        winStreakNumInt = sp.getInt("win streak", 0);
        winStreakNum.setText(String.valueOf(winStreakNumInt));
        win1 = sp.getInt("wins in 1 guess", 0);
        win2 = sp.getInt("wins in 2 guesses", 0);
        win3 = sp.getInt("wins in 3 guesses", 0);
        win4 = sp.getInt("wins in 4 guesses", 0);
        win5 = sp.getInt("wins in 5 guesses", 0);
        win6 = sp.getInt("wins in 5 guesses", 0);
        winNull = sp.getInt("losses", 0);
        }

    private void updateSharedPreferences() {
        SharedPreferences sp = getSharedPreferences("shared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("win streak", winStreakNumInt);
        editor.putInt("wins in 1 guess", win1);
        editor.putInt("wins in 2 guesses", win2);
        editor.putInt("wins in 3 guesses", win3);
        editor.putInt("wins in 4 guesses", win4);
        editor.putInt("wins in 5 guesses", win5);
        editor.putInt("wins in 6 guesses", win6);
        editor.putInt("losses", winNull);
        editor.commit();
    }
}
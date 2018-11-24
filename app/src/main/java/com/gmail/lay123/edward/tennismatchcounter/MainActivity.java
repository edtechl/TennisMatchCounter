package com.gmail.lay123.edward.tennismatchcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int playerAScore = 0;

    int playerBScore = 0;

    Button addPlayerAScore;
    Button subtractPlayerAScore;
    Button addPlayerBScore;
    Button subPlayerAScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPlayerAScore(playerAScore);
        displayPlayerBScore(playerBScore);
    }

    /**
     * Displays the score for player a.
     */
    public void displayPlayerAScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_score_text_view);
        scoreView.setText(convertScore(score));
    }

    /**
     * Displays the score for player b.
     */
    public void displayPlayerBScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_score_text_view);
        scoreView.setText(convertScore(score));
    }

    public void addScorePlayerAButton(View view) {

        if (playerAScore < 5) {

            if (playerAScore == 3 && isDeuce() == false) {

                playerAScore = playerAScore + 2;

            } else {

                if (playerAScore + 1 == playerBScore && playerBScore == 4) {

                    playerBScore = playerBScore - 1;
                    displayPlayerBScore(playerBScore);

                } else if (!(playerAScore + 2 == playerBScore && playerBScore == 5)) {

                    playerAScore = playerAScore + 1;
                }





            }

        }

        displayPlayerAScore(playerAScore);

    }

    public void subtractScorePlayerAButton(View view) {

        if (playerAScore > 0) {


            if (playerAScore == 5 && isDeuce() == false) {

                playerAScore = playerAScore - 2;

            } else {

                if (playerAScore - 1 == playerBScore && playerBScore == 4) {

                    playerAScore = playerAScore - 1;
                    playerBScore = playerBScore - 1;
                    displayPlayerBScore(playerBScore);
                }

                    playerAScore = playerAScore - 1;

            }

        }
        displayPlayerAScore(playerAScore);
    }

    public void addScorePlayerBButton(View view) {
        if (playerBScore < 5) {


            if (playerBScore == 3 && isDeuce() == false) {

                playerBScore = playerBScore + 2;

            } else {
                if (playerBScore + 1 == playerAScore && playerAScore == 4) {

                    playerAScore = playerAScore - 1;
                    displayPlayerAScore(playerAScore);

                } else if (!(playerBScore + 2 == playerAScore && playerAScore == 5)) {
                    playerBScore = playerBScore + 1;
                }

            }

        }

        displayPlayerBScore(playerBScore);
    }

    public void subtractScorePlayerBButton(View view) {
        if (playerBScore > 0) {


            if (playerBScore == 5 && isDeuce() == false) {

                playerBScore = playerBScore - 2;

            } else {

                if (playerBScore - 1 == playerAScore && playerAScore == 4) {

                    playerBScore = playerBScore - 1;
                    playerAScore = playerAScore - 1;
                    displayPlayerAScore(playerAScore);

                }
                    playerBScore = playerBScore - 1;

            }

        }
        displayPlayerBScore(playerBScore);
    }

    public void resetScores(View view) {
        playerAScore = 0;
        playerBScore = 0;
        displayPlayerAScore(playerAScore);
        displayPlayerBScore(playerBScore);
    }

    public boolean isDeuce() {

        if (playerAScore >= 3 && playerBScore >= 3) {

            return true;

        } else {

            return false;
        }

    }

    public String convertScore(int score) {
        String convertedScore = "";
        switch (score) {
            case 0:
                convertedScore = "Love";
                break;
            case 1:
                convertedScore = "15";
                break;
            case 2:
                convertedScore = "30";
                break;
            case 3:
                convertedScore = "40";
                break;
            case 4:
                convertedScore = "Adv";
                break;
            case 5:
                convertedScore = "Game";
                break;
        }
        return convertedScore;
    }
}

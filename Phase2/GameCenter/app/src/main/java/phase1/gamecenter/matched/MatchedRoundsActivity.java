package phase1.gamecenter.matched;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import phase1.gamecenter.FileManager;
import phase1.gamecenter.R;

/**
 * MatchedBoard Complexity Activity
 */
public class MatchedRoundsActivity extends FileManager {

    /**
     * A temporary save file.
     */
    public static final String TEMP_SAVE_FILENAME = "matched_file_tmp.ser";

    /**
     * The round buttons to be displayed
     */
    private Button round1Button;
    private Button round2Button;
    private Button round3Button;
    private Button round4Button;
    private Button round5Button;
    private Button round6Button;
    private Button round7Button;
    private Button round8Button;
    private Button round9Button;
    private Button round10Button;
    private Button round11Button;
    private Button round12Button;


    /**
     * The componenets of the instructions button to be displayed
     */
    private TextView instructionsTitle;
    private Button instructionsButton;
    private TextView instructionsBody;
    private View instructionsView;

    /**
     * The save progress button
     */
    Button saveProgress;

    /**
     * the board manager
     */
    private MatchedBoardManager boardManager;

    /**
     * number of rounds unlocked
     */
    private int rounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_tile_rounds);
        int win = getIntent().getIntExtra("rounds", 1);
        rounds = win;
        findView();
        activateInstructionsButton();
        activateRound1Button();

        saveProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFile(MatchedStartingActivity.TEMP_SAVE_FILENAME, boardManager);
                saveRounds("rounds.ser", rounds);
                Toast.makeText(MatchedRoundsActivity.this, "Succesfully saved", Toast.LENGTH_LONG).show();
            }
        });

        switch (win) {
            case 2:
                activateRound2Button();
                break;
            case 3:
                activateRound3Button();
                break;
            case 4:
                activateRound4Button();
                break;
            case 5:
                activateRound5Button();
                break;
            case 6:
                activateRound6Button();
                break;
            case 7:
                activateRound7Button();
                break;
            case 8:
                activateRound8Button();
                break;
            case 9:
                activateRound9Button();
                break;
            case 10:
                activateRound10Button();
                break;
            case 11:
                activateRound11Button();
                break;
            case 12:
                activateRound12Button();
                break;
            default:
                activateRound1Button();
                break;

        }
    }

    /**
     * Activate the buttons for round 12 and all the buttons before it
     */
    private void activateRound12Button() {
        activateRound11Button();
        round12Button = findViewById(R.id.round12_button);
        round12Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(12, 6, 0, 59);

            }
        });
    }

    /**
     * Activate the button for round 11 and all the buttons before it
     */
    private void activateRound11Button() {
        activateRound10Button();
        round11Button = findViewById(R.id.round11_button);
        round11Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(11, 6, 1, 20);
            }
        });
    }

    private void activateRound1Button() {

        round1Button = findViewById(R.id.round1_button);

        /*
         * Activate the button for round 1
         */
        round1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(1, 3, 0, 59);
            }

        });
    }

    /**
     * Activate how to play button
     */
    private void activateInstructionsButton() {

        instructionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (instructionsView.getVisibility() == View.GONE) {
                    instructionsView.setVisibility(View.VISIBLE);
                    instructionsTitle.setVisibility(View.VISIBLE);
                    instructionsBody.setVisibility(View.VISIBLE);
                } else {
                    instructionsTitle.setVisibility(View.GONE);
                    instructionsView.setVisibility(View.GONE);
                    instructionsBody.setVisibility(View.GONE);
                }
            }
        });
    }

    /**
     * Activate the button for round 10 and keep all the other buttons before it activated
     */
    private void activateRound10Button() {
        activateRound9Button();
        round10Button = findViewById(R.id.round10_button);

        round10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(10, 6, 1, 59);
            }

        });
    }

    /**
     * Activate the button for round 9 and keep all the other buttons before it activated
     */
    private void activateRound9Button() {
        activateRound8Button();
        round9Button = findViewById(R.id.round9_button);

        round9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(9, 5, 2, 0);
            }

        });
    }

    /**
     * Activate the button for round 8 and keep all the other buttons before it activated
     */
    private void activateRound8Button() {
        activateRound7Button();

        round8Button = findViewById(R.id.round8_button);

        round8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(8, 5, 2, 0);
            }

        });
    }

    /**
     * Activate the button for round 7 and keep all the other buttons before it activated
     */
    private void activateRound7Button() {
        activateRound6Button();
        round7Button = findViewById(R.id.round7_button);

        round7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(7, 5, 0, 20);
            }

        });
    }

    /**
     * Activate the button for round 6 and keep all the other buttons before it activated
     */
    private void activateRound6Button() {
        activateRound5Button();
        round6Button = findViewById(R.id.round6_button);

        round6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(6, 4, 0, 20);
            }

        });
    }

    /**
     * Activate the button for round 5 and keep all the other buttons before it activated
     */
    private void activateRound5Button() {
        activateRound4Button();
        round5Button = findViewById(R.id.round5_button);

        round5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(5, 4, 0, 20);
            }

        });
    }

    /**
     * Activate the button for round 4 and keep all the other buttons before it activated
     */
    private void activateRound4Button() {
        activateRound3Button();
        round4Button = findViewById(R.id.round4_button);

        round4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(5, 4, 0, 20);
            }

        });
    }

    /**
     * Activate the button for round 3 and keep all the other buttons before it activated
     */
    private void activateRound3Button() {
        activateRound2Button();
        round3Button = findViewById(R.id.round3_button);

        round3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(4, 3, 0, 20);
            }

        });
    }

    /**
     * finds the view of all of the buttons, textViews, and views.
     */
    private void findView() {

        instructionsButton = findViewById(R.id.instructions_button);
        saveProgress = findViewById(R.id.save_progress);
        instructionsBody = findViewById(R.id.instructions);
        instructionsTitle = findViewById(R.id.instructions_title);
        instructionsView = findViewById(R.id.view);
        instructionsTitle.setVisibility(View.GONE);
        instructionsView.setVisibility(View.GONE);
        instructionsBody.setVisibility(View.GONE);


    }

    /**
     * Activate the button for round 2 and keep all the other buttons before it activated
     */
    public void activateRound2Button() {

        activateRound1Button();
        round2Button = findViewById(R.id.round2_button);

        round2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(2, 3, 0, 40);
            }

        });
    }

    /**
     * Switch to the round/level that the user selects.
     */
    private void switchToRound(int round, int complexity, int minute, int second) {
        boardManager = new MatchedBoardManager(round, complexity, minute, second);
        saveToFile(TEMP_SAVE_FILENAME, boardManager);
        Intent tmp = new Intent(MatchedRoundsActivity.this, MatchedGameActivity.class);
        startActivity(tmp);
    }

    /**
     * Back button from the game to the main page
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MatchedRoundsActivity.this, MatchedStartingActivity.class);
        saveRounds("rounds.ser", rounds);
        startActivity(intent);
    }
}







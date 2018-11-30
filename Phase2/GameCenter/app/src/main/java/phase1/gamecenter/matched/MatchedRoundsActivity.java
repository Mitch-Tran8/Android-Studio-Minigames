package phase1.gamecenter.matched;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
     * The save progress button
     */
    Button saveProgress;
    /**
     * The componenets of the instructions button to be displayed
     */
    private TextView instructionsTitle;
    private Button instructionsButton;
    private TextView instructionsBody;
    private View instructionsView;
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

        /*
         * activates corresponding buttons from record
         */
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
     * Activate the buttons for round 12 and all the buttons before it
     */
    private void activateRound12Button() {
        activateRound11Button();
        Button round12Button = findViewById(R.id.round12_button);
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
        Button round11Button = findViewById(R.id.round11_button);
        round11Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(11, 6, 1, 20);
            }
        });
    }

    /**
     * Activate the button for round 10 and keep all the other buttons before it activated
     */
    private void activateRound10Button() {
        activateRound9Button();
        Button round10Button = findViewById(R.id.round10_button);

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
        Button round9Button = findViewById(R.id.round9_button);

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

        Button round8Button = findViewById(R.id.round8_button);

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
        Button round7Button = findViewById(R.id.round7_button);

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
        Button round6Button = findViewById(R.id.round6_button);

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
        Button round5Button = findViewById(R.id.round5_button);

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
        Button round4Button = findViewById(R.id.round4_button);

        round4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(4, 4, 0, 20);
            }

        });
    }

    /**
     * Activate the button for round 3 and keep all the other buttons before it activated
     */
    private void activateRound3Button() {
        activateRound2Button();
        Button round3Button = findViewById(R.id.round3_button);

        round3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(3, 3, 0, 20);
            }

        });
    }

    /**
     * Activate the button for round 2 and keep all the other buttons before it activated
     */
    public void activateRound2Button() {

        activateRound1Button();
        Button round2Button = findViewById(R.id.round2_button);

        round2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(2, 3, 0, 40);
            }

        });
    }

    /**
     * Activate the button for round 1
     */
    private void activateRound1Button() {
        /*
         * The round buttons to be displayed
         */
        Button round1Button = findViewById(R.id.round1_button);

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







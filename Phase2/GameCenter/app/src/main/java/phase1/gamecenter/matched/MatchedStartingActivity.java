package phase1.gamecenter.matched;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import phase1.gamecenter.FileManager;
import phase1.gamecenter.GameCenterMainActivity;
import phase1.gamecenter.R;


/**
 * The initial activity for the matched game.
 */
public class MatchedStartingActivity extends FileManager {

    /**
     * A temporary save file.
     */
    public static final String TEMP_SAVE_FILENAME = "matched_file_tmp.ser";

    /**
     * The instructions button
     */
    Button instructionsButton;

    /**
     * The instructions box/view
     */
    View instructionsView;

    /**
     * The instructions title
     */
    TextView instructionsTitle;

    /**
     * The instructions body
     */
    TextView instructionsBody;

    /**
     * the rounds
     */
    int rounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_colourstarting_);
        addStartButtonListener();
        addLoadButtonListener();

        /*
         * sets up the instruction buttons and views
         */
        instructionsButton = findViewById(R.id.instructions_button2);
        instructionsView = findViewById(R.id.view2);
        instructionsTitle = findViewById(R.id.instructions_title2);
        instructionsBody = findViewById(R.id.instructions2);
        instructionsBody.setVisibility(View.GONE);
        instructionsTitle.setVisibility(View.GONE);
        instructionsView.setVisibility(View.GONE);

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
     * Activate the start button.
     */
    private void addStartButtonListener() {
        Button startButton = findViewById(R.id.StartButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToGame();
            }
        });
    }

    /**
     * Activate the load button.
     */
    private void addLoadButtonListener() {
        Button loadButton = findViewById(R.id.LoadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rounds = loadRounds();
                makeToastLoadedText();
                switchToGame();
            }
        });
    }

    /**
     * Display that a game was loaded successfully.
     */
    private void makeToastLoadedText() {
        Toast.makeText(this, "Loaded Game", Toast.LENGTH_SHORT).show();
    }

    /**
     * Read the temporary board from disk.
     */
    @Override
    protected void onResume() {
        super.onResume();
        loadFromFileMatched(TEMP_SAVE_FILENAME);
    }

    /**
     * Switch to the MatchedGameActivity view to play the game.
     */
    private void switchToGame() {
        Intent tmp = new Intent(this, MatchedRoundsActivity.class);
        tmp.putExtra("rounds", rounds);
        startActivity(tmp);
    }

    /**
     * Back button from the game to the main page
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MatchedStartingActivity.this, GameCenterMainActivity.class);
        startActivity(intent);
    }

}

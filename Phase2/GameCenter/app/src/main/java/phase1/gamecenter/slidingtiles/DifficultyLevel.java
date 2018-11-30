package phase1.gamecenter.slidingtiles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import phase1.gamecenter.FileManager;
import phase1.gamecenter.R;

/**
 * the difficulty level page activity
 */
public class DifficultyLevel extends FileManager {

    /**
     * A temporary save file.
     */
    public static final String TEMP_SAVE_FILENAME = "save_file_tmp.ser";
    /**
     * the button to confirm user's desired undo moves
     */
    Button easyButton;
    /**
     * the button to confirm the user would like unlimited undo moves - until the initial game
     * state is reached
     */
    Button okButton;
    /**
     * the button to confirm the user would like unlimited undo moves - until the initial game
     * state is reached
     */
    Button spicyButton;
    /**
     * the board manager
     */
    SlidingTileBoardManager slidingTileBoardManager;
    /**
     * The current user's Id
     */
    private String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        user_id = i.getStringExtra("user_id");
        slidingTileBoardManager = loadFromFileSlidingTiles(TEMP_SAVE_FILENAME);
        setContentView(R.layout.activity_set_max_undo_moves);

        /*
         * the button for a 4x4 board
         */
        easyButton = findViewById(R.id.easyButton);

        /*
         * the button for a 4x4 board
         */
        okButton = findViewById(R.id.okButton);

        /*
         * the button for a 4x4 board
         */
        spicyButton = findViewById(R.id.spicyButton);

        /*
         * activate easy button
         * let user know if task was succesful or not
         * if it is, take to game page. If not, try again.
         */
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingTileBoardManager.setMaxUndoTimes(6);
                saveToFile(TEMP_SAVE_FILENAME, slidingTileBoardManager);
                switchToGame();
            }
        });

        /*
         * activate ok button
         * let user know if task was succesful or not
         * if it is, take to game page. If not, try again.
         */
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingTileBoardManager.setMaxUndoTimes(3);
                saveToFile(TEMP_SAVE_FILENAME, slidingTileBoardManager);
                switchToGame();
            }
        });

        /*
         * activate spicy button
         * let user know if task was succesful or not
         * if it is, take to game page. If not, try again.
         */
        spicyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingTileBoardManager.setMaxUndoTimes(0);
                saveToFile(TEMP_SAVE_FILENAME, slidingTileBoardManager);
                switchToGame();
            }
        });

    }

    /**
     * Switch to the MatchedGameActivity view to play the game.
     */
    private void switchToGame() {
        Intent tmp = new Intent(DifficultyLevel.this, SlidingTilesGameActivity.class);
        saveToFile(TEMP_SAVE_FILENAME, slidingTileBoardManager);
        tmp.putExtra("user_id", user_id);
        startActivity(tmp);
    }
}

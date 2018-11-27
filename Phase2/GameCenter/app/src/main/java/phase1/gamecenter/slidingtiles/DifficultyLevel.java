package phase1.gamecenter.slidingtiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import phase1.gamecenter.BoardComplexity;
import phase1.gamecenter.R;
import phase1.gamecenter.StartingActivity;


public class DifficultyLevel extends AppCompatActivity {

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
     *
     * @param user_id
     */
    private String user_id;

    /**
     * A temporary save file.
     */
    public static final String TEMP_SAVE_FILENAME = "save_file_tmp.ser";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        user_id = i.getStringExtra("user_id");
        loadFromFile(BoardComplexity.TEMP_SAVE_FILENAME);
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
                saveToFile(TEMP_SAVE_FILENAME);
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
                saveToFile(TEMP_SAVE_FILENAME);
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
                saveToFile(TEMP_SAVE_FILENAME);
                switchToGame();
            }
        });

    }

    /**
     * Switch to the ColourGameActivity view to play the game.
     */
    private void switchToGame() {
        Intent tmp = new Intent(DifficultyLevel.this, GameActivity.class);
        saveToFile(StartingActivity.TEMP_SAVE_FILENAME);
        tmp.putExtra("user_id", user_id);
        startActivity(tmp);
    }

    /**
     * Load the board manager from fileName.
     *
     * @param fileName the name of the file
     */
    private void loadFromFile(String fileName) {

        try {
            InputStream inputStream = this.openFileInput(fileName);
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                slidingTileBoardManager = (SlidingTileBoardManager) input.readObject();
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("login activity", "File contained unexpected data type: " + e.toString());
        }
    }

    /**
     * Save the board manager to fileName.
     *
     * @param fileName the name of the file
     */
    public void saveToFile(String fileName) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    this.openFileOutput(fileName, MODE_PRIVATE));
            outputStream.writeObject(slidingTileBoardManager);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}

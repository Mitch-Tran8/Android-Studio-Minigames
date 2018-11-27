package phase1.gamecenter;

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


/**
 * The initial activity for the sliding puzzle tile game.
 */
public class ColourStartingActivity extends AppCompatActivity {

    /**
     * The main save file.
     */
    public static final String SAVE_FILENAME = "save_file.ser";
    /**
     * A temporary save file.
     */
    public static final String TEMP_SAVE_FILENAME = "save_file_tmp.ser";
    /**
     * The board manager.
     */
    private ColourBoardManager boardManager;

    /**
     *
     * The start new game button
     */
    Button newGame;

    /**
     *
     * The load saved game button
     */
    Button loadGame;

    /**
     *
     * The rankings button
     */
    Button rankingsButton;

    /**
     *
     * The instructions button
     */
    Button instructionsButton;

    /**
     * The instructions box/view
     * @param savedInstanceState
     */
    View instructionsView;

    /**
     * The instructions title
     *
     */
    TextView instructionsTitle;

    /**
     * The instructions body
     *
     */
    TextView instructionsBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        saveToFile(TEMP_SAVE_FILENAME);

        setContentView(R.layout.activity_colourstarting_);
        addStartButtonListener();
        addLoadButtonListener();

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
                if(instructionsView.getVisibility() == View.GONE) {
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
                loadFromFile(SAVE_FILENAME);
                saveToFile(TEMP_SAVE_FILENAME);
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


//    /**
//     * Display that a game was saved successfully.
//     */
//    private void makeToastSavedText() {
//        Toast.makeText(this, "Game Saved", Toast.LENGTH_SHORT).show();
//    }

    /**
     * Read the temporary board from disk.
     */
    @Override
    protected void onResume() {
        super.onResume();
        loadFromFile(TEMP_SAVE_FILENAME);
    }

    /**
     * Switch to the ColourGameActivity view to play the game.
     */
    private void switchToGame() {
        Intent tmp = new Intent(this, ColourTileRoundsActivity.class);
        saveToFile(ColourStartingActivity.TEMP_SAVE_FILENAME);
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
                boardManager = (ColourBoardManager) input.readObject();
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
            outputStream.writeObject(boardManager);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}

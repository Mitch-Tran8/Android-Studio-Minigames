package phase1.gamecenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ColourBoard Complexity Activity
 */
public class ColourTileRoundsActivity extends AppCompatActivity {


    /**
     * The main save file.
     */
    public static final String SAVE_FILENAME = "save_file.ser";

    /**
     * A temporary save file.
     */
    public static final String TEMP_SAVE_FILENAME = "save_file_tmp.ser";

    /**
     * The round1 button
     */
    Button round1Button;

    /**
     * The round2 button
     */
    Button round2Button;

    /**
     * The round3 button
     */
    Button round3Button;

    /**
     * The round3 button
     */
    Button round10Button;

    /**
     * the board manager
     */
    private ColourBoardManager boardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_tile_rounds);
        round1Button = findViewById(R.id.round1_button);
        round2Button = findViewById(R.id.round2_button);
        round3Button = findViewById(R.id.round3_button);
        round10Button = findViewById(R.id.round10_button);

        /**
         * Activate the button for round 1
         */
        round1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(3, 1, 0);
            }

        });

        /**
         * Activate the button for round 2
         */
        round2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(3, 0, 40);
            }

        });

        /**
         * Activate the button for round 3
         */
        round3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(3, 0, 20);
            }

        });

        /**
         * Activate the button for round 10
         */
        round10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(5, 2, 0);
            }

        });
    }


    /**
     * Switch to the round/level that the user selects.
     */
    private void switchToRound(int complexity, int minute, int second) {
        boardManager = new ColourBoardManager(complexity, minute, second);
        saveToFile(TEMP_SAVE_FILENAME);
        Intent tmp = new Intent(ColourTileRoundsActivity.this, ColourGameActivity.class);
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







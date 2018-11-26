package phase1.gamecenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
     * The round4 button
     */
    Button round4Button;

    /**
     * The round5 button
     */
    Button round5Button;

    /**
     * The round6 button
     */
    Button round6Button;

    /**
     * The round7 button
     */
    Button round7Button;

    /**
     * The round8 button
     */
    Button round8Button;

    /**
     * The round9 button
     */
    Button round9Button;

    /**
     * The round3 button
     */
    Button round10Button;

    /**
     * The "how to play"/instructions button
     */
    Button instructionsButton;

    /**
     * The title for the instruction
     */
    TextView instructionsTitle;

    /**
     * The body of the instructions
     */
    TextView instructionsBody;

    /**
     * The view of the instructions
     */
    View instructionsView;

    /**
     * the board manager
     */
    private ColourBoardManager boardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_tile_rounds);
        findView();

        /**
         * Activate how to play button
         */
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

        /**
         * Activate the button for round 1
         */
        round1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(3, 0, 59);
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
         * Activate the button for round 4
         */
        round4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(4, 0, 20);
            }

        });

        /**
         * Activate the button for round 5
         */
        round5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(4, 0, 20);
            }

        });

        /**
         * Activate the button for round 6
         */
        round6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(4, 0, 20);
            }

        });

        /**
         * Activate the button for round 7
         */
        round7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(5, 0, 20);
            }

        });
        /**
         /**
         * Activate the button for round 8
         */
        round8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(5, 2, 0);
            }

        });
        /**
         /**
         * Activate the button for round 9
         */
        round9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(5, 2, 0);
            }

        });

        /**
        /**
         * Activate the button for round 10
         */
        round10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(5, 1, 59);
            }

        });


    }

    /**
     * finds the view of all of the buttons, textViews, and views.
     */
    private void findView() {
        round1Button = findViewById(R.id.round1_button);
        round2Button = findViewById(R.id.round2_button);
        round3Button = findViewById(R.id.round3_button);
        round4Button = findViewById(R.id.round4_button);
        round4Button = findViewById(R.id.round4_button);
        round5Button = findViewById(R.id.round5_button);
        round6Button = findViewById(R.id.round6_button);
        round7Button = findViewById(R.id.round7_button);
        round8Button = findViewById(R.id.round8_button);
        round9Button = findViewById(R.id.round9_button);
        round10Button = findViewById(R.id.round10_button);
        instructionsButton = findViewById(R.id.instructions_button);
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







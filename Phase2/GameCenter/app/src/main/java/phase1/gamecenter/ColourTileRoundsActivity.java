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
     * current round
     */
    static int currentRound;

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
        Bundle b = getIntent().getExtras();
        int win = b.getInt("round");
        System.out.println("number "+win);
        findView();
        activateInstructionsButton();
        activateRound1Button();

        switch(win){
            case 2: activateRound2Button();break;
            case 3: activateRound3Button();break;
            case 4: activateRound4Button();break;
            case 5: activateRound5Button();break;
            case 6: activateRound6Button();break;
            case 7: activateRound7Button();break;
            case 8: activateRound8Button();break;
            case 9: activateRound9Button();break;
            case 10: activateRound10Button();break;
            default: activateRound1Button();break;

        }


    }

    private void activateRound1Button() {
        /**
         * Activate the button for round 1
         */
        round1Button = findViewById(R.id.round1_button);

        round1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(1,3, 0, 59);
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
     * Activate the button for round 10
     */
    private void activateRound10Button() {

        round10Button = findViewById(R.id.round10_button);

        round10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(10,5, 1, 59);
            }

        });
    }

    /**
     /**
     * Activate the button for round 9
     */
    private void activateRound9Button() {

        round9Button = findViewById(R.id.round9_button);

        round9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(9,5, 2, 0);
            }

        });
    }

    /**
     /**
     * Activate the button for round 8
     */
    private void activateRound8Button() {

        round8Button = findViewById(R.id.round8_button);

        round8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(8,5, 2, 0);
            }

        });
    }

    /**
     * Activate the button for round 7
     */
    private void activateRound7Button() {

        round7Button = findViewById(R.id.round7_button);

        round7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(7,5, 0, 20);
            }

        });
    }

    /**
     * Activate the button for round 6
     */
    private void activateRound6Button() {

        round6Button = findViewById(R.id.round6_button);

        round6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(6,4, 0, 20);
            }

        });
    }

    /**
     * Activate the button for round 5
     */
    private void activateRound5Button() {

        round5Button = findViewById(R.id.round5_button);

        round5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(5,4, 0, 20);
            }

        });
    }

    /**
     * Activate the button for round 4
     */
    private void activateRound4Button() {

        round4Button = findViewById(R.id.round4_button);

        round4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(5,4, 0, 20);
            }

        });
    }

    /**
     * Activate the button for round 3
     */
    private void activateRound3Button() {

        round3Button = findViewById(R.id.round3_button);

        round3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToRound(4,3, 0, 20);
            }

        });
    }

    /**
     * finds the view of all of the buttons, textViews, and views.
     */
    private void findView() {

        instructionsButton = findViewById(R.id.instructions_button);
        instructionsBody = findViewById(R.id.instructions);
        instructionsTitle = findViewById(R.id.instructions_title);
        instructionsView = findViewById(R.id.view);
        instructionsTitle.setVisibility(View.GONE);
        instructionsView.setVisibility(View.GONE);
        instructionsBody.setVisibility(View.GONE);


    }

    /**
     * Activate the button for round 2
     */
    public void activateRound2Button() {

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
        boardManager = new ColourBoardManager(round, complexity, minute, second);
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







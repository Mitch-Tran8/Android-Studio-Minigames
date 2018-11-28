package phase1.gamecenter.slidingtiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import phase1.gamecenter.R;
import phase1.gamecenter.StartingActivity;

/**
 * ColourBoard Complexity Activity
 */
public class BoardComplexity extends AppCompatActivity {


    /**
     * The main save file.
     */
    public static final String SAVE_FILENAME = "save_file.ser";

    /**
     * A temporary save file.
     */
    public static final String TEMP_SAVE_FILENAME = "save_file_tmp.ser";

    /**
     * button for four by four board.
     */
    Button fourButton;
    /**
     * button for five by five board.
     */
    Button fiveButton;
    /**
     * button for three by three board.
     */
    Button threeButton;
    /**
     * The current user's Id
     *
     * @param user_id
     */
    private String user_id;

    /**
     * The load button
     */
    Button loadButton;

    /**
     * the board manager
     */
    private SlidingTileBoardManager slidingTileBoardManager;

    /**
     * the firebase auth
     */
    private FirebaseAuth mAuth;

    /**
     * the firebase database reference
     */
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        user_id = i.getStringExtra("user_id");
        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_board_complexity);

        /*
         * the button for a 4x4 board
         */
        fourButton = findViewById(R.id.four_board);

        /*
          the button for a 5x5 board
         */
        fiveButton = findViewById(R.id.five_board);

        /*
         * the button for a 3x3 board
         */
        threeButton = findViewById(R.id.three_board);

        /*
         * the load saved game button
         */
        loadButton = findViewById(R.id.load_game_button);

        /*
         * activate 4x4 button
         */
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingTileBoardManager = new SlidingTileBoardManager(4, 4);
                saveToFile(TEMP_SAVE_FILENAME);
                switchToDifficulty();

            }
        });

        /*
         * activate load button
         */
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent tmp = new Intent(BoardComplexity.this, GameActivity.class);
                tmp.putExtra("user_id", user_id);
                startActivity(tmp);


            }
        });

        /*
         * activate 5x5 button
         */
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingTileBoardManager = new SlidingTileBoardManager(5, 5);
                saveToFile(TEMP_SAVE_FILENAME);
                switchToDifficulty();
            }
        });

        /*
         * activate 3x3 button
         */
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingTileBoardManager = new SlidingTileBoardManager(3, 3);
                saveToFile(TEMP_SAVE_FILENAME);
                switchToDifficulty();
            }

        });

    }

    /**
     * Switch to the DifficultyLevel view to play the game.
     */
    private void switchToDifficulty() {
        Intent tmp = new Intent(BoardComplexity.this, DifficultyLevel.class);
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







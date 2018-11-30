package phase1.gamecenter.slidingtiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.io.IOException;
import java.io.ObjectOutputStream;

import phase1.gamecenter.FileManager;
import phase1.gamecenter.R;

/**
 * MatchedBoard Complexity Activity
 */
public class BoardComplexity extends FileManager {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        user_id = i.getStringExtra("user_id");
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
                saveToFile(TEMP_SAVE_FILENAME, slidingTileBoardManager);
                switchToDifficulty();

            }
        });

        /*
         * activate load button
         */
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent tmp = new Intent(BoardComplexity.this, SlidingTilesGameActivity.class);
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
                saveToFile(TEMP_SAVE_FILENAME, slidingTileBoardManager);
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
                saveToFile(TEMP_SAVE_FILENAME, slidingTileBoardManager);
                switchToDifficulty();
            }

        });

    }

    /**
     * Switch to the DifficultyLevel view to play the game.
     */
    private void switchToDifficulty() {
        Intent tmp = new Intent(BoardComplexity.this, DifficultyLevel.class);
        tmp.putExtra("user_id", user_id);
        startActivity(tmp);
    }
}







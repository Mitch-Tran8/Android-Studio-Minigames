package phase1.gamecenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


/**
 * The initial activity when sliding tiles is chosen.
 */
public class SlidingTileMainPageActivity extends AppCompatActivity implements Serializable {

    /**
     * The buttons to display
     */
    Button startButton;
    Button userRankingsButton;
    Button leaderboardButton;
    Button backButton;


    /**
     * Emails and scores of userList
     */
    public ArrayList<EmailAndScore> userList;

    /**
     * The current user's Id
     */
    private String user_id;

    /**
     * Sliding tile main page
     */
    public SlidingTileMainPageActivity() {
        this.userList = new ArrayList<>();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        user_id = i.getStringExtra("user_id");
        setContentView(R.layout.activity_sliding_tile_main_page);
        startButton = findViewById(R.id.start_game_button);
        leaderboardButton = findViewById(R.id.LeaderboardButton);
        userRankingsButton = findViewById(R.id.UserRankingButton);

        /**
         * Activate start button
         */
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SlidingTileMainPageActivity.this, BoardComplexity.class);
                i.putExtra("user_id", user_id);
                startActivity(i);
            }
        });

        /**
         * Activate current user rankings button
         */
        leaderboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SlidingTileMainPageActivity.this, LeaderboardActivity.class);
                i.putExtra("name", "slidingtiles");
                startActivity(i);
            }
        });

        /**
         * Activate leaderboard rankings button
         */
        userRankingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SlidingTileMainPageActivity.this, UserScoreBoardActivity.class);
                i.putExtra("game", "slidingtiles");
                i.putExtra("user_id", user_id );
                startActivity(i);

            }
        });}


        /**
         * Back button from the game to the main page
         */
    @Override
    public void onBackPressed() {
        GameCenterMainActivity gameCentre= new GameCenterMainActivity();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        Intent intent = new Intent(SlidingTileMainPageActivity.this, GameCenterMainActivity.class);

        startActivity(intent); //GO TO GAME CENTRE
    }
}


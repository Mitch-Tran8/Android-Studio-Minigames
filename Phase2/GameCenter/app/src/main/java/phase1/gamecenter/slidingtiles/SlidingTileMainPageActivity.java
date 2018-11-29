package phase1.gamecenter.slidingtiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;
import java.util.ArrayList;

import phase1.gamecenter.registrationinfo.EmailAndScore;
import phase1.gamecenter.GameCenterMainActivity;
import phase1.gamecenter.LeaderboardActivity;
import phase1.gamecenter.R;
import phase1.gamecenter.registrationinfo.UserScoreBoardActivity;


/**
 * The initial activity when sliding tiles is chosen.
 */
public class SlidingTileMainPageActivity extends AppCompatActivity implements Serializable {

    /**
     * The buttons to display
     */
    Button startButton;

    /**
     * the user's randings button
     */
    Button userRankingsButton;

    /**
     * the leaderboard button
     */
    Button leaderboardButton;

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
        });
    }

    /**
     * Back button from the game to the main page
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SlidingTileMainPageActivity.this, GameCenterMainActivity.class);
        startActivity(intent);
    }
}


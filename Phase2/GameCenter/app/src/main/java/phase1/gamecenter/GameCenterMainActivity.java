package phase1.gamecenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import phase1.gamecenter.connectnumbers.ConnectNumbersStartingActivity;
import phase1.gamecenter.matched.MatchedStartingActivity;
import phase1.gamecenter.registrationinfo.LeaderboardActivity;
import phase1.gamecenter.registrationinfo.LoginActivity;
import phase1.gamecenter.registrationinfo.UserScoreBoardActivity;
import phase1.gamecenter.slidingtiles.SlidingTileMainPageActivity;

/**
 * Game Center main page Activity.
 */
public class GameCenterMainActivity extends AppCompatActivity {

    /**
     * Sliding tiles button that leads to sliding tiles game.
     */
    ImageButton slidingtilesbutton;
    /**
     * Colour tiles button that leads to the colour tiles game
     */
    ImageButton colourTilesButton;

    /**
     * Colour tiles button that leads to the colour tiles game
     */
    ImageButton connectFourButton;

    /**
     * Logout page button
     */
    Button logoutButton;

    /**
     * the menu view
     */
    View menuView;

    /**
     * The menu button
     */
    FloatingActionButton menuButton;

    /**
     * scoreboard button
     */
    Button userScoreboardButton;

    /**
     * Leaderboard button
     */
    Button leaderBoardButton;

    /**
     * The current user's Id
     */
    private String user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        user_id = i.getStringExtra("user_id");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_center_main);
        slidingtilesbutton = findViewById(R.id.slidingtilesbutton);
        colourTilesButton = findViewById(R.id.colourtilesbutton);
        connectFourButton = findViewById(R.id.connect4button);
        logoutButton = findViewById(R.id.logoutPageButton);
        menuView = findViewById(R.id.menuView);
        menuButton = findViewById(R.id.menuButton);
        menuView.setVisibility(View.GONE);
        logoutButton.setVisibility(View.GONE);
        userScoreboardButton = findViewById(R.id.scoreboard);
        leaderBoardButton = findViewById(R.id.leaderboard);

        /*
         * Activate the menu button
         */
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menuView.getVisibility() == View.GONE) {
                    menuView.setVisibility(View.VISIBLE);
                    logoutButton.setVisibility(View.VISIBLE);
                } else {
                    menuView.setVisibility(View.GONE);
                    logoutButton.setVisibility(View.GONE);
                }
            }

        });

        /*
         * Activate sliding tiles button
         */
        slidingtilesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GameCenterMainActivity.this, SlidingTileMainPageActivity.class);
                i.putExtra("user_id", user_id);
                startActivity(i);
            }
        });

        /*
         * Activate the colour tiles button
         */
        colourTilesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameCenterMainActivity.this, MatchedStartingActivity.class);
                startActivity(i);
            }
        });

        /*
         * Activate the connect four button
         */
        connectFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameCenterMainActivity.this, ConnectNumbersStartingActivity.class);
                i.putExtra("user_id", user_id);
                startActivity(i);
            }
        });

        /*
         * Activate the logoutButton
         */
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_game_center_main);
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(GameCenterMainActivity.this, "Logout Succesful", Toast.LENGTH_LONG).show();
                Intent i = new Intent(GameCenterMainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        /*
         *Activate user score board button
         */
        userScoreboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameCenterMainActivity.this, UserScoreBoardActivity.class);
                startActivity(i);
            }
        });

        /*
         * Activate leader board button
         */

        leaderBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameCenterMainActivity.this, LeaderboardActivity.class);
                startActivity(i);
            }
        });


    }
}
package phase1.gamecenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Game Center Activity.
 */

public class GameCenterMainActivity extends AppCompatActivity {

    /**
     * Sliding tiles button that leads to sliding tiles game.
     */
    ImageButton slidingtilesbutton;
    /**
     * Colour tiles button that leads to the colour tiles game
     */
    Button colourTilesButton;

    /*
     * the profile button
     */
    ImageButton profileButton;

    /*
     * the profile button
     */
    ImageButton colortileButton;

    /**
     * Logout page button
     */
    Button logoutButton;

    /**
     * The current user's Id
     *
     * @param user_id
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
        profileButton = findViewById(R.id.profile_button);
        colortileButton = findViewById(R.id.colorTileGame_Button);

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

        /**
         * Activate the colour tiles button
         */
        colourTilesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameCenterMainActivity.this, ColourStartingActivity.class);
                i.putExtra("user_id", user_id);
                startActivity(i);
            }
        });

        /*
         * Activate color tiles game button
         */
        colortileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GameCenterMainActivity.this, ColourStartingActivity.class);
                i.putExtra("user_id", user_id);
                startActivity(i);
            }
        });

        /*
         * Activate profile button
         */
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GameCenterMainActivity.this, Profile.class);
                i.putExtra("user_id", user_id);
                startActivity(i);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameCenterMainActivity.this, LogoutActivity.class);
                startActivity(i);
            }
        });
    }
}
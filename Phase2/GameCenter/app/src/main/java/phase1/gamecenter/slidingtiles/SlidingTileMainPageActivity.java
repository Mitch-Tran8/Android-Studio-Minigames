package phase1.gamecenter.slidingtiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;
import java.util.ArrayList;

import phase1.gamecenter.GameCenterMainActivity;
import phase1.gamecenter.R;
import phase1.gamecenter.registrationinfo.EmailAndScore;


/**
 * The initial activity when sliding tiles is chosen.
 */
public class SlidingTileMainPageActivity extends AppCompatActivity implements Serializable {

    /**
     * Emails and scores of userList
     */
    public ArrayList<EmailAndScore> userList;
    /**
     * The buttons to display
     */
    Button startButton;
    Button howToPlayButton;
    /**
     * The view and textViews to be displayed
     */
    TextView instructionsTitle;
    TextView instructionsBody;
    View instructionsView;
    ImageButton exitInstructionsButton;
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
        howToPlayButton = findViewById(R.id.howToPlayButton);
        instructionsBody = findViewById(R.id.instructionsBody);
        instructionsTitle = findViewById(R.id.instructions_title3);
        instructionsView = findViewById(R.id.view3);
        exitInstructionsButton = findViewById(R.id.exitInstructionsButton);

        instructionsBody.setVisibility(View.GONE);
        instructionsView.setVisibility(View.GONE);
        instructionsTitle.setVisibility(View.GONE);
        exitInstructionsButton.setVisibility(View.GONE);


        /*
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

        /*
         * Activate the how to play button
         */
        howToPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (instructionsView.getVisibility() == View.GONE) {
                    instructionsView.setVisibility(View.VISIBLE);
                    instructionsTitle.setVisibility(View.VISIBLE);
                    instructionsBody.setVisibility(View.VISIBLE);
                    exitInstructionsButton.setVisibility(View.VISIBLE);
                } else {
                    instructionsTitle.setVisibility(View.GONE);
                    instructionsView.setVisibility(View.GONE);
                    instructionsBody.setVisibility(View.GONE);
                    exitInstructionsButton.setVisibility(View.GONE);
                }
            }
        });

        /*
         * Activate the exit instructions button
         */
        exitInstructionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instructionsTitle.setVisibility(View.GONE);
                instructionsView.setVisibility(View.GONE);
                instructionsBody.setVisibility(View.GONE);
                exitInstructionsButton.setVisibility(View.GONE);
            }
        });

    }


    /**
     * Back button from the game to the main page
     */
    @Override
    public void onBackPressed() {
        GameCenterMainActivity gameCentre = new GameCenterMainActivity();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        Intent intent = new Intent(SlidingTileMainPageActivity.this, GameCenterMainActivity.class);
        startActivity(intent);
    }
}


package phase1.gamecenter;

import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;


public class UserScoreBoard extends AppCompatActivity implements Serializable {

    public TextView topScoreUser1, topScoreUser2, topScoreUser3, topScoreUser4, topScoreUser5;

    public TextView scoreOne, scoreTwo, scoreThree, scoreFour, scoreFive;

    public TextView topScoreOne, topScoreTwo, topScoreThree, topScoreFour, topScoreFive;

    public ArrayList<Object> scoreList;

    public ArrayList<Object> topScoreList;

    //public String userId;
    public String userEmail;

    /**
     * The user's scoreboard will display the top 5 overall rankings and their personal top 5
     * rankings.
     */

    public UserScoreBoard() {
        this.scoreList = new ArrayList<>();
        this.topScoreList = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings_screen);

        Bundle data = getIntent().getBundleExtra("scoresBundle");
        this.scoreList = (ArrayList<Object>) data.getSerializable("scoreList");
        this.topScoreList = (ArrayList<Object>) data.getSerializable("topScoreList");
        //this.userId = (String) data.getSerializable("userId");
        this.userEmail = (String) data.getSerializable("userEmail");

        //----------Populating User Scoreboard---------

        TextView userScoreBoard = findViewById(R.id.userScoreBoard);
        userScoreBoard.setText(userEmail + " 's Scoreboard");

        if (scoreList.size() > 0) {
            scoreOne = findViewById(R.id.score_one);
            scoreOne.setText((scoreList.get(0)).toString());
        }
        if (scoreList.size() > 1) {
            scoreTwo = findViewById(R.id.score_two);
            scoreTwo.setText((scoreList.get(1)).toString());
        }
        if (scoreList.size() > 2) {
            scoreThree = findViewById(R.id.score_three);
            scoreThree.setText((scoreList.get(2)).toString());
        }
        if (scoreList.size() > 3) {
            scoreFour = findViewById(R.id.score_four);
            scoreFour.setText((scoreList.get(3)).toString());
        }
        if (scoreList.size() > 4) {
            scoreFive = findViewById(R.id.score_five);
            scoreFive.setText((scoreList.get(4)).toString());
        }

        //-----------Populating Game Scoreboard----------
        if (topScoreList.size() > 0) {
            topScoreUser1 = findViewById(R.id.top_score_user1);
            topScoreUser1.setText((topScoreList.get(0)).toString());

            topScoreOne = findViewById(R.id.top_score_one);
            topScoreOne.setText((topScoreList.get(1)).toString());
        }
        if (topScoreList.size() > 2) {
            topScoreUser2 = findViewById(R.id.top_score_user2);
            topScoreUser2.setText((topScoreList.get(2)).toString());

            topScoreTwo = findViewById(R.id.top_score_two);
            topScoreTwo.setText((topScoreList.get(3)).toString());
        }
        if (topScoreList.size() > 4) {
            topScoreUser3 = findViewById(R.id.top_score_user3);
            topScoreUser3.setText((topScoreList.get(4)).toString());

            topScoreThree = findViewById(R.id.top_score_three);
            topScoreThree.setText((topScoreList.get(5)).toString());
        }
        if (topScoreList.size() > 6) {
            topScoreUser4 = findViewById(R.id.top_score_user4);
            topScoreUser4.setText((topScoreList.get(6)).toString());

            topScoreFour = findViewById(R.id.top_score_four);
            topScoreFour.setText((topScoreList.get(7)).toString());
        }
        if (topScoreList.size() > 8) {
            topScoreUser5 = findViewById(R.id.top_score_user5);
            topScoreUser5.setText((topScoreList.get(8)).toString());

            topScoreFive = findViewById(R.id.top_score_five);
            topScoreFive.setText((topScoreList.get(9)).toString());
        }
    }

    /**
     * Back button from the Scoreboard to the sliding tile main page
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(UserScoreBoard.this, SlidingTileMainPageActivity.class);
        startActivity(intent);
    }

}







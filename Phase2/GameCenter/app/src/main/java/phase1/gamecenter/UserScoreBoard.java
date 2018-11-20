package phase1.gamecenter;

import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;


public class
UserScoreBoard extends AppCompatActivity implements Serializable {

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

        int num = 0;
        if (scoreList.size() <= 5) {
            num = scoreList.size();
        }
        else{
            num = 5;
        }
        for (int i = 0; i < num; i++) {
            int id = getResources().getIdentifier("score" + i, "id", getPackageName());
            TextView textView = (TextView) findViewById(id);
            textView.setText(scoreList.get(i).toString());
        }

        //-----------Populating Game Scoreboard----------
        int num1 = 0;
        if (topScoreList.size() <= 10) {
            num1 = topScoreList.size();
        }
        else{
            num1 = 10;
        }
        int integer = 0;
        for (int i = 0; i < num1;) {
            int name_id = getResources().getIdentifier("top_score_user" + integer, "id", getPackageName());
            int score_id = getResources().getIdentifier("top_score" + integer, "id", getPackageName());
            TextView textView = (TextView) findViewById(name_id);
            textView.setText(topScoreList.get(i).toString());
            textView = (TextView) findViewById(score_id);
            textView.setText(topScoreList.get(i + 1).toString());
            i+=2;
            integer+=1;
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







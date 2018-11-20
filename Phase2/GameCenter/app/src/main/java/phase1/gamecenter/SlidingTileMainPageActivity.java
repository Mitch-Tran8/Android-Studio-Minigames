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
     * The save scores file.
     */
    public static final String FILE_NAME = "save_current_score13.ser";

    public static final String SCORE_FILE_2 = "score_file13.ser";

    public static final String TOP_SCORE_FILE = "top_score_file13.ser";

    /**
     * The buttons to display
     */
    Button startButton;
    Button rankingsButton;
    Button backButton;

    /**
     * The current user's scoreboard
     */
    public static UserScoreBoard userScoreBoard = new UserScoreBoard();

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
        rankingsButton = findViewById(R.id.RankingsButton);

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
         * Activate rankings button
         */
        rankingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readScores(FILE_NAME);
                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                if (userList.size() != 0) {
                    if (SCORE_FILE_2 != null){
                        readScoreList(SCORE_FILE_2);
                        readTopScoreList(TOP_SCORE_FILE);
                    }

                    //USER SCOREBOARD
                    for (int i = 0; i == userList.size() - 1; i++) {
                        if (userList.get(i).getUserEmail().equals(firebaseUser.getEmail())) {
                            userScoreBoard.scoreList.add(userList.get(i).getGameScore()); //create users score list
                            saveScoreList(SCORE_FILE_2);
                        }
                    }

                    //GAME SCOREBOARD
                    for (int i = 0; i == userList.size() - 1; i++) {
                        if (userScoreBoard.topScoreList.size() == 0) {
                            userScoreBoard.topScoreList.add(userList.get(i).getUserEmail());
                            userScoreBoard.topScoreList.add(userList.get(i).getGameScore());
                            saveTopScoreList(TOP_SCORE_FILE);
                        }else if (userScoreBoard.topScoreList.size() >= 1) {
                            int oddInt = 1;
                            while (oddInt < userScoreBoard.topScoreList.size() && (Integer) userScoreBoard.topScoreList.get(oddInt) >=
                                    userList.get(0).getGameScore()) {
                                oddInt += 2;
                            }
                            if (oddInt > userScoreBoard.topScoreList.size()) {
                                userScoreBoard.topScoreList.add(userList.get(i).getUserEmail());
                                userScoreBoard.topScoreList.add(userList.get(i).getGameScore());
                                if (userScoreBoard.topScoreList.size() > 10){
                                    userScoreBoard.topScoreList.remove(11);
                                    userScoreBoard.topScoreList.remove(10);
                                }
                                saveTopScoreList(TOP_SCORE_FILE);
                            }else {
                                userScoreBoard.topScoreList.add(oddInt - 1, userList.get(i).getUserEmail());
                                userScoreBoard.topScoreList.add(oddInt, userList.get(i).getGameScore());
                                if (userScoreBoard.topScoreList.size() > 10){
                                    userScoreBoard.topScoreList.remove(11);
                                    userScoreBoard.topScoreList.remove(10);
                                }
                                saveTopScoreList(TOP_SCORE_FILE);
                            }
                        }
                    }
                    Collections.sort(userScoreBoard.scoreList, Collections.reverseOrder());
                }

                Intent intent = new Intent(SlidingTileMainPageActivity.this, UserScoreBoard.class);
                Bundle scoresBundle = new Bundle();
                scoresBundle.putSerializable("scoreList", userScoreBoard.scoreList);
                scoresBundle.putSerializable("topScoreList", userScoreBoard.topScoreList);
                scoresBundle.putSerializable("userEmail", firebaseUser.getEmail());
                //scoresBundle.putSerializable("userId", user_id);
                intent.putExtra("scoresBundle", scoresBundle);
                startActivity(intent);

            }
        });
    }

    /**
     * Read the scores from a file
     *
     * @param fileName file to read scores from
     */
    public void readScores(String fileName) {

        try {
            InputStream in = this.openFileInput(fileName);
            if (in != null) {
                ObjectInputStream input = new ObjectInputStream(in);
                ArrayList<EmailAndScore> UserListFromFile = (ArrayList<EmailAndScore>) input.readObject();
                input.close();
                this.userList = UserListFromFile;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Save the scoreList to fileName
     *
     * @param fileName file to save scoreList to
     */
    public void saveScoreList(String fileName) {
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(this.openFileOutput(fileName, MODE_PRIVATE));
            out.writeObject(userScoreBoard.scoreList);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Save the topScoreList to fileName
     *
     * @param fileName file to save topScoreList to
     */
    public void saveTopScoreList(String fileName) {
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(this.openFileOutput(fileName, MODE_PRIVATE));
            out.writeObject(userScoreBoard.topScoreList);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Read the scoreList from fileName
     *
     * @param fileName file to read scoreList from
     */
    public void readScoreList(String fileName) {

        try {
            InputStream in = this.openFileInput(fileName);
            if (in != null) {
                ObjectInputStream input = new ObjectInputStream(in);
                ArrayList<Object> ScoreListFromFile = (ArrayList<Object>) input.readObject();
                input.close();
                userScoreBoard.scoreList = ScoreListFromFile;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Read the topScoreList from fileName
     *
     * @param fileName file to read topScoreList from
     */
    public void readTopScoreList(String fileName) {

        try {
            InputStream in = this.openFileInput(fileName);
            if (in != null) {
                ObjectInputStream input = new ObjectInputStream(in);
                ArrayList<Object> TopScoreListFromFile = (ArrayList<Object>) input.readObject();
                input.close();
                userScoreBoard.topScoreList = TopScoreListFromFile;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

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


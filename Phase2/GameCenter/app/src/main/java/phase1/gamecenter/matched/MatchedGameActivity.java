/*
Timer adapted from:
https://stackoverflow.com/a/17486406
 */

package phase1.gamecenter.matched;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;

import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

import phase1.gamecenter.CustomAdapter;
import phase1.gamecenter.FileManager;
import phase1.gamecenter.GameActivity;
import phase1.gamecenter.GestureDetectGridView;
import phase1.gamecenter.R;
import phase1.gamecenter.ScoreBoardUpdater;

/**
 * The game activity with the goal to connect the biggest possible blob of colour tiles.
 */
public class MatchedGameActivity extends FileManager implements GameActivity {

    /**
     * The board manager.
     */
    private MatchedBoardManager boardManager;

    /**
     * The board.
     */
    private MatchedBoard board;

    /**
     * The buttons to display.
     */
    private ArrayList<Button> tileButtons;

    /**
     * Grid View and calculated column height and width based on device size
     */
    private GestureDetectGridView gridView;

    /**
     * the column width and height
     */
    private static int columnWidth, columnHeight;

    /**
     * the initial seconds
     */
    private int seconds;

    /**
     * the initial minute
     */
    private int minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boardManager = loadFromFileMatched();
        createTileButtons(this);
        setContentView(R.layout.activity_colourmain);

        // Add View to activity
        board = boardManager.getBoard();
        boardManager.getBoard().addObserver(this);
        gridView = findViewById(R.id.grid);
        gridView.setNumColumns(board.getNUM_ROWS());
        gridView.setBoardManager(boardManager);

        // Observer sets up desired dimensions as well as calls our display function
        gridView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        gridView.getViewTreeObserver().removeOnGlobalLayoutListener(
                                this);
                        int displayWidth = gridView.getMeasuredWidth();
                        int displayHeight = gridView.getMeasuredHeight();

                        columnWidth = displayWidth / board.getNUM_ROWS();
                        columnHeight = displayHeight / board.getNUM_ROWS();

                        display();
                    }
                });
        setTheTimer();
    }

    /**
     * Set up the background image for each button based on the master list
     * of positions, and then call the adapter to set the view.
     */
    public void display() {
        updateTileButtons();
        gridView.setAdapter(new CustomAdapter(tileButtons, columnWidth, columnHeight));
    }

    /**
     * helper function to set the timer
     */
    void setTheTimer(){
        //Declare the timer
        Timer t = new Timer();
        seconds = boardManager.getSeconds();
        minutes = boardManager.getMinutes();
        //Set the schedule function and rate
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        TextView tv = (TextView) findViewById(R.id.editText);
                        tv.setText(String.format("%s:%s", String.valueOf(minutes), String.valueOf(seconds)));
                        seconds -= 1;

                        if(seconds == 0 && minutes != 0) {
                            seconds=60;
                            minutes=minutes-1;
                            tv.setText(String.format("%s:%s", String.valueOf(minutes), String.valueOf(seconds)));
                        }
                        else if (seconds == 0){
                            gameOver();
                        }
                    }
                });
            }
        }, 0, 1000);

    }

    /**
     * Helper function to the setTimer method, deals with the case when time is over.
     */
    protected void gameOver() {
        String score = Integer.toString(boardManager.getScore());
        updateScoreboard(boardManager.getScore());
        updateLeaderBoard(boardManager.getScore());
        if(boardManager.getScore() < boardManager.getScoreReq()) {
            Toast toast = Toast.makeText(MatchedGameActivity.this, "Time's up! Try again to unlock the next level. Your score: " + score, Toast.LENGTH_LONG);
            toast.setGravity(0,10,10);
            toast.show();
            saveToFile(MatchedBoardManager.TEMP_SAVE_FILENAME, boardManager);
            Intent tmp = new Intent(MatchedGameActivity.this, MatchedRoundsActivity.class);
            boardManager.setRound(boardManager.getRound() - 1);
            tmp.putExtra("rounds", boardManager.getRound());
            System.out.println("lost "+ (boardManager.getRound()));
            startActivity(tmp);
        } else {
            Toast toast = Toast.makeText(MatchedGameActivity.this, "Time's up! you've unlocked the next level. :D" +
                    " your score: " + score, Toast.LENGTH_LONG);
            toast.setGravity(0,10,10);
            toast.show();
            Intent tmp = new Intent(MatchedGameActivity.this, MatchedRoundsActivity.class);
            boardManager.setRound(boardManager.getRound() + 1);
            saveToFile(MatchedBoardManager.TEMP_SAVE_FILENAME, boardManager);
            tmp.putExtra("rounds", boardManager.getRound());
            System.out.println("won "+ (boardManager.getRound()));
            startActivity(tmp);
        }
    }

    /**
     * update the user's scoreboard on firebase
     * @param score
     */

    public void updateScoreboard(int score) {
        ScoreBoardUpdater sbu = new ScoreBoardUpdater(score,"Colour Tiles");
        sbu.updateUserScoreBoard();
    }

    /**
     * update scoreboard for leaderboard on firebase
     *
     */
    private void updateLeaderBoard(int score){
        ScoreBoardUpdater sbu = new ScoreBoardUpdater(score, "Colour Tiles");
        sbu.updateLeaderBoard();
    }

    /**
     * Create the buttons for displaying the tiles.
     * @param context the context
     */
    public void createTileButtons(Context context) {
        MatchedBoard board = boardManager.getBoard();
        tileButtons = new ArrayList<>();
        for (int row = 0; row != board.getNUM_ROWS(); row++) {
            for (int col = 0; col != board.getNUM_ROWS(); col++) {
                Button tmp = new Button(context);
                tmp.setBackgroundResource(board.getTile(row, col).getBackground());
                this.tileButtons.add(tmp);
            }
        }
    }

    /**
     * Update the backgrounds on the buttons to match the tiles.
     */
    public void updateTileButtons() {
        MatchedBoard board = boardManager.getBoard();
        int nextPos = 0;
        for (Button b : tileButtons) {
            int row = nextPos / board.getNUM_ROWS();
            int col = nextPos % board.getNUM_ROWS();
            b.setBackgroundResource(board.getTile(row, col).getBackground());
            nextPos++;
        }
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        saveToFile(MatchedStartingActivity.TEMP_SAVE_FILENAME, boardManager);
    }

    @Override
    public void update(Observable o, Object arg) {
        display();
    }

    /**
     * Back button from the game to the main page
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MatchedGameActivity.this, MatchedRoundsActivity.class);
        seconds = 0;
        minutes = 0;
        startActivity(intent);
    }
}
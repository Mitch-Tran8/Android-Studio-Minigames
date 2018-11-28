/*
Timer adapted from:
https://stackoverflow.com/a/17486406
 */

package phase1.gamecenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;



/**
 * The game activity with the goal to connect the biggest possible blob of colour tiles.
 */
public class ColourGameActivity extends AppCompatActivity implements Observer {

    /**
     * The board manager.
     */
    private ColourBoardManager boardManager;

    /**
     * The board.
     */
    private ColourBoard board;

    /**
     * The buttons to display.
     */
    private ArrayList<Button> tileButtons;

    /**
     * Save button
     */
    private Button saveButton;

    /**
     * Grid View and calculated column height and width based on device size
     */
    private GestureDetectGridView gridView;

    /**
     * the column width and height
     */
    private static int columnWidth, columnHeight;
    private int seconds;
    private int minutes;

    /**
     * Set up the background image for each button based on the master list
     * of positions, and then call the adapter to set the view.
     */
    // Display
    public void display() {
        updateTileButtons();
        gridView.setAdapter(new CustomAdapter(tileButtons, columnWidth, columnHeight));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadFromFile(ColourStartingActivity.TEMP_SAVE_FILENAME);
        createTileButtons(this);
        setContentView(R.layout.activity_colourmain);
        addSaveButtonListener();


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
                        tv.setText(String.valueOf(minutes)+":"+ String.valueOf(seconds));
                        seconds -= 1;

                        if(seconds == 0 && minutes != 0) {
                            seconds=60;
                            minutes=minutes-1;
                            tv.setText(String.valueOf(minutes)+":"+String.valueOf(seconds));
                        }
                        else if (seconds == 0 && minutes == 0){
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
    private void gameOver() {
        String score = Integer.toString(boardManager.getScore());
        updateScoreboard(boardManager.getScore());
        if(boardManager.getScore() < board.getScoreReq()) {
            Toast toast = Toast.makeText(ColourGameActivity.this, "Time's up! Try again to unlock the next level. Your score: " + score, Toast.LENGTH_LONG);
            toast.setGravity(0,10,10);
            toast.show();
            saveToFile(ColourBoardManager.TEMP_SAVE_FILENAME);
            Intent tmp = new Intent(ColourGameActivity.this, ColourTileRoundsActivity.class);
            board.setRound(board.getRound() - 1);
            tmp.putExtra("round", board.getRound());
            System.out.println("lost "+ (board.getRound()));
            startActivity(tmp);
        } else {
            Toast toast = Toast.makeText(ColourGameActivity.this, "Time's up! you've unlocked the next level. :D" +
                    " your score: " + score, Toast.LENGTH_LONG);
            toast.setGravity(0,10,10);
            toast.show();
            saveToFile(ColourBoardManager.TEMP_SAVE_FILENAME);
            Intent tmp = new Intent(ColourGameActivity.this, ColourTileRoundsActivity.class);
            Bundle b = new Bundle();
            board.setRound(board.getRound() + 1);
            b.putInt("round",  board.getRound());
            System.out.println("won "+ (board.getRound()));
            tmp.putExtras(b);
            startActivity(tmp);

        }
    }


    private void updateScoreboard(int score) {
        ScoreBoardUpdater sbu = new ScoreBoardUpdater(score,"Colour tiles");
        sbu.updateUserScoreBoard();
    }

    /**
     * Create the buttons for displaying the tiles.
     *
     * @param context the context
     */
    private void createTileButtons(Context context) {
        ColourBoard board = boardManager.getBoard();
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
    private void updateTileButtons() {
        ColourBoard board = boardManager.getBoard();
        int nextPos = 0;
        for (Button b : tileButtons) {
            int row = nextPos / board.getNUM_ROWS();
            int col = nextPos % board.getNUM_ROWS();
            b.setBackgroundResource(board.getTile(row, col).getBackground());
            nextPos++;
        }
    }

    /**
     * Activate the save button
     */
    private void addSaveButtonListener() {
        saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFile(ColourStartingActivity.TEMP_SAVE_FILENAME);
                Toast.makeText(ColourGameActivity.this, "Succesfully saved", Toast.LENGTH_LONG).show();

            }
        });
    }



    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        saveToFile(ColourStartingActivity.TEMP_SAVE_FILENAME);
    }

    /**
     * Load the board manager from fileName.
     *
     * @param fileName the name of the file
     */
    private void loadFromFile(String fileName) {

        try {
            InputStream inputStream = this.openFileInput(fileName);
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                boardManager = (ColourBoardManager) input.readObject();
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("login activity", "File contained unexpected data type: " + e.toString());
        }
    }

    /**
     * Save the board manager to fileName.
     *
     * @param fileName the name of the file
     */
    public void saveToFile(String fileName) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    this.openFileOutput(fileName, MODE_PRIVATE));
            outputStream.writeObject(boardManager);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        display();
    }
}

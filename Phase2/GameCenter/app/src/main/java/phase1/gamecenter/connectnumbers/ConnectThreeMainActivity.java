package phase1.gamecenter.connectnumbers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

import phase1.gamecenter.R;
import phase1.gamecenter.ScoreBoardUpdater;

public class ConnectThreeMainActivity extends ConnectNumbersActivity implements View.OnClickListener {

    /**
     * 2D array of buttons, representing the connect three game board.
     */
    private Button[][] buttons = new Button[3][3];

    /**
     * TextView that shows the number of rounds player 1 has won.
     */
    private TextView scorePlayer2;

    /**
     * the max times for player 2 to undo their moves.
     */
    private int maxPlayer2UndoTimes;

    /**
     * set the number of undos for player 2 for testing purpose
     *
     * @param maxUndo setting the maxiumum number of undos.
     */
    public void setMaxPlayer2UndoTimes(int maxUndo) {
        this.maxPlayer2UndoTimes = maxUndo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_three_bubbles);
        scorePlayer1 = findViewById(R.id.scorePlayer1);
        scorePlayer2 = findViewById(R.id.scorePlayer2);
        draws = findViewById(R.id.draws);
        Button buttonReset = findViewById(R.id.button_reset);
        Button gameReset = findViewById(R.id.button_reset_game);
        Button undoButton = findViewById(R.id.undoButton);
        maxUndoTimes = 3;
        maxPlayer2UndoTimes = 3;
        this.moveStack = new Stack<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID); //populating array with buttons
                buttons[i][j].setOnClickListener(this);
                buttons[i][j].setText("");
            }
        }
        //reset to NEW ROUND using button
        buttonResetListener(buttonReset);
        //reset the GAME using button
        gameResetListener(gameReset);
        ///undo move using button
        addUndoButtonListener(undoButton);
    }

    /**
     * On click listener for the game reset button -> reset the game.
     *
     * @param gameReset game reset button.
     */
    @Override
    protected void gameResetListener(Button gameReset) {
        gameReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        buttons[i][j].setText("");
                        buttons[i][j].setBackgroundResource(R.drawable.circle_button);
                    }
                }
                moves = 0;
                maxUndoTimes = 3;
                maxPlayer2UndoTimes = 3;
                moveStack = new Stack<>();
                roundsPlayed = 0;
                player1Turn = true;
                player1points = 0;
                player1RoundsWon = 0;
                opponentRoundsWon = 0;
                ties = 0;
                updateRoundsWon();
            }
        });
    }

    /**
     * On click listener for the reset match button -> make a new match.
     *
     * @param buttonReset match reset button
     */
    @Override
    protected void buttonResetListener(Button buttonReset) {
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!gameOver()) {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            buttons[i][j].setText("");
                            buttons[i][j].setBackgroundResource(R.drawable.circle_button);
                        }
                    }
                    moves = 0;
                    maxUndoTimes = 3;
                    maxPlayer2UndoTimes = 3;
                    moveStack = new Stack<>();
                    player1Turn = true;
                } else {
                    if (player1RoundsWon == 3) {
                        updateScoreboard();
                        updateLeaderBoard();
                        Toast.makeText(getApplicationContext(), "Game Over. Player 1 wins! Please start a new game.", Toast.LENGTH_LONG).show();
                    } else if (opponentRoundsWon == 3) {
                        Toast.makeText(getApplicationContext(), "Game Over. Player 2 wins! Please start a new game.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Game Over. TIE! Please start a new game.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    /**
     * Activate the undo button.
     */
    @Override
    protected void addUndoButtonListener(Button undoButton) {
        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!matchOver(3, buttons) && moves < 9) {
                    if (isValidUndo()) {
                        undoMove();
                        Toast.makeText(getApplicationContext(), "Successful undo!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Match over - invalid undo!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (gameOver()) {
            gameOverMessage();
        } else {
            if (matchOver(3, buttons)) {
                Toast.makeText(this, "Match over. Please start a new match.", Toast.LENGTH_LONG).show();
            } else {
                if (!((Button) v).getText().toString().equals("")) {//checks if button contains empty string, if X or O then already used
                    Toast.makeText(this, "Invalid move! Please choose another spot.", Toast.LENGTH_SHORT).show();
                } else {
                    processMove((Button) v);
                }
            }
        }
    }

    /**
     * Process the move of the current player.
     *
     * @param v The button pressed by the current player.
     */
    private void processMove(Button v) {
        if (player1Turn) {
            v.setTextColor(Color.parseColor("#00ffffff"));
            v.setBackgroundResource(R.drawable.sunglass_smiley);
            v.setText("X");
            this.moveStack.push(v.getId());

        } else {
            v.setTextColor(Color.parseColor("#00ffffff"));
            v.setBackgroundResource(R.drawable.crazy_face);
            v.setText("O");
            this.moveStack.push(v.getId());

        }
        moves++;
        if (matchOver(3, buttons)) {
            if (player1Turn) {
                player1Wins();
                Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_LONG).show();
                updateRoundsWon();
            } else {
                opponentWins();
                Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_LONG).show();
                updateRoundsWon();
            }
        } else if (moves == 9) {
            tie();
            Toast.makeText(this, "Tied!", Toast.LENGTH_LONG).show();
            updateRoundsWon();
        } else {
            player1Turn = !player1Turn;
        }
    }

    /**
     * Player 1 wins the match, update scores.
     */
    public void player1Wins() {
        player1points = player1points + 10;
        player1RoundsWon++;
        roundsPlayed++;
    }

    /**
     * Opponent wins the match, update scores.
     */
    public void opponentWins() {
        player1points = player1points - 6;
        opponentRoundsWon++;
        roundsPlayed++;
    }

    /**
     * Displays the toast message when the game is over.
     */
    protected void gameOverMessage() {
        if (player1RoundsWon == 3) {
            Toast.makeText(this, "Game Over. Player 1 wins! Please start a new game.", Toast.LENGTH_LONG).show();
        } else if (opponentRoundsWon == 3) {
            Toast.makeText(this, "Game Over. Player 2 wins! Please start a new game.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Game Over. TIE! Please start a new game.", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Update TextView with the scores of each player.
     */
    protected void updateRoundsWon() {
        scorePlayer1.setText("Player 1: " + player1RoundsWon);
        scorePlayer2.setText("Player 2: " + opponentRoundsWon);
        draws.setText("Draws: " + ties);
    }

    /**
     * returns if undo is valid
     *
     * @return if undo is valid
     */

    public boolean isValidUndo() {
        return (player1Turn && maxPlayer2UndoTimes > 0 || !player1Turn && maxUndoTimes > 0);
    }

    /**
     * undo the most recent move if the max undo times has not been reached
     */
    protected void undoMove() {
            if (moveStack.size() > 0) {
                if (player1Turn) {
                    int id = this.moveStack.pop();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (buttons[i][j].getId() == id) {
                                buttons[i][j].setText("");
                                buttons[i][j].setBackgroundResource(R.drawable.circle_button);
                                player1Turn = false;
                                maxPlayer2UndoTimes--;
                            }
                        }
                    }
                } else {
                    int id = this.moveStack.pop();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (buttons[i][j].getId() == id) {
                                buttons[i][j].setText("");
                                buttons[i][j].setBackgroundResource(R.drawable.circle_button);
                                player1Turn = true;
                                maxUndoTimes--;
                            }
                        }
                    }
                }
            }
            moves--;
    }

    /**
     * Return to the connect numbers starting page.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ConnectThreeMainActivity.this, ConnectNumbersStartingActivity.class);
        startActivity(intent);
    }

    /**
     * update user's scoreboard on firebase
     */
    private void updateScoreboard() {
        ScoreBoardUpdater sbu = new ScoreBoardUpdater(player1points, "Connect 34");
        sbu.updateUserScoreBoard();
    }

    /**
     * update scoreboard for leaderboard on firebase
     */
    private void updateLeaderBoard() {
        ScoreBoardUpdater sbu = new ScoreBoardUpdater(player1points, "Connect 34");
        sbu.updateLeaderBoard();
    }


}

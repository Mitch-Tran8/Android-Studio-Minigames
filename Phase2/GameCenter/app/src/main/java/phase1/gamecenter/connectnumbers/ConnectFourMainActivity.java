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

public class ConnectFourMainActivity extends ConnectNumbersActivity implements View.OnClickListener {

    /**
     * 2D array of buttons, representing the connect four game board.
     */
    private Button[][] buttons = new Button[5][5];

    /**
     * TextView that shows the number of rounds player 1 has won.
     */
    private TextView scorePlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_four_bubbles);
        scorePlayer1 = findViewById(R.id.scorePlayer1);
        scorePlayer2 = findViewById(R.id.scorePlayer2);
        draws = findViewById(R.id.draws);
        Button buttonReset = findViewById(R.id.button_reset);
        Button gameReset = findViewById(R.id.button_reset_game);
        Button undoButton = findViewById(R.id.undoButton);
        this.moveStack = new Stack<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID); //populating array with buttons
                buttons[i][j].setOnClickListener(this);
                buttons[i][j].setText("");
            }
        }

        buttonResetListener(buttonReset);
        gameResetListener(gameReset);
        addUndoButtonListener(undoButton);
    }

    /**
     * On click listener for the game reset button -> reset the game.
     *
     * @param gameReset the reset game button.
     */
    protected void gameResetListener(Button gameReset) {
        gameReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        buttons[i][j].setText("");
                        buttons[i][j].setBackgroundResource(R.drawable.circle_button);
                    }
                }
                moves = 0;
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
     * On click listener for the reset button -> create a new match
     *
     * @param buttonReset the new match button
     */
    protected void buttonResetListener(Button buttonReset) {
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!gameOver()) {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            buttons[i][j].setText("");
                            buttons[i][j].setBackgroundResource(R.drawable.circle_button);
                        }
                    }
                    moves = 0;
                    player1Turn = true;
                } else {
                    if (player1RoundsWon == 3) {
                        updateLeaderBoard();
                        updateScoreboard();
                        Toast.makeText(getApplicationContext(), "Game Over. Player 1 wins! Please refresh the game.", Toast.LENGTH_LONG).show();
                    } else if (opponentRoundsWon == 3) {
                        Toast.makeText(getApplicationContext(), "Game Over. Player 2 wins! Please refresh the game.", Toast.LENGTH_LONG).show();
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
    protected void addUndoButtonListener(Button undoButton) {
        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                undoMove();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (gameOver()) {
            gameOverMessage();
        } else {
            if (matchOver(5, buttons)) {
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
        if (matchOver(5, buttons)) {
            if (player1Turn) {
                player1Wins();
                Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_LONG).show();
                updateRoundsWon();
            } else {
                opponentWins();
                Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_LONG).show();
                updateRoundsWon();
            }
        } else if (moves == 25) {
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
        player1points = player1points + 15;
        player1RoundsWon++;
        roundsPlayed++;
    }

    /**
     * Opponent wins the match, update scores.
     */
    public void opponentWins() {
        player1points = player1points - 4;
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
     * Return whether or not there is a 4 in a row.
     *
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 4 in a row.
     */
    @Override
    public boolean checkRows(String[][] board) {
        for (int i = 0; i < 5; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) &&
                    board[i][0].equals(board[i][3]) && !board[i][0].equals("")) {
                return true;
            }

            if (board[i][1].equals(board[i][2]) && board[i][1].equals(board[i][3]) &&
                    board[i][1].equals(board[i][4]) && !board[i][1].equals("")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether or not there is a 4 in a column.
     *
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 4 in a column
     */
    @Override
    public boolean checkColumns(String[][] board) {
        for (int i = 0; i < 5; i++) {
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) &&
                    board[0][i].equals(board[3][i]) && !board[0][i].equals("")) {
                return true;
            }

            if (board[1][i].equals(board[2][i]) && board[1][i].equals(board[3][i]) &&
                    board[1][i].equals(board[4][i]) && !board[1][i].equals("")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether or not there is a 4 in an ascending diagonal pattern.
     *
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 4 in a ascending diagonal.
     */
    @Override
    public boolean checkAscendingDiagonals(String[][] board) {

        if (board[3][0].equals(board[2][1]) &&
                board[3][0].equals(board[1][2]) &&
                board[3][0].equals(board[0][3]) && !board[3][0].equals("")) {
            return true;
        }

        if (board[4][0].equals(board[3][1]) &&
                board[4][0].equals(board[2][2]) &&
                board[4][0].equals(board[1][3]) && !board[4][0].equals("")) {
            return true;
        }

        if (board[3][1].equals(board[2][2]) &&
                board[3][1].equals(board[1][3]) &&
                board[3][1].equals(board[0][4]) && !board[3][1].equals("")) {
            return true;
        }

        if (board[4][1].equals(board[3][2]) &&
                board[4][1].equals(board[2][3]) &&
                board[4][1].equals(board[1][4]) && !board[4][1].equals("")) {
            return true;
        }

        return false;
    }

    /**
     * Return whether or not there is a 4 in an descending diagonal pattern.
     *
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 4 in a descending diagonal.
     */
    @Override
    public boolean checkDescendingDiagonals(String[][] board) {

        if (board[1][0].equals(board[2][1]) &&
                board[1][0].equals(board[3][2]) &&
                board[1][0].equals(board[4][3]) && !board[1][0].equals("")) {
            return true;
        }

        if (board[0][0].equals(board[1][1]) &&
                board[0][0].equals(board[2][2]) &&
                board[0][0].equals(board[3][3]) && !board[0][0].equals("")) {
            return true;
        }

        if (board[1][1].equals(board[2][2]) &&
                board[1][1].equals(board[3][3]) &&
                board[1][1].equals(board[4][4]) && !board[1][1].equals("")) {
            return true;
        }

        if (board[0][1].equals(board[1][2]) &&
                board[0][1].equals(board[2][3]) &&
                board[0][1].equals(board[3][4]) && !board[0][1].equals("")) {
            return true;
        }
        return false;
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
     * undo the most recent move if the max undo times has not been reached
     */
    protected void undoMove() {
        if (!matchOver(5, buttons) && moves < 25) {
            if (moveStack.size() > 0) {
                int id = this.moveStack.pop();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (buttons[i][j].getId() == id) {
                            buttons[i][j].setText("");
                            buttons[i][j].setBackgroundResource(R.drawable.circle_button);
                            if (player1Turn) {
                                player1Turn = false;
                            } else {
                                player1Turn = true;
                            }
                        }
                    }
                }
                --moves;
            }
        }
    }

    /**
     * Return to the connect numbers starting page.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ConnectFourMainActivity.this, ConnectNumbersStartingActivity.class);
        startActivity(intent);
    }

    /**
     * update user's scoreboard on firebase
     */
    private void updateScoreboard() {
        ScoreBoardUpdater sbu = new ScoreBoardUpdater(player1points, "Connect34");
        sbu.updateUserScoreBoard();
    }

    /**
     * update scoreboard for leaderboard on firebase
     */
    private void updateLeaderBoard() {
        ScoreBoardUpdater sbu = new ScoreBoardUpdater(player1points, "Connect34");
        sbu.updateLeaderBoard();
    }


}
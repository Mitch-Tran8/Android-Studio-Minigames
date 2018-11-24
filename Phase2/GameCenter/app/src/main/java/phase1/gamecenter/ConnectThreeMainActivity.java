package phase1.gamecenter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConnectThreeMainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 2D array of buttons, representing the connect four game board.
     */
    private Button[][] buttons = new Button[3][3];

    /**
     * Boolean representing if it is player 1's turn.
     */
    private boolean player1Turn = true;

    /**
     * The number of moves made on the connect four board.
     */
    private int moves;

    /**
     * The number of rounds player 1 has won.
     */
    private int player1points;

    /**
     * The number of rounds player 2 has won.
     */
    private int player2points;

    /**
     * The number of games tied.
     */
    private int ties;

    /**
     * TextView that shows the number of rounds player 1 has won.
     */
    private TextView scorePlayer1;

    /**
     * TextView that shows the number of rounds player 1 has won.
     */
    private TextView scorePlayer2;

    /**
     * TextView that shows the number of ties.
     */
    private TextView draws;

    /**
     * Number of rounds won by player 1.
     */
    private int player1RoundsWon;

    /**
     * Number of rounds won by player 2.
     */
    private int player2RoundsWon;

    /**
     * Number of rounds played.
     */
    private int roundsPlayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_three_bubbles);
        scorePlayer1 = findViewById(R.id.scorePlayer1);
        scorePlayer2 = findViewById(R.id.scorePlayer2);
        draws = findViewById(R.id.draws);
        Button buttonReset = findViewById(R.id.button_reset);
        Button gameReset = findViewById(R.id.button_reset_game);

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
    }

    /**
     * On click listener for the game reset button -> reset the game.
     * @param gameReset game reset button.
     */
    private void gameResetListener(Button gameReset) {
        gameReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        buttons[i][j].setText("");
                    }
                }
                moves = 0;
                roundsPlayed = 0;
                player1Turn = true;
                player1points = 0;
                player2points = 0;
                player1RoundsWon = 0;
                player2RoundsWon = 0;
                ties = 0;
                updatePoints();
            }
        });
    }

    /**
     * On click listener for the reset match button -> make a new match.
     * @param buttonReset
     */
    private void buttonResetListener(Button buttonReset) {
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!gameOver()) {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            buttons[i][j].setText("");
                        }
                    }
                    moves = 0;
                    player1Turn = true;
                } else {
                    if (player1RoundsWon == 3) {
                        Toast.makeText(getApplicationContext(), "Game Over. Player 1 wins! Please start a new game.", Toast.LENGTH_LONG).show();
                    } else if (player2RoundsWon == 3){
                        Toast.makeText(getApplicationContext(), "Game Over. Player 2 wins! Please start a new game.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Game Over. TIE! Please start a new game.", Toast.LENGTH_LONG).show();
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
            if (matchOver()) {
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
            //v.setTextColor(Color.parseColor("#FFE35A7F"));
            v.setTextColor(Color.parseColor("#00ffffff"));
            v.setBackgroundResource(R.drawable.sunglass_smiley);
            v.setText("X");
        } else {
            //v.setTextColor(Color.parseColor("#FFE79024"));
            v.setTextColor(Color.parseColor("#00ffffff"));
            v.setBackgroundResource(R.drawable.crazy_face);
            v.setText("O");
        }
        moves++;
        if (matchOver()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (moves == 9) {
            tie();
        } else {
            player1Turn = !player1Turn;
        }
    }

    /**
     * Displays the toast message when the game is over.
     */
    private void gameOverMessage() {
        if (player1RoundsWon == 3) {
            Toast.makeText(this, "Game Over. Player 1 wins! Please start a new game.", Toast.LENGTH_LONG).show();
        } else if (player2RoundsWon == 3) {
            Toast.makeText(this, "Game Over. Player 2 wins! Please start a new game.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Game Over. TIE! Please start a new game.", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Tie in the game.
     */
    private void tie() {
        ties++;
        roundsPlayed++;
        Toast.makeText(this, "Tied!", Toast.LENGTH_LONG).show();
        updatePoints();
    }

    /**
     * Player 2 wins the match, update scores.
     */
    private void player2Wins() {
        player2points = player2points + 5;
        player1points = player1points - 3;
        player2RoundsWon++;
        roundsPlayed++;
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_LONG).show();
        updatePoints();
    }

    /**
     * Player 1 wins the match, update scores.
     */
    private void player1Wins() {
        player1points = player1points + 5;
        player2points = player2points - 3;
        player1RoundsWon++;
        roundsPlayed++;
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_LONG).show();
        updatePoints();
    }

    /**
     * Return whether the connect three game is over, that is, if a player has made three in a row.
     *
     * @return whether the game is over.
     */
    private boolean gameOver() {
        return (player1RoundsWon == 3 || player2RoundsWon == 3 || roundsPlayed == 5);
    }

    /**
     * Return whether the connect three game is over, that is, if a player has made three in a row.
     *
     * @return whether the game is over.
     */
    private boolean matchOver() {
        String[][] board = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText().toString(); //go thru all buttons and set their XO text
            }
        }

        return (checkRows(board) || checkColumns(board) || checkAscendingDiagonals(board) || checkDescendingDiagonals(board));
    }

    /**
     * Return whether or not there is a 3 in a row.
     *
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 3 in a row.
     */
    private boolean checkRows(String[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) &&
                    !board[i][0].equals("")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether or not there is a 3 in a column.
     *
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 3 in a column
     */
    private boolean checkColumns(String[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) &&
                    !board[0][i].equals("")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether or not there is a 3 in an ascending diagonal pattern.
     *
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 3 in a ascending diagonal.
     */
    private boolean checkAscendingDiagonals(String[][] board) {

        return (board[0][2].equals(board[1][1]) &&
                board[0][2].equals(board[2][0]) &&
                !board[0][2].equals(""));
    }

    /**
     * Return whether or not there is a 3 in an descending diagonal pattern.
     *
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 3 in a descending diagonal.
     */
    private boolean checkDescendingDiagonals(String[][] board) {

        return (board[0][0].equals(board[1][1]) &&
                board[0][0].equals(board[2][2]) &&
                !board[0][0].equals(""));
    }

    /**
     * Update TextView with the scores of each player.
     */
    private void updatePoints() {
        scorePlayer1.setText("Player 1: " + player1RoundsWon);
        scorePlayer2.setText("Player 2: " + player2RoundsWon);
        draws.setText("Draws: " + ties);
    }

    /**
     * Return to the connect numbers starting page.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ConnectThreeMainActivity.this, ConnectNumbersStartingActivity.class);
        startActivity(intent);
    }

}

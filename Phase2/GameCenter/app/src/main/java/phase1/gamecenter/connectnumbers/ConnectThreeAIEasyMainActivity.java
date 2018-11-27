package phase1.gamecenter.connectnumbers;

import java.util.Random;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import phase1.gamecenter.R;

public class ConnectThreeAIEasyMainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 2D array of buttons, representing the connect three game board.
     */
    private Button[][] buttons = new Button[3][3];

    /**
     * a variable representing a random call.
     */
    private static final Random RANDOM = new Random();

    /**
     * Boolean representing if it is player 1's turn.
     */
    private boolean player1Turn = true;

    /**
     * The number of moves made on the connect three board.
     */
    private int moves;

    /**
     * The number of games tied.
     */
    private int ties;

    /**
     * The score of player 1.
     */
    private int player1points;

    /**
     * The score of the AI.
     */
    private int aipoints;

    /**
     * TextView that shows the number of rounds player 1 has won.
     */
    private TextView scorePlayer1;

    /**
     * TextView that shows the number of rounds the AI has won.
     */
    private TextView aiPlayer;

    /**
     * TextView that shows the number of ties.
     */
    private TextView draws;

    /**
     * Number of rounds won by player 1.
     */
    private int player1RoundsWon;

    /**
     * Number of rounds won by the AI.
     */
    private int aiRoundsWon;

    /**
     * Number of rounds played.
     */
    private int roundsPlayed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_three_ai);
        scorePlayer1 = findViewById(R.id.scorePlayer1);
        aiPlayer = findViewById(R.id.aiPlayer);
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
                player1RoundsWon = 0;
                aiRoundsWon = 0;
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
                    } else if (aiRoundsWon == 3){
                        Toast.makeText(getApplicationContext(), "Game Over. AI wins! Please start a new game.", Toast.LENGTH_LONG).show();
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
    private void processMove (Button v) {
        if (((Button) v).getText().toString().equals("")){
            ((Button) v).setText("X");

            if (matchOver()) {
                if (player1Turn) {
                    player1Wins();
                }
            }
            else {
                player1Turn = false;
                int i;
                int j;
                if (moves < 4){
                        do {
                        i = RANDOM.nextInt(3);
                        j = RANDOM.nextInt(3);
                    } while (!buttons[i][j].getText().toString().equals(""));
                    (buttons[i][j]).setText("O");
                    if (matchOver()) {
                        if (!player1Turn) {
                            aiWins();
                        }
                    }
                }
            }
        }

        moves++;
        if (moves == 5) {
            tie();
        }else {
            player1Turn = true;
        }
    }

    /**
     * Displays the toast message when the game is over.
     */
    private void gameOverMessage() {
        if (player1RoundsWon == 3) {
            Toast.makeText(this, "Game Over. Player 1 wins! Please start a new game.", Toast.LENGTH_LONG).show();
        } else if (aiRoundsWon == 3) {
            Toast.makeText(this, "Game Over. Player 2 wins! Please start a new game.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Game Over. TIE! Please start a new game.", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Player 1 wins the match, update scores.
     */
    private void player1Wins() {
        player1points = player1points + 5;
        aipoints = aipoints - 3;
        player1RoundsWon++;
        roundsPlayed++;
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_LONG).show();
        updatePoints();
    }

    /**
     * The AI wins the match, update scores.
     */
    private void aiWins() {
        aipoints = aipoints + 5;
        player1points = player1points - 3;
        aiRoundsWon++;
        roundsPlayed++;
        Toast.makeText(this, "AI wins!", Toast.LENGTH_LONG).show();
        updatePoints();
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
     * Return whether the connect three game is over, that is, if the player or the AI has won three
     * rounds or five rounds have been played without the player or AI winning 3 rounds.
     *
     * @return whether the game is over.
     */
    private boolean gameOver() {
        return (player1RoundsWon == 3 || aiRoundsWon == 3 || roundsPlayed == 5);
    }

    /**
     * Return whether the connect three game is over, that is, if the player or AI has made three in
     * a row.
     *
     * @return whether the game is over.
     */
    private boolean matchOver() {
        String[][] board = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText().toString(); //go through all buttons and set their XO text
            }
        }

        return (checkRows(board) || checkColumns(board) || checkAscendingDiagonals(board) ||
                checkDescendingDiagonals(board));
    }

    /**
     * Return whether or not there is a 3 in a row.
     *
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 3 in a row.
     */
    public boolean checkRows(String[][] board) {
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
    public boolean checkColumns(String[][] board) {
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
    public boolean checkAscendingDiagonals(String[][] board) {

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
    public boolean checkDescendingDiagonals(String[][] board) {

        return (board[0][0].equals(board[1][1]) &&
                board[0][0].equals(board[2][2]) &&
                !board[0][0].equals(""));
    }

    /**
     * Update TextView with the scores of the player and AI.
     */
    private void updatePoints() {
        scorePlayer1.setText("Player 1: " + player1RoundsWon);
        aiPlayer.setText("AI: " + aiRoundsWon);
        draws.setText("Draws: " + ties);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ConnectThreeAIEasyMainActivity.this, ConnectNumbersStartingActivity.class);
        startActivity(intent);
    }

}

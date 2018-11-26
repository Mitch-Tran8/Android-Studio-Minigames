package phase1.gamecenter;

import java.util.Random;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConnectThreeAIEasyMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];

    private static final Random RANDOM = new Random();

    private boolean player1Turn = true;

    private int moves;

    private int ties;

    private int player1points;

    private int aipoints;

    private TextView scorePlayer1;

    private TextView aiPlayer;

    private TextView draws;

    private int player1RoundsWon;

    private int aiRoundsWon;

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

    private void processMove (Button v) {
        if (((Button) v).getText().toString().equals("")){

            ((Button) v).setTextColor(Color.parseColor("#FFE35A7F"));
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

                    (buttons[i][j]).setTextColor(Color.parseColor("#FFE79024"));
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

    private void player1Wins() {
        player1points = player1points + 5;
        aipoints = aipoints - 3;
        player1RoundsWon++;
        roundsPlayed++;
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_LONG).show();
        updatePoints();
    }

    private void aiWins() {
        aipoints = aipoints + 5;
        player1points = player1points - 3;
        aiRoundsWon++;
        roundsPlayed++;
        Toast.makeText(this, "AI wins!", Toast.LENGTH_LONG).show();
        updatePoints();
    }
    private void tie() {
        ties++;
        roundsPlayed++;
        Toast.makeText(this, "Tied!", Toast.LENGTH_LONG).show();
        updatePoints();
    }

    private boolean gameOver() {
        return (player1RoundsWon == 3 || aiRoundsWon == 3 || roundsPlayed == 5);
    }

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
     * Return whether or not there is a 4 in a row.
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 4 in a row.
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
     * Return whether or not there is a 4 in a column.
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 4 in a column
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
     * Return whether or not there is a 4 in an ascending diagonal pattern.
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 4 in a ascending diagonal.
     */
    private boolean checkAscendingDiagonals(String[][] board) {

        return (board[0][2].equals(board[1][1]) &&
                board[0][2].equals(board[2][0]) &&
                !board[0][2].equals(""));
    }

    /**
     * Return whether or not there is a 4 in an descending diagonal pattern.
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 4 in a descending diagonal.
     */
    private boolean checkDescendingDiagonals(String[][] board) {

        return (board[0][0].equals(board[1][1]) &&
                board[0][0].equals(board[2][2]) &&
                !board[0][0].equals(""));
    }

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

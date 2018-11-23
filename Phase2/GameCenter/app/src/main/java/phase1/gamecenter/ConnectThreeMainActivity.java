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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_three);
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

        //reset to NEW ROUND
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        buttons[i][j].setText(""); }
                }
                moves = 0;
                player1Turn = true;
            }
        });

        //reset the GAME
        gameReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        buttons[i][j].setText(""); }
                }
                moves = 0;
                player1Turn = true;
                player1points = 0;
                player2points = 0;
                ties = 0;
                updatePoints();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {//checks if button contains empty string, if X or O then already used
            Toast.makeText(this, "Invalid move! Please choose another spot.", Toast.LENGTH_LONG).show(); }

        if (player1Turn) {
            ((Button) v).setTextColor(Color.parseColor("#FFE35A7F"));
            ((Button) v).setText("X"); }

        else {
            ((Button) v).setTextColor(Color.parseColor("#FFE79024"));
            ((Button) v).setText("O"); }

        moves++;
        if (gameOver()) {
            if (player1Turn) {
                player1points++;
                Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_LONG).show();
                updatePoints(); }
            else{
                player2points++;
                Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_LONG).show();
                updatePoints();
            }
        } else if (moves == 9) {
            ties++;
            Toast.makeText(this, "Tied!", Toast.LENGTH_LONG).show();
            updatePoints();
        } else {
            player1Turn = !player1Turn;
        }
    }

    /**
     * Return whether the connect four game is over, that is, if a player has made four in a row.
     * @return whether the game is over.
     */
    private boolean gameOver() {
        String[][] board = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText().toString(); //go thru all buttons and set their XO text
            }
        }

        if (checkRows(board) || checkColumns(board) || checkAscendingDiagonals(board) || checkDescendingDiagonals(board)) {
            return true;
        }
        return false;
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

    /**
     * Update TextView with the scores of each player.
     */
    private void updatePoints() {
        scorePlayer1.setText("Player 1: " + player1points);
        scorePlayer2.setText("Player 2: " + player2points);
        draws.setText("Draws: " + ties);

    }

    /**
     * Return to the connect four starting page.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ConnectThreeMainActivity.this, ConnectNumbersStartingActivity.class);
        startActivity(intent);
    }

}

package phase1.gamecenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ConnectFourMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[5][5];

    private boolean player1Turn = true;

    private int moves;

    private int player1points;
    private int player2points;

    private TextView scorePlayer1;
    private TextView scorePlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_four);
        scorePlayer1 = findViewById(R.id.scorePlayer1);
        scorePlayer2 = findViewById(R.id.scorePlayer2);
        Button buttonReset = findViewById(R.id.button_reset);
        Button gameReset = findViewById(R.id.button_reset_game);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
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
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        buttons[i][j].setText("");
                    }
                }
                moves = 0;
                player1Turn = true;
            }
        });

        //reset the GAME
        gameReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        buttons[i][j].setText("");
                    }
                }
                moves = 0;
                player1Turn = true;
                player1points = 0;
                player2points = 0;
                updatePointsText();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {//checks if button contains empty string, if X or O then already used
            Toast.makeText(this, "Invalid move!", Toast.LENGTH_LONG).show();
        }

        if (player1Turn) {
            ((Button) v).setText("X");
        }
        else {
            ((Button) v).setText("O");
        }

        moves++;
        if (gameOver()) {
            if (player1Turn) {
                player1Wins();
            } else{
                player2Wins();
            }
        } else if (moves == 25) {
            tie();
        } else {
            player1Turn = !player1Turn;
        }
    }

    private boolean gameOver() {
        String[][] board = new String[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
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
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 4 in a column
     */
    private boolean checkColumns(String[][] board) {
        for (int i = 0; i < 5; i++) {
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) &&
                    board[0][i].equals(board[3][i])&& !board[0][i].equals("")) {
                return true;
            }

            if (board[1][i].equals(board[2][i]) && board[1][i].equals(board[3][i]) &&
                    board[1][i].equals(board[4][i])&& !board[1][i].equals("")) {
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

        if (board[3][0].equals(board[2][1]) &&
                board[3][0].equals(board[1][2]) &&
                board[3][0].equals(board[0][3]) && !board[3][0].equals("")) { return true; }

        if (board[4][0].equals(board[3][1]) &&
                board[4][0].equals(board[2][2]) &&
                board[4][0].equals(board[1][3]) && !board[4][0].equals("")) { return true; }

        if (board[3][1].equals(board[2][2]) &&
                board[3][1].equals(board[1][3]) &&
                board[3][1].equals(board[0][4]) && !board[3][1].equals("")) { return true; }

        if (board[4][1].equals(board[3][2]) &&
                board[4][1].equals(board[2][3]) &&
                board[4][1].equals(board[1][4]) && !board[4][1].equals("")) { return true; }

        return false;
    }

    /**
     * Return whether or not there is a 4 in an descending diagonal pattern.
     * @param board String[][] with the current moves on the board (X's and O's)
     * @return whether or not there is a 4 in a descending diagonal.
     */
    private boolean checkDescendingDiagonals(String[][] board) {

        if (board[1][0].equals(board[2][1]) &&
                board[1][0].equals(board[3][2]) &&
                board[1][0].equals(board[4][3]) && !board[1][0].equals("")) { return true; }

        if (board[0][0].equals(board[1][1]) &&
                board[0][0].equals(board[2][2]) &&
                board[0][0].equals(board[3][3]) && !board[0][0].equals("")) { return true; }

        if (board[1][1].equals(board[2][2]) &&
                board[1][1].equals(board[3][3]) &&
                board[1][1].equals(board[4][4]) && !board[1][1].equals("")) { return true; }

        if (board[0][1].equals(board[1][2]) &&
                board[0][1].equals(board[2][3]) &&
                board[0][1].equals(board[3][4]) && !board[0][1].equals("")) { return true; }
        return false;
    }

    private void player1Wins() {
        player1points++;
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_LONG).show();
        updatePointsText();
    }

    private void player2Wins() {
        player2points++;
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_LONG).show();
        updatePointsText();
    }
    private void tie() {
        Toast.makeText(this, "Tied!", Toast.LENGTH_LONG).show();
    }

    private void updatePointsText() {
        scorePlayer1.setText("Player 1: " + player1points);
        scorePlayer2.setText("Player 2: " + player2points);

    }

    private void resetBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setText("");
            }
        }
        moves = 0;
        player1Turn = true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ConnectFourMainActivity.this, ConnectFourStartingActivity.class);
        startActivity(intent);
    }

}
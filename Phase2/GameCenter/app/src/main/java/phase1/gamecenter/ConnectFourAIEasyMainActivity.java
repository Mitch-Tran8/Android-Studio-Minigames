package phase1.gamecenter;

import java.util.Random;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConnectFourAIEasyMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[5][5];

    private static final Random RANDOM = new Random();

    private boolean player1Turn = true;

    private int moves;

    private int player1points;
    private int aipoints;

    private TextView scorePlayer1;
    private TextView aiPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_four_ai);
        scorePlayer1 = findViewById(R.id.scorePlayer1);
        aiPlayer = findViewById(R.id.aiPlayer);
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
                aipoints = 0;
                updatePointsText();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {//checks if button contains empty string, if X or O then already used
            Toast.makeText(this, "Invalid move!", Toast.LENGTH_LONG).show();
        }
        ((Button) v).setText("X");
        if (gameOver()) {
            if (player1Turn) {
                player1Wins();
            }
        }
        else {
            player1Turn = false;
            int i = -1;
            int j = -1;
            do {
                i = RANDOM.nextInt(4);
                j = RANDOM.nextInt(4);
            } while (!buttons[i][j].getText().toString().equals(""));
            (buttons[i][j]).setText("O");
            if (gameOver()) {
                if (!player1Turn) {
                    aiWins();
                }
            }
        }

        moves++;
         if (moves == 25) {
            tie();
        }else {
             player1Turn = true;
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

    private void aiWins() {
        aipoints++;
        Toast.makeText(this, "AI wins!", Toast.LENGTH_LONG).show();
        updatePointsText();
    }
    private void tie() {
        Toast.makeText(this, "Tied!", Toast.LENGTH_LONG).show();
    }

    private void updatePointsText() {
        scorePlayer1.setText("Player 1: " + player1points);
        aiPlayer.setText("AI: " + aipoints);

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
        Intent intent = new Intent(ConnectFourAIEasyMainActivity.this, ConnectNumbersStartingActivity.class);
        startActivity(intent);
    }

}
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

    private int player1points;
    private int aipoints;

    private TextView scorePlayer1;
    private TextView aiPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_three_bubbles);
        scorePlayer1 = findViewById(R.id.scorePlayer1);
        aiPlayer = findViewById(R.id.aiPlayer);
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
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
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
        ((Button) v).setTextColor(Color.parseColor("#FFE35A7F"));
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
                i = RANDOM.nextInt(2);
                j = RANDOM.nextInt(2);
            } while (!buttons[i][j].getText().toString().equals(""));
            (buttons[i][j]).setTextColor(Color.parseColor("#FFE79024"));
            (buttons[i][j]).setText("O");
            if (gameOver()) {
                if (!player1Turn) {
                    aiWins();
                }
            }
        }

        moves++;
        if (moves == 9) {
            tie();
        }else {
            player1Turn = true;
        }
    }

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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        moves = 0;
        player1Turn = true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ConnectThreeAIEasyMainActivity.this, ConnectNumbersStartingActivity.class);
        startActivity(intent);
    }

}

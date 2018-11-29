package phase1.gamecenter.connectnumbers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

import phase1.gamecenter.R;

public class ConnectThreeMainActivity extends ConnectNumbersActivity implements View.OnClickListener {

    /**
     * 2D array of buttons, representing the connect three game board.
     */
    private Button[][] buttons = new Button[3][3];

    /**
     * TextView that shows the number of rounds player 1 has won.
     */
    private TextView scorePlayer2;

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

        buttonResetListener(buttonReset);
        gameResetListener(gameReset);
        addUndoButtonListener(undoButton);
    }

    /**
     * On click listener for the game reset button -> reset the game.
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
     * @param buttonReset
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
                    player1Turn = true;
                } else {
                    if (player1RoundsWon == 3) {
                        Toast.makeText(getApplicationContext(), "Game Over. Player 1 wins! Please start a new game.", Toast.LENGTH_LONG).show();
                    } else if (opponentRoundsWon == 3){
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
                undoMove();
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
     * undo the most recent move if the max undo times has not been reached
     */
    protected void undoMove() {
        if(!matchOver(3, buttons) && moves < 9){
            if(moveStack.size() > 0){
                int id = this.moveStack.pop();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (buttons[i][j].getId() == id){
                            buttons[i][j].setText("");
                            buttons[i][j].setBackgroundResource(R.drawable.circle_button);
                            if (player1Turn){
                                player1Turn = false;
                            } else{
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
        Intent intent = new Intent(ConnectThreeMainActivity.this, ConnectNumbersStartingActivity.class);
        startActivity(intent);
    }

}

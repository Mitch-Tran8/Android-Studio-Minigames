package phase1.gamecenter.connectnumbers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

import phase1.gamecenter.R;


public abstract class ConnectNumbersActivity extends AppCompatActivity {

    /**
     * 2D array of buttons, representing the connect three game board.
     */
    //protected Button[][] buttons;
    /**
     * Boolean representing if it is player 1's turn.
     */
    protected boolean player1Turn = true;

    /**
     * The number of moves made on the connect three board.
     */
    protected int moves;

    /**
     * The score of player 1.
     */
    protected int player1points;

    /**
     * The number of games tied.
     */
    protected int ties;

    /**
     * TextView that shows the number of rounds player 1 has won.
     */
    protected TextView scorePlayer1;

    /**
     * TextView that shows the number of rounds player 1 has won.
     */
    protected TextView scorePlayer2;

    /**
     * TextView that shows the number of ties.
     */
    protected TextView draws;

    /**
     * Number of rounds won by player 1.
     */
    protected int player1RoundsWon;

    /**
     * Number of rounds won by player 2.
     */
    protected int player2RoundsWon;

    /**
     * Number of rounds played.
     */
    protected int roundsPlayed;

    /**
     * The stack that stocks all previous moves
     */
    protected Stack<Integer> moveStack;

    /**
     * set the number of rounds player 1 has won only for testing purpose
     * @param round amount of rounds to be set
     */
    protected void setPlayer1RoundsWon(int round){ this.player1RoundsWon = round;}

    /**
     * get the number of rounds player 1 has won only for testing purpose
     */
    protected int getPlayer1RoundsWon(){ return player1RoundsWon;}

    /**
     * set the number of rounds the AI has won only for testing purpose
     * @param round amount of rounds to be set
     */
    protected void setPlayer2RoundsWon(int round){ this.player2RoundsWon = round;}

    /**
     * get the number of rounds the AI has won only for testing purpose
     */
    protected int getPlayer2RoundsWon(){ return player2RoundsWon;}

    /**
     * set the number of rounds that have been played for testing purpose
     * @param round amount of rounds to be set
     */
    protected void setRoundsPlayed(int round){ this.roundsPlayed = round;}

    /**
     * get the number of rounds that have been played for testing purpose
     */
    protected int getRoundsPlayed(){ return roundsPlayed;}

    /**
     * get the number of rounds player 1 has won only for testing purpose
     */
    protected int getPlayer1Points(){ return player1points;}

    /**
     * get the number of rounds that have been played for testing purpose
     */
    protected int getTies(){ return ties;}

    /**
     * Displays the toast message when the game is over.
     */
    protected void gameOverMessage() {
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
    protected void tie() {
        ties++;
        roundsPlayed++;
    }

    /**
     * Player 2 wins the match, update scores.
     */
    protected void player2Wins() {
        player1points = player1points - 3;
        player2RoundsWon++;
        roundsPlayed++;
    }

    /**
     * Player 1 wins the match, update scores.
     */
    protected void player1Wins() {
        player1points = player1points + 5;
        player1RoundsWon++;
        roundsPlayed++;
    }

    /**
     * Return whether the connect game is over, that is, if a player has won three rounds or
     * five rounds have been played without a player winning 3 rounds.
     *
     * @return whether the game is over.
     */
    protected boolean gameOver() {
        return (player1RoundsWon == 3 || player2RoundsWon == 3 || roundsPlayed == 5);
    }

    protected boolean matchOver(int size, Button[][] buttonsArray) {
        String[][] board = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = buttonsArray[i][j].getText().toString(); //go thru all buttons and set their XO text
            }
        }
        return (checkRows(board) || checkColumns(board) || checkAscendingDiagonals(board) || checkDescendingDiagonals(board));
    }

    /**
     * Update TextView with the scores of each player.
     */
    protected void updateRoundsWon() {
        scorePlayer1.setText("Player 1: " + player1RoundsWon);
        scorePlayer2.setText("Player 2: " + player2RoundsWon);
        draws.setText("Draws: " + ties);
    }

    /**
     * On click listener for the game reset button -> reset the game.
     * @param gameReset game reset button.
     */
    abstract void gameResetListener(Button gameReset);

    /**
     * On click listener for the reset match button -> make a new match.
     * @param buttonReset
     */
    abstract void buttonResetListener(Button buttonReset);

    /**
     * Activate the undo button.
     */
    abstract void addUndoButtonListener(Button undoButton);


    abstract boolean checkRows(String[][] board);
    abstract boolean checkColumns(String[][] board);
    abstract boolean checkAscendingDiagonals(String[][] board);
    abstract boolean checkDescendingDiagonals(String[][] board);

}

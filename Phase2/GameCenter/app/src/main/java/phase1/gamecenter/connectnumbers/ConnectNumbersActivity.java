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
    protected int opponentRoundsWon;

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
     *
     * @param round amount of rounds to be set
     */
    public void setPlayer1RoundsWon(int round) {
        this.player1RoundsWon = round;
    }

    /**
     * get the number of rounds player 1 has won only for testing purpose
     */
    public int getPlayer1RoundsWon() {
        return player1RoundsWon;
    }

    /**
     * set the number of rounds player 1 has won only for testing purpose
     *
     * @param round amount of rounds to be set
     */
    public void setOpponentRoundsWon(int round) {
        this.opponentRoundsWon = round;
    }

    /**
     * get the number of rounds player 1 has won only for testing purpose
     */
    public int getOpponentRoundsWon() {
        return opponentRoundsWon;
    }

    /**
     * set the number of rounds that have been played for testing purpose
     *
     * @param round amount of rounds to be set
     */
    public void setRoundsPlayed(int round) {
        this.roundsPlayed = round;
    }

    /**
     * get the number of rounds that have been played for testing purpose
     */
    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    /**
     * get the number of rounds player 1 has won only for testing purpose
     */
    public int getPlayer1Points() {
        return player1points;
    }

    /**
     * get the number of rounds that have been played for testing purpose
     */
    public int getTies() {
        return ties;
    }

    /**
     * Tie in the game.
     */
    public void tie() {
        ties++;
        roundsPlayed++;
    }

    /**
     * Player 1 wins the match, update scores.
     */
    public void player1Wins() {
        player1points = player1points + 5;
        player1RoundsWon++;
        roundsPlayed++;
    }

    /**
     * Opponent wins the match, update scores.
     */
    public void opponentWins() {
        player1points = player1points - 3;
        opponentRoundsWon++;
        roundsPlayed++;
    }

    /**
     * Return whether the connect game is over, that is, if a player has won three rounds or
     * five rounds have been played without a player winning 3 rounds.
     *
     * @return whether the game is over.
     */
    public boolean gameOver() {
        return (player1RoundsWon == 3 || opponentRoundsWon == 3 || roundsPlayed == 5);
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
     * On click listener for the game reset button -> reset the game.
     *
     * @param gameReset game reset button.
     */
    abstract void gameResetListener(Button gameReset);

    /**
     * On click listener for the reset match button -> make a new match.
     *
     * @param buttonReset
     */
    abstract void buttonResetListener(Button buttonReset);

    /**
     * Activate the undo button.
     */
    abstract void addUndoButtonListener(Button undoButton);

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

    abstract void gameOverMessage();

    abstract void updateRoundsWon();

    abstract void undoMove();


}

package phase1.gamecenter.connectnumbers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

import phase1.gamecenter.R;
import phase1.gamecenter.ScoreBoardUpdater;

public class ConnectThreeAIHardMainActivity extends ConnectNumbersActivity implements View.OnClickListener {

    /**
     * 2D array of buttons, representing the connect three game board.
     */
    private Button[][] buttons = new Button[3][3];

    /**
     * TextView that shows the number of rounds the AI has won.
     */
    private TextView aiPlayer;

    /**
     * The number of turns that have been made on the connect three board, one turn represents when
     * either player 1 or the AI mark an empty spot on the connect three board with an "X" or "O".
     */
    private int turns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_three_ai);
        scorePlayer1 = findViewById(R.id.scorePlayer1);
        aiPlayer = findViewById(R.id.aiPlayer);
        draws = findViewById(R.id.draws);
        Button buttonReset = findViewById(R.id.button_reset);
        Button gameReset = findViewById(R.id.button_reset_game);
        Button undoButton = findViewById(R.id.undoButton);
        maxUndoTimes = 8;
        this.moveStack = new Stack<>();
        turns = 9;

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
        ///undo move using button
        addUndoButtonListener(undoButton);
    }

    /**
     * On click listener for the game reset button -> reset the game.
     *
     * @param gameReset game reset button.
     */
    protected void gameResetListener(Button gameReset) {
        gameReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        buttons[i][j].setText("");
                    }
                }
                moveStack = new Stack<>();
                turns = 9;
                maxUndoTimes = 8;
                moves = 0;
                player1Turn = true;
                roundsPlayed = 0;
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
     *
     * @param buttonReset match reset button
     */
    protected void buttonResetListener(Button buttonReset) {
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!gameOver()) {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            buttons[i][j].setText("");
                        }
                    }
                    moveStack = new Stack<>();
                    turns = 9;
                    maxUndoTimes = 8;
                    moves = 0;
                    player1Turn = true;
                } else {
                    if (player1RoundsWon == 3) {
                        Toast.makeText(getApplicationContext(), "Game Over. Player 1 wins! Please start a new game.", Toast.LENGTH_LONG).show();
                    } else if (opponentRoundsWon == 3) {
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
     * Activate the undo button.
     */
    protected void addUndoButtonListener(Button undoButton) {
        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidUndo()) {
                    undoMove();
                    Toast.makeText(getApplicationContext(), "Successful undo!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Match over - invalid undo!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    /**
     * Process the move of the current player.
     *
     * @param v The button pressed by the current player.
     */
    private void processMove(Button v) {
        // if button already has been played, don't do anything
        if (((Button) v).getText().toString().equals("")) {
            ((Button) v).setText("X"); // human move
            this.moveStack.push(v.getId());
            turns--;
            if (matchOver(3, buttons)) {
                if (player1Turn) {
                    player1Wins();
                    Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_LONG).show();
                    updateRoundsWon();
                }
            } else {
                player1Turn = false;
                if (moves < 4) {
                    Button button = findViewById(findBestMove()); // AI's turn
                    button.setText("O");
                    this.moveStack.push(button.getId());
                    turns--;
                    if (matchOver(3, buttons)) {
                        if (!player1Turn) {
                            opponentWins();
                            Toast.makeText(this, "AI wins!", Toast.LENGTH_LONG).show();
                            updateRoundsWon();
                        }
                    }
                }
            }
        }
        moves++;
        if (moves == 5) {
            tie();
            Toast.makeText(this, "Tied!", Toast.LENGTH_LONG).show();
            updateRoundsWon();
        } else {
            player1Turn = true;
        }
    }

    /**
     * Player 1 wins the match, update scores.
     */
    public void player1Wins() {
        player1points = player1points + 20;
        player1RoundsWon++;
        roundsPlayed++;
    }

    /**
     * Opponent wins the match, update scores.
     */
    public void opponentWins() {
        player1points = player1points - 2;
        opponentRoundsWon++;
        roundsPlayed++;
    }

    /**
     * Displays the toast message when the game is over.
     */
    protected void gameOverMessage() {
        if (player1RoundsWon == 3) {
            updateLeaderBoard();
            updateScoreboard();
            Toast.makeText(this, "Game Over. Player 1 wins! Please start a new game.", Toast.LENGTH_LONG).show();
        } else if (opponentRoundsWon == 3) {
            Toast.makeText(this, "Game Over. AI wins! Please start a new game.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Game Over. TIE! Please start a new game.", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Update TextView with the scores of each player.
     */
    protected void updateRoundsWon() {
        scorePlayer1.setText("Player 1: " + player1RoundsWon);
        aiPlayer.setText("AI: " + opponentRoundsWon);
        draws.setText("Draws: " + ties);
    }

    /**
     * returns if undo is valid
     *
     * @return if undo is valid
     */

    public boolean isValidUndo() {
        return (maxUndoTimes > 0 && !matchOver(3, buttons));
    }

    /**
     * undo the most recent move if the max undo times has not been reached
     */
    protected void undoMove() {
        if (!matchOver(3, buttons) || turns < 5) {
            if (moveStack.size() > 0) {
                int id = this.moveStack.pop();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (buttons[i][j].getId() == id) {
                            buttons[i][j].setText("");
                            buttons[i][j].setBackgroundResource(R.drawable.circle_button);
                            turns++;
                        }
                    }
                }
                int id2 = this.moveStack.pop();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (buttons[i][j].getId() == id2) {
                            buttons[i][j].setText("");
                            buttons[i][j].setBackgroundResource(R.drawable.circle_button);
                            turns++;
                        }
                    }
                }
                moves--;
                maxUndoTimes--;
            }
        }
    }

    /**
     * Return the best move bestMove for the AI to execute.
     */
    private int findBestMove() {
        int bestMove = -1; // will be the resource id of the best button to play
        int best = -1000;

        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = buttons[i][j].getText().toString();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("")) {
                    board[i][j] = "O"; // only ever evaluate for AI player2
                    turns--;
                    int currentValue = minimax(board, 0, false);
                    turns--;
                    board[i][j] = "";
                    if (currentValue > best) {
                        best = currentValue;
                        String buttonID = "button_" + i + j;
                        bestMove = getResources().getIdentifier(buttonID, "id", getPackageName());
                    }
                }
            }
        }
        return bestMove;
    }

    public boolean movesLeft(String[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j].equals(""))
                    return true;
        return false;
    }

    /**
     * Return the best value bestValue using a minimax algorithm.
     */
    private int minimax(String[][] board, int depth, boolean isMax) {
        int score = evaluateBoard(board);

        if (score == 10) {
            return score - depth;
        } else if (score == -10) {
            return score + depth;
        } else if (!movesLeft(board)) {
            return 0;
        }

        if (isMax) {
            int bestValue = -1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals("")) {
                        board[i][j] = "O";
                        turns--;
                        bestValue = Math.max(bestValue, minimax(board, depth + 1, false));
                        turns++;
                        board[i][j] = "";
                    }
                }
            }
            return bestValue;
        } else {
            int bestValue = 1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals("")) {
                        board[i][j] = "X";
                        turns--;
                        bestValue = Math.min(bestValue, minimax(board, depth + 1, true));
                        turns++;
                        board[i][j] = "";
                    }
                }
            }
            return bestValue;
        }
    }

    /**
     * Evaluates the current connect three board to see if the game is over and returns the value.
     */
    public int evaluateBoard(String[][] board) {
        // check whether or not there is 3 in a row
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) &&
                    !board[i][0].equals("")) {
                if (board[i][0].equals("O")) {
                    return +10;
                } else if (board[i][0].equals("X")) {
                    return -10;
                }
            }
        }
        // check whether or not there is 3 in a column
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) &&
                    !board[0][i].equals("")) {
                if (board[0][i].equals("O")) {
                    return +10;
                } else if (board[0][i].equals("X")) {
                    return -10;
                }
            }
        }

        // check whether or not there is 3 in an ascending diagonal pattern
        if (board[0][2].equals(board[1][1]) &&
                board[0][2].equals(board[2][0]) &&
                !board[0][2].equals("")) {
            if (board[0][2].equals("O")) {
                return +10;
            } else if (board[0][2].equals("X")) {
                return -10;
            }
        }

        // check whether or not there is 3 in an descending diagonal pattern
        if (board[0][0].equals(board[1][1]) &&
                board[0][0].equals(board[2][2]) &&
                !board[0][0].equals("")) {
            if (board[0][0].equals("O")) {
                return +10;
            } else if (board[0][0].equals("X")) {
                return -10;
            }
        }
        return 0;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ConnectThreeAIHardMainActivity.this, ConnectNumbersStartingActivity.class);
        startActivity(intent);
    }

    /**
     * update user's scoreboard on firebase
     */
    private void updateScoreboard() {
        ScoreBoardUpdater sbu = new ScoreBoardUpdater(player1points, "Connect 34");
        sbu.updateUserScoreBoard();
    }

    /**
     * update scoreboard for leaderboard on firebase
     */
    private void updateLeaderBoard() {
        ScoreBoardUpdater sbu = new ScoreBoardUpdater(player1points, "Connect 34");
        sbu.updateLeaderBoard();
    }


}


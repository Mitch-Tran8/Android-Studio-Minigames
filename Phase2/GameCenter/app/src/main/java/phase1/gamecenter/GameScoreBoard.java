package phase1.gamecenter;

import java.util.ArrayList;

import android.support.v7.app.AppCompatActivity;

import phase1.gamecenter.slidingtiles.SlidingTileBoardManager;

/**
 * The scoreboard for a specific game,holds the top 5 scores and corresponding users for the
 * specific game.
 */
public class GameScoreBoard extends AppCompatActivity {

    /**
     * The userName of the current player of the game.
     */
    private String userName;

    /**
     * The score that user userName scored for the game.
     */
    private Integer gameScore;

    /**
     * The game ScoreBoard - stores the top5 scores in an ArrayList.
     */
    private ArrayList<Object> gameScoreBoard;

    public SlidingTileBoardManager slidingTileBoardManager;

    public User user;

    ArrayList<User> userScores;

    /**
     * The game scoreboard.
     */
    public GameScoreBoard(ArrayList<User> userScores) {
        this.userScores = userScores;
//        this.userName = user.getName();
    }

    /**
     *Update the game scoreboard.
     */
//    public void updateScoreBoard(){
//        if(gameScoreBoard.size() <= 10){
//            gameScoreBoard.add(userName);
//            gameScoreBoard.add(gameScore);
//            }
//        else {
//            int oddInteger=1;
//            while((Integer) gameScoreBoard.get(oddInteger) >= gameScore && oddInteger <= 9){
//                oddInteger+=2;
//            }
//            gameScoreBoard.add(oddInteger - 1, userName);
//            gameScoreBoard.add(oddInteger, gameScore);
//            gameScoreBoard.remove(11);
//            gameScoreBoard.remove(10);
//        }
//        }

    /**
     * Clear all the scores in gameScoreBoard.
     */
    public void clearScoreBoard() {
        this.gameScoreBoard.clear();
    }

    /**
     * Return the game scoreboard.
     *
     * @return the gameScoreBoard
     */
    public ArrayList<Object> getScoreBoard() {
        return this.gameScoreBoard;
    }

}
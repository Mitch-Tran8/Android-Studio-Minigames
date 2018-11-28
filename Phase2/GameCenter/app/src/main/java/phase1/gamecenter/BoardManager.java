package phase1.gamecenter;

import java.util.Stack;

/**
 * a board manager. the abstract boardmanager to SlidingTileBoardManager and ColourBoardManager.
 */
public abstract class BoardManager {

    /**
     * Score of the slidingTilesBoard.
     */
    private int score;


    /**
     * The number of moves that has been made to this slidingTilesBoard
     */
    protected int numOfMoves;

    /**
     * The stack that stocks all previous moves
     */
    private Stack<int[]> moveStack;

    /**
     * complexity of the slidingTilesBoard
     */
    private String complexity;


    /**
     * the max times for the user to undo their moves, which can be manually modified by user.
     * otherwise is set as 3 by default
     */
    protected int maxUndoTimes;

    /**
     * whether the moves can be undone - whether the maxUndoTimes has been reached
     */
    private boolean isValidUndo;

    /**
     * The columns of the slidingTilesBoard, the slidingTilesBoard manager is managing
     */
    private int columns;

    /**
     * the times the user has used the undo function
     */
    private int undoneTimes;

    /**
     * The rows of the slidingTilesBoard, the slidingTilesBoard manager is managing
     */
    private int rows;


    /**
     * Manage a slidingTilesBoard that has been pre-populated.
     *
     */
    public BoardManager() {
        undoneTimes = 0;
    }
}

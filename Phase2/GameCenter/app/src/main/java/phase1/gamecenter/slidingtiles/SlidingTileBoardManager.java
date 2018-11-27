package phase1.gamecenter.slidingtiles;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import phase1.gamecenter.BoardComplexity;
import phase1.gamecenter.BoardManager;
import phase1.gamecenter.ScoreBoardUpdater;


/**
 * Manage a slidingTilesBoard, including swapping tiles, checking for a win, and managing taps.
 */
public class SlidingTileBoardManager extends BoardManager implements Serializable {

    /**
     * The slidingTilesBoard being managed.
     */
    private SlidingTilesBoard slidingTilesBoard;

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
     * the times the user has used the undo function
     */
    private int undoneTimes;

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
     * The rows of the slidingTilesBoard, the slidingTilesBoard manager is managing
     */
    private int rows;


    /**
     * Manage a slidingTilesBoard that has been pre-populated.
     *
     */
    public SlidingTileBoardManager(SlidingTilesBoard slidingTilesBoard, int score) {
        this.slidingTilesBoard = slidingTilesBoard;
        this.score = score;
        undoneTimes = 0;
        maxUndoTimes = 3;
        isValidUndo = true;
    }

    /**
     * Manage a new shuffled slidingTilesBoard.
     */
    public SlidingTileBoardManager(int row, int col) {
        SlidingTilesBoard.NUM_COLS = col;
        SlidingTilesBoard.NUM_ROWS = row;
        columns = col;
        rows = row;

        if (SlidingTilesBoard.NUM_COLS == 3) {
            setComplexity("3x3");
        }
        if (SlidingTilesBoard.NUM_COLS == 4) {
            setComplexity("4x4");
        }

        if (SlidingTilesBoard.NUM_COLS == 5) {
            setComplexity("5x5");

        }
        List<NumberTile> numberTiles = new ArrayList<>();
        this.moveStack = new Stack<>();

        undoneTimes = 0;
        maxUndoTimes = 3;
        isValidUndo = true;

        final int numTiles = SlidingTilesBoard.NUM_COLS * SlidingTilesBoard.NUM_ROWS;
        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
            numberTiles.add(new NumberTile(tileNum, getComplexity()));
        }

        Collections.shuffle(numberTiles);

        while (!(solvableBoard(numberTiles, SlidingTilesBoard.NUM_ROWS))) { //while slidingTilesBoard is not solvable, keep shuffling the numberTiles
            Collections.shuffle(numberTiles);
        }
        this.slidingTilesBoard = new SlidingTilesBoard(numberTiles);
    }

    /**
     * Returns whether or not the ColourBoard is solvable
     *
     * @return whether the slidingTilesBoard is solvable or not
     */
    public boolean solvableBoard(List<NumberTile> numberTiles, int boardRows) {
        int inversions = countInversions(numberTiles);
        int blankTileRow = getBlankTileRow(numberTiles);

        if (boardRows % 2 == 1) {
            if (inversions % 2 == 0) { //odd slidingTilesBoard + even inversions
                return true;
            }
        }

        if (boardRows % 2 == 0) { //even slidingTilesBoard
            if (inversions % 2 == 1 && blankTileRow % 2 == 0) { //odd inversions + even BT row
                return true;
            }

            if (inversions % 2 == 0 && blankTileRow % 2 == 1) { //even inversions + odd BT row
                return true;
            }
        }

        return false;
    }

    /**
     * set numOfMoves
     */
    public void setNumOfMoves(int num){
        this.numOfMoves = num;
    }

    /**
     * get maxUndoTimes
     */
    public int getMaxUndoTimes(){
        return this.maxUndoTimes;
    }

    /**
     * set complexity
     *
     * @param complex the complexity of the game
     */
    public void setComplexity(String complex) {
        this.complexity = complex;
    }

    /**
     * get the complexity
     *
     * @return Complexity
     */
    public String getComplexity() {
        return complexity;
    }

    /**
     * Return the current slidingTilesBoard.
     */
    public SlidingTilesBoard getSlidingTilesBoard() {
        return slidingTilesBoard;
    }


    /**
     * Returns the number of inversion in the slidingTilesBoard's numberTiles
     *
     * @param numberTiles the numberTiles of the slidingTilesBoard
     * @return number of inversions in the slidingTilesBoard's numberTiles
     */
    public int countInversions(List<NumberTile> numberTiles) {
        int inversions = 0;

        ArrayList<Integer> tilesValues = getTilesValues(numberTiles);

        for (int i = 0; i <= tilesValues.size() - 1; i++) {
            for (int j = i + 1; j <= tilesValues.size() - 1; j++) {
                if (tilesValues.get(i) > tilesValues.get(j)) {
                    inversions++;
                }
            }
        }

        return inversions;
    }

    /**
     * Return an arraylist of the integer values of the slidingTilesBoard's numberTiles in order
     *
     * @param numberTiles List of numberTiles that slidingTilesBoard will be populated with
     * @return arraylist of the integer values of the numberTiles in order
     */
    public ArrayList<Integer> getTilesValues(List<NumberTile> numberTiles) { //UNITTEST OKAY!

        ArrayList<Integer> tilesValues = new ArrayList<>();

        //---create arraylist with integer values of slidingTilesBoard's numberTiles in order, while skipping the blank tile

        if (numberTiles.size() == 9) {  //3x3 slidingTilesBoard, blank tile has id = 9
            for (NumberTile x : numberTiles) {
                if (x.getId() != 9) {
                    tilesValues.add(x.getId());
                }
            }
        }

        if (numberTiles.size() == 16) { //4x4 slidingTilesBoard
            for (NumberTile x : numberTiles) {
                if (x.getId() != 16) {
                    tilesValues.add(x.getId());
                }
            }
        }

        if (numberTiles.size() == 25) { //5x5 slidingTilesBoard
            for (NumberTile x : numberTiles) {
                if (x.getId() != 25) {
                    tilesValues.add(x.getId());
                }
            }
        }

        return tilesValues;

    }

    /**
     * Return the row of the blank tile in the slidingTilesBoard counting from the bottom of the slidingTilesBoard
     *
     * @return the row of the blank tile in the slidingTilesBoard
     */
    public int getBlankTileRow(List<NumberTile> numberTiles) { //UNIT TEST OKAY CONFIRMED
        int blankTileIndex = indexBlankTile(numberTiles);

        if (numberTiles.size() == 9) {
            if (blankTileIndex >= 6) {
                return 1;
            } else if (blankTileIndex >= 3) {
                return 2;
            } else {
                return 3;
            }
        }

        if (numberTiles.size() == 16) {
            if (blankTileIndex >= 12) {
                return 1;
            } else if (blankTileIndex >= 8) {
                return 2;
            } else if (blankTileIndex >= 4) {
                return 3;
            } else {
                return 4;
            }
        }

        if (numberTiles.size() == 25) {
            if (blankTileIndex >= 20) {
                return 1;
            } else if (blankTileIndex >= 15) {
                return 2;
            } else if (blankTileIndex >= 10) {
                return 3;
            } else if (blankTileIndex >= 5) {
                return 4;
            } else {
                return 5;
            }
        }
        return 0; //never will be this case...
    }

    public int indexBlankTile(List<NumberTile> numberTiles) { //UNIT TEST CONFIRMED WORKS OKAY
        int blankTileIndex;
        int i = 0;

        if (numberTiles.size() == 9) {
            while (i <= numberTiles.size() - 1 && numberTiles.get(i).getId() != 9) {
                i++;
            }
        }

        if (numberTiles.size() == 16) {
            while (i <= numberTiles.size() - 1 && numberTiles.get(i).getId() != 16) {
                i++;
            }
        }

        if (numberTiles.size() == 25) {
            while (i <= numberTiles.size() - 1 && numberTiles.get(i).getId() != 25) {
                i++;
            }
        }
        blankTileIndex = i;
        return blankTileIndex;
    }

    /**
     * returns the number of columns the slidingTilesBoard manager is managing
     * @return number of columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * returns the number of rows the slidingTilesBoard manager is managing
     * @return number of rows
     */
    public int getRows(){return rows;}

    /**
     * returns the number of moves made
     *
     * @return the number of moves made
     */

    public int getNumOfMoves() {
        return numOfMoves;
    }

    /**
     * Return whether the tiles are in row-major order.
     *
     * @return whether the tiles are in row-major order
     */
    public boolean puzzleSolved() {
        boolean solved = true;
        int lastId = 1;

        for (NumberTile numberTile : slidingTilesBoard) {
            if (numberTile.getId() == lastId) {
                lastId++;
            } else {
                solved = false;
            }
        }
        if (solved) {
            updateScore(solved);
            updateScoreboard();
            updateLeadeBoard();
        }
        return solved;
    }

    /**
     * update current score
     */
    public void updateScore(boolean solved) {
        if (SlidingTilesBoard.NUM_COLS == 3 && solved) {
            score = 50 - numOfMoves;
        } else if (SlidingTilesBoard.NUM_COLS == 4 && solved) {
            score = 150 - numOfMoves;
        } else if (SlidingTilesBoard.NUM_COLS == 5 && solved) {
            score = 250 - numOfMoves;
        }
    }

    /**
     * update scoreboard for the user for sliding tiles
     */

    private void updateScoreboard() {
        ScoreBoardUpdater sbu = new ScoreBoardUpdater(getScore(), "Sliding tiles");
        sbu.updateUserScoreBoard();
    }

    /**
     * update scoreboard for leaderboard of sliding tiles
     *
     */
    private void updateLeadeBoard(){
        ScoreBoardUpdater sbu = new ScoreBoardUpdater(getScore(), "Sliding tiles");
        sbu.updateLeaderBoard();
    }

    /*
     * creates a new file
     */
    private void createNewFile() throws IOException {
        File file = new File(BoardComplexity.TEMP_SAVE_FILENAME);
        file.createNewFile();
    }

    /**
     * Get the score of the slidingTilesBoard
     *
     * @return the score of the slidingTilesBoard
     */
    public int getScore() {
        return score;
    }

    /**
     * Return whether any of the four surrounding tiles is the blank tile.
     *
     * @param position the tile to check
     * @return whether the tile at position is surrounded by a blank tile
     */
    public boolean isValidTap(int position) {

        int row = position / SlidingTilesBoard.NUM_ROWS;
        int col = position % SlidingTilesBoard.NUM_COLS;
        int blankId = slidingTilesBoard.numTiles();

        NumberTile blank = slidingTilesBoard.getTile(getBlankTile(row, col, blankId)[0], getBlankTile(row, col, blankId)[1]);
        return (blank.getId() == blankId && blank != slidingTilesBoard.getTile(row, col));
    }

    /**
     * returns if undo is valid
     *
     * @return if undo is valid
     */

    public boolean isValidUndo() {
        if (maxUndoTimes == 0) {
            return false;
        }
        return isValidUndo;
    }

    /**
     * undo the most recent move if the max undo times has not been reached
     */
    void undo() {
        int[] prevMove = this.moveStack.pop();

        if (isValidUndo && (prevMove[0] + prevMove[1] + prevMove[2] + prevMove[3] != 0)) {
            this.slidingTilesBoard.swapTiles(prevMove[0], prevMove[1], prevMove[2],
                    prevMove[3]);
            undoneTimes++;
            if (undoneTimes == maxUndoTimes) {
                isValidUndo = false;
            }
        }
    }

    /**
     * sets the maximum undo times
     */
    public void setMaxUndoTimes(int times) {
        maxUndoTimes = times;
    }

    /**
     * Process a touch at position in the slidingTilesBoard, swapping tiles as appropriate.
     *
     * @param position the position
     */
    public void touchMove(int position) {

        int row = position / SlidingTilesBoard.NUM_ROWS;
        int col = position % SlidingTilesBoard.NUM_COLS;
        int blankId = slidingTilesBoard.numTiles();
        int[] blank = getBlankTile(row, col, blankId);

        int[] prevMove = {blank[0], blank[1], row, col};
        this.moveStack.push(prevMove);

        slidingTilesBoard.swapTiles(row, col, blank[0], blank[1]);
        numOfMoves++;

    }


    /**
     * returns the moveStack
     */
    Stack getMoveStack() {
        return this.moveStack;
    }


    /**
     * Helper function for touchMove, returns the row and column as an array of the blank tile
     * closest to the tile provided
     *
     * @param row     the row of tile provided
     * @param col     the column of the tile provided
     * @param blankId the id of the blank tile(known to be the largest id)
     * @return the row and column of the blank tile closest too the tile provided as an int[]
     */
    public int[] getBlankTile(int row, int col, int blankId) {

        int blankRow = row;
        int blankCol = col;

        if (row > 0 && slidingTilesBoard.getTile(row - 1, col).getId() == blankId) {
            blankRow--;
        } else if (row < SlidingTilesBoard.NUM_ROWS - 1 && slidingTilesBoard.getTile(row + 1, col).getId() == blankId) {
            blankRow++;
        }
        if (col < SlidingTilesBoard.NUM_COLS - 1 && slidingTilesBoard.getTile(row, col + 1).getId() == blankId) {
            blankCol++;
        } else if (col > 0 && slidingTilesBoard.getTile(row, col - 1).getId() == blankId) {
            blankCol--;
        }

        return new int[]{blankRow, blankCol};
    }
}
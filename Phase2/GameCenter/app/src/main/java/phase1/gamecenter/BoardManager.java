package phase1.gamecenter;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


/**
 * Manage a board, including swapping tiles, checking for a win, and managing taps.
 */
class BoardManager implements Serializable {

    /**
     * The board being managed.
     */
    private Board board;

    /**
     * Score of the board.
     */
    private int score;


    /**
     * The number of moves that has been made to this board
     */
    private int numOfMoves;

    /**
     * The stack that stocks all previous moves
     */
    private Stack<int[]> moveStack;

    /**
     * complexity of the board
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
    private int maxUndoTimes;

    /**
     * whether the moves can be undone - whether the maxUndoTimes has been reached
     */
    private boolean isValidUndo;

    static int NUM_ROWS;
    static int NUM_COLS;


    /**
     * Manage a board that has been pre-populated.
     *
     */
    BoardManager(){}
    public BoardManager(Board board, int score) {
        this.board = board;
        this.score = score;
        undoneTimes = 0;
        maxUndoTimes = 3;
        isValidUndo = true;
    }

    /**
     * set complexity
     *
     * @param complex the complexity of the game
     */
    private void setComplexity(String complex) {
        this.complexity = complex;
    }

    /**
     * get the complexity
     *
     * @return Complexity
     */
    private String getComplexity() {
        return complexity;
    }

    /**
     * Return the current board.
     */
    Board getBoard() {
        return board;
    }

    /**
     * Manage a new shuffled board.
     */
    BoardManager(int row, int col) {
        Board.NUM_COLS = col;
        Board.NUM_ROWS = row;

        if (Board.NUM_COLS == 3) {
            setComplexity("3x3");
        }
        if (Board.NUM_COLS == 4) {
            setComplexity("4x4");
        }

        if (Board.NUM_COLS == 5) {
            setComplexity("5x5");

        }
        List<Tile> tiles = new ArrayList<>();
        this.moveStack = new Stack<>();

        undoneTimes = 0;
        maxUndoTimes = 3;
        isValidUndo = true;

        final int numTiles = Board.NUM_COLS * Board.NUM_ROWS;
        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
            tiles.add(new Tile(tileNum, getComplexity()));
        }

        Collections.shuffle(tiles);

        while (!(solvableBoard(tiles, Board.NUM_ROWS))) { //while board is not solvable, keep shuffling the tiles
            Collections.shuffle(tiles);
        }
        this.board = new Board(tiles);
    }

    /**
     * Returns whether or not the ColourBoard is solvable
     *
     * @return whether the board is solvable or not
     */
    public boolean solvableBoard(List<Tile> tiles, int boardRows) {
        int inversions = countInversions(tiles);
        int blankTileRow = getBlankTileRow(tiles);

        if (boardRows % 2 == 1) {
            if (inversions % 2 == 0) { //odd board + even inversions
                return true;
            }
        }

        if (boardRows % 2 == 0) { //even board
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
     * Returns the number of inversion in the board's tiles
     *
     * @param tiles the tiles of the board
     * @return number of inversions in the board's tiles
     */
    public int countInversions(List<Tile> tiles) {
        int inversions = 0;

        ArrayList<Integer> tilesValues = getTilesValues(tiles);

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
     * Return an arraylist of the integer values of the board's tiles in order
     *
     * @param tiles List of tiles that board will be populated with
     * @return arraylist of the integer values of the tiles in order
     */
    public ArrayList<Integer> getTilesValues(List<Tile> tiles) { //UNITTEST OKAY!

        ArrayList<Integer> tilesValues = new ArrayList<>();

        //---create arraylist with integer values of board's tiles in order, while skipping the blank tile

        if (tiles.size() == 9) {  //3x3 board, blank tile has id = 9
            for (Tile x : tiles) {
                if (x.getId() != 9) {
                    tilesValues.add(x.getId());
                }
            }
        }

        if (tiles.size() == 16) { //4x4 board
            for (Tile x : tiles) {
                if (x.getId() != 16) {
                    tilesValues.add(x.getId());
                }
            }
        }

        if (tiles.size() == 25) { //5x5 board
            for (Tile x : tiles) {
                if (x.getId() != 25) {
                    tilesValues.add(x.getId());
                }
            }
        }

        return tilesValues;

    }

    /**
     * Return the row of the blank tile in the board counting from the bottom of the board
     *
     * @return the row of the blank tile in the board
     */
    public int getBlankTileRow(List<Tile> tiles) { //UNIT TEST OKAY CONFIRMED
        int blankTileIndex = indexBlankTile(tiles);

        if (tiles.size() == 9) {
            if (blankTileIndex >= 6) {
                return 1;
            } else if (blankTileIndex >= 3) {
                return 2;
            } else {
                return 3;
            }
        }

        if (tiles.size() == 16) {
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

        if (tiles.size() == 25) {
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

    public int indexBlankTile(List<Tile> tiles) { //UNIT TEST CONFIRMED WORKS OKAY
        int blankTileIndex;
        int i = 0;

        if (tiles.size() == 9) {
            while (i <= tiles.size() - 1 && tiles.get(i).getId() != 9) {
                i++;
            }
        }

        if (tiles.size() == 16) {
            while (i <= tiles.size() - 1 && tiles.get(i).getId() != 16) {
                i++;
            }
        }

        if (tiles.size() == 25) {
            while (i <= tiles.size() - 1 && tiles.get(i).getId() != 25) {
                i++;
            }
        }
        blankTileIndex = i;
        return blankTileIndex;
    }


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
    boolean puzzleSolved() {
        boolean solved = true;
        int lastId = 1;

        for (Tile tile : board) {
            if (tile.getId() == lastId) {
                lastId++;
            } else {
                solved = false;
            }
        }
        if (Board.NUM_COLS == 3 && solved) {
            score = 50 - numOfMoves;
        } else if (Board.NUM_COLS == 4 && solved) {
            score = 150 - numOfMoves;
        } else if (Board.NUM_COLS == 5 && solved) {
            score = 250 - numOfMoves;
        }

        if (solved) {
            try {
                createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return solved;
    }

    /*
     * creates a new file
     */
    private void createNewFile() throws IOException {
        File file = new File(BoardComplexity.TEMP_SAVE_FILENAME);
        file.createNewFile();
    }

    /**
     * Get the score of the board
     *
     * @return the score of the board
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
    boolean isValidTap(int position) {

        int row = position / Board.NUM_ROWS;
        int col = position % Board.NUM_COLS;
        int blankId = board.numTiles();

        Tile blank = board.getTile(getBlankTile(row, col, blankId)[0], getBlankTile(row, col, blankId)[1]);
        return (blank.getId() == blankId && blank != board.getTile(row, col));
    }

    /**
     * returns if undo is valid
     * @return if undo is valid
     */
    boolean isValidUndo() {
        if (maxUndoTimes == 0){
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
            this.board.swapTiles(prevMove[0], prevMove[1], prevMove[2],
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
    void setMaxUndoTimes(int times){
        maxUndoTimes = times;
    }

    /**
     * Process a touch at position in the board, swapping tiles as appropriate.
     *
     * @param position the position
     */
    void touchMove(int position) {

        int row = position / Board.NUM_ROWS;
        int col = position % Board.NUM_COLS;
        int blankId = board.numTiles();
        int[] blank = getBlankTile(row, col, blankId);

        int[] prevMove = {blank[0], blank[1], row, col};
        this.moveStack.push(prevMove);

        board.swapTiles(row, col, blank[0], blank[1]);
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
    private int[] getBlankTile(int row, int col, int blankId) {

        int blankRow = row;
        int blankCol = col;

        if (row > 0 && board.getTile(row - 1, col).getId() == blankId) {
            blankRow--;
        } else if (row < Board.NUM_ROWS - 1 && board.getTile(row + 1, col).getId() == blankId) {
            blankRow++;
        }
        if (col < Board.NUM_COLS - 1 && board.getTile(row, col + 1).getId() == blankId) {
            blankCol++;
        } else if (col > 0 && board.getTile(row, col - 1).getId() == blankId) {
            blankCol--;
        }

        return new int[]{blankRow, blankCol};
    }
}
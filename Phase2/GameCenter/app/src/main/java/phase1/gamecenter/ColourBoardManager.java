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
class ColourBoardManager implements Serializable {

    /**
     * The board being managed.
     */
    private ColourBoard board;

    /**
     * the score
     */
    private int score;

    /**
     * the number of moves taken
     */
    private int numOfMoves;

    /**
     * A temporary save file.
     */
    public static final String TEMP_SAVE_FILENAME = "save_file_tmp.ser";

    /**
     * The stack that stocks all previous moves
     */
    private Stack<int[]> moveStack;

    /**
     * the first tap
     */
    private int firstTap;

    /**
     * Manage a board that has been pre-populated.
     *
     * @param board the board
     */
    ColourBoardManager(ColourBoard board) {
        this.board = board;
    }

    /**
     * Return the current board.
     */
    ColourBoard getBoard() {
        return board;
    }

    /**
     * Manage a new shuffled board.
     */
    ColourBoardManager() {
        List<ColourTile> tiles = new ArrayList<>();
        final int numTiles = ColourBoard.NUM_ROWS * ColourBoard.NUM_COLS;
        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
            tiles.add(new ColourTile(tileNum));
        }

        Collections.shuffle(tiles);
        this.board = new ColourBoard(tiles);
        this.firstTap = 0;
    }

    /**
     * Return whether the tiles are in row-major order.
     *
     * @return whether the tiles are in row-major order
     */
    boolean puzzleSolved() {
        boolean solved = (rowSolved() || colSolved());

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
        File file = new File(TEMP_SAVE_FILENAME);
        file.createNewFile();
    }

    /**
     * Helper function to puzzleSolved, returns whether all tiles of each row are of the same colour
     * @return whether all tiles of each row are of the same colour
     */
    private boolean rowSolved(){
        int currRow = 0;
        int currCol = 1;
        int currBackground = board.getTiles()[0][0].getBackground();

        //checks whether all tiles in a row are in the same colour
        while (currRow < 4) {
            for (ColourTile tile : board.getTiles()[currRow]){
                if (tile.getBackground() != currBackground){
                    return false;
                }
            }
            currRow++;
            currBackground = board.getTiles()[currRow][currCol].getBackground();
        }
        score = 100-numOfMoves;
        return true;
    }

    /**
     * Helper function to puzzleSolved, returns whether all tiles of each column are of the same colour
     * @return whether all tiles of each column are of the same colour
     */
    private boolean colSolved(){
        int currRow = 1;
        int currCol = 0;
        int currBackground = board.getTiles()[0][0].getBackground();

        //checks whether all tiles in a column are in the same colour
        while(currCol < 4){
            while (currRow < 4){
                if (board.getTiles()[currRow][currCol].getBackground() != currBackground){
                    return false;
                }
                currRow++;
            }
            currCol++;
            currRow = 1;
            currBackground = board.getTiles()[currCol][0].getBackground();
        }
        return true;
    }

    /**
     * returns the score
     */
    int getScore(){
        return score;
    }

    /**
     * Return whether any of the four surrounding tiles is the blank tile.
     *
     * @return whether the tile at position is surrounded by a blank tile
     */
    boolean hasFirstTap() {
        return firstTap != 0;
    }

    /**
     * sets the first tap's position to position
     * @param position the position
     */
    void setFirstTap(int position){
        this.firstTap = position;
    }

    /**
     * Return whether any of the four surrounding tiles is the first tile.
     *
     * @param position the tile to check
     * @return whether the tile at position is next to the first tile
     */
    boolean isValidTap(int position) {

        int row = position / ColourBoard.NUM_ROWS;
        int col = position % ColourBoard.NUM_COLS;

        int firstTapRow = firstTap / ColourBoard.NUM_ROWS;
        int firstTapCol = firstTap % ColourBoard.NUM_COLS;

        if (row == firstTapRow && col == firstTapCol){
            return false;
        }
        else if (row == firstTapRow){
            if (col -firstTapCol == 1){
                return true;
            }
            else return firstTapCol - col == 1;
        }
        else if (firstTapCol == col){
            if (row - firstTapRow == 1){
                return true;
            }
            else return firstTapRow - row == 1;
        }
        return false;
    }

    /**
     * Process a touch at position in the board, swapping tiles as appropriate.
     *
     * @param position the position
     */
    void touchMove(int position) {

        int row = position / ColourBoard.NUM_ROWS;
        int col = position % ColourBoard.NUM_COLS;

        int firstTapRow = firstTap / ColourBoard.NUM_ROWS;
        int firstTapCol = firstTap % ColourBoard.NUM_COLS;

        board.swapTiles(row, col, firstTapRow, firstTapCol);
        numOfMoves++;
    }

}

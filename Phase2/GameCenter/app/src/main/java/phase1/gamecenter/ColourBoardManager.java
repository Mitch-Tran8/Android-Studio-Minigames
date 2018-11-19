package phase1.gamecenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manage a board, including swapping tiles, checking for a win, and managing taps.
 */
class ColourBoardManager implements Serializable {

    /**
     * The board being managed.
     */
    private ColourBoard board;

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
    }

    /**
     * Return whether the tiles are in row-major order.
     *
     * @return whether the tiles are in row-major order
     */
    boolean puzzleSolved() {
        boolean solved = true;
        int lastId = 1;

        for (ColourTile tile : board) {
            if (tile.getId() == lastId) {
                lastId++;
            } else {
                solved = false;
            }
        }
        return solved;
    }

    /**
     * Return whether any of the four surrounding tiles is the blank tile.
     *
     * @param position the tile to check
     * @return whether the tile at position is surrounded by a blank tile
     */
    boolean isValidTap(int position) {

        int row = position / ColourBoard.NUM_COLS;
        int col = position % ColourBoard.NUM_COLS;
        int blankId = board.numTiles();

        ColourTile blank = board.getTile(getBlankTile(row, col, blankId)[0], getBlankTile(row, col, blankId)[1]);
        return (blank.getId() == blankId && blank != board.getTile(row, col));
    }

    /**
     * Process a touch at position in the board, swapping tiles as appropriate.
     *
     * @param position the position
     */
    void touchMove(int position) {

        int row = position / ColourBoard.NUM_ROWS;
        int col = position % ColourBoard.NUM_COLS;
        int blankId = board.numTiles();
        int[] blank = getBlankTile(row, col, blankId);

        board.swapTiles(row, col, blank[0], blank[1]);
    }

    /**
     * Helper function for touchMove, returns the row and column as an array of the blank tile
     * closest too the tile provided
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
        } else if (row < ColourBoard.NUM_ROWS - 1 && board.getTile(row + 1, col).getId() == blankId) {
            blankRow++;
        }
        if (col < ColourBoard.NUM_COLS - 1 && board.getTile(row, col + 1).getId() == blankId) {
            blankCol++;
        } else if (col > 0 && board.getTile(row, col - 1).getId() == blankId) {
            blankCol--;
        }

        return new int[]{blankRow, blankCol};
    }

}

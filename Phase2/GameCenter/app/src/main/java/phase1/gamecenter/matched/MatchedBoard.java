package phase1.gamecenter.matched;

import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import phase1.gamecenter.interfaces.Board;

/**
 * The matched game board.
 */
public class MatchedBoard extends Observable implements Board {

    /**
     * The number of rows.
     */
    private int NUM_ROWS;

    /**
     * The number of rows.
     */
    private int NUM_COLS;

    /**
     * The tiles on the board in row-major order.
     */
    private MatchedTile[][] tiles;

    /**
     * A new board of tiles in row-major order.
     * Precondition: len(tiles) == NUM_ROWS * NUM_COLS
     *
     * @param tiles the tiles for the board
     */
    MatchedBoard(List<MatchedTile> tiles, int complexity) {
        NUM_ROWS = complexity;
        NUM_COLS = complexity;
        this.tiles = new MatchedTile[NUM_ROWS][NUM_COLS];
        Iterator<MatchedTile> iter = tiles.iterator();

        for (int row = 0; row != complexity; row++) {
            for (int col = 0; col != complexity; col++) {
                this.tiles[row][col] = iter.next();
            }
        }
    }

    /**
     * returns the NUM_ROWS
     *
     * @return the NUM_ROWS
     */
    int getNUM_ROWS() {
        return this.NUM_ROWS;
    }

    /**
     * returns the NUM_COLS
     *
     * @return NUM_COLS
     */
    int getNUM_COLS() {
        return this.NUM_COLS;
    }

    /**
     * Return the tile at (row, col)
     *
     * @param row the tile row
     * @param col the tile column
     * @return the tile at (row, col)
     */
    MatchedTile getTile(int row, int col) {
        return tiles[row][col];
    }

    /**
     * returns the tiles
     *
     * @return tiles
     */
    public MatchedTile[][] getTiles() {
        return tiles;
    }


    /*
     * sets the tile
     */
    void setTile(int row, int col, MatchedTile newTile) {
        this.tiles[row][col] = newTile;
        setChanged();
        notifyObservers();
    }

    /*
     * replace tiles in row with tiles in the row above
     */
    void replaceRow(int currRow, int thirdCol) {
        MatchedTile copy1 = tiles[currRow - 1][thirdCol];
        MatchedTile copy2 = tiles[currRow - 1][thirdCol - 1];
        MatchedTile copy3 = tiles[currRow - 1][thirdCol - 1];

        tiles[currRow][thirdCol] = copy1;
        tiles[currRow][thirdCol - 1] = copy2;
        tiles[currRow][thirdCol - 2] = copy3;
        setChanged();
        notifyObservers();
    }

    /**
     * Swap the tiles at (row1, col1) and (row2, col2)
     *
     * @param row1 the first tile row
     * @param col1 the first tile col
     * @param row2 the second tile row
     * @param col2 the second tile col
     */
    public void swapTiles(int row1, int col1, int row2, int col2) {

        MatchedTile tile1 = getTile(row1, col1);
        MatchedTile tile2 = getTile(row2, col2);

        tiles[row1][col1] = tile2;
        tiles[row2][col2] = tile1;

        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "MatchedBoard{" +
                "tiles=" + Arrays.toString(tiles) +
                '}';
    }

    @Override
    @NonNull
    public Iterator<MatchedTile> iterator() {
        return new BoardIterator();
    }

    /**
     * The matched game board iterator.
     * Subclass to the board class.
     */
    private class BoardIterator implements Iterator<MatchedTile> {

        int row = 0;
        private int nextColumn = 0;

        @Override
        public boolean hasNext() {
            return row < NUM_ROWS;
        }

        @Override
        public MatchedTile next() {
            if (!hasNext()) {
                return null;
            }

            MatchedTile current = getTile(row, nextColumn);

            if (nextColumn == NUM_COLS - 1) {
                row++;
                nextColumn = 0;
            } else {
                nextColumn++;
            }

            return current;
        }
    }
}

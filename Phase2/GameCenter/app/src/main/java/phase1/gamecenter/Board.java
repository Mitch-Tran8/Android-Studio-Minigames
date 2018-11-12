package phase1.gamecenter;

import android.support.annotation.NonNull;

import java.util.Observable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * The sliding tiles board.
 */
public class Board extends Observable implements Serializable, Iterable<Tile> {

    /**
     * The number of rows.
     */
    static int NUM_ROWS;

    /**
     * The number of rows.
     */
    static int NUM_COLS;

    /**
     * The tiles on the board in row-major order.
     */
    private Tile[][] tiles = new Tile[NUM_ROWS][NUM_COLS];


    /**
     * A new board of tiles in row-major order.
     * Precondition: len(tiles) == NUM_ROWS * NUM_COLS
     *
     * @param tiles the tiles for the board
     */
    Board(List<Tile> tiles) {
        Iterator<Tile> iter = tiles.iterator();

        for (int row = 0; row != Board.NUM_ROWS; row++) {
            for (int col = 0; col != Board.NUM_COLS; col++) {
                this.tiles[row][col] = iter.next();
            }
        }
    }

    /**
     * Return the number of tiles on the board.
     *
     * @return the number of tiles on the board
     */
    int numTiles() {
        return NUM_COLS * NUM_ROWS;
    }

    /**
     * Return the tile at (row, col)
     *
     * @param row the tile row
     * @param col the tile column
     * @return the tile at (row, col)
     */
    Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    /**
     * Swap the tiles at (row1, col1) and (row2, col2)
     *
     * @param row1 the first tile row
     * @param col1 the first tile col
     * @param row2 the second tile row
     * @param col2 the second tile col
     */
    void swapTiles(int row1, int col1, int row2, int col2) {

        Tile tile1 = getTile(row1, col1);
        Tile tile2 = getTile(row2, col2);

        tiles[row1][col1] = tile2;
        tiles[row2][col2] = tile1;

        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Board{" +
                "tiles=" + Arrays.toString(tiles) +
                '}';
    }

    @Override
    @NonNull
    public Iterator<Tile> iterator() {
        return new BoardIterator();
    }


    /**
     * The sliding tiles board iterator.
     * Subclass to the board class.
     */
    private class BoardIterator implements Iterator<Tile> {

        private int nextColumn = 0;
        int row = 0;

        @Override
        public boolean hasNext() {
            return row < NUM_ROWS;
        }

        @Override
        public Tile next() {
            if (!hasNext()) {
                return null;
            }

            Tile current = getTile(row, nextColumn);

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

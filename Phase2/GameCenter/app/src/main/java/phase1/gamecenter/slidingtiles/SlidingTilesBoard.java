package phase1.gamecenter.slidingtiles;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import phase1.gamecenter.Board;

/**
 * The sliding numberTiles board.
 */
public class SlidingTilesBoard extends Observable implements Board {

    /**
     * The number of rows.
     */
    static int NUM_ROWS = 3;

    /**
     * The number of rows.
     */
    static int NUM_COLS = 3;

    /**
     * The numberTiles on the board in row-major order.
     */
    private NumberTile[][] numberTiles = new NumberTile[NUM_ROWS][NUM_COLS];

    /**
     * A new board of numberTiles in row-major order.
     * Precondition: len(numberTiles) == NUM_ROWS * NUM_COLS
     *
     * @param numberTiles the numberTiles for the board
     */
    public SlidingTilesBoard(List<NumberTile> numberTiles) {
        super();
        Iterator<NumberTile> iter = numberTiles.iterator();

        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                this.numberTiles[row][col] = iter.next();
            }
        }
    }

    /**
     * Return the number of numberTiles on the board.
     *
     * @return the number of numberTiles on the board
     */
    public int numTiles() {
        return NUM_COLS * NUM_ROWS;
    }

    /**
     * Return the tile at (row, col)
     *
     * @param row the tile row
     * @param col the tile column
     * @return the tile at (row, col)
     */
    public NumberTile getTile(int row, int col) {
        return numberTiles[row][col];
    }

    /**
     * Swap the numberTiles at (row1, col1) and (row2, col2)
     *
     * @param row1 the first tile row
     * @param col1 the first tile col
     * @param row2 the second tile row
     * @param col2 the second tile col
     */
    public void swapTiles(int row1, int col1, int row2, int col2) {

        NumberTile numberTile1 = getTile(row1, col1);
        NumberTile numberTile2 = getTile(row2, col2);

        numberTiles[row1][col1] = numberTile2;
        numberTiles[row2][col2] = numberTile1;

        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "SlidingTilesBoard{" +
                "numberTiles=" + Arrays.toString(numberTiles) +
                '}';
    }

    @Override
    @NonNull
    public Iterator<NumberTile> iterator() {
        return new BoardIterator();
    }


    /**
     * The sliding numberTiles board iterator.
     * Subclass to the board class.
     */
    private class BoardIterator implements Iterator<NumberTile> {

        private int nextColumn = 0;
        int row = 0;

        @Override
        public boolean hasNext() {
            return row < NUM_ROWS;
        }

        @Override
        public NumberTile next() {
            if (!hasNext()) {
                return null;
            }

            NumberTile current = getTile(row, nextColumn);

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

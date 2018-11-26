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
public class ColourBoard extends Observable implements Serializable, Iterable<ColourTile> {


    public static final String up = "up";
    public static final String down = "down";
    public static final String left = "left";
    public static final String right = "right";

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
    private ColourTile[][] tiles;

    /**
     * A new board of tiles in row-major order.
     * Precondition: len(tiles) == NUM_ROWS * NUM_COLS
     *
     * @param tiles the tiles for the board
     */
    ColourBoard(List<ColourTile> tiles, int complexity) {
        NUM_ROWS = complexity;
        NUM_COLS = complexity;
        this.tiles = new ColourTile[NUM_ROWS][NUM_COLS];
        Iterator<ColourTile> iter = tiles.iterator();

        for (int row = 0; row != complexity; row++) {
            for (int col = 0; col != complexity; col++) {
                this.tiles[row][col] = iter.next();
            }
        }
    }

    int getNUM_ROWS(){
        return this.NUM_ROWS;
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
    ColourTile getTile(int row, int col) {
        return tiles[row][col];
    }

    /**
     * returns the tiles
     * @return tiles
     */
    ColourTile[][] getTiles() {
        return tiles;
    }

    /*
     * sets the tile
     */
    void setTile(int row, int col, ColourTile newTile){
        this.tiles[row][col] = newTile;
        setChanged();
        notifyObservers();
    }

    /*
     * replace tiles in row with tiles in the row above
     */
    void replaceRow(int currRow, int thirdCol){
        ColourTile copy1 = tiles[currRow - 1][thirdCol];
        ColourTile copy2 = tiles[currRow - 1][thirdCol-1];
        ColourTile copy3 = tiles[currRow - 1][thirdCol-1];

        tiles[currRow][thirdCol] = copy1;
        tiles[currRow][thirdCol-1] = copy2;
        tiles[currRow][thirdCol-2] = copy3;
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
    void swapTiles(int row1, int col1, int row2, int col2) {

        ColourTile tile1 = getTile(row1, col1);
        ColourTile tile2 = getTile(row2, col2);

        tiles[row1][col1] = tile2;
        tiles[row2][col2] = tile1;

        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "ColourBoard{" +
                "tiles=" + Arrays.toString(tiles) +
                '}';
    }

    @Override
    @NonNull
    public Iterator<ColourTile> iterator() {
        return new BoardIterator();
    }


    /**
     * The sliding tiles board iterator.
     * Subclass to the board class.
     */
    private class BoardIterator implements Iterator<ColourTile> {

        private int nextColumn = 0;
        int row = 0;

        @Override
        public boolean hasNext() {
            return row < NUM_ROWS;
        }

        @Override
        public ColourTile next() {
            if (!hasNext()) {
                return null;
            }

            ColourTile current = getTile(row, nextColumn);

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

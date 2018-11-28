package phase1.gamecenter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import phase1.gamecenter.slidingtiles.NumberTile;
import phase1.gamecenter.slidingtiles.SlidingTilesBoard;

import static org.junit.Assert.*;

public class SlidingTilesBoardTest {

    @Test
    public void numTiles() {
        List<NumberTile> numberTiles = new ArrayList<>();
        numberTiles.add(new NumberTile(1, 0));
        numberTiles.add(new NumberTile(2, 1));
        numberTiles.add(new NumberTile(3, 2));
        numberTiles.add(new NumberTile(4, 3));
        numberTiles.add(new NumberTile(5, 4));
        numberTiles.add(new NumberTile(6, 5));
        numberTiles.add(new NumberTile(7, 6));
        numberTiles.add(new NumberTile(8, 7));
        numberTiles.add(new NumberTile(9, 8));
        SlidingTilesBoard testerSlidingTilesBoard = new SlidingTilesBoard(numberTiles);
        assertEquals(9, testerSlidingTilesBoard.numTiles());
    }

    @Test
    public void getTile() {
        List<NumberTile> numberTiles = new ArrayList<>();
        numberTiles.add(new NumberTile(1, 0));
        numberTiles.add(new NumberTile(2, 1));
        numberTiles.add(new NumberTile(3, 2));
        numberTiles.add(new NumberTile(4, 3));
        numberTiles.add(new NumberTile(5, 4));
        numberTiles.add(new NumberTile(6, 5));
        numberTiles.add(new NumberTile(7, 6));
        numberTiles.add(new NumberTile(8, 7));
        numberTiles.add(new NumberTile(9, 8));

        NumberTile expectedNumberTile = new NumberTile(1, 0);
        SlidingTilesBoard testerSlidingTilesBoard = new SlidingTilesBoard(numberTiles);
        assertEquals(0, expectedNumberTile.compareTo(testerSlidingTilesBoard.getTile(0, 0)));
    }


    @Test
    public void testSwapTiles() {
        List<NumberTile> numberTiles = new ArrayList<>();
        numberTiles.add(new NumberTile(1, 0));
        numberTiles.add(new NumberTile(2, 1));
        numberTiles.add(new NumberTile(3, 2));
        numberTiles.add(new NumberTile(4, 3));
        numberTiles.add(new NumberTile(5, 4));
        numberTiles.add(new NumberTile(6, 5));
        numberTiles.add(new NumberTile(7, 6));
        numberTiles.add(new NumberTile(8, 7));
        numberTiles.add(new NumberTile(9, 8));

        SlidingTilesBoard testerSlidingTilesBoard = new SlidingTilesBoard(numberTiles);

        testerSlidingTilesBoard.swapTiles(0, 0, 0, 1);

        NumberTile expectedNumberTile1 = new NumberTile(2, 1);
        NumberTile expectedNumberTile2 = new NumberTile(1, 0);

        assertEquals(0, expectedNumberTile1.compareTo(testerSlidingTilesBoard.getTile(0, 0)));
        assertEquals(0, expectedNumberTile2.compareTo(testerSlidingTilesBoard.getTile(0, 1)));

    }

/*    @Test
    public void testToString() {
        List<NumberTile> tiles = new ArrayList<>();
        tiles.add(new NumberTile(1, 0));
        tiles.add(new NumberTile(2, 1));
        tiles.add(new NumberTile(3, 2));
        tiles.add(new NumberTile(4, 3));
        tiles.add(new NumberTile(5, 4));
        tiles.add(new NumberTile(6, 5));
        tiles.add(new NumberTile(7, 6));
        tiles.add(new NumberTile(8, 7));
        tiles.add(new NumberTile(9, 8));

        SlidingTilesBoard testerBoard = new SlidingTilesBoard(tiles);
        assertEquals(Arrays.toString(tiles) == testerBoard.toString());
    }*/
}
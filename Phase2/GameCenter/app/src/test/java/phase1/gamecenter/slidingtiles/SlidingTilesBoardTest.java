package phase1.gamecenter.slidingtiles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

    @Test
    public void testToString(){

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
        assertEquals("SlidingTilesBoard{" + "numberTiles=" +
                Arrays.toString(testerSlidingTilesBoard.getNumberTiles()) +'}',
                testerSlidingTilesBoard.toString() );
    }

    @Test
    public void testIterator(){

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

        Iterator<NumberTile> iter1 = numberTiles.iterator();
        assertTrue(iter1.hasNext());
        assertNotNull(iter1.next());
    }

    @Test
    public void getNumberTiles(){
        List<NumberTile> numberTiles = new ArrayList<>();
        NumberTile tile = new NumberTile(1, 0);
        numberTiles.add(tile);
        numberTiles.add(new NumberTile(2, 1));
        numberTiles.add(new NumberTile(3, 2));
        numberTiles.add(new NumberTile(4, 3));
        numberTiles.add(new NumberTile(5, 4));
        numberTiles.add(new NumberTile(6, 5));
        numberTiles.add(new NumberTile(7, 6));
        numberTiles.add(new NumberTile(8, 7));
        numberTiles.add(new NumberTile(9, 8));
        SlidingTilesBoard slidingTilesBoard = new SlidingTilesBoard(numberTiles);
        assertTrue(slidingTilesBoard.getNumberTiles()[0][0] == tile);

    }
}
package phase1.gamecenter.slidingtiles;


import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import phase1.gamecenter.slidingtiles.NumberTile;
import phase1.gamecenter.slidingtiles.SlidingTileBoardManager;
import phase1.gamecenter.slidingtiles.SlidingTilesBoard;


public class SlidingTilesBoardManagerUnitTest {

    @Test
    public void testSetComplexity() {
        List<NumberTile> numberTiles = new ArrayList<NumberTile>();
        numberTiles.add(new NumberTile(0, "3x3"));
        numberTiles.add(new NumberTile(1, "3x3"));
        numberTiles.add(new NumberTile(2, "3x3"));
        numberTiles.add(new NumberTile(3, "3x3"));
        numberTiles.add(new NumberTile(4, "3x3"));
        numberTiles.add(new NumberTile(5, "3x3"));
        numberTiles.add(new NumberTile(6, "3x3"));
        numberTiles.add(new NumberTile(7, "3x3"));
        numberTiles.add(new NumberTile(8, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard = new SlidingTilesBoard(numberTiles);
        SlidingTileBoardManager testerSlidingTileBoardManager = new SlidingTileBoardManager(testerSlidingTilesBoard, 70);
        testerSlidingTileBoardManager.setComplexity("3x3");
        assertEquals("3x3", testerSlidingTileBoardManager.getComplexity());
    }

    @Test
    public void testGetBoard() {
        List<NumberTile> numberTiles = new ArrayList<NumberTile>();
        numberTiles.add(new NumberTile(0, "3x3"));
        numberTiles.add(new NumberTile(1, "3x3"));
        numberTiles.add(new NumberTile(2, "3x3"));
        numberTiles.add(new NumberTile(3, "3x3"));
        numberTiles.add(new NumberTile(4, "3x3"));
        numberTiles.add(new NumberTile(5, "3x3"));
        numberTiles.add(new NumberTile(6, "3x3"));
        numberTiles.add(new NumberTile(7, "3x3"));
        numberTiles.add(new NumberTile(8, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard = new SlidingTilesBoard(numberTiles);
        SlidingTileBoardManager testerSlidingTileBoardManager = new SlidingTileBoardManager(testerSlidingTilesBoard, 70);
        assertEquals(true, testerSlidingTilesBoard.equals(testerSlidingTileBoardManager.getSlidingTilesBoard()));
    }

    @Test
    public void testGetColumnsRows() {
        List<NumberTile> numberTiles = new ArrayList<NumberTile>();
        numberTiles.add(new NumberTile(0, "3x3"));
        numberTiles.add(new NumberTile(1, "3x3"));
        numberTiles.add(new NumberTile(2, "3x3"));
        numberTiles.add(new NumberTile(3, "3x3"));
        numberTiles.add(new NumberTile(4, "3x3"));
        numberTiles.add(new NumberTile(5, "3x3"));
        numberTiles.add(new NumberTile(6, "3x3"));
        numberTiles.add(new NumberTile(7, "3x3"));
        numberTiles.add(new NumberTile(8, "3x3"));
        SlidingTileBoardManager testerSlidingTileBoardManager = new SlidingTileBoardManager(3, 3);
        testerSlidingTileBoardManager.setComplexity("3x3");
        assertEquals(3, testerSlidingTileBoardManager.getColumns());
        assertEquals(3, testerSlidingTileBoardManager.getRows());

    }

    @Test
    public void testNumOfMoves() {
        SlidingTileBoardManager testerSlidingTileBoardManager2 = new SlidingTileBoardManager(3, 3);
        testerSlidingTileBoardManager2.setNumOfMoves(3);
        assertEquals(3, testerSlidingTileBoardManager2.getNumOfMoves());
    }

    @Test
    public void testUpdateScore3x3() {
        List<NumberTile> numberTiles = new ArrayList<NumberTile>();
        numberTiles.add(new NumberTile(0, "3x3"));
        numberTiles.add(new NumberTile(1, "3x3"));
        numberTiles.add(new NumberTile(2, "3x3"));
        numberTiles.add(new NumberTile(3, "3x3"));
        numberTiles.add(new NumberTile(4, "3x3"));
        numberTiles.add(new NumberTile(5, "3x3"));
        numberTiles.add(new NumberTile(6, "3x3"));
        numberTiles.add(new NumberTile(7, "3x3"));
        numberTiles.add(new NumberTile(8, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard = new SlidingTilesBoard(numberTiles);
        SlidingTileBoardManager testerSlidingTileBoardManager = new SlidingTileBoardManager(testerSlidingTilesBoard, 39);
        testerSlidingTileBoardManager.updateScore(true);
        assertEquals(50, testerSlidingTileBoardManager.getScore());
    }

    @Test
    public void testUpdateScore4x4() {
        SlidingTileBoardManager testerSlidingTileBoardManager5X5 = new SlidingTileBoardManager(4,4);
        testerSlidingTileBoardManager5X5.updateScore(true);
        assertEquals(150, testerSlidingTileBoardManager5X5.getScore());
    }

    @Test
    public void testUpdateScore5x5() {
        SlidingTileBoardManager testerSlidingTileBoardManager5X5 = new SlidingTileBoardManager(5,5);
        testerSlidingTileBoardManager5X5.updateScore(true);
        assertEquals(250, testerSlidingTileBoardManager5X5.getScore());
    }

    @Test
    public void testIsValidTap() {
        List<NumberTile> numberTiles = new ArrayList<NumberTile>();
        numberTiles.add(new NumberTile(0, "3x3"));
        numberTiles.add(new NumberTile(1, "3x3"));
        numberTiles.add(new NumberTile(2, "3x3"));
        numberTiles.add(new NumberTile(3, "3x3"));
        numberTiles.add(new NumberTile(4, "3x3"));
        numberTiles.add(new NumberTile(5, "3x3"));
        numberTiles.add(new NumberTile(6, "3x3"));
        numberTiles.add(new NumberTile(7, "3x3"));
        numberTiles.add(new NumberTile(8, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard = new SlidingTilesBoard(numberTiles);
        SlidingTileBoardManager testerSlidingTileBoardManager = new SlidingTileBoardManager(testerSlidingTilesBoard, 39);
        assertFalse(testerSlidingTileBoardManager.isValidTap(3));
    }


    @Test
    public void testIsValidUndo() {
        List<NumberTile> numberTiles = new ArrayList<NumberTile>();
        numberTiles.add(new NumberTile(0, "3x3"));
        numberTiles.add(new NumberTile(1, "3x3"));
        numberTiles.add(new NumberTile(2, "3x3"));
        numberTiles.add(new NumberTile(3, "3x3"));
        numberTiles.add(new NumberTile(4, "3x3"));
        numberTiles.add(new NumberTile(5, "3x3"));
        numberTiles.add(new NumberTile(6, "3x3"));
        numberTiles.add(new NumberTile(7, "3x3"));
        numberTiles.add(new NumberTile(8, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard = new SlidingTilesBoard(numberTiles);
        SlidingTileBoardManager testerSlidingTileBoardManager = new SlidingTileBoardManager(testerSlidingTilesBoard, 39);
        assertTrue(testerSlidingTileBoardManager.isValidUndo());
    }

    @Test
    public void testSetMaxUndoTimes() {
        List<NumberTile> numberTiles = new ArrayList<NumberTile>();
        numberTiles.add(new NumberTile(0, "3x3"));
        numberTiles.add(new NumberTile(1, "3x3"));
        numberTiles.add(new NumberTile(2, "3x3"));
        numberTiles.add(new NumberTile(3, "3x3"));
        numberTiles.add(new NumberTile(4, "3x3"));
        numberTiles.add(new NumberTile(5, "3x3"));
        numberTiles.add(new NumberTile(6, "3x3"));
        numberTiles.add(new NumberTile(7, "3x3"));
        numberTiles.add(new NumberTile(8, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard = new SlidingTilesBoard(numberTiles);
        SlidingTileBoardManager testerSlidingTileBoardManager = new SlidingTileBoardManager(testerSlidingTilesBoard, 39);
        testerSlidingTileBoardManager.setMaxUndoTimes(10);
        assertEquals(10, testerSlidingTileBoardManager.getMaxUndoTimes());
    }

    @Test
    public void testGetBlankTile() {
        List<NumberTile> numberTiles = new ArrayList<NumberTile>();
        numberTiles.add(new NumberTile(0, "3x3"));
        numberTiles.add(new NumberTile(1, "3x3"));
        numberTiles.add(new NumberTile(2, "3x3"));
        numberTiles.add(new NumberTile(3, "3x3"));
        numberTiles.add(new NumberTile(4, "3x3"));
        numberTiles.add(new NumberTile(5, "3x3"));
        numberTiles.add(new NumberTile(6, "3x3"));
        numberTiles.add(new NumberTile(7, "3x3"));
        numberTiles.add(new NumberTile(8, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard = new SlidingTilesBoard(numberTiles);
        SlidingTileBoardManager testerSlidingTileBoardManager = new SlidingTileBoardManager(testerSlidingTilesBoard, 39);
        int blankTileRow = testerSlidingTileBoardManager.getBlankTileRow(numberTiles);
        assertEquals(blankTileRow, testerSlidingTileBoardManager.getBlankTile(1, 1, 9)[0]);
    }

}

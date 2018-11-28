package phase1.gamecenter;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import phase1.gamecenter.slidingtiles.NumberTile;
import phase1.gamecenter.slidingtiles.SlidingTileBoardManager;
import phase1.gamecenter.slidingtiles.SlidingTilesBoard;


public class SolvableSlidingTilesBoardUnitTest {

    //------indexBlankTile() tests------
    @Test
    public void testIndexBlankTileLastTile() {
        List<NumberTile> tiles3x3 = new ArrayList<>();
        tiles3x3.add(new NumberTile(0, "3x3"));
        tiles3x3.add(new NumberTile(1, "3x3"));
        tiles3x3.add(new NumberTile(2, "3x3"));
        tiles3x3.add(new NumberTile(3, "3x3"));
        tiles3x3.add(new NumberTile(4, "3x3"));
        tiles3x3.add(new NumberTile(5, "3x3"));
        tiles3x3.add(new NumberTile(6, "3x3"));
        tiles3x3.add(new NumberTile(7, "3x3"));
        tiles3x3.add(new NumberTile(8, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard3X3 = new SlidingTilesBoard(tiles3x3);
        SlidingTileBoardManager testerSlidingTileBoardManager3X3 = new SlidingTileBoardManager(testerSlidingTilesBoard3X3, 100);

        assertEquals(8, testerSlidingTileBoardManager3X3.indexBlankTile(tiles3x3));
    }

    @Test
    public void testIndexBlankTileFirstTile() {
        List<NumberTile> tiles3x3 = new ArrayList<>();
        tiles3x3.add(new NumberTile(8, "3x3"));
        tiles3x3.add(new NumberTile(0, "3x3"));
        tiles3x3.add(new NumberTile(1, "3x3"));
        tiles3x3.add(new NumberTile(2, "3x3"));
        tiles3x3.add(new NumberTile(3, "3x3"));
        tiles3x3.add(new NumberTile(4, "3x3"));
        tiles3x3.add(new NumberTile(5, "3x3"));
        tiles3x3.add(new NumberTile(6, "3x3"));
        tiles3x3.add(new NumberTile(7, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard3X3 = new SlidingTilesBoard(tiles3x3);
        SlidingTileBoardManager testerSlidingTileBoardManager3X3 = new SlidingTileBoardManager(testerSlidingTilesBoard3X3, 100);
        assertEquals(0, testerSlidingTileBoardManager3X3.indexBlankTile(tiles3x3));
    }

    @Test
    public void testIndexBlankTileMiddleTile3x3() {
        List<NumberTile> tiles3x3 = new ArrayList<>();
        tiles3x3.add(new NumberTile(0, "3x3"));
        tiles3x3.add(new NumberTile(1, "3x3"));
        tiles3x3.add(new NumberTile(2, "3x3"));
        tiles3x3.add(new NumberTile(3, "3x3"));
        tiles3x3.add(new NumberTile(8, "3x3"));
        tiles3x3.add(new NumberTile(4, "3x3"));
        tiles3x3.add(new NumberTile(5, "3x3"));
        tiles3x3.add(new NumberTile(6, "3x3"));
        tiles3x3.add(new NumberTile(7, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard3X3 = new SlidingTilesBoard(tiles3x3);
        SlidingTileBoardManager testerSlidingTileBoardManager3X3 = new SlidingTileBoardManager(testerSlidingTilesBoard3X3, 100);
        assertEquals(4, testerSlidingTileBoardManager3X3.indexBlankTile(tiles3x3));
    }

    @Test
    public void testIndexBlankTileMiddleTile4x4() {
        List<NumberTile> tiles4x4 = new ArrayList<>();
        tiles4x4.add(new NumberTile(0, "4x4"));
        tiles4x4.add(new NumberTile(1, "4x4"));
        tiles4x4.add(new NumberTile(2, "4x4"));
        tiles4x4.add(new NumberTile(3, "4x4"));
        tiles4x4.add(new NumberTile(4, "4x4"));
        tiles4x4.add(new NumberTile(5, "4x4"));
        tiles4x4.add(new NumberTile(6, "4x4"));
        tiles4x4.add(new NumberTile(7, "4x4"));
        tiles4x4.add(new NumberTile(8, "4x4"));
        tiles4x4.add(new NumberTile(9, "4x4"));
        tiles4x4.add(new NumberTile(10, "4x4"));
        tiles4x4.add(new NumberTile(11, "4x4"));
        tiles4x4.add(new NumberTile(15, "4x4"));
        tiles4x4.add(new NumberTile(12, "4x4"));
        tiles4x4.add(new NumberTile(13, "4x4"));
        tiles4x4.add(new NumberTile(14, "4x4"));
        SlidingTilesBoard testerSlidingTilesBoard4X4 = new SlidingTilesBoard(tiles4x4);
        SlidingTileBoardManager testerSlidingTileBoardManager4X4 = new SlidingTileBoardManager(testerSlidingTilesBoard4X4, 67);

        assertEquals(12, testerSlidingTileBoardManager4X4.indexBlankTile(tiles4x4));
    }

    @Test
    public void testIndexBlankTileMiddleTile5x5() {
        List<NumberTile> tiles5x5 = new ArrayList<>();
        tiles5x5.add(new NumberTile(0, "5x5"));
        tiles5x5.add(new NumberTile(1, "5x5"));
        tiles5x5.add(new NumberTile(2, "5x5"));
        tiles5x5.add(new NumberTile(3, "5x5"));
        tiles5x5.add(new NumberTile(4, "5x5"));
        tiles5x5.add(new NumberTile(5, "5x5"));
        tiles5x5.add(new NumberTile(6, "5x5"));
        tiles5x5.add(new NumberTile(7, "5x5"));
        tiles5x5.add(new NumberTile(8, "5x5"));
        tiles5x5.add(new NumberTile(9, "5x5"));
        tiles5x5.add(new NumberTile(10, "5x5"));
        tiles5x5.add(new NumberTile(11, "5x5"));
        tiles5x5.add(new NumberTile(12, "5x5"));
        tiles5x5.add(new NumberTile(13, "5x5"));
        tiles5x5.add(new NumberTile(14, "5x5"));
        tiles5x5.add(new NumberTile(15, "5x5"));
        tiles5x5.add(new NumberTile(16, "5x5"));
        tiles5x5.add(new NumberTile(17, "5x5"));
        tiles5x5.add(new NumberTile(18, "5x5"));
        tiles5x5.add(new NumberTile(19, "5x5"));
        tiles5x5.add(new NumberTile(24, "5x5"));
        tiles5x5.add(new NumberTile(20, "5x5"));
        tiles5x5.add(new NumberTile(21, "5x5"));
        tiles5x5.add(new NumberTile(22, "5x5"));
        tiles5x5.add(new NumberTile(23, "5x5"));
        SlidingTilesBoard testerSlidingTilesBoard5X5 = new SlidingTilesBoard(tiles5x5);
        SlidingTileBoardManager testerSlidingTileBoardManager5X5 = new SlidingTileBoardManager(testerSlidingTilesBoard5X5, 10);

        assertEquals(20, testerSlidingTileBoardManager5X5.indexBlankTile(tiles5x5));
    }

    //------getBlankTileRow() tests------

    @Test
    public void testGetBlankTileRow_LastFromBottom3x3() {
        List<NumberTile> tiles3x3 = new ArrayList<>();

        tiles3x3.clear();
        tiles3x3.add(new NumberTile(8, "3x3"));
        tiles3x3.add(new NumberTile(0, "3x3"));
        tiles3x3.add(new NumberTile(1, "3x3"));
        tiles3x3.add(new NumberTile(2, "3x3"));
        tiles3x3.add(new NumberTile(3, "3x3"));
        tiles3x3.add(new NumberTile(4, "3x3"));
        tiles3x3.add(new NumberTile(5, "3x3"));
        tiles3x3.add(new NumberTile(6, "3x3"));
        tiles3x3.add(new NumberTile(7, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard3X3 = new SlidingTilesBoard(tiles3x3);
        SlidingTileBoardManager testerSlidingTileBoardManager3X3 = new SlidingTileBoardManager(testerSlidingTilesBoard3X3, 100);

        assertEquals(3, testerSlidingTileBoardManager3X3.getBlankTileRow(tiles3x3));
    }

    @Test
    public void testGetBlankTileRow_FirstRowFromBottom3x3() {
        List<NumberTile> tiles3x3 = new ArrayList<>();

        tiles3x3.add(new NumberTile(0, "3x3"));
        tiles3x3.add(new NumberTile(1, "3x3"));
        tiles3x3.add(new NumberTile(2, "3x3"));
        tiles3x3.add(new NumberTile(3, "3x3"));
        tiles3x3.add(new NumberTile(4, "3x3"));
        tiles3x3.add(new NumberTile(5, "3x3"));
        tiles3x3.add(new NumberTile(6, "3x3"));
        tiles3x3.add(new NumberTile(7, "3x3"));
        tiles3x3.add(new NumberTile(8, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard3X3 = new SlidingTilesBoard(tiles3x3);
        SlidingTileBoardManager testerSlidingTileBoardManager3X3 = new SlidingTileBoardManager(testerSlidingTilesBoard3X3, 100);

        assertEquals(1, testerSlidingTileBoardManager3X3.getBlankTileRow(tiles3x3));
    }

    @Test
    public void testGetBlankTileRow_MiddleFromBottom3x3() {
        List<NumberTile> tiles3x3 = new ArrayList<>();
        tiles3x3.add(new NumberTile(0, "3x3"));
        tiles3x3.add(new NumberTile(1, "3x3"));
        tiles3x3.add(new NumberTile(2, "3x3"));
        tiles3x3.add(new NumberTile(3, "3x3"));
        tiles3x3.add(new NumberTile(8, "3x3"));
        tiles3x3.add(new NumberTile(4, "3x3"));
        tiles3x3.add(new NumberTile(5, "3x3"));
        tiles3x3.add(new NumberTile(6, "3x3"));
        tiles3x3.add(new NumberTile(7, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard3X3 = new SlidingTilesBoard(tiles3x3);
        SlidingTileBoardManager testerSlidingTileBoardManager3X3 = new SlidingTileBoardManager(testerSlidingTilesBoard3X3, 100);
        assertEquals(2, testerSlidingTileBoardManager3X3.getBlankTileRow(tiles3x3));
    }

    @Test
    public void testGetBlankTileRow_TopFromBottom3x3() {
        List<NumberTile> tiles3x3 = new ArrayList<>();
        tiles3x3.add(new NumberTile(8, "3x3"));
        tiles3x3.add(new NumberTile(0, "3x3"));
        tiles3x3.add(new NumberTile(1, "3x3"));
        tiles3x3.add(new NumberTile(2, "3x3"));
        tiles3x3.add(new NumberTile(3, "3x3"));
        tiles3x3.add(new NumberTile(4, "3x3"));
        tiles3x3.add(new NumberTile(5, "3x3"));
        tiles3x3.add(new NumberTile(6, "3x3"));
        tiles3x3.add(new NumberTile(7, "3x3"));

        SlidingTilesBoard testerSlidingTilesBoard3X3 = new SlidingTilesBoard(tiles3x3);
        SlidingTileBoardManager testerSlidingTileBoardManager3X3 = new SlidingTileBoardManager(testerSlidingTilesBoard3X3, 100);
        assertEquals(3, testerSlidingTileBoardManager3X3.getBlankTileRow(tiles3x3));
    }

    @Test
    public void testGetBlankTileRow_Bottom4x4() {
        List<NumberTile> tiles4x4 = new ArrayList<>();
        tiles4x4.add(new NumberTile(0, "4x4"));
        tiles4x4.add(new NumberTile(1, "4x4"));
        tiles4x4.add(new NumberTile(2, "4x4"));
        tiles4x4.add(new NumberTile(3, "4x4"));
        tiles4x4.add(new NumberTile(4, "4x4"));
        tiles4x4.add(new NumberTile(5, "4x4"));
        tiles4x4.add(new NumberTile(6, "4x4"));
        tiles4x4.add(new NumberTile(7, "4x4"));
        tiles4x4.add(new NumberTile(8, "4x4"));
        tiles4x4.add(new NumberTile(9, "4x4"));
        tiles4x4.add(new NumberTile(10, "4x4"));
        tiles4x4.add(new NumberTile(11, "4x4"));
        tiles4x4.add(new NumberTile(12, "4x4"));
        tiles4x4.add(new NumberTile(13, "4x4"));
        tiles4x4.add(new NumberTile(14, "4x4"));
        tiles4x4.add(new NumberTile(15, "4x4"));
        SlidingTilesBoard testerSlidingTilesBoard4X4 = new SlidingTilesBoard(tiles4x4);
        SlidingTileBoardManager testerSlidingTileBoardManager4X4 = new SlidingTileBoardManager(testerSlidingTilesBoard4X4, 67);
        assertEquals(1, testerSlidingTileBoardManager4X4.getBlankTileRow(tiles4x4));
    }


    @Test
    public void testGetBlankTileRow_2ndFromBottom4x4() {
        List<NumberTile> tiles4x4 = new ArrayList<>();
        tiles4x4.add(new NumberTile(0, "4x4"));
        tiles4x4.add(new NumberTile(1, "4x4"));
        tiles4x4.add(new NumberTile(2, "4x4"));
        tiles4x4.add(new NumberTile(3, "4x4"));
        tiles4x4.add(new NumberTile(4, "4x4"));
        tiles4x4.add(new NumberTile(5, "4x4"));
        tiles4x4.add(new NumberTile(6, "4x4"));
        tiles4x4.add(new NumberTile(7, "4x4"));
        tiles4x4.add(new NumberTile(15, "4x4"));
        tiles4x4.add(new NumberTile(8, "4x4"));
        tiles4x4.add(new NumberTile(9, "4x4"));
        tiles4x4.add(new NumberTile(10, "4x4"));
        tiles4x4.add(new NumberTile(11, "4x4"));
        tiles4x4.add(new NumberTile(12, "4x4"));
        tiles4x4.add(new NumberTile(13, "4x4"));
        tiles4x4.add(new NumberTile(14, "4x4"));
        SlidingTilesBoard testerSlidingTilesBoard4X4 = new SlidingTilesBoard(tiles4x4);
        SlidingTileBoardManager testerSlidingTileBoardManager4X4 = new SlidingTileBoardManager(testerSlidingTilesBoard4X4, 67);
        assertEquals(2, testerSlidingTileBoardManager4X4.getBlankTileRow(tiles4x4));
    }

    @Test
    public void testGetBlankTileRow_3rdFromBottom4x4() {
        List<NumberTile> tiles4x4 = new ArrayList<>();
        tiles4x4.add(new NumberTile(0, "4x4"));
        tiles4x4.add(new NumberTile(1, "4x4"));
        tiles4x4.add(new NumberTile(2, "4x4"));
        tiles4x4.add(new NumberTile(3, "4x4"));
        tiles4x4.add(new NumberTile(4, "4x4"));
        tiles4x4.add(new NumberTile(15, "4x4"));
        tiles4x4.add(new NumberTile(5, "4x4"));
        tiles4x4.add(new NumberTile(6, "4x4"));
        tiles4x4.add(new NumberTile(7, "4x4"));
        tiles4x4.add(new NumberTile(8, "4x4"));
        tiles4x4.add(new NumberTile(9, "4x4"));
        tiles4x4.add(new NumberTile(10, "4x4"));
        tiles4x4.add(new NumberTile(11, "4x4"));
        tiles4x4.add(new NumberTile(12, "4x4"));
        tiles4x4.add(new NumberTile(13, "4x4"));
        tiles4x4.add(new NumberTile(14, "4x4"));
        SlidingTilesBoard testerSlidingTilesBoard4X4 = new SlidingTilesBoard(tiles4x4);
        SlidingTileBoardManager testerSlidingTileBoardManager4X4 = new SlidingTileBoardManager(testerSlidingTilesBoard4X4, 67);
        assertEquals(3, testerSlidingTileBoardManager4X4.getBlankTileRow(tiles4x4));
    }

    @Test
    public void testGetBlankTileRow_4thFromBottom4x4() {
        List<NumberTile> tiles4x4 = new ArrayList<>();
        tiles4x4.add(new NumberTile(15, "4x4"));
        tiles4x4.add(new NumberTile(0, "4x4"));
        tiles4x4.add(new NumberTile(1, "4x4"));
        tiles4x4.add(new NumberTile(2, "4x4"));
        tiles4x4.add(new NumberTile(3, "4x4"));
        tiles4x4.add(new NumberTile(4, "4x4"));
        tiles4x4.add(new NumberTile(5, "4x4"));
        tiles4x4.add(new NumberTile(6, "4x4"));
        tiles4x4.add(new NumberTile(7, "4x4"));
        tiles4x4.add(new NumberTile(8, "4x4"));
        tiles4x4.add(new NumberTile(9, "4x4"));
        tiles4x4.add(new NumberTile(10, "4x4"));
        tiles4x4.add(new NumberTile(11, "4x4"));
        tiles4x4.add(new NumberTile(12, "4x4"));
        tiles4x4.add(new NumberTile(13, "4x4"));
        tiles4x4.add(new NumberTile(14, "4x4"));
        SlidingTilesBoard testerSlidingTilesBoard4X4 = new SlidingTilesBoard(tiles4x4);
        SlidingTileBoardManager testerSlidingTileBoardManager4X4 = new SlidingTileBoardManager(testerSlidingTilesBoard4X4, 67);
        assertEquals(4, testerSlidingTileBoardManager4X4.getBlankTileRow(tiles4x4));
    }

    @Test
    public void testGetBlankTileRow_1stFromBottom5x5() {
        List<NumberTile> tiles5x5 = new ArrayList<>();
        tiles5x5.add(new NumberTile(0, "5x5"));
        tiles5x5.add(new NumberTile(1, "5x5"));
        tiles5x5.add(new NumberTile(2, "5x5"));
        tiles5x5.add(new NumberTile(3, "5x5"));
        tiles5x5.add(new NumberTile(4, "5x5"));
        tiles5x5.add(new NumberTile(5, "5x5"));
        tiles5x5.add(new NumberTile(6, "5x5"));
        tiles5x5.add(new NumberTile(7, "5x5"));
        tiles5x5.add(new NumberTile(8, "5x5"));
        tiles5x5.add(new NumberTile(9, "5x5"));
        tiles5x5.add(new NumberTile(10, "5x5"));
        tiles5x5.add(new NumberTile(11, "5x5"));
        tiles5x5.add(new NumberTile(12, "5x5"));
        tiles5x5.add(new NumberTile(13, "5x5"));
        tiles5x5.add(new NumberTile(14, "5x5"));
        tiles5x5.add(new NumberTile(15, "5x5"));
        tiles5x5.add(new NumberTile(16, "5x5"));
        tiles5x5.add(new NumberTile(17, "5x5"));
        tiles5x5.add(new NumberTile(18, "5x5"));
        tiles5x5.add(new NumberTile(19, "5x5"));
        tiles5x5.add(new NumberTile(20, "5x5"));
        tiles5x5.add(new NumberTile(21, "5x5"));
        tiles5x5.add(new NumberTile(22, "5x5"));
        tiles5x5.add(new NumberTile(23, "5x5"));
        tiles5x5.add(new NumberTile(24, "5x5"));
        SlidingTilesBoard testerSlidingTilesBoard5X5 = new SlidingTilesBoard(tiles5x5);
        SlidingTileBoardManager testerSlidingTileBoardManager5X5 = new SlidingTileBoardManager(testerSlidingTilesBoard5X5, 10);
        assertEquals(1, testerSlidingTileBoardManager5X5.getBlankTileRow(tiles5x5));
    }

    @Test
    public void testGetBlankTileRow_2ndFromBottom5x5() {
        List<NumberTile> tiles5x5 = new ArrayList<>();
        tiles5x5.add(new NumberTile(0, "5x5"));
        tiles5x5.add(new NumberTile(1, "5x5"));
        tiles5x5.add(new NumberTile(2, "5x5"));
        tiles5x5.add(new NumberTile(3, "5x5"));
        tiles5x5.add(new NumberTile(4, "5x5"));
        tiles5x5.add(new NumberTile(5, "5x5"));
        tiles5x5.add(new NumberTile(6, "5x5"));
        tiles5x5.add(new NumberTile(7, "5x5"));
        tiles5x5.add(new NumberTile(8, "5x5"));
        tiles5x5.add(new NumberTile(9, "5x5"));
        tiles5x5.add(new NumberTile(10, "5x5"));
        tiles5x5.add(new NumberTile(11, "5x5"));
        tiles5x5.add(new NumberTile(12, "5x5"));
        tiles5x5.add(new NumberTile(13, "5x5"));
        tiles5x5.add(new NumberTile(14, "5x5"));
        tiles5x5.add(new NumberTile(15, "5x5"));
        tiles5x5.add(new NumberTile(16, "5x5"));
        tiles5x5.add(new NumberTile(17, "5x5"));
        tiles5x5.add(new NumberTile(24, "5x5"));
        tiles5x5.add(new NumberTile(18, "5x5"));
        tiles5x5.add(new NumberTile(19, "5x5"));
        tiles5x5.add(new NumberTile(20, "5x5"));
        tiles5x5.add(new NumberTile(21, "5x5"));
        tiles5x5.add(new NumberTile(22, "5x5"));
        tiles5x5.add(new NumberTile(23, "5x5"));
        SlidingTilesBoard testerSlidingTilesBoard5X5 = new SlidingTilesBoard(tiles5x5);
        SlidingTileBoardManager testerSlidingTileBoardManager5X5 = new SlidingTileBoardManager(testerSlidingTilesBoard5X5, 10);
        assertEquals(2, testerSlidingTileBoardManager5X5.getBlankTileRow(tiles5x5));
    }

    @Test
    public void testGetBlankTileRow_3rdFromBottom5x5() {
        List<NumberTile> tiles5x5 = new ArrayList<>();
        tiles5x5.add(new NumberTile(0, "5x5"));
        tiles5x5.add(new NumberTile(1, "5x5"));
        tiles5x5.add(new NumberTile(2, "5x5"));
        tiles5x5.add(new NumberTile(3, "5x5"));
        tiles5x5.add(new NumberTile(4, "5x5"));
        tiles5x5.add(new NumberTile(5, "5x5"));
        tiles5x5.add(new NumberTile(6, "5x5"));
        tiles5x5.add(new NumberTile(7, "5x5"));
        tiles5x5.add(new NumberTile(8, "5x5"));
        tiles5x5.add(new NumberTile(9, "5x5"));
        tiles5x5.add(new NumberTile(24, "5x5"));
        tiles5x5.add(new NumberTile(10, "5x5"));
        tiles5x5.add(new NumberTile(11, "5x5"));
        tiles5x5.add(new NumberTile(12, "5x5"));
        tiles5x5.add(new NumberTile(13, "5x5"));
        tiles5x5.add(new NumberTile(14, "5x5"));
        tiles5x5.add(new NumberTile(15, "5x5"));
        tiles5x5.add(new NumberTile(16, "5x5"));
        tiles5x5.add(new NumberTile(17, "5x5"));
        tiles5x5.add(new NumberTile(18, "5x5"));
        tiles5x5.add(new NumberTile(19, "5x5"));
        tiles5x5.add(new NumberTile(20, "5x5"));
        tiles5x5.add(new NumberTile(21, "5x5"));
        tiles5x5.add(new NumberTile(22, "5x5"));
        tiles5x5.add(new NumberTile(23, "5x5"));
        SlidingTilesBoard testerSlidingTilesBoard5X5 = new SlidingTilesBoard(tiles5x5);
        SlidingTileBoardManager testerSlidingTileBoardManager5X5 = new SlidingTileBoardManager(testerSlidingTilesBoard5X5, 10);
        assertEquals(3, testerSlidingTileBoardManager5X5.getBlankTileRow(tiles5x5));
    }

    @Test
    public void testGetBlankTileRow_4thFromBottom5x5() {
        List<NumberTile> tiles5x5 = new ArrayList<>();
        tiles5x5.add(new NumberTile(0, "5x5"));
        tiles5x5.add(new NumberTile(1, "5x5"));
        tiles5x5.add(new NumberTile(2, "5x5"));
        tiles5x5.add(new NumberTile(3, "5x5"));
        tiles5x5.add(new NumberTile(4, "5x5"));
        tiles5x5.add(new NumberTile(5, "5x5"));
        tiles5x5.add(new NumberTile(24, "5x5"));
        tiles5x5.add(new NumberTile(6, "5x5"));
        tiles5x5.add(new NumberTile(7, "5x5"));
        tiles5x5.add(new NumberTile(8, "5x5"));
        tiles5x5.add(new NumberTile(9, "5x5"));
        tiles5x5.add(new NumberTile(10, "5x5"));
        tiles5x5.add(new NumberTile(11, "5x5"));
        tiles5x5.add(new NumberTile(12, "5x5"));
        tiles5x5.add(new NumberTile(13, "5x5"));
        tiles5x5.add(new NumberTile(14, "5x5"));
        tiles5x5.add(new NumberTile(15, "5x5"));
        tiles5x5.add(new NumberTile(16, "5x5"));
        tiles5x5.add(new NumberTile(17, "5x5"));
        tiles5x5.add(new NumberTile(18, "5x5"));
        tiles5x5.add(new NumberTile(19, "5x5"));
        tiles5x5.add(new NumberTile(20, "5x5"));
        tiles5x5.add(new NumberTile(21, "5x5"));
        tiles5x5.add(new NumberTile(22, "5x5"));
        tiles5x5.add(new NumberTile(23, "5x5"));
        SlidingTilesBoard testerSlidingTilesBoard5X5 = new SlidingTilesBoard(tiles5x5);
        SlidingTileBoardManager testerSlidingTileBoardManager5X5 = new SlidingTileBoardManager(testerSlidingTilesBoard5X5, 10);
        assertEquals(4, testerSlidingTileBoardManager5X5.getBlankTileRow(tiles5x5));
    }

    @Test
    public void testGetBlankTileRow_5thFromBottom5x5() {
        List<NumberTile> tiles5x5 = new ArrayList<>();
        tiles5x5.add(new NumberTile(24, "5x5"));
        tiles5x5.add(new NumberTile(0, "5x5"));
        tiles5x5.add(new NumberTile(1, "5x5"));
        tiles5x5.add(new NumberTile(2, "5x5"));
        tiles5x5.add(new NumberTile(3, "5x5"));
        tiles5x5.add(new NumberTile(4, "5x5"));
        tiles5x5.add(new NumberTile(5, "5x5"));
        tiles5x5.add(new NumberTile(6, "5x5"));
        tiles5x5.add(new NumberTile(7, "5x5"));
        tiles5x5.add(new NumberTile(8, "5x5"));
        tiles5x5.add(new NumberTile(9, "5x5"));
        tiles5x5.add(new NumberTile(10, "5x5"));
        tiles5x5.add(new NumberTile(11, "5x5"));
        tiles5x5.add(new NumberTile(12, "5x5"));
        tiles5x5.add(new NumberTile(13, "5x5"));
        tiles5x5.add(new NumberTile(14, "5x5"));
        tiles5x5.add(new NumberTile(15, "5x5"));
        tiles5x5.add(new NumberTile(16, "5x5"));
        tiles5x5.add(new NumberTile(17, "5x5"));
        tiles5x5.add(new NumberTile(18, "5x5"));
        tiles5x5.add(new NumberTile(19, "5x5"));
        tiles5x5.add(new NumberTile(20, "5x5"));
        tiles5x5.add(new NumberTile(21, "5x5"));
        tiles5x5.add(new NumberTile(22, "5x5"));
        tiles5x5.add(new NumberTile(23, "5x5"));
        SlidingTilesBoard testerSlidingTilesBoard5X5 = new SlidingTilesBoard(tiles5x5);
        SlidingTileBoardManager testerSlidingTileBoardManager5X5 = new SlidingTileBoardManager(testerSlidingTilesBoard5X5, 10);
        assertEquals(5, testerSlidingTileBoardManager5X5.getBlankTileRow(tiles5x5));
    }


    //-----------getTilesValues() tests ----------

    @Test
    public void getTilesValues3x3() {
        List<NumberTile> tiles3x3 = new ArrayList<>();

        tiles3x3.add(new NumberTile(0, "3x3"));
        tiles3x3.add(new NumberTile(1, "3x3"));
        tiles3x3.add(new NumberTile(2, "3x3"));
        tiles3x3.add(new NumberTile(4, "3x3"));
        tiles3x3.add(new NumberTile(8, "3x3"));
        tiles3x3.add(new NumberTile(5, "3x3"));
        tiles3x3.add(new NumberTile(6, "3x3"));
        tiles3x3.add(new NumberTile(3, "3x3"));
        tiles3x3.add(new NumberTile(7, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard3X3 = new SlidingTilesBoard(tiles3x3);
        SlidingTileBoardManager testerSlidingTileBoardManager3X3 = new SlidingTileBoardManager(testerSlidingTilesBoard3X3, 100);

        ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1,2,3,5,6,7,4,8));

        assertEquals(expectedList, testerSlidingTileBoardManager3X3.getTilesValues(tiles3x3));

    }
    @Test
    public void getTilesValues4x4() {
        List<NumberTile> tiles4x4 = new ArrayList<>();
        tiles4x4.add(new NumberTile(0, "4x4"));
        tiles4x4.add(new NumberTile(1, "4x4"));
        tiles4x4.add(new NumberTile(2, "4x4"));
        tiles4x4.add(new NumberTile(3, "4x4"));
        tiles4x4.add(new NumberTile(4, "4x4"));
        tiles4x4.add(new NumberTile(13, "4x4"));
        tiles4x4.add(new NumberTile(5, "4x4"));
        tiles4x4.add(new NumberTile(6, "4x4"));
        tiles4x4.add(new NumberTile(7, "4x4"));
        tiles4x4.add(new NumberTile(14, "4x4"));
        tiles4x4.add(new NumberTile(15, "4x4"));
        tiles4x4.add(new NumberTile(8, "4x4"));
        tiles4x4.add(new NumberTile(9, "4x4"));
        tiles4x4.add(new NumberTile(10, "4x4"));
        tiles4x4.add(new NumberTile(11, "4x4"));
        tiles4x4.add(new NumberTile(12, "4x4"));
        SlidingTilesBoard testerSlidingTilesBoard4X4 = new SlidingTilesBoard(tiles4x4);
        SlidingTileBoardManager testerSlidingTileBoardManager4X4 = new SlidingTileBoardManager(testerSlidingTilesBoard4X4, 67);

        ArrayList<Integer> expectedList = new ArrayList<>
                (Arrays.asList(1,2,3,4,5,14,6,7,8,15,9,10,11,12,13));

        assertEquals(expectedList, testerSlidingTileBoardManager4X4.getTilesValues(tiles4x4));
    }

    @Test
    public void getTilesValues5x5() {
        List<NumberTile> tiles5x5 = new ArrayList<>();
        tiles5x5.add(new NumberTile(0, "5x5"));
        tiles5x5.add(new NumberTile(1, "5x5"));
        tiles5x5.add(new NumberTile(2, "5x5"));
        tiles5x5.add(new NumberTile(3, "5x5"));
        tiles5x5.add(new NumberTile(23, "5x5"));
        tiles5x5.add(new NumberTile(4, "5x5"));
        tiles5x5.add(new NumberTile(5, "5x5"));
        tiles5x5.add(new NumberTile(6, "5x5"));
        tiles5x5.add(new NumberTile(8, "5x5"));
        tiles5x5.add(new NumberTile(9, "5x5"));
        tiles5x5.add(new NumberTile(24, "5x5"));
        tiles5x5.add(new NumberTile(10, "5x5"));
        tiles5x5.add(new NumberTile(11, "5x5"));
        tiles5x5.add(new NumberTile(17, "5x5"));
        tiles5x5.add(new NumberTile(12, "5x5"));
        tiles5x5.add(new NumberTile(13, "5x5"));
        tiles5x5.add(new NumberTile(14, "5x5"));
        tiles5x5.add(new NumberTile(15, "5x5"));
        tiles5x5.add(new NumberTile(16, "5x5"));
        tiles5x5.add(new NumberTile(7, "5x5"));
        tiles5x5.add(new NumberTile(18, "5x5"));
        tiles5x5.add(new NumberTile(19, "5x5"));
        tiles5x5.add(new NumberTile(20, "5x5"));
        tiles5x5.add(new NumberTile(21, "5x5"));
        tiles5x5.add(new NumberTile(22, "5x5"));
        SlidingTilesBoard testerSlidingTilesBoard5X5 = new SlidingTilesBoard(tiles5x5);
        SlidingTileBoardManager testerSlidingTileBoardManager5X5 = new SlidingTileBoardManager(testerSlidingTilesBoard5X5, 10);


        ArrayList<Integer> expectedList = new ArrayList<>
                (Arrays.asList(1,2,3,4, 24, 5,6,7,9,10,11,12,18,13,14,15,16,17,8,19,20,21,22,23));

        assertEquals(expectedList, testerSlidingTileBoardManager5X5.getTilesValues(tiles5x5));
    }

    //--------countInversions() Tests---------------

    @Test
    public void testCountInversions3x3(){
        List<NumberTile> tiles3x3 = new ArrayList<>();

        tiles3x3.clear();
        tiles3x3.add(new NumberTile(8, "3x3"));
        tiles3x3.add(new NumberTile(0, "3x3"));
        tiles3x3.add(new NumberTile(7, "3x3"));
        tiles3x3.add(new NumberTile(2, "3x3"));
        tiles3x3.add(new NumberTile(1, "3x3"));
        tiles3x3.add(new NumberTile(6, "3x3"));
        tiles3x3.add(new NumberTile(4, "3x3"));
        tiles3x3.add(new NumberTile(3, "3x3"));
        tiles3x3.add(new NumberTile(5, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard3X3 = new SlidingTilesBoard(tiles3x3);
        SlidingTileBoardManager testerSlidingTileBoardManager3X3 = new SlidingTileBoardManager(testerSlidingTilesBoard3X3, 100);

        assertEquals(11, testerSlidingTileBoardManager3X3.countInversions(tiles3x3));
    }

    @Test
    public void testCountInversions4x4(){
        List<NumberTile> tiles4x4 = new ArrayList<>();
        tiles4x4.add(new NumberTile(5, "4x4"));
        tiles4x4.add(new NumberTile(12, "4x4"));
        tiles4x4.add(new NumberTile(6, "4x4"));
        tiles4x4.add(new NumberTile(9, "4x4"));
        tiles4x4.add(new NumberTile(7, "4x4"));
        tiles4x4.add(new NumberTile(8, "4x4"));
        tiles4x4.add(new NumberTile(10, "4x4"));
        tiles4x4.add(new NumberTile(15, "4x4"));
        tiles4x4.add(new NumberTile(14, "4x4"));
        tiles4x4.add(new NumberTile(1, "4x4"));
        tiles4x4.add(new NumberTile(11, "4x4"));
        tiles4x4.add(new NumberTile(4, "4x4"));
        tiles4x4.add(new NumberTile(13, "4x4"));
        tiles4x4.add(new NumberTile(2, "4x4"));
        tiles4x4.add(new NumberTile(0, "4x4"));
        tiles4x4.add(new NumberTile(3, "4x4"));
        SlidingTilesBoard testerSlidingTilesBoard4X4 = new SlidingTilesBoard(tiles4x4);
        SlidingTileBoardManager testerSlidingTileBoardManager4X4 = new SlidingTileBoardManager(testerSlidingTilesBoard4X4, 67);

        assertEquals(62, testerSlidingTileBoardManager4X4.countInversions(tiles4x4));

    }

    @Test
    public void testCountInversions5x5(){
        List<NumberTile> tiles5x5 = new ArrayList<>();
        tiles5x5.add(new NumberTile(0, "5x5"));
        tiles5x5.add(new NumberTile(1, "5x5"));
        tiles5x5.add(new NumberTile(2, "5x5"));
        tiles5x5.add(new NumberTile(3, "5x5"));
        tiles5x5.add(new NumberTile(23, "5x5"));
        tiles5x5.add(new NumberTile(4, "5x5"));
        tiles5x5.add(new NumberTile(5, "5x5"));
        tiles5x5.add(new NumberTile(6, "5x5"));
        tiles5x5.add(new NumberTile(7, "5x5"));
        tiles5x5.add(new NumberTile(8, "5x5"));
        tiles5x5.add(new NumberTile(9, "5x5"));
        tiles5x5.add(new NumberTile(24, "5x5"));
        tiles5x5.add(new NumberTile(10, "5x5"));
        tiles5x5.add(new NumberTile(11, "5x5"));
        tiles5x5.add(new NumberTile(17, "5x5"));
        tiles5x5.add(new NumberTile(12, "5x5"));
        tiles5x5.add(new NumberTile(13, "5x5"));
        tiles5x5.add(new NumberTile(14, "5x5"));
        tiles5x5.add(new NumberTile(15, "5x5"));
        tiles5x5.add(new NumberTile(16, "5x5"));
        tiles5x5.add(new NumberTile(18, "5x5"));
        tiles5x5.add(new NumberTile(19, "5x5"));
        tiles5x5.add(new NumberTile(20, "5x5"));
        tiles5x5.add(new NumberTile(21, "5x5"));
        tiles5x5.add(new NumberTile(22, "5x5"));
        SlidingTilesBoard testerSlidingTilesBoard5X5 = new SlidingTilesBoard(tiles5x5);
        SlidingTileBoardManager testerSlidingTileBoardManager5X5 = new SlidingTileBoardManager(testerSlidingTilesBoard5X5, 10);

        assertEquals(24, testerSlidingTileBoardManager5X5.countInversions(tiles5x5));

    }

    //-----------------SolvableBoard test--------

    @Test
    public void testSolvableBoard3x3OddSolvable(){
        List<NumberTile> tiles3x3 = new ArrayList<>();

        tiles3x3.add(new NumberTile(0, "3x3"));
        tiles3x3.add(new NumberTile(7, "3x3"));
        tiles3x3.add(new NumberTile(1, "3x3"));
        tiles3x3.add(new NumberTile(8, "3x3"));
        tiles3x3.add(new NumberTile(3, "3x3"));
        tiles3x3.add(new NumberTile(2, "3x3"));
        tiles3x3.add(new NumberTile(6, "3x3"));
        tiles3x3.add(new NumberTile(5, "3x3"));
        tiles3x3.add(new NumberTile(4, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard3X3 = new SlidingTilesBoard(tiles3x3);
        SlidingTileBoardManager testerSlidingTileBoardManager3X3 = new SlidingTileBoardManager(testerSlidingTilesBoard3X3, 100);

        assertEquals(10, testerSlidingTileBoardManager3X3.countInversions(tiles3x3));
        assertEquals(2, testerSlidingTileBoardManager3X3.getBlankTileRow(tiles3x3));
        assertTrue(testerSlidingTileBoardManager3X3.solvableBoard(tiles3x3, 3));
    }

    @Test
    public void testSolvableBoard3x3OddUnsolvable(){
        List<NumberTile> tiles3x3 = new ArrayList<>();

        tiles3x3.add(new NumberTile(0, "3x3"));
        tiles3x3.add(new NumberTile(1, "3x3"));
        tiles3x3.add(new NumberTile(2, "3x3"));
        tiles3x3.add(new NumberTile(3, "3x3"));
        tiles3x3.add(new NumberTile(4, "3x3"));
        tiles3x3.add(new NumberTile(7, "3x3"));
        tiles3x3.add(new NumberTile(6, "3x3"));
        tiles3x3.add(new NumberTile(5, "3x3"));
        tiles3x3.add(new NumberTile(8, "3x3"));
        SlidingTilesBoard testerSlidingTilesBoard3X3 = new SlidingTilesBoard(tiles3x3);
        SlidingTileBoardManager testerSlidingTileBoardManager3X3 = new SlidingTileBoardManager(testerSlidingTilesBoard3X3, 100);

        assertEquals(3, testerSlidingTileBoardManager3X3.countInversions(tiles3x3));
        assertEquals(1, testerSlidingTileBoardManager3X3.getBlankTileRow(tiles3x3));
        assertFalse(testerSlidingTileBoardManager3X3.solvableBoard(tiles3x3, 3));
    }

    @Test
    public void testSolvableBoard4x4EvenUnsolvable() {
        List<NumberTile> tiles4x4 = new ArrayList<>();

        tiles4x4.add(new NumberTile(2, "4x4"));
        tiles4x4.add(new NumberTile(8, "4x4"));
        tiles4x4.add(new NumberTile(0, "4x4"));
        tiles4x4.add(new NumberTile(14, "4x4"));
        tiles4x4.add(new NumberTile(13, "4x4"));
        tiles4x4.add(new NumberTile(10, "4x4"));
        tiles4x4.add(new NumberTile(3, "4x4"));
        tiles4x4.add(new NumberTile(5, "4x4"));
        tiles4x4.add(new NumberTile(12, "4x4"));
        tiles4x4.add(new NumberTile(15, "4x4"));
        tiles4x4.add(new NumberTile(9, "4x4"));
        tiles4x4.add(new NumberTile(11, "4x4"));
        tiles4x4.add(new NumberTile(1, "4x4"));
        tiles4x4.add(new NumberTile(6, "4x4"));
        tiles4x4.add(new NumberTile(7, "4x4"));
        tiles4x4.add(new NumberTile(4, "4x4"));
        SlidingTilesBoard testerSlidingTilesBoard4X4 = new SlidingTilesBoard(tiles4x4);
        SlidingTileBoardManager testerSlidingTileBoardManager4X4 = new SlidingTileBoardManager(testerSlidingTilesBoard4X4, 67);

        assertEquals(56, testerSlidingTileBoardManager4X4.countInversions(tiles4x4));
        assertEquals(2, testerSlidingTileBoardManager4X4.getBlankTileRow(tiles4x4));
        assertFalse(testerSlidingTileBoardManager4X4.solvableBoard(tiles4x4, 4));

    }

    @Test
    public void testSolvableBoard4x4EvenSolvable() {
        List<NumberTile> tiles4x4 = new ArrayList<>();

        tiles4x4.add(new NumberTile(12, "4x4"));
        tiles4x4.add(new NumberTile(1, "4x4"));
        tiles4x4.add(new NumberTile(9, "4x4"));
        tiles4x4.add(new NumberTile(2, "4x4"));
        tiles4x4.add(new NumberTile(0, "4x4"));
        tiles4x4.add(new NumberTile(11, "4x4"));
        tiles4x4.add(new NumberTile(7, "4x4"));
        tiles4x4.add(new NumberTile(3, "4x4"));
        tiles4x4.add(new NumberTile(4, "4x4"));
        tiles4x4.add(new NumberTile(15, "4x4"));
        tiles4x4.add(new NumberTile(8, "4x4"));
        tiles4x4.add(new NumberTile(5, "4x4"));
        tiles4x4.add(new NumberTile(14, "4x4"));
        tiles4x4.add(new NumberTile(13, "4x4"));
        tiles4x4.add(new NumberTile(10, "4x4"));
        tiles4x4.add(new NumberTile(6, "4x4"));
        SlidingTilesBoard testerSlidingTilesBoard4X4 = new SlidingTilesBoard(tiles4x4);
        SlidingTileBoardManager testerSlidingTileBoardManager4X4 = new SlidingTileBoardManager(testerSlidingTilesBoard4X4, 67);

        assertEquals(41, testerSlidingTileBoardManager4X4.countInversions(tiles4x4));
        assertEquals(2, testerSlidingTileBoardManager4X4.getBlankTileRow(tiles4x4));
        assertTrue(testerSlidingTileBoardManager4X4.solvableBoard(tiles4x4, 4));
    }

    }

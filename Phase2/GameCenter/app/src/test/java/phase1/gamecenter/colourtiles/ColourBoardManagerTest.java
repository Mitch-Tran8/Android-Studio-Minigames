package phase1.gamecenter.colourtiles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import phase1.gamecenter.colourtiles.ColourBoard;
import phase1.gamecenter.colourtiles.ColourBoardManager;
import phase1.gamecenter.colourtiles.ColourTile;

import static org.junit.Assert.*;

public class ColourBoardManagerTest {
    private List<ColourTile> tiles = new ArrayList<>();
    private ColourBoardManager testerBoardManager1 = new ColourBoardManager(1, 3, 0, 59);
    private ColourBoardManager testerBoardManager2 = new ColourBoardManager(2, 3, 0, 59);
    private ColourBoardManager testerBoardManager3 = new ColourBoardManager(3, 3, 0, 59);
    private ColourBoardManager testerBoardManager4 = new ColourBoardManager(4, 4, 1, 59);
    private ColourBoardManager testerBoardManager5 = new ColourBoardManager(5, 4, 0, 59);
    private ColourBoardManager testerBoardManager6 = new ColourBoardManager(6, 4, 1, 59);
    private ColourBoardManager testerBoardManager7 = new ColourBoardManager(7, 5, 0, 59);
    private ColourBoardManager testerBoardManager8 = new ColourBoardManager(8, 5, 0, 59);
    private ColourBoardManager testerBoardManager9 = new ColourBoardManager(9, 5, 1, 59);

    @Test
    public void testGetBoard_3() {
        tiles.clear();
        tiles.add(new ColourTile(1));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(5));
        tiles.add(new ColourTile(6));
        tiles.add(new ColourTile(7));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        ColourBoard testerBoard = new ColourBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);

        assertEquals(testerBoard, testerBoardManager1.getBoard());
    }

    @Test
    public void testGetBoard_4() {
        tiles.clear();
        tiles.add(new ColourTile(10));
        tiles.add(new ColourTile(11));
        tiles.add(new ColourTile(12));
        tiles.add(new ColourTile(13));
        tiles.add(new ColourTile(14));
        tiles.add(new ColourTile(15));
        tiles.add(new ColourTile(16));
        tiles.add(new ColourTile(17));
        tiles.add(new ColourTile(18));
        tiles.add(new ColourTile(19));
        tiles.add(new ColourTile(20));
        tiles.add(new ColourTile(21));
        tiles.add(new ColourTile(22));
        tiles.add(new ColourTile(23));
        tiles.add(new ColourTile(24));
        tiles.add(new ColourTile(25));

        ColourBoard testerBoard = new ColourBoard(tiles, 4);
        testerBoardManager1.setBoard(testerBoard);

        assertEquals(testerBoard, testerBoardManager1.getBoard());
    }

    @Test
    public void testPuzzleSolved_FirstRowSolved() {
        tiles.clear();
        tiles.add(new ColourTile(1));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(7));
        tiles.add(new ColourTile(5));
        tiles.add(new ColourTile(6));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        ColourBoard testerBoard = new ColourBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);

        assertTrue(testerBoardManager1.puzzleSolved());
    }

    @Test
    public void testPuzzleSolved_SecondRowSolved() {
        tiles.clear();
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        ColourBoard testerBoard = new ColourBoard(tiles,3);
        testerBoardManager1.setBoard(testerBoard);

        assertTrue(testerBoardManager1.puzzleSolved());
    }

    @Test
    public void testPuzzleSolved_ThirdRowSolved() {
        tiles.clear();
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(7));
        tiles.add(new ColourTile(7));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        ColourBoard testerBoard = new ColourBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);

        assertTrue(testerBoardManager1.puzzleSolved());
    }

    @Test
    public void testPuzzleSolved_TwoRowsSolved() {
        tiles.clear();
        tiles.add(new ColourTile(1));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        ColourBoard testerBoard = new ColourBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);

        assertTrue(testerBoardManager1.puzzleSolved());
    }

    @Test
    public void testPuzzleSolved_ColSolved() {
        tiles.clear();
        tiles.add(new ColourTile(1));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        ColourBoard testerBoard = new ColourBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);

        assertTrue(testerBoardManager1.puzzleSolved());
    }

    @Test
    public void testIsValidTapTrue() {
        tiles.clear();
        tiles.add(new ColourTile(1));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(5));
        tiles.add(new ColourTile(6));
        tiles.add(new ColourTile(7));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        ColourBoard testerBoard = new ColourBoard(tiles,3);
        testerBoardManager1.setBoard(testerBoard);
        testerBoardManager1.setFirstTap(1);

        assertTrue(testerBoardManager1.isValidTap(2));
    }

    @Test
    public void testIsValidTapFalse_When_Not_A_Neighbor_Tile() {
        tiles.clear();
        tiles.add(new ColourTile(1));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(5));
        tiles.add(new ColourTile(6));
        tiles.add(new ColourTile(7));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        ColourBoard testerBoard = new ColourBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);
        testerBoardManager1.setFirstTap(5);

        assertFalse(testerBoardManager1.isValidTap(1));
    }

    @Test
    public void testIsValidTap_When_No_First_Tap() {
        tiles.clear();
        tiles.add(new ColourTile(1));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(5));
        tiles.add(new ColourTile(6));
        tiles.add(new ColourTile(7));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        ColourBoard testerBoard = new ColourBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);
        testerBoardManager1.setFirstTap(0);

        assertFalse(testerBoardManager1.isValidTap(2));
    }

    @Test
    public void testTouchMove_Tow_Same_Taps() {
        tiles.clear();
        tiles.add(new ColourTile(1));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(5));
        tiles.add(new ColourTile(6));
        tiles.add(new ColourTile(7));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        testerBoardManager1.setFirstTap(1);

        ColourBoardManager copy = testerBoardManager1;
        copy.touchMove(1);
        assertEquals(testerBoardManager1, copy);
    }

    @Test
    public void testTouchMove_general() {
        tiles.clear();
        tiles.add(new ColourTile(1));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(5));
        tiles.add(new ColourTile(6));
        tiles.add(new ColourTile(7));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        testerBoardManager1.setFirstTap(1);
        ColourBoard copyBoard = testerBoardManager1.getBoard();
        copyBoard.swapTiles(0,0,1,0);

        testerBoardManager1.touchMove(4);
        assertEquals(testerBoardManager1.getBoard(), copyBoard);
    }

    @Test
    public void testIterator() {
        tiles.clear();
        tiles.add(new ColourTile(1));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(5));
        tiles.add(new ColourTile(6));
        tiles.add(new ColourTile(7));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        List<ColourTile> tiles2 = tiles;

        Iterator<ColourTile> iter = tiles.iterator();
        Iterator<ColourTile> iter2 = tiles2.iterator();

        assertTrue(iter.hasNext());
        assertSame(iter.next(), iter2.next());
    }

    @Test
    public void testSetScoreReq() {
        tiles.clear();
        tiles.add(new ColourTile(1));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(5));
        tiles.add(new ColourTile(6));
        tiles.add(new ColourTile(7));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        List<ColourTile> tiles2 = tiles;

        ColourBoard testerBoard = new ColourBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);
        testerBoardManager1.setScoreReq(2);
        testerBoardManager1.setScoreReq(3);
        testerBoardManager1.setScoreReq(5);
        testerBoardManager1.setScoreReq(6);
        testerBoardManager1.setScoreReq(7);
        testerBoardManager1.setScoreReq(8);
        testerBoardManager1.setScoreReq(9);
        assertEquals(testerBoardManager1.getScoreReq(), 20);
    }

    @Test
    public void testGetRound() {
        tiles.clear();
        tiles.add(new ColourTile(1));
        tiles.add(new ColourTile(2));
        tiles.add(new ColourTile(3));
        tiles.add(new ColourTile(4));
        tiles.add(new ColourTile(5));
        tiles.add(new ColourTile(6));
        tiles.add(new ColourTile(7));
        tiles.add(new ColourTile(8));
        tiles.add(new ColourTile(9));
        List<ColourTile> tiles2 = tiles;
        ColourBoard testerBoard = new ColourBoard(tiles, 3);

        testerBoardManager1.setBoard(testerBoard);

        assertEquals(testerBoardManager1.getRound(), 1);
    }




}
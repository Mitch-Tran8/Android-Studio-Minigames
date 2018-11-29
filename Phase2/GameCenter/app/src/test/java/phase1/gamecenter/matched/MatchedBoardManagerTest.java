package phase1.gamecenter.matched;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class MatchedBoardManagerTest {
    private List<MatchedTile> tiles = new ArrayList<>();
    private MatchedBoardManager testerBoardManager1 = new MatchedBoardManager(1, 3, 0, 59);
    private MatchedBoardManager testerBoardManager2 = new MatchedBoardManager(2, 3, 0, 59);
    private MatchedBoardManager testerBoardManager3 = new MatchedBoardManager(3, 3, 0, 59);
    private MatchedBoardManager testerBoardManager4 = new MatchedBoardManager(4, 4, 1, 59);
    private MatchedBoardManager testerBoardManager5 = new MatchedBoardManager(5, 4, 0, 59);
    private MatchedBoardManager testerBoardManager6 = new MatchedBoardManager(6, 4, 1, 59);
    private MatchedBoardManager testerBoardManager7 = new MatchedBoardManager(7, 5, 0, 59);
    private MatchedBoardManager testerBoardManager8 = new MatchedBoardManager(8, 5, 0, 59);
    private MatchedBoardManager testerBoardManager9 = new MatchedBoardManager(9, 5, 1, 59);

    @Test
    public void testGetBoard_3() {
        tiles.clear();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard testerBoard = new MatchedBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);

        assertEquals(testerBoard, testerBoardManager1.getBoard());
    }

    @Test
    public void testGetBoard_4() {
        tiles.clear();
        tiles.add(new MatchedTile(10));
        tiles.add(new MatchedTile(11));
        tiles.add(new MatchedTile(12));
        tiles.add(new MatchedTile(13));
        tiles.add(new MatchedTile(14));
        tiles.add(new MatchedTile(15));
        tiles.add(new MatchedTile(16));
        tiles.add(new MatchedTile(17));
        tiles.add(new MatchedTile(18));
        tiles.add(new MatchedTile(19));
        tiles.add(new MatchedTile(20));
        tiles.add(new MatchedTile(21));
        tiles.add(new MatchedTile(22));
        tiles.add(new MatchedTile(23));
        tiles.add(new MatchedTile(24));
        tiles.add(new MatchedTile(25));

        MatchedBoard testerBoard = new MatchedBoard(tiles, 4);
        testerBoardManager1.setBoard(testerBoard);

        assertEquals(testerBoard, testerBoardManager1.getBoard());
    }

    @Test
    public void testPuzzleSolved_FirstRowSolved() {
        tiles.clear();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard testerBoard = new MatchedBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);

        assertTrue(testerBoardManager1.puzzleSolved());
    }

    @Test
    public void testPuzzleSolved_SecondRowSolved() {
        tiles.clear();
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard testerBoard = new MatchedBoard(tiles,3);
        testerBoardManager1.setBoard(testerBoard);

        assertTrue(testerBoardManager1.puzzleSolved());
    }

    @Test
    public void testPuzzleSolved_ThirdRowSolved() {
        tiles.clear();
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard testerBoard = new MatchedBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);

        assertTrue(testerBoardManager1.puzzleSolved());
    }

    @Test
    public void testPuzzleSolved_TwoRowsSolved() {
        tiles.clear();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard testerBoard = new MatchedBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);

        assertTrue(testerBoardManager1.puzzleSolved());
    }

    @Test
    public void testPuzzleSolved_ColSolved() {
        tiles.clear();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard testerBoard = new MatchedBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);

        assertTrue(testerBoardManager1.puzzleSolved());
    }

    @Test
    public void testIsValidTapTrue() {
        tiles.clear();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard testerBoard = new MatchedBoard(tiles,3);
        testerBoardManager1.setBoard(testerBoard);
        testerBoardManager1.setFirstTap(1);

        assertTrue(testerBoardManager1.isValidTap(2));
    }

    @Test
    public void testIsValidTapFalse_When_Not_A_Neighbor_Tile() {
        tiles.clear();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard testerBoard = new MatchedBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);
        testerBoardManager1.setFirstTap(5);

        assertFalse(testerBoardManager1.isValidTap(1));
    }

    @Test
    public void testIsValidTap_When_No_First_Tap() {
        tiles.clear();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard testerBoard = new MatchedBoard(tiles, 3);
        testerBoardManager1.setBoard(testerBoard);
        testerBoardManager1.setFirstTap(0);

        assertFalse(testerBoardManager1.isValidTap(2));
    }

    @Test
    public void testTouchMove_Tow_Same_Taps() {
        tiles.clear();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        testerBoardManager1.setFirstTap(1);

        MatchedBoardManager copy = testerBoardManager1;
        copy.touchMove(1);
        assertEquals(testerBoardManager1, copy);
    }

    @Test
    public void testTouchMove_general() {
        tiles.clear();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        testerBoardManager1.setFirstTap(1);
        MatchedBoard copyBoard = testerBoardManager1.getBoard();
        copyBoard.swapTiles(0,0,1,0);

        testerBoardManager1.touchMove(4);
        assertEquals(testerBoardManager1.getBoard(), copyBoard);
    }

    @Test
    public void testIterator() {
        tiles.clear();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        List<MatchedTile> tiles2 = tiles;

        Iterator<MatchedTile> iter = tiles.iterator();
        Iterator<MatchedTile> iter2 = tiles2.iterator();

        assertTrue(iter.hasNext());
        assertSame(iter.next(), iter2.next());
    }

    @Test
    public void testSetScoreReq() {
        tiles.clear();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        List<MatchedTile> tiles2 = tiles;

        MatchedBoard testerBoard = new MatchedBoard(tiles, 3);
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
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        List<MatchedTile> tiles2 = tiles;
        MatchedBoard testerBoard = new MatchedBoard(tiles, 3);

        testerBoardManager1.setBoard(testerBoard);

        assertEquals(testerBoardManager1.getRound(), 1);
    }




}
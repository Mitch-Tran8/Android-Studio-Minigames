package phase1.gamecenter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ColourBoardManagerTest {
    private List<ColourTile> tiles = new ArrayList<>();
    private ColourBoardManager testerBoardManager = new ColourBoardManager(1,3, 0, 59);
    private ColourBoardManager testerRoundsBoardManager = new ColourBoardManager(1,3, 0, 59);
    private ColourBoardManager testerBoardManager2 = new ColourBoardManager(1,5, 1, 59);

    @Test
    public void testSetReqScoreRounds(){
        assertEquals(20, testerRoundsBoardManager.getScoreReq());
        testerRoundsBoardManager.setScoreReq(2);
        assertEquals(40, testerRoundsBoardManager.getScoreReq());
        testerRoundsBoardManager.setScoreReq(3);
        assertEquals(60, testerRoundsBoardManager.getScoreReq());
        testerRoundsBoardManager.setScoreReq(4);
        assertEquals(80, testerRoundsBoardManager.getScoreReq());
        testerRoundsBoardManager.setScoreReq(5);
        assertEquals(100, testerRoundsBoardManager.getScoreReq());
        testerRoundsBoardManager.setScoreReq(6);
        assertEquals(120, testerRoundsBoardManager.getScoreReq());
        testerRoundsBoardManager.setScoreReq(7);
        assertEquals(140, testerRoundsBoardManager.getScoreReq());
        testerRoundsBoardManager.setScoreReq(8);
        assertEquals(160, testerRoundsBoardManager.getScoreReq());
        testerRoundsBoardManager.setScoreReq(9);
        assertEquals(180, testerRoundsBoardManager.getScoreReq());
        testerRoundsBoardManager.setScoreReq(10);
        assertEquals(200, testerRoundsBoardManager.getScoreReq());
    }

    @Test
    public void testGetScoreReqScoreRounds(){
        ColourBoardManager round1 = new ColourBoardManager(1,3, 0, 59);
        ColourBoardManager round2 = new ColourBoardManager(2,3, 0, 59);
        ColourBoardManager round3 = new ColourBoardManager(3,3, 0, 59);
        ColourBoardManager round4 = new ColourBoardManager(4,3, 0, 59);
        ColourBoardManager round5 = new ColourBoardManager(5,3, 0, 59);
        ColourBoardManager round6 = new ColourBoardManager(6,3, 0, 59);
        ColourBoardManager round7 = new ColourBoardManager(7,3, 0, 59);
        ColourBoardManager round8 = new ColourBoardManager(8,3, 0, 59);
        ColourBoardManager round9 = new ColourBoardManager(9,3, 0, 59);
        ColourBoardManager round10 = new ColourBoardManager(10,3, 0, 59);

        assertEquals(20, round1.getScoreReq());
        assertEquals(40, round2.getScoreReq());
        assertEquals(60, round3.getScoreReq());
        assertEquals(80, round4.getScoreReq());
        assertEquals(100, round5.getScoreReq());
        assertEquals(120, round6.getScoreReq());
        assertEquals(140, round7.getScoreReq());
        assertEquals(160, round8.getScoreReq());
        assertEquals(180, round9.getScoreReq());
        assertEquals(200, round10.getScoreReq());


    }

    @Test
    public void testGetBoard() {
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
        testerBoardManager.setBoard(testerBoard);

        assertEquals(testerBoard, testerBoardManager.getBoard());
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
        testerBoardManager.setBoard(testerBoard);

        assertTrue(testerBoardManager.puzzleSolved());
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
        testerBoardManager.setBoard(testerBoard);

        assertTrue(testerBoardManager.puzzleSolved());
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
        testerBoardManager.setBoard(testerBoard);

        assertTrue(testerBoardManager.puzzleSolved());
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
        testerBoardManager.setBoard(testerBoard);

        assertTrue(testerBoardManager.puzzleSolved());
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
        testerBoardManager.setBoard(testerBoard);
        testerBoardManager.setFirstTap(1);

        assertTrue(testerBoardManager.isValidTap(2));
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
        testerBoardManager.setBoard(testerBoard);
        testerBoardManager.setFirstTap(5);

        assertFalse(testerBoardManager.isValidTap(1));
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
        testerBoardManager.setBoard(testerBoard);
        testerBoardManager.setFirstTap(0);

        assertFalse(testerBoardManager.isValidTap(2));
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
        testerBoardManager.setFirstTap(1);

        ColourBoardManager copy = testerBoardManager;
        copy.touchMove(1);
        assertEquals(testerBoardManager, copy);
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
        testerBoardManager.setFirstTap(1);
        ColourBoard copyBoard = testerBoardManager.getBoard();
        copyBoard.swapTiles(0,0,1,0);

        testerBoardManager.touchMove(4);
        assertEquals(testerBoardManager.getBoard(), copyBoard);
    }
}
package phase1.gamecenter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ColourBoardManagerTest {
    private List<ColourTile> tiles = new ArrayList<>();
    private ColourBoardManager testerBoardManager = new ColourBoardManager(3, 0, 59);
    private ColourBoardManager testerBoardManager2 = new ColourBoardManager(5, 1, 59);

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
    public void touchMove() {
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
}
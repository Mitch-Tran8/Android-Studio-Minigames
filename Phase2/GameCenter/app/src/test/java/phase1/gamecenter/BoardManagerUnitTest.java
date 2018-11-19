package phase1.gamecenter;


import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


public class BoardManagerUnitTest {
    private List<Tile> tiles = new ArrayList<>();
    private Board testerBoard = new Board(tiles);
    private BoardManager testerBoardManager = new BoardManager(testerBoard, 50);
    private BoardManager testerBoardManager2 = new BoardManager(4, 4);

    @Test
    public void testGetBoard() {
        assertEquals(testerBoard, testerBoardManager.getBoard());
    }

    @Test
    public void testGetScore() {
        assertEquals(450, testerBoardManager.getScore());
    }

    @Test
    public void testIsValidUndoTrue() {
        assertEquals(true, testerBoardManager.isValidUndo());
    }

    @Test
    public void testIsValidUndoFalse() {
        assertEquals(false, testerBoardManager.isValidUndo());
    }

    @Test
    public void testPuzzleSolvedFalse() {
        assertEquals(false, testerBoardManager2.puzzleSolved());
    }

    /*@Test
    public void testPuzzleSolvedTrue() {
        tiles.clear();
        tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));
        tiles.add(new Tile(8, "3x3"));

        assertEquals(true, testerBoardManager.puzzleSolved());
    }*/

    @Test
    public void testGetNumOfMoves() {
        tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));
        tiles.add(new Tile(8, "3x3"));

        assertEquals(0, testerBoardManager.getNumOfMoves());

    }

    @Test
    public void testIsValidTapTrue() {
        tiles.clear();
        tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(8, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));

        assertEquals(true, testerBoardManager.isValidTap(0));
    }


}

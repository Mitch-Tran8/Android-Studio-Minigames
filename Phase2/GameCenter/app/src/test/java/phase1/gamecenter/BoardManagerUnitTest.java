package phase1.gamecenter;


import android.provider.Settings;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


public class BoardManagerUnitTest {

    @Test
    public void testSetComplexity() {
        List<Tile> tiles = new ArrayList<Tile>();
        tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));
        tiles.add(new Tile(8, "3x3"));
        Board testerBoard = new Board(tiles);
        BoardManager testerBoardManager = new BoardManager(testerBoard, 70);
        testerBoardManager.setComplexity("3x3");
        assertEquals("3x3", testerBoardManager.getComplexity());
    }

    @Test
    public void testGetBoard() {
        List<Tile> tiles = new ArrayList<Tile>();
        tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));
        tiles.add(new Tile(8, "3x3"));
        Board testerBoard = new Board(tiles);
        BoardManager testerBoardManager = new BoardManager(testerBoard, 70);
        assertEquals(true, testerBoard.equals(testerBoardManager.getBoard()));
    }

    @Test
    public void testGetColumnsRows() {
        List<Tile> tiles = new ArrayList<Tile>();
        tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));
        tiles.add(new Tile(8, "3x3"));
        BoardManager testerBoardManager = new BoardManager(3, 3);
        testerBoardManager.setComplexity("3x3");
        assertEquals(3, testerBoardManager.getColumns());
        assertEquals(3, testerBoardManager.getRows());

    }

    @Test
    public void testNumOfMoves() {
        List<Tile> tiles = new ArrayList<Tile>();
        tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));
        tiles.add(new Tile(8, "3x3"));
        Board.NUM_ROWS = 3;
        Board.NUM_COLS = 3;
        Board testerBoard = new Board(tiles);
        BoardManager testerBoardManager = new BoardManager(testerBoard, 39);
        testerBoardManager.numOfMoves = 3;
        assertEquals(3, testerBoardManager.getNumOfMoves());
    }

/*    @Test
    public void testPuzzleSolved() {
        List<Tile> tiles = new ArrayList<Tile>();
        tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));
        tiles.add(new Tile(8, "3x3"));
        Board testerBoard = new Board(tiles);
        BoardManager testerBoardManager = new BoardManager(testerBoard, 39);
        assertEquals(true, testerBoardManager.puzzleSolved());
    }*/

    @Test
    public void testUpdateScore3x3() {
        List<Tile> tiles = new ArrayList<Tile>();
        tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));
        tiles.add(new Tile(8, "3x3"));
        Board testerBoard = new Board(tiles);
        BoardManager testerBoardManager = new BoardManager(testerBoard, 39);
        testerBoardManager.updateScore(true);
        assertEquals(50, testerBoardManager.getScore());
    }

    @Test
    public void testUpdateScore4x4() {
        BoardManager testerBoardManager5x5 = new BoardManager(4,4);
        testerBoardManager5x5.updateScore(true);
        assertEquals(150, testerBoardManager5x5.getScore());
    }

    @Test
    public void testUpdateScore5x5() {
        BoardManager testerBoardManager5x5 = new BoardManager(5,5);
        testerBoardManager5x5.updateScore(true);
        assertEquals(250, testerBoardManager5x5.getScore());
    }

    @Test
    public void testIsValidTap() {
        List<Tile> tiles = new ArrayList<Tile>();
        tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));
        tiles.add(new Tile(8, "3x3"));
        Board testerBoard = new Board(tiles);
        BoardManager testerBoardManager = new BoardManager(testerBoard, 39);
        assertEquals(false, testerBoardManager.isValidTap(3));
    }


    @Test
    public void testIsValidUndo() {
        List<Tile> tiles = new ArrayList<Tile>();
        tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));
        tiles.add(new Tile(8, "3x3"));
        Board testerBoard = new Board(tiles);
        BoardManager testerBoardManager = new BoardManager(testerBoard, 39);
        assertEquals(true, testerBoardManager.isValidUndo());
    }

    @Test
    public void testSetMaxUndoTimes() {
        List<Tile> tiles = new ArrayList<Tile>();
        tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));
        tiles.add(new Tile(8, "3x3"));
        Board testerBoard = new Board(tiles);
        BoardManager testerBoardManager = new BoardManager(testerBoard, 39);
        testerBoardManager.setMaxUndoTimes(10);
        assertEquals(10, testerBoardManager.maxUndoTimes);
    }

    @Test
    public void testGetBlankTile() {
        List<Tile> tiles = new ArrayList<Tile>();
        tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));
        tiles.add(new Tile(8, "3x3"));
        Board testerBoard = new Board(tiles);
        BoardManager testerBoardManager = new BoardManager(testerBoard, 39);
        int blankTileRow = testerBoardManager.getBlankTileRow(tiles);
        assertEquals(blankTileRow, testerBoardManager.getBlankTile(1, 1, 9)[0]);
    }

}

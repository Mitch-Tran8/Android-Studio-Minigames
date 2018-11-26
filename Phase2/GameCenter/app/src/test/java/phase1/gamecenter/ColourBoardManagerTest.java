package phase1.gamecenter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ColourBoardManagerTest {
    private List<ColourTile> tiles = new ArrayList<>();
    private ColourBoard testerBoard = new ColourBoard(tiles);
    private ColourBoardManager testerBoardManager = new ColourBoardManager(3, 0, 59);
    private ColourBoardManager testerBoardManager2 = new ColourBoardManager(5, 1, 59);

    @Test
    public void testGetBoard() {
        assertEquals(testerBoard, testerBoardManager.getBoard());
    }

    @Test
    public void testPuzzleSolvedFalse() {
        assertFalse(testerBoardManager2.puzzleSolved());
    }

    @Test
    public void testPuzzleSolvedTrue() {
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
        assertTrue(testerBoardManager.isValidTap(0));
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
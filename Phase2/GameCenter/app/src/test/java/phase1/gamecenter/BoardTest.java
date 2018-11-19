package phase1.gamecenter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {

    List<Tile> tiles = new ArrayList<>();
    Board testerBoard = new Board(tiles);

    @Test
    public void testGetTile() {
        tiles.add(new Tile(1, 0));
        tiles.add(new Tile(1, 0));
        tiles.add(new Tile(1, 0));
        tiles.add(new Tile(1, 0));
        tiles.add(new Tile(1, 0));
        tiles.add(new Tile(1, 0));
        tiles.add(new Tile(1, 0));
        tiles.add(new Tile(1, 0));
        tiles.add(new Tile(1, 0));

        /*tiles.add(new Tile(0, "3x3"));
        tiles.add(new Tile(1, "3x3"));
        tiles.add(new Tile(2, "3x3"));
        tiles.add(new Tile(3, "3x3"));
        tiles.add(new Tile(4, "3x3"));
        tiles.add(new Tile(5, "3x3"));
        tiles.add(new Tile(6, "3x3"));
        tiles.add(new Tile(7, "3x3"));
        tiles.add(new Tile(8, "3x3"));*/
        testerBoard.NUM_ROWS = 3;
        testerBoard.NUM_COLS = 3;

        System.out.println(testerBoard.NUM_ROWS);
        System.out.println(testerBoard.NUM_COLS);
        System.out.println(testerBoard.getTile(0,2));

        Tile expectedTile = new Tile(2,1);
        assertEquals(expectedTile, testerBoard.getTile(0, 2));
    }

    @Test
    public void testSwapTiles() {
    }
}
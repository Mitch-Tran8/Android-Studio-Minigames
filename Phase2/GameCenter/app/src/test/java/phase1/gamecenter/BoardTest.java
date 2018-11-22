package phase1.gamecenter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {

    List<Tile> tiles = new ArrayList<>();

    @Test
    public void testGetTile() {
        tiles.add(new Tile(1, 0));
        tiles.add(new Tile(2, 1));
        tiles.add(new Tile(3, 2));
        tiles.add(new Tile(4, 3));
        tiles.add(new Tile(5, 4));
        tiles.add(new Tile(6, 5));
        tiles.add(new Tile(7, 6));
        tiles.add(new Tile(8, 7));
        tiles.add(new Tile(9, 8));

        Board testerBoard = new Board(tiles);

        testerBoard.NUM_ROWS = 3;
        testerBoard.NUM_COLS = 3;

        System.out.println(testerBoard.NUM_ROWS);
        System.out.println(testerBoard.NUM_COLS);
        System.out.println(testerBoard.getTile(0,2));

        Tile expectedTile = new Tile(3, 2);
        assertEquals(expectedTile, testerBoard.getTile(0, 2));
    }

    @Test
    public void testSwapTiles() {
        tiles.clear();
        tiles.add(new Tile(1, 0));
        tiles.add(new Tile(2, 1));
        tiles.add(new Tile(3, 2));
        tiles.add(new Tile(4, 3));
        tiles.add(new Tile(5, 4));
        tiles.add(new Tile(6, 5));
        tiles.add(new Tile(7, 6));
        tiles.add(new Tile(8, 7));
        tiles.add(new Tile(9, 8));

        Board testerBoard = new Board(tiles);
        System.out.println(testerBoard.NUM_COLS);

        testerBoard.swapTiles(0,0,0,1);
        //testerBoard.getTile(0,0);
        //testerBoard.getTile(0,1);
        Tile expectedTile1 = new Tile(2, 1);
        Tile expectedTile2 = new Tile(1, 0);

        assertEquals(expectedTile1, testerBoard.getTile(0, 0));
        assertEquals(expectedTile2, testerBoard.getTile(0,1));

    }
}
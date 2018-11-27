package phase1.gamecenter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void numTiles() {
        List<Tile> tiles = new ArrayList<>();
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
        assertEquals(9, testerBoard.numTiles());
    }

    @Test
    public void getTile() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(1, 0));
        tiles.add(new Tile(2, 1));
        tiles.add(new Tile(3, 2));
        tiles.add(new Tile(4, 3));
        tiles.add(new Tile(5, 4));
        tiles.add(new Tile(6, 5));
        tiles.add(new Tile(7, 6));
        tiles.add(new Tile(8, 7));
        tiles.add(new Tile(9, 8));

        Tile expectedTile = new Tile(1, 0);
        Board testerBoard = new Board(tiles);
        assertEquals(0, expectedTile.compareTo(testerBoard.getTile(0, 0)));
    }


    @Test
    public void testSwapTiles() {
        List<Tile> tiles = new ArrayList<>();
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

        testerBoard.swapTiles(0, 0, 0, 1);

        Tile expectedTile1 = new Tile(2, 1);
        Tile expectedTile2 = new Tile(1, 0);

        assertEquals(0, expectedTile1.compareTo(testerBoard.getTile(0, 0)));
        assertEquals(0, expectedTile2.compareTo(testerBoard.getTile(0, 1)));

    }

/*    @Test
    public void testToString() {
        List<Tile> tiles = new ArrayList<>();
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
        assertEquals(Arrays.toString(tiles) == testerBoard.toString());
    }*/
}
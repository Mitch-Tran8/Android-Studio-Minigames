package phase1.gamecenter.matched;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class MatchedBoardTest {


    @Test
    public void getNUM_ROWS() {
        List<MatchedTile> tiles = new ArrayList<>();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard board = new MatchedBoard(tiles, 3);
        assertEquals(board.getNUM_ROWS(), 3);
    }

    @Test
    public void getNUM_COLS() {
        List<MatchedTile> tiles = new ArrayList<>();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard board = new MatchedBoard(tiles, 3);
        assertEquals(board.getNUM_COLS(), 3);
    }

    @Test
    public void getTile() {
        List<MatchedTile> tiles = new ArrayList<>();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard board = new MatchedBoard(tiles, 3);

        assertEquals(board.getTile(0,0).getId(), 1);
    }

    @Test
    public void setTile() {
        List<MatchedTile> tiles = new ArrayList<>();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard board = new MatchedBoard(tiles, 3);
        MatchedTile newTile = new MatchedTile(4);
        board.setTile(0,0, newTile);
        assertEquals(board.getTile(0,0).getBackground(), newTile.getBackground());
    }

    @Test
    public void replaceRow() {
        List<MatchedTile> tiles = new ArrayList<>();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard board = new MatchedBoard(tiles, 3);
        MatchedTile newTile = board.getTile(0,0);
        board.replaceRow(1, 2);

        assertEquals(board.getTile(1, 0).getBackground(), newTile.getBackground());
    }

    @Test
    public void swapTiles() {
        List<MatchedTile> tiles = new ArrayList<>();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard board = new MatchedBoard(tiles, 3);
        MatchedTile newTile1 = board.getTile(0,1);
        MatchedTile newTile2 = board.getTile(0,0);

        board.swapTiles(0,0,0,1);
        assertEquals(board.getTile(0,1).getBackground(), newTile1.getBackground());
        assertEquals(board.getTile(0,0).getBackground(), newTile2.getBackground());

    }
    @Test
    public void toStringTest(){
        List<MatchedTile> tiles = new ArrayList<>();
        tiles.add(new MatchedTile(1));
        tiles.add(new MatchedTile(2));
        tiles.add(new MatchedTile(3));
        tiles.add(new MatchedTile(4));
        tiles.add(new MatchedTile(5));
        tiles.add(new MatchedTile(6));
        tiles.add(new MatchedTile(7));
        tiles.add(new MatchedTile(8));
        tiles.add(new MatchedTile(9));
        MatchedBoard board = new MatchedBoard(tiles, 3);

        assertEquals("MatchedBoard{" + "tiles=" + Arrays.toString(board.getTiles()) + '}', board.toString());
    }

    @Test
    public void iterator() {

    }
}
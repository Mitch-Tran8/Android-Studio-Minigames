package phase1.gamecenter;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SolvableBoardUnitTest {

    //------indexBlankTile() tests------
    @Test
    public void testIndexBlankTileLastTile() {
        List<Tile> tiles3x3 = new ArrayList<>();
        tiles3x3.add(new Tile(0, "3x3"));
        tiles3x3.add(new Tile(1, "3x3"));
        tiles3x3.add(new Tile(2, "3x3"));
        tiles3x3.add(new Tile(3, "3x3"));
        tiles3x3.add(new Tile(4, "3x3"));
        tiles3x3.add(new Tile(5, "3x3"));
        tiles3x3.add(new Tile(6, "3x3"));
        tiles3x3.add(new Tile(7, "3x3"));
        tiles3x3.add(new Tile(8, "3x3"));
        Board testerBoard3x3 = new Board(tiles3x3);
        BoardManager testerBoardManager3x3 = new BoardManager(testerBoard3x3, 100);

        assertEquals(8, testerBoardManager3x3.indexBlankTile(tiles3x3));
    }

    @Test
    public void testIndexBlankTileFirstTile() {
        List<Tile> tiles3x3 = new ArrayList<>();
        tiles3x3.add(new Tile(8, "3x3"));
        tiles3x3.add(new Tile(0, "3x3"));
        tiles3x3.add(new Tile(1, "3x3"));
        tiles3x3.add(new Tile(2, "3x3"));
        tiles3x3.add(new Tile(3, "3x3"));
        tiles3x3.add(new Tile(4, "3x3"));
        tiles3x3.add(new Tile(5, "3x3"));
        tiles3x3.add(new Tile(6, "3x3"));
        tiles3x3.add(new Tile(7, "3x3"));
        Board testerBoard3x3 = new Board(tiles3x3);
        BoardManager testerBoardManager3x3 = new BoardManager(testerBoard3x3, 100);
        assertEquals(0, testerBoardManager3x3.indexBlankTile(tiles3x3));
    }

    @Test
    public void testIndexBlankTileMiddleTile3x3() {
        List<Tile> tiles3x3 = new ArrayList<>();
        tiles3x3.add(new Tile(0, "3x3"));
        tiles3x3.add(new Tile(1, "3x3"));
        tiles3x3.add(new Tile(2, "3x3"));
        tiles3x3.add(new Tile(3, "3x3"));
        tiles3x3.add(new Tile(8, "3x3"));
        tiles3x3.add(new Tile(4, "3x3"));
        tiles3x3.add(new Tile(5, "3x3"));
        tiles3x3.add(new Tile(6, "3x3"));
        tiles3x3.add(new Tile(7, "3x3"));
        Board testerBoard3x3 = new Board(tiles3x3);
        BoardManager testerBoardManager3x3 = new BoardManager(testerBoard3x3, 100);
        assertEquals(4, testerBoardManager3x3.indexBlankTile(tiles3x3));
    }

    @Test
    public void testIndexBlankTileMiddleTile4x4() {
        List<Tile> tiles4x4 = new ArrayList<>();
        tiles4x4.add(new Tile(0, "4x4"));
        tiles4x4.add(new Tile(1, "4x4"));
        tiles4x4.add(new Tile(2, "4x4"));
        tiles4x4.add(new Tile(3, "4x4"));
        tiles4x4.add(new Tile(4, "4x4"));
        tiles4x4.add(new Tile(5, "4x4"));
        tiles4x4.add(new Tile(6, "4x4"));
        tiles4x4.add(new Tile(7, "4x4"));
        tiles4x4.add(new Tile(8, "4x4"));
        tiles4x4.add(new Tile(9, "4x4"));
        tiles4x4.add(new Tile(10, "4x4"));
        tiles4x4.add(new Tile(11, "4x4"));
        tiles4x4.add(new Tile(15, "4x4"));
        tiles4x4.add(new Tile(12, "4x4"));
        tiles4x4.add(new Tile(13, "4x4"));
        tiles4x4.add(new Tile(14, "4x4"));
        Board testerBoard4x4 = new Board(tiles4x4);
        BoardManager testerBoardManager4x4 = new BoardManager(testerBoard4x4, 67);

        assertEquals(12, testerBoardManager4x4.indexBlankTile(tiles4x4));
    }

    @Test
    public void testIndexBlankTileMiddleTile5x5() {
        List<Tile> tiles5x5 = new ArrayList<>();
        tiles5x5.add(new Tile(0, "5x5"));
        tiles5x5.add(new Tile(1, "5x5"));
        tiles5x5.add(new Tile(2, "5x5"));
        tiles5x5.add(new Tile(3, "5x5"));
        tiles5x5.add(new Tile(4, "5x5"));
        tiles5x5.add(new Tile(5, "5x5"));
        tiles5x5.add(new Tile(6, "5x5"));
        tiles5x5.add(new Tile(7, "5x5"));
        tiles5x5.add(new Tile(8, "5x5"));
        tiles5x5.add(new Tile(9, "5x5"));
        tiles5x5.add(new Tile(10, "5x5"));
        tiles5x5.add(new Tile(11, "5x5"));
        tiles5x5.add(new Tile(12, "5x5"));
        tiles5x5.add(new Tile(13, "5x5"));
        tiles5x5.add(new Tile(14, "5x5"));
        tiles5x5.add(new Tile(15, "5x5"));
        tiles5x5.add(new Tile(16, "5x5"));
        tiles5x5.add(new Tile(17, "5x5"));
        tiles5x5.add(new Tile(18, "5x5"));
        tiles5x5.add(new Tile(19, "5x5"));
        tiles5x5.add(new Tile(24, "5x5"));
        tiles5x5.add(new Tile(20, "5x5"));
        tiles5x5.add(new Tile(21, "5x5"));
        tiles5x5.add(new Tile(22, "5x5"));
        tiles5x5.add(new Tile(23, "5x5"));
        Board testerBoard5x5 = new Board(tiles5x5);
        BoardManager testerBoardManager5x5 = new BoardManager(testerBoard5x5, 10);

        assertEquals(20, testerBoardManager5x5.indexBlankTile(tiles5x5));
    }

    //------getBlankTileRow() tests------

    @Test
    public void testGetBlankTileRow_LastFromBottom3x3() {
        List<Tile> tiles3x3 = new ArrayList<>();

        tiles3x3.clear();
        tiles3x3.add(new Tile(8, "3x3"));
        tiles3x3.add(new Tile(0, "3x3"));
        tiles3x3.add(new Tile(1, "3x3"));
        tiles3x3.add(new Tile(2, "3x3"));
        tiles3x3.add(new Tile(3, "3x3"));
        tiles3x3.add(new Tile(4, "3x3"));
        tiles3x3.add(new Tile(5, "3x3"));
        tiles3x3.add(new Tile(6, "3x3"));
        tiles3x3.add(new Tile(7, "3x3"));
        Board testerBoard3x3 = new Board(tiles3x3);
        BoardManager testerBoardManager3x3 = new BoardManager(testerBoard3x3, 100);

        assertEquals(3, testerBoardManager3x3.getBlankTileRow(tiles3x3));
    }

    @Test
    public void testGetBlankTileRow_FirstRowFromBottom3x3() {
        List<Tile> tiles3x3 = new ArrayList<>();

        tiles3x3.add(new Tile(0, "3x3"));
        tiles3x3.add(new Tile(1, "3x3"));
        tiles3x3.add(new Tile(2, "3x3"));
        tiles3x3.add(new Tile(3, "3x3"));
        tiles3x3.add(new Tile(4, "3x3"));
        tiles3x3.add(new Tile(5, "3x3"));
        tiles3x3.add(new Tile(6, "3x3"));
        tiles3x3.add(new Tile(7, "3x3"));
        tiles3x3.add(new Tile(8, "3x3"));
        Board testerBoard3x3 = new Board(tiles3x3);
        BoardManager testerBoardManager3x3 = new BoardManager(testerBoard3x3, 100);

        assertEquals(1, testerBoardManager3x3.getBlankTileRow(tiles3x3));
    }

    @Test
    public void testGetBlankTileRow_MiddleFromBottom3x3() {
        List<Tile> tiles3x3 = new ArrayList<>();
        tiles3x3.add(new Tile(0, "3x3"));
        tiles3x3.add(new Tile(1, "3x3"));
        tiles3x3.add(new Tile(2, "3x3"));
        tiles3x3.add(new Tile(3, "3x3"));
        tiles3x3.add(new Tile(8, "3x3"));
        tiles3x3.add(new Tile(4, "3x3"));
        tiles3x3.add(new Tile(5, "3x3"));
        tiles3x3.add(new Tile(6, "3x3"));
        tiles3x3.add(new Tile(7, "3x3"));
        Board testerBoard3x3 = new Board(tiles3x3);
        BoardManager testerBoardManager3x3 = new BoardManager(testerBoard3x3, 100);
        assertEquals(2, testerBoardManager3x3.getBlankTileRow(tiles3x3));
    }

    @Test
    public void testGetBlankTileRow_MiddleFromBottom4x4() {
        List<Tile> tiles4x4 = new ArrayList<>();
        tiles4x4.add(new Tile(0, "4x4"));
        tiles4x4.add(new Tile(1, "4x4"));
        tiles4x4.add(new Tile(2, "4x4"));
        tiles4x4.add(new Tile(3, "4x4"));
        tiles4x4.add(new Tile(4, "4x4"));
        tiles4x4.add(new Tile(5, "4x4"));
        tiles4x4.add(new Tile(6, "4x4"));
        tiles4x4.add(new Tile(7, "4x4"));
        tiles4x4.add(new Tile(15, "4x4"));
        tiles4x4.add(new Tile(8, "4x4"));
        tiles4x4.add(new Tile(9, "4x4"));
        tiles4x4.add(new Tile(10, "4x4"));
        tiles4x4.add(new Tile(11, "4x4"));
        tiles4x4.add(new Tile(12, "4x4"));
        tiles4x4.add(new Tile(13, "4x4"));
        tiles4x4.add(new Tile(14, "4x4"));
        Board testerBoard4x4 = new Board(tiles4x4);
        BoardManager testerBoardManager4x4 = new BoardManager(testerBoard4x4, 67);
        assertEquals(2, testerBoardManager4x4.getBlankTileRow(tiles4x4));
    }

    @Test
    public void testGetBlankTileRow_MiddleFromBottom5x5() {
        List<Tile> tiles5x5 = new ArrayList<>();

        tiles5x5.add(new Tile(0, "5x5"));
        tiles5x5.add(new Tile(1, "5x5"));
        tiles5x5.add(new Tile(2, "5x5"));
        tiles5x5.add(new Tile(3, "5x5"));
        tiles5x5.add(new Tile(4, "5x5"));
        tiles5x5.add(new Tile(5, "5x5"));
        tiles5x5.add(new Tile(6, "5x5"));
        tiles5x5.add(new Tile(7, "5x5"));
        tiles5x5.add(new Tile(8, "5x5"));
        tiles5x5.add(new Tile(9, "5x5"));
        tiles5x5.add(new Tile(24, "5x5"));
        tiles5x5.add(new Tile(10, "5x5"));
        tiles5x5.add(new Tile(11, "5x5"));
        tiles5x5.add(new Tile(12, "5x5"));
        tiles5x5.add(new Tile(13, "5x5"));
        tiles5x5.add(new Tile(14, "5x5"));
        tiles5x5.add(new Tile(15, "5x5"));
        tiles5x5.add(new Tile(16, "5x5"));
        tiles5x5.add(new Tile(17, "5x5"));
        tiles5x5.add(new Tile(18, "5x5"));
        tiles5x5.add(new Tile(19, "5x5"));
        tiles5x5.add(new Tile(20, "5x5"));
        tiles5x5.add(new Tile(21, "5x5"));
        tiles5x5.add(new Tile(22, "5x5"));
        tiles5x5.add(new Tile(23, "5x5"));
        Board testerBoard5x5 = new Board(tiles5x5);
        BoardManager testerBoardManager5x5 = new BoardManager(testerBoard5x5, 10);
        assertEquals(3, testerBoardManager5x5.getBlankTileRow(tiles5x5));
    }

    //-----------getTilesValues() tests ----------

    @Test
    public void getTilesValues3x3() {
        List<Tile> tiles3x3 = new ArrayList<>();

        tiles3x3.add(new Tile(0, "3x3"));
        tiles3x3.add(new Tile(1, "3x3"));
        tiles3x3.add(new Tile(2, "3x3"));
        tiles3x3.add(new Tile(4, "3x3"));
        tiles3x3.add(new Tile(8, "3x3"));
        tiles3x3.add(new Tile(5, "3x3"));
        tiles3x3.add(new Tile(6, "3x3"));
        tiles3x3.add(new Tile(3, "3x3"));
        tiles3x3.add(new Tile(7, "3x3"));
        Board testerBoard3x3 = new Board(tiles3x3);
        BoardManager testerBoardManager3x3 = new BoardManager(testerBoard3x3, 100);

        ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1,2,3,5,6,7,4,8));

        assertEquals(expectedList, testerBoardManager3x3.getTilesValues(tiles3x3));

    }
    @Test
    public void getTilesValues4x4() {
        List<Tile> tiles4x4 = new ArrayList<>();
        tiles4x4.add(new Tile(0, "4x4"));
        tiles4x4.add(new Tile(1, "4x4"));
        tiles4x4.add(new Tile(2, "4x4"));
        tiles4x4.add(new Tile(3, "4x4"));
        tiles4x4.add(new Tile(4, "4x4"));
        tiles4x4.add(new Tile(13, "4x4"));
        tiles4x4.add(new Tile(5, "4x4"));
        tiles4x4.add(new Tile(6, "4x4"));
        tiles4x4.add(new Tile(7, "4x4"));
        tiles4x4.add(new Tile(14, "4x4"));
        tiles4x4.add(new Tile(15, "4x4"));
        tiles4x4.add(new Tile(8, "4x4"));
        tiles4x4.add(new Tile(9, "4x4"));
        tiles4x4.add(new Tile(10, "4x4"));
        tiles4x4.add(new Tile(11, "4x4"));
        tiles4x4.add(new Tile(12, "4x4"));
        Board testerBoard4x4 = new Board(tiles4x4);
        BoardManager testerBoardManager4x4 = new BoardManager(testerBoard4x4, 67);

        ArrayList<Integer> expectedList = new ArrayList<>
                (Arrays.asList(1,2,3,4,5,14,6,7,8,15,9,10,11,12,13));

        assertEquals(expectedList, testerBoardManager4x4.getTilesValues(tiles4x4));
    }

    @Test
    public void getTilesValues5x5() {
        List<Tile> tiles5x5 = new ArrayList<>();
        tiles5x5.add(new Tile(0, "5x5"));
        tiles5x5.add(new Tile(1, "5x5"));
        tiles5x5.add(new Tile(2, "5x5"));
        tiles5x5.add(new Tile(3, "5x5"));
        tiles5x5.add(new Tile(23, "5x5"));
        tiles5x5.add(new Tile(4, "5x5"));
        tiles5x5.add(new Tile(5, "5x5"));
        tiles5x5.add(new Tile(6, "5x5"));
        tiles5x5.add(new Tile(8, "5x5"));
        tiles5x5.add(new Tile(9, "5x5"));
        tiles5x5.add(new Tile(24, "5x5"));
        tiles5x5.add(new Tile(10, "5x5"));
        tiles5x5.add(new Tile(11, "5x5"));
        tiles5x5.add(new Tile(17, "5x5"));
        tiles5x5.add(new Tile(12, "5x5"));
        tiles5x5.add(new Tile(13, "5x5"));
        tiles5x5.add(new Tile(14, "5x5"));
        tiles5x5.add(new Tile(15, "5x5"));
        tiles5x5.add(new Tile(16, "5x5"));
        tiles5x5.add(new Tile(7, "5x5"));
        tiles5x5.add(new Tile(18, "5x5"));
        tiles5x5.add(new Tile(19, "5x5"));
        tiles5x5.add(new Tile(20, "5x5"));
        tiles5x5.add(new Tile(21, "5x5"));
        tiles5x5.add(new Tile(22, "5x5"));
        Board testerBoard5x5 = new Board(tiles5x5);
        BoardManager testerBoardManager5x5 = new BoardManager(testerBoard5x5, 10);


        ArrayList<Integer> expectedList = new ArrayList<>
                (Arrays.asList(1,2,3,4, 24, 5,6,7,9,10,11,12,18,13,14,15,16,17,8,19,20,21,22,23));

        assertEquals(expectedList, testerBoardManager5x5.getTilesValues(tiles5x5));
    }

    //--------countInversions() Tests---------------

    @Test
    public void testCountInversions3x3(){
        List<Tile> tiles3x3 = new ArrayList<>();

        tiles3x3.clear();
        tiles3x3.add(new Tile(8, "3x3"));
        tiles3x3.add(new Tile(0, "3x3"));
        tiles3x3.add(new Tile(7, "3x3"));
        tiles3x3.add(new Tile(2, "3x3"));
        tiles3x3.add(new Tile(1, "3x3"));
        tiles3x3.add(new Tile(6, "3x3"));
        tiles3x3.add(new Tile(4, "3x3"));
        tiles3x3.add(new Tile(3, "3x3"));
        tiles3x3.add(new Tile(5, "3x3"));
        Board testerBoard3x3 = new Board(tiles3x3);
        BoardManager testerBoardManager3x3 = new BoardManager(testerBoard3x3, 100);

        assertEquals(11, testerBoardManager3x3.countInversions(tiles3x3));
    }

    @Test
    public void testCountInversions4x4(){
        List<Tile> tiles4x4 = new ArrayList<>();
        tiles4x4.add(new Tile(5, "4x4"));
        tiles4x4.add(new Tile(12, "4x4"));
        tiles4x4.add(new Tile(6, "4x4"));
        tiles4x4.add(new Tile(9, "4x4"));
        tiles4x4.add(new Tile(7, "4x4"));
        tiles4x4.add(new Tile(8, "4x4"));
        tiles4x4.add(new Tile(10, "4x4"));
        tiles4x4.add(new Tile(15, "4x4"));
        tiles4x4.add(new Tile(14, "4x4"));
        tiles4x4.add(new Tile(1, "4x4"));
        tiles4x4.add(new Tile(11, "4x4"));
        tiles4x4.add(new Tile(4, "4x4"));
        tiles4x4.add(new Tile(13, "4x4"));
        tiles4x4.add(new Tile(2, "4x4"));
        tiles4x4.add(new Tile(0, "4x4"));
        tiles4x4.add(new Tile(3, "4x4"));
        Board testerBoard4x4 = new Board(tiles4x4);
        BoardManager testerBoardManager4x4 = new BoardManager(testerBoard4x4, 67);

        assertEquals(62, testerBoardManager4x4.countInversions(tiles4x4));

    }

    @Test
    public void testCountInversions5x5(){
        List<Tile> tiles5x5 = new ArrayList<>();
        tiles5x5.add(new Tile(0, "5x5"));
        tiles5x5.add(new Tile(1, "5x5"));
        tiles5x5.add(new Tile(2, "5x5"));
        tiles5x5.add(new Tile(3, "5x5"));
        tiles5x5.add(new Tile(23, "5x5"));
        tiles5x5.add(new Tile(4, "5x5"));
        tiles5x5.add(new Tile(5, "5x5"));
        tiles5x5.add(new Tile(6, "5x5"));
        tiles5x5.add(new Tile(7, "5x5"));
        tiles5x5.add(new Tile(8, "5x5"));
        tiles5x5.add(new Tile(9, "5x5"));
        tiles5x5.add(new Tile(24, "5x5"));
        tiles5x5.add(new Tile(10, "5x5"));
        tiles5x5.add(new Tile(11, "5x5"));
        tiles5x5.add(new Tile(17, "5x5"));
        tiles5x5.add(new Tile(12, "5x5"));
        tiles5x5.add(new Tile(13, "5x5"));
        tiles5x5.add(new Tile(14, "5x5"));
        tiles5x5.add(new Tile(15, "5x5"));
        tiles5x5.add(new Tile(16, "5x5"));
        tiles5x5.add(new Tile(18, "5x5"));
        tiles5x5.add(new Tile(19, "5x5"));
        tiles5x5.add(new Tile(20, "5x5"));
        tiles5x5.add(new Tile(21, "5x5"));
        tiles5x5.add(new Tile(22, "5x5"));
        Board testerBoard5x5 = new Board(tiles5x5);
        BoardManager testerBoardManager5x5 = new BoardManager(testerBoard5x5, 10);

        assertEquals(24, testerBoardManager5x5.countInversions(tiles5x5));

    }

    //-----------------SolvableBoard test--------

    @Test
    public void testSolvableBoard3x3OddSolvable(){
        List<Tile> tiles3x3 = new ArrayList<>();

        tiles3x3.add(new Tile(0, "3x3"));
        tiles3x3.add(new Tile(7, "3x3"));
        tiles3x3.add(new Tile(1, "3x3"));
        tiles3x3.add(new Tile(8, "3x3"));
        tiles3x3.add(new Tile(3, "3x3"));
        tiles3x3.add(new Tile(2, "3x3"));
        tiles3x3.add(new Tile(6, "3x3"));
        tiles3x3.add(new Tile(5, "3x3"));
        tiles3x3.add(new Tile(4, "3x3"));
        Board testerBoard3x3 = new Board(tiles3x3);
        BoardManager testerBoardManager3x3 = new BoardManager(testerBoard3x3, 100);

        assertEquals(10, testerBoardManager3x3.countInversions(tiles3x3));
        assertEquals(2, testerBoardManager3x3.getBlankTileRow(tiles3x3));
        assertTrue(testerBoardManager3x3.solvableBoard(tiles3x3, 3));
    }

    @Test
    public void testSolvableBoard3x3OddUnsolvable(){
        List<Tile> tiles3x3 = new ArrayList<>();

        tiles3x3.add(new Tile(0, "3x3"));
        tiles3x3.add(new Tile(1, "3x3"));
        tiles3x3.add(new Tile(2, "3x3"));
        tiles3x3.add(new Tile(3, "3x3"));
        tiles3x3.add(new Tile(4, "3x3"));
        tiles3x3.add(new Tile(7, "3x3"));
        tiles3x3.add(new Tile(6, "3x3"));
        tiles3x3.add(new Tile(5, "3x3"));
        tiles3x3.add(new Tile(8, "3x3"));
        Board testerBoard3x3 = new Board(tiles3x3);
        BoardManager testerBoardManager3x3 = new BoardManager(testerBoard3x3, 100);

        assertEquals(3, testerBoardManager3x3.countInversions(tiles3x3));
        assertEquals(1, testerBoardManager3x3.getBlankTileRow(tiles3x3));
        assertFalse(testerBoardManager3x3.solvableBoard(tiles3x3, 3));
    }

    @Test
    public void testSolvableBoard4x4EvenUnsolvable() {
        List<Tile> tiles4x4 = new ArrayList<>();

        tiles4x4.add(new Tile(2, "4x4"));
        tiles4x4.add(new Tile(8, "4x4"));
        tiles4x4.add(new Tile(0, "4x4"));
        tiles4x4.add(new Tile(14, "4x4"));
        tiles4x4.add(new Tile(13, "4x4"));
        tiles4x4.add(new Tile(10, "4x4"));
        tiles4x4.add(new Tile(3, "4x4"));
        tiles4x4.add(new Tile(5, "4x4"));
        tiles4x4.add(new Tile(12, "4x4"));
        tiles4x4.add(new Tile(15, "4x4"));
        tiles4x4.add(new Tile(9, "4x4"));
        tiles4x4.add(new Tile(11, "4x4"));
        tiles4x4.add(new Tile(1, "4x4"));
        tiles4x4.add(new Tile(6, "4x4"));
        tiles4x4.add(new Tile(7, "4x4"));
        tiles4x4.add(new Tile(4, "4x4"));
        Board testerBoard4x4 = new Board(tiles4x4);
        BoardManager testerBoardManager4x4 = new BoardManager(testerBoard4x4, 67);

        assertEquals(56, testerBoardManager4x4.countInversions(tiles4x4));
        assertEquals(2, testerBoardManager4x4.getBlankTileRow(tiles4x4));
        assertFalse(testerBoardManager4x4.solvableBoard(tiles4x4, 4));

    }

    @Test
    public void testSolvableBoard4x4EvenSolvable() {
        List<Tile> tiles4x4 = new ArrayList<>();

        tiles4x4.add(new Tile(12, "4x4"));
        tiles4x4.add(new Tile(1, "4x4"));
        tiles4x4.add(new Tile(9, "4x4"));
        tiles4x4.add(new Tile(2, "4x4"));
        tiles4x4.add(new Tile(0, "4x4"));
        tiles4x4.add(new Tile(11, "4x4"));
        tiles4x4.add(new Tile(7, "4x4"));
        tiles4x4.add(new Tile(3, "4x4"));
        tiles4x4.add(new Tile(4, "4x4"));
        tiles4x4.add(new Tile(15, "4x4"));
        tiles4x4.add(new Tile(8, "4x4"));
        tiles4x4.add(new Tile(5, "4x4"));
        tiles4x4.add(new Tile(14, "4x4"));
        tiles4x4.add(new Tile(13, "4x4"));
        tiles4x4.add(new Tile(10, "4x4"));
        tiles4x4.add(new Tile(6, "4x4"));
        Board testerBoard4x4 = new Board(tiles4x4);
        BoardManager testerBoardManager4x4 = new BoardManager(testerBoard4x4, 67);

        assertEquals(41, testerBoardManager4x4.countInversions(tiles4x4));
        assertEquals(2, testerBoardManager4x4.getBlankTileRow(tiles4x4));
        assertTrue(testerBoardManager4x4.solvableBoard(tiles4x4, 4));
    }

    }

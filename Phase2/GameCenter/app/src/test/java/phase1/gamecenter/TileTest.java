package phase1.gamecenter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TileTest {
    Tile testingTile = new Tile(4,3);
    Tile testingTile2 = new Tile(5,4);


    @Test
    public void testGetBackground() {
        assertEquals(3, testingTile.getBackground());
    }

    @Test
    public void testGetId() {
        assertEquals(4, testingTile.getId());
    }

    @Test
    public void testCompareTo(){
        assertEquals(1, testingTile.compareTo(testingTile2));
    }

    @Test
    public void testTile1() {
        Tile testerTile = new Tile(0, "3x3");
        assertEquals(1, testerTile.getId());
    }

    @Test
    public void testTile2() {
        Tile testerTile = new Tile(1, "3x3");
        assertEquals(2, testerTile.getId());
    }

    @Test
    public void testTile3() {
        Tile testerTile = new Tile(2, "3x3");
        assertEquals(3, testerTile.getId());
    }

    @Test
    public void testTile4() {
        Tile testerTile = new Tile(3, "3x3");
        assertEquals(4, testerTile.getId());
    }

    @Test
    public void testTile5() {
        Tile testerTile = new Tile(4, "3x3");
        assertEquals(5, testerTile.getId());
    }

    @Test
    public void testTile6() {
        Tile testerTile = new Tile(5, "3x3");
        assertEquals(6, testerTile.getId());
    }

    @Test
    public void testTile7() {
        Tile testerTile = new Tile(6, "3x3");
        assertEquals(7, testerTile.getId());
    }

    @Test
    public void testTile8() {
        Tile testerTile = new Tile(7, "3x3");
        assertEquals(8, testerTile.getId());
    }

    @Test
    public void testTile9() {
        Tile testerTile = new Tile(8, "3x3");
        assertEquals(9, testerTile.getId());
    }

    @Test
    public void testTile9_2() {
        Tile testerTile = new Tile(8, "4x4");
        assertEquals(9, testerTile.getId());
    }

    @Test
    public void testTile10() {
        Tile testerTile = new Tile(9, "4x4");
        assertEquals(10, testerTile.getId());
    }

    @Test
    public void testTile11() {
        Tile testerTile = new Tile(10, "4x4");
        assertEquals(11, testerTile.getId());
    }

    @Test
    public void testTile12() {
        Tile testerTile = new Tile(11, "4x4");
        assertEquals(12, testerTile.getId());
    }

    @Test
    public void testTile13() {
        Tile testerTile = new Tile(12, "4x4");
        assertEquals(13, testerTile.getId());
    }

    @Test
    public void testTile14() {
        Tile testerTile = new Tile(13, "4x4");
        assertEquals(14, testerTile.getId());
    }

    @Test
    public void testTile15() {
        Tile testerTile = new Tile(14, "4x4");
        assertEquals(15, testerTile.getId());
    }

    @Test
    public void testTile16() {
        Tile testerTile = new Tile(15, "4x4");
        assertEquals(16, testerTile.getId());
    }

    @Test
    public void testTile16_2() {
        Tile testerTile = new Tile(15, "5x5");
        assertEquals(16, testerTile.getId());
    }

    @Test
    public void testTile17() {
        Tile testerTile = new Tile(16, "4x4");
        assertEquals(17, testerTile.getId());
    }
    @Test
    public void testTile18() {
        Tile testerTile = new Tile(17, "5x5");
        assertEquals(18, testerTile.getId());
    }
    @Test
    public void testTile19() {
        Tile testerTile = new Tile(18, "5x5");
        assertEquals(19, testerTile.getId());
    }

    @Test
    public void testTile20() {
        Tile testerTile = new Tile(19, "5x5");
        assertEquals(20, testerTile.getId());
    }

    @Test
    public void testTile21() {
        Tile testerTile = new Tile(20, "5x5");
        assertEquals(21, testerTile.getId());
    }

    @Test
    public void testTile22() {
        Tile testerTile = new Tile(21, "5x5");
        assertEquals(22, testerTile.getId());
    }

    @Test
    public void testTile23() {
        Tile testerTile = new Tile(22, "5x5");
        assertEquals(23, testerTile.getId());
    }

    @Test
    public void testTile24() {
        Tile testerTile = new Tile(23, "5x5");
        assertEquals(24, testerTile.getId());
    }

    @Test
    public void testTile25() {
        Tile testerTile = new Tile(24, "5x5");
        assertEquals(25, testerTile.getId());
    }

    @Test
    public void testTileEmptyConstructor() {
        Tile testerTile = new Tile();
        assertEquals(0, testerTile.getId());
    }

    @Test
    public void testTileEmptyConstructor2() {
        Tile testerTile = new Tile(-1, "3x3");
        assertEquals(0, testerTile.getId());
    }

}

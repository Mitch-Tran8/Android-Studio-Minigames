package phase1.gamecenter.slidingtiles;
import org.junit.Test;

import phase1.gamecenter.slidingtiles.NumberTile;

import static org.junit.Assert.assertEquals;

public class NumberTileTest {
    NumberTile testingNumberTile = new NumberTile(4,3);
    NumberTile testingNumberTile2 = new NumberTile(5,4);


    @Test
    public void testGetBackground() {
        assertEquals(3, testingNumberTile.getBackground());
    }

    @Test
    public void testGetId() {
        assertEquals(4, testingNumberTile.getId());
    }

    @Test
    public void testCompareTo(){
        assertEquals(1, testingNumberTile.compareTo(testingNumberTile2));
    }

    @Test
    public void testTile1() {
        NumberTile testerNumberTile = new NumberTile(0, "3x3");
        assertEquals(1, testerNumberTile.getId());
    }

    @Test
    public void testTile2() {
        NumberTile testerNumberTile = new NumberTile(1, "3x3");
        assertEquals(2, testerNumberTile.getId());
    }

    @Test
    public void testTile3() {
        NumberTile testerNumberTile = new NumberTile(2, "3x3");
        assertEquals(3, testerNumberTile.getId());
    }

    @Test
    public void testTile4() {
        NumberTile testerNumberTile = new NumberTile(3, "3x3");
        assertEquals(4, testerNumberTile.getId());
    }

    @Test
    public void testTile5() {
        NumberTile testerNumberTile = new NumberTile(4, "3x3");
        assertEquals(5, testerNumberTile.getId());
    }

    @Test
    public void testTile6() {
        NumberTile testerNumberTile = new NumberTile(5, "3x3");
        assertEquals(6, testerNumberTile.getId());
    }

    @Test
    public void testTile7() {
        NumberTile testerNumberTile = new NumberTile(6, "3x3");
        assertEquals(7, testerNumberTile.getId());
    }

    @Test
    public void testTile8() {
        NumberTile testerNumberTile = new NumberTile(7, "3x3");
        assertEquals(8, testerNumberTile.getId());
    }

    @Test
    public void testTile9() {
        NumberTile testerNumberTile = new NumberTile(8, "3x3");
        assertEquals(9, testerNumberTile.getId());
    }

    @Test
    public void testTile9_2() {
        NumberTile testerNumberTile = new NumberTile(8, "4x4");
        assertEquals(9, testerNumberTile.getId());
    }

    @Test
    public void testTile10() {
        NumberTile testerNumberTile = new NumberTile(9, "4x4");
        assertEquals(10, testerNumberTile.getId());
    }

    @Test
    public void testTile11() {
        NumberTile testerNumberTile = new NumberTile(10, "4x4");
        assertEquals(11, testerNumberTile.getId());
    }

    @Test
    public void testTile12() {
        NumberTile testerNumberTile = new NumberTile(11, "4x4");
        assertEquals(12, testerNumberTile.getId());
    }

    @Test
    public void testTile13() {
        NumberTile testerNumberTile = new NumberTile(12, "4x4");
        assertEquals(13, testerNumberTile.getId());
    }

    @Test
    public void testTile14() {
        NumberTile testerNumberTile = new NumberTile(13, "4x4");
        assertEquals(14, testerNumberTile.getId());
    }

    @Test
    public void testTile15() {
        NumberTile testerNumberTile = new NumberTile(14, "4x4");
        assertEquals(15, testerNumberTile.getId());
    }

    @Test
    public void testTile16() {
        NumberTile testerNumberTile = new NumberTile(15, "4x4");
        assertEquals(16, testerNumberTile.getId());
    }

    @Test
    public void testTile16_2() {
        NumberTile testerNumberTile = new NumberTile(15, "5x5");
        assertEquals(16, testerNumberTile.getId());
    }

    @Test
    public void testTile17() {
        NumberTile testerNumberTile = new NumberTile(16, "4x4");
        assertEquals(17, testerNumberTile.getId());
    }
    @Test
    public void testTile18() {
        NumberTile testerNumberTile = new NumberTile(17, "5x5");
        assertEquals(18, testerNumberTile.getId());
    }
    @Test
    public void testTile19() {
        NumberTile testerNumberTile = new NumberTile(18, "5x5");
        assertEquals(19, testerNumberTile.getId());
    }

    @Test
    public void testTile20() {
        NumberTile testerNumberTile = new NumberTile(19, "5x5");
        assertEquals(20, testerNumberTile.getId());
    }

    @Test
    public void testTile21() {
        NumberTile testerNumberTile = new NumberTile(20, "5x5");
        assertEquals(21, testerNumberTile.getId());
    }

    @Test
    public void testTile22() {
        NumberTile testerNumberTile = new NumberTile(21, "5x5");
        assertEquals(22, testerNumberTile.getId());
    }

    @Test
    public void testTile23() {
        NumberTile testerNumberTile = new NumberTile(22, "5x5");
        assertEquals(23, testerNumberTile.getId());
    }

    @Test
    public void testTile24() {
        NumberTile testerNumberTile = new NumberTile(23, "5x5");
        assertEquals(24, testerNumberTile.getId());
    }

    @Test
    public void testTile25() {
        NumberTile testerNumberTile = new NumberTile(24, "5x5");
        assertEquals(25, testerNumberTile.getId());
    }

    @Test
    public void testTileEmptyConstructor() {
        NumberTile testerNumberTile = new NumberTile();
        assertEquals(0, testerNumberTile.getId());
    }

    @Test
    public void testTileEmptyConstructor2() {
        NumberTile testerNumberTile = new NumberTile(-1, "3x3");
        assertEquals(0, testerNumberTile.getId());
    }

}

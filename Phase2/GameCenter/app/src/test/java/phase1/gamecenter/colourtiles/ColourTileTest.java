package phase1.gamecenter.colourtiles;

import org.junit.Test;

import phase1.gamecenter.colourtiles.ColourTile;
import phase1.gamecenter.slidingtiles.NumberTile;

import static org.junit.Assert.assertEquals;

public class ColourTileTest {

   ColourTile testingTile = new ColourTile(4, 3);
   ColourTile testingTile2 = new ColourTile(5, 4);
   ColourTile testingTile3 = new ColourTile(10, 10);

    @Test
    public void testGetBackground_3() {
        assertEquals(3, testingTile.getBackground());
    }

    @Test
    public void testGetBackground_4() {
        assertEquals(10, testingTile3.getBackground());
    }

    @Test
    public void testGetId() {
        assertEquals(4, testingTile.getId());
    }

    @Test
    public void testCompareTo() {
        assertEquals(1, testingTile.compareTo(testingTile2));
    }

    @Test
    public void testTile10() {
        ColourTile testerTile = new ColourTile(10);
        assertEquals(10, testerTile.getId());
    }

    @Test
    public void testTile11() {
        ColourTile testerTile = new ColourTile(11);
        assertEquals(11, testerTile.getId());
    }

    @Test
    public void testTile12() {
        ColourTile testerTile = new ColourTile(12);
        assertEquals(12, testerTile.getId());
    }

    @Test
    public void testTile13() {
        ColourTile testerTile = new ColourTile(13);
        assertEquals(13, testerTile.getId());
    }

    @Test
    public void testTile14() {
        ColourTile testerTile = new ColourTile(14);
        assertEquals(14, testerTile.getId());
    }

    @Test
    public void testTile15() {
        ColourTile testerTile = new ColourTile(15);
        assertEquals(15, testerTile.getId());
    }

    @Test
    public void testTile16() {
        ColourTile testerTile = new ColourTile(16);
        assertEquals(16, testerTile.getId());
    }

    @Test
    public void testTile17() {
        ColourTile testerTile = new ColourTile(17);
        assertEquals(17, testerTile.getId());
    }

    @Test
    public void testTile18() {
        ColourTile testerTile = new ColourTile(18);
        assertEquals(18, testerTile.getId());
    }

    @Test
    public void testTile19() {
        ColourTile testerTile = new ColourTile(19);
        assertEquals(19, testerTile.getId());
    }

    @Test
    public void testTile20() {
        ColourTile testerTile = new ColourTile(20);
        assertEquals(20, testerTile.getId());
    }

    @Test
    public void testTile21() {
        ColourTile testerTile = new ColourTile(21);
        assertEquals(21, testerTile.getId());
    }

    @Test
    public void testTile22() {
        ColourTile testerTile = new ColourTile(22);
        assertEquals(22, testerTile.getId());
    }

    @Test
    public void testTile23() {
        ColourTile testerTile = new ColourTile(23);
        assertEquals(23, testerTile.getId());
    }

    @Test
    public void testTile24() {
        ColourTile testerTile = new ColourTile(24);
        assertEquals(24, testerTile.getId());
    }

    @Test
    public void testTile25() {
        ColourTile testerTile = new ColourTile(25);
        assertEquals(25, testerTile.getId());
    }
}

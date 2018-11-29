package phase1.gamecenter.matched;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatchedTileTest {

   MatchedTile testingTile = new MatchedTile(4, 3);
   MatchedTile testingTile2 = new MatchedTile(5, 4);
   MatchedTile testingTile3 = new MatchedTile(10, 10);

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
        MatchedTile testerTile = new MatchedTile(10);
        assertEquals(10, testerTile.getId());
    }

    @Test
    public void testTile11() {
        MatchedTile testerTile = new MatchedTile(11);
        assertEquals(11, testerTile.getId());
    }

    @Test
    public void testTile12() {
        MatchedTile testerTile = new MatchedTile(12);
        assertEquals(12, testerTile.getId());
    }

    @Test
    public void testTile13() {
        MatchedTile testerTile = new MatchedTile(13);
        assertEquals(13, testerTile.getId());
    }

    @Test
    public void testTile14() {
        MatchedTile testerTile = new MatchedTile(14);
        assertEquals(14, testerTile.getId());
    }

    @Test
    public void testTile15() {
        MatchedTile testerTile = new MatchedTile(15);
        assertEquals(15, testerTile.getId());
    }

    @Test
    public void testTile16() {
        MatchedTile testerTile = new MatchedTile(16);
        assertEquals(16, testerTile.getId());
    }

    @Test
    public void testTile17() {
        MatchedTile testerTile = new MatchedTile(17);
        assertEquals(17, testerTile.getId());
    }

    @Test
    public void testTile18() {
        MatchedTile testerTile = new MatchedTile(18);
        assertEquals(18, testerTile.getId());
    }

    @Test
    public void testTile19() {
        MatchedTile testerTile = new MatchedTile(19);
        assertEquals(19, testerTile.getId());
    }

    @Test
    public void testTile20() {
        MatchedTile testerTile = new MatchedTile(20);
        assertEquals(20, testerTile.getId());
    }

    @Test
    public void testTile21() {
        MatchedTile testerTile = new MatchedTile(21);
        assertEquals(21, testerTile.getId());
    }

    @Test
    public void testTile22() {
        MatchedTile testerTile = new MatchedTile(22);
        assertEquals(22, testerTile.getId());
    }

    @Test
    public void testTile23() {
        MatchedTile testerTile = new MatchedTile(23);
        assertEquals(23, testerTile.getId());
    }

    @Test
    public void testTile24() {
        MatchedTile testerTile = new MatchedTile(24);
        assertEquals(24, testerTile.getId());
    }

    @Test
    public void testTile25() {
        MatchedTile testerTile = new MatchedTile(25);
        assertEquals(25, testerTile.getId());
    }
}

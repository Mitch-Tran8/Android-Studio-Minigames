package phase1.gamecenter;

import org.junit.Test;

import phase1.gamecenter.colourtiles.ColourTile;

import static org.junit.Assert.assertEquals;

public class ColorNumberTileTest {

   ColourTile testingTile = new ColourTile(4, 3);
   ColourTile testingTile2 = new ColourTile(5, 4);

    @Test
    public void testGetBackground() {
        assertEquals(3, testingTile.getBackground());
    }

    @Test
    public void testGetId() {
        assertEquals(4, testingTile.getId());
    }

    @Test
    public void testCompareTo() {
        assertEquals(1, testingTile.compareTo(testingTile2));
    }
}

package phase1.gamecenter;

import org.junit.Test;

import phase1.gamecenter.colourtiles.ColourTile;

import static org.junit.Assert.assertEquals;

public class ColorNumberTileTest {

   ColourTile testingTile = new ColourTile(4, 3);
   ColourTile testingTile2 = new ColourTile(5, 4);
   ColourTile testingTile3 = new ColourTile(50, 49);

    @Test
    public void testGetBackground() {

        assertEquals(3, testingTile.getBackground());
        assertEquals(49, testingTile3.getBackground());
    }

    @Test
    public void testGetId() {

        assertEquals(4, testingTile.getId());
        assertEquals(50, testingTile3.getId());
    }

    @Test
    public void testCompareTo() {

        assertEquals(1, testingTile.compareTo(testingTile2));
        assertEquals(-46, testingTile3.compareTo(testingTile));
    }



}

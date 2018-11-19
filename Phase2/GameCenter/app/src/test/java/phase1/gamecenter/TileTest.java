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


}

package phase1.gamecenter.interfaces;
import java.io.Serializable;

/**
 * a tile interface
 */
public interface Tile extends Comparable, Serializable {

    /**
     * returns a tile's id
     * @return a tile's id
     */
    int getId();

    /**
     * returns a tile's background
     * @return a tile's background
     */
    int getBackground();
}

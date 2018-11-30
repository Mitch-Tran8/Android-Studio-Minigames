package phase1.gamecenter.interfaces;
import java.io.Serializable;

/**
 * a board interface
 */
public interface Board extends Serializable, Iterable{

    void swapTiles(int row, int col, int row1, int col1);
}

package phase1.gamecenter;
import java.io.Serializable;

public interface Board extends Serializable, Iterable{

    void swapTiles(int row, int col, int row1, int col1);
}

package phase1.gamecenter.interfaces;

import java.io.Serializable;

/**
 * a board manager interface
 */
public interface BoardManager extends Serializable {

    /**
     * checks whether the board is solved
     * @return whether the board is solved
     */
    boolean puzzleSolved();

    /**
     * proceeds the move upon touch
     * @param position the touch position
     */
    void touchMove(int position);

    /**
     * returns whether the position is a valid tap
     * @param position the touch position
     * @return whether the position is a valid tap
     */
    boolean isValidTap(int position);
}

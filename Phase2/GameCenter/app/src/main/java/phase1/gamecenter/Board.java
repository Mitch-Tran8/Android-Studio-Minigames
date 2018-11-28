package phase1.gamecenter;

import java.util.Observable;

/**
 * a board. the abstract class for SlidingTileBoard and ColourBoard.
 */
public abstract class Board extends Observable {

    /**
     * The number of rows.
     */
    private int NUM_ROWS;

    /**
     * The number of rows.
     */
    private int NUM_COLS;

    public Board(){
    }


}

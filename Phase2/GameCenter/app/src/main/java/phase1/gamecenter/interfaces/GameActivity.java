package phase1.gamecenter.interfaces;

import android.content.Context;

import java.io.Serializable;
import java.util.Observer;

/**
 * the game activity interface.
 */
public interface GameActivity extends Observer, Serializable {

    /**
     * Set up the background image for each button based on the master list
     * of positions, and then call the adapter to set the view.
     */
    void display();

    /**
     * Create the buttons for displaying the tiles.
     * @param context the context
     */
    void createTileButtons(Context context);

    /**
     * Update the backgrounds on the buttons to match the tiles.
     */
    void updateTileButtons();
}

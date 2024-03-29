package phase1.gamecenter;

import android.content.Context;
import android.widget.Toast;

import phase1.gamecenter.matched.MatchedBoardManager;
import phase1.gamecenter.slidingtiles.SlidingTileBoardManager;

/**
 * Controls movements on SlidingTileBoardManager
 */
class MovementController {

    /**
     * The SlidingTileBoardManager that MovementController is controlling.
     */
    private SlidingTileBoardManager slidingTileBoardManager = null;
    private MatchedBoardManager matchedBoardManager = null;

    /**
     * The MovementController
     */
    MovementController() {
    }

    /**
     * Set the slidingTileBoardManager that MovementController is acting upon.
     *
     * @param slidingTileBoardManager the slidingTileBoardManager being controlled
     */
    void setSlidingTileBoardManager(SlidingTileBoardManager slidingTileBoardManager) {
        this.slidingTileBoardManager = slidingTileBoardManager;
    }

    void setBoardManager(MatchedBoardManager boardManager) {
        this.matchedBoardManager = boardManager;
    }

    /**
     * Processing a tap movement.
     *
     * @param context  the context
     * @param position the position
     */
    void processTapMovement(Context context, int position) {

        // tap movements on the board manager
        if (slidingTileBoardManager != null) {
            if (slidingTileBoardManager.isValidTap(position)) {
                slidingTileBoardManager.touchMove(position);
                if (slidingTileBoardManager.puzzleSolved()) {
                    String score = Integer.toString(slidingTileBoardManager.getScore());
                    Toast.makeText(context, "YOU WIN! Your score is: " + score, Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(context, "Invalid Tap", Toast.LENGTH_SHORT).show();
            }
        }

        // tap movements on the colourboard manager
        else {

            if (matchedBoardManager.hasFirstTap()) {
                if (matchedBoardManager.isValidTap(position)) {
                    matchedBoardManager.touchMove(position);

                    if (matchedBoardManager.puzzleSolved()) {
                        Toast toast = Toast.makeText(context, "It's a match!", Toast.LENGTH_LONG);
                        toast.setGravity(0, 50, 50);
                        toast.show();
                    }
                    matchedBoardManager.setFirstTap(0);
                } else {
                    Toast.makeText(context, "Invalid Tap", Toast.LENGTH_SHORT).show();
                    matchedBoardManager.setFirstTap(0);
                }

            } else {
                matchedBoardManager.setFirstTap(position);
                Toast.makeText(context, "Select a tile to swap", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
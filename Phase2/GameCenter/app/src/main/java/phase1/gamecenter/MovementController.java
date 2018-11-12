
package phase1.gamecenter;

import android.content.Context;
import android.widget.Toast;

/**
 * Controls movements on BoardManager
 */
public class MovementController {

    /**
     * The BoardManager that MovementController is controlling.
     */
    private BoardManager boardManager = null;

    /**
     * The MovementController
     */
    public MovementController() {
    }

    /**
     * Set the boardManager that MovementController is acting upon.
     * @param boardManager the boardManager being controlled
     */
    public void setBoardManager(BoardManager boardManager) {
        this.boardManager = boardManager;
    }

    /**
     * Processing a tap movement.
     * @param context
     * @param position
     * @param display
     */
    public void processTapMovement(Context context, int position, boolean display) {
        if (boardManager.isValidTap(position)) {
            boardManager.touchMove(position);
            if (boardManager.puzzleSolved()) {
                String score = Integer.toString(boardManager.getScore());
                Toast.makeText(context, "YOU WIN! Score: " + score, Toast.LENGTH_LONG).show();
                //gameActivity.switchToMain();

            }
        } else {
            Toast.makeText(context, "Invalid Tap", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Undoing a move.
     */
    public void processUndoMovement(Context context){
        if (boardManager.isValidUndo()){
            boardManager.undo();

        }
    }

}
package phase1.gamecenter;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Controls movements on BoardManager
 */
public class MovementController {

    /**
     * The BoardManager that MovementController is controlling.
     */
    private BoardManager boardManager = null;
    private ColourBoardManager colourBoardManager = null;

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
    public void setBoardManager(ColourBoardManager boardManager) {
        this.colourBoardManager = boardManager;
    }

    /**
     * Processing a tap movement.
     * @param context
     * @param position
     * @param display
     */
    public void processTapMovement(Context context, int position, boolean display) {

        // tap movements on the board manager
        if(boardManager != null) {
            if (boardManager.isValidTap(position)) {
                boardManager.touchMove(position);
                if (boardManager.puzzleSolved()) {
                    String score = Integer.toString(boardManager.getScore());
                    Toast.makeText(context, "YOU WIN! Your score is: " + score, Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(context, "Invalid Tap", Toast.LENGTH_SHORT).show();
            }
        }

        // tap movements on the colourboard manager
        else {

            if (colourBoardManager.hasFirstTap()) {
                if (colourBoardManager.isValidTap(position)){
                    colourBoardManager.touchMove(position);

                    if (colourBoardManager.puzzleSolved()) {
//                        colourBoardManager.addNewTiles();
//                        String score = Integer.toString(colourBoardManager.getScore());

                        Toast toast = Toast.makeText(context, "It's a match!", Toast.LENGTH_LONG);
                        toast.setGravity(0,50,50);
                        toast.show();
                    }
                    colourBoardManager.setFirstTap(0);
                    }
                else {
                    Toast.makeText(context, "Invalid Tap", Toast.LENGTH_SHORT).show();
                    colourBoardManager.setFirstTap(0);
                }

            } else {
                colourBoardManager.setFirstTap(position);
                Toast.makeText(context, "Select a tile to swap", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
package phase1.gamecenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SetMaxUndoMoves extends AppCompatActivity {

    /**
     * the button to confirm user's desired undo moves
     */
    Button desiredUndo;

    /**
     * the button to confirm the user would like unlimited undo moves - until the initial game
     * state is reached
     */
    Button unlimitedUndo;

    /**
     * the board manager
     */
    BoardManager boardManager;

    /**
     * The email as typed in by user
     */
    private EditText undoMovesField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_max_undo_moves);
        desiredUndo = findViewById(R.id.go_to_desired_maxUndo);
        unlimitedUndo = findViewById(R.id.unlimited_undo);
        undoMovesField = findViewById(R.id.desired_maxUndo);

        /**
         * activate login button
         * let user know if task was succesful or not
         * if it is, take to game page. If not, try again.
         */
        desiredUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int undoTemp = Integer.parseInt(undoMovesField.getText().toString());
            }
        });
    }
}

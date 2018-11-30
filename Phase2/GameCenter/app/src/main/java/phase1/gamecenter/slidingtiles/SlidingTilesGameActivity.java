package phase1.gamecenter.slidingtiles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Observable;

import phase1.gamecenter.CustomAdapter;
import phase1.gamecenter.FileManager;
import phase1.gamecenter.interfaces.GameActivity;
import phase1.gamecenter.GestureDetectGridView;
import phase1.gamecenter.R;

/**
 * The game activity.
 */
public class SlidingTilesGameActivity extends FileManager implements GameActivity {

    /**
     * The board manager.
     */
    private SlidingTileBoardManager slidingTileBoardManager;

    /**
     * The buttons to display.
     */
    private ArrayList<Button> tileButtons;


    /**
     * Grid View and calculated column height and width based on device size
     */
    private GestureDetectGridView gridView;

    /**
     * the column width and height
     */
    private static int columnWidth, columnHeight;

    /**
     * Set up the background image for each button based on the master list
     * of positions, and then call the adapter to set the view.
     */
    public void display() {
        updateTileButtons();
        gridView.setAdapter(new CustomAdapter(tileButtons, columnWidth, columnHeight));
    }

    /**
     * saves the game every 3 moves
     */

    public void autoSave() {
        int numMoves = slidingTileBoardManager.getNumOfMoves();
        if (numMoves % 3 == 0) {
            saveToFile(BoardComplexity.TEMP_SAVE_FILENAME, slidingTileBoardManager);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        slidingTileBoardManager = loadFromFileSlidingTiles(BoardComplexity.TEMP_SAVE_FILENAME);
        createTileButtons(this);
        setContentView(R.layout.activity_main);
        addUndoButtonListener();
        addSaveButtonListener();


        // Add View to activity
        gridView = findViewById(R.id.grid);
        gridView.setNumColumns(slidingTileBoardManager.getColumns());
        gridView.setSlidingTileBoardManager(slidingTileBoardManager);
        slidingTileBoardManager.getSlidingTilesBoard().addObserver(this);

        // Observer sets up desired dimensions as well as calls our display function
        gridView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        gridView.getViewTreeObserver().removeOnGlobalLayoutListener(
                                this);
                        int displayWidth = gridView.getMeasuredWidth();
                        int displayHeight = gridView.getMeasuredHeight();

                        columnWidth = displayWidth / slidingTileBoardManager.getColumns();
                        columnHeight = displayHeight / slidingTileBoardManager.getRows();

                        display();
                    }
                });
    }

    /**
     * Activate the undo button.
     */
    private void addUndoButtonListener() {
        Button undoButton = findViewById(R.id.undoButton);

        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (slidingTileBoardManager.isValidUndo()) {
                    slidingTileBoardManager.undo();
                    Toast.makeText(SlidingTilesGameActivity.this, "Undo Succesful", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SlidingTilesGameActivity.this, "Maximum undo moves reached", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Activate the save button
     */
    public void addSaveButtonListener() {
        Button saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFile(BoardComplexity.TEMP_SAVE_FILENAME, slidingTileBoardManager);
                Toast.makeText(SlidingTilesGameActivity.this, "Succesfully saved", Toast.LENGTH_LONG).show();

            }
        });
    }

    /**
     * Create the buttons for displaying the tiles.
     *
     * @param context the context
     */
    public void createTileButtons(Context context) {
        SlidingTilesBoard slidingTilesBoard = slidingTileBoardManager.getSlidingTilesBoard();
        tileButtons = new ArrayList<>();
        for (int row = 0; row != slidingTileBoardManager.getRows(); row++) {
            for (int col = 0; col != slidingTileBoardManager.getColumns(); col++) {
                Button tmp = new Button(context);
                tmp.setBackgroundResource(slidingTilesBoard.getTile(row, col).getBackground());
                this.tileButtons.add(tmp);
            }
        }
    }

    /**
     * Update the backgrounds on the buttons to match the tiles.
     */
    public void updateTileButtons() {
        SlidingTilesBoard slidingTilesBoard = slidingTileBoardManager.getSlidingTilesBoard();
        int nextPos = 0;
        for (Button b : tileButtons) {
            int row = nextPos / slidingTileBoardManager.getRows();
            int col = nextPos % slidingTileBoardManager.getColumns();
            b.setBackgroundResource(slidingTilesBoard.getTile(row, col).getBackground());
            nextPos++;
        }
        autoSave();
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        saveToFile(BoardComplexity.TEMP_SAVE_FILENAME, slidingTileBoardManager);
    }

    @Override
    public void update(Observable o, Object arg) {
        display();
    }

    /**
     * Back button from the game to the main page
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SlidingTilesGameActivity.this, SlidingTileMainPageActivity.class);
        startActivity(intent);
    }
}


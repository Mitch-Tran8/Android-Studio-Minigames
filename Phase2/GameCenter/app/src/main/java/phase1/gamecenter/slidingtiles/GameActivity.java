package phase1.gamecenter.slidingtiles;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import phase1.gamecenter.CustomAdapter;
import phase1.gamecenter.GestureDetectGridView;
import phase1.gamecenter.R;
import phase1.gamecenter.SlidingTileMainPageActivity;


/**
 * The game activity.
 */
public class  GameActivity extends AppCompatActivity implements Observer, Serializable {

    /**
     * The board manager.
     */
    private SlidingTileBoardManager slidingTileBoardManager;

    /**
     * The buttons to display.
     */
    private ArrayList<Button> tileButtons;


    // Grid View and calculated column height and width based on device size
    private GestureDetectGridView gridView;
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

    public void autoSave(){
        int numMoves = slidingTileBoardManager.getNumOfMoves();
        if(numMoves %3 ==0){
            saveToFile(BoardComplexity.TEMP_SAVE_FILENAME);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadFromFile(BoardComplexity.TEMP_SAVE_FILENAME);
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
                    Toast.makeText(GameActivity.this, "Undo Succesful", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(GameActivity.this, "Maximum undo moves reached", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Activate the save button
     */
    private void addSaveButtonListener() {
        Button saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFile(BoardComplexity.TEMP_SAVE_FILENAME);
                Toast.makeText(GameActivity.this, "Succesfully saved", Toast.LENGTH_LONG).show();

            }
        });
    }

    /**
     * Create the buttons for displaying the tiles.
     *
     * @param context the context
     */
    private void createTileButtons(Context context) {
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
    private void updateTileButtons() {
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
        saveToFile(BoardComplexity.TEMP_SAVE_FILENAME);
    }

    /**
     * Load the board manager from fileName.
     *
     * @param fileName the name of the file
     */
    private void loadFromFile(String fileName) {

        try {
            InputStream inputStream = this.openFileInput(fileName);
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                slidingTileBoardManager = (SlidingTileBoardManager) input.readObject();

                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("login activity", "File contained unexpected data type: " + e.toString());
        }
    }

    /**
     * Save the board manager to fileName.
     *
     * @param fileName the name of the file
     */
    public void saveToFile(String fileName) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    this.openFileOutput(fileName, MODE_PRIVATE));
            outputStream.writeObject(slidingTileBoardManager);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
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
        Intent intent = new Intent(GameActivity.this, SlidingTileMainPageActivity.class);
        startActivity(intent);
}}


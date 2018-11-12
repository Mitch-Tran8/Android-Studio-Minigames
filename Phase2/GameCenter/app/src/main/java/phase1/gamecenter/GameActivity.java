package phase1.gamecenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


/**
 * The game activity.
 */
public class GameActivity extends AppCompatActivity implements Observer, Serializable {

    /**
     * The board manager.
     */
    private phase1.gamecenter.BoardManager boardManager;

    /**
     * The buttons to display.
     */
    private ArrayList<Button> tileButtons;

    /**
     * The current user's Id
     */
    private String user_id;

    /**
     * Firebase auth
     */
    private FirebaseAuth mAuth;

    /**
     * Firebase database
     */
    private DatabaseReference databaseReference;

    /**
     * current user's most recent gamestate
     */
    private String gameState;

    public SlidingTileMainPageActivity slidingTileMainPageActivity;

    public EmailAndScore emailAndScore;

    public static ArrayList<EmailAndScore> saveList = new ArrayList<>();

    /**
     * Constants for swiping directions. Should be an enum, probably.
     */
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;

    /**
     * Save button
     */
    private Button saveButton;


    // Grid View and calculated column height and width based on device size
    private GestureDetectGridView gridView;
    private static int columnWidth, columnHeight;

    /**
     * Set up the background image for each button based on the master list
     * of positions, and then call the adapter to set the view.
     */
    // Display
    public void display() {
        updateTileButtons();
        gridView.setAdapter(new CustomAdapter(tileButtons, columnWidth, columnHeight));
    }

    public void autoSave(){
        int numMoves = boardManager.getNumOfMoves();
        if(numMoves %3 ==0){
            saveToFile(BoardComplexity.TEMP_SAVE_FILENAME);
        }
    }

    public GameActivity(){this.saveList = new ArrayList<>();}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        user_id = i.getStringExtra("user_id");
        mAuth = FirebaseAuth.getInstance();

        loadFromFile(BoardComplexity.TEMP_SAVE_FILENAME);
        createTileButtons(this);
        setContentView(R.layout.activity_main);
        addUndoButtonListener();
        addSaveButtonListener();


        // Add View to activity
        gridView = findViewById(R.id.grid);
        gridView.setNumColumns(Board.NUM_COLS);
        gridView.setBoardManager(boardManager);

        boardManager.getBoard().addObserver(this);
        // Observer sets up desired dimensions as well as calls our display function
        gridView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        gridView.getViewTreeObserver().removeOnGlobalLayoutListener(
                                this);
                        int displayWidth = gridView.getMeasuredWidth();
                        int displayHeight = gridView.getMeasuredHeight();

                        columnWidth = displayWidth / Board.NUM_COLS;
                        columnHeight = displayHeight / Board.NUM_ROWS;

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
                if (boardManager.isValidUndo()) {
                    boardManager.undo();
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
        saveButton = findViewById(R.id.save_button);

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
        Board board = boardManager.getBoard();
        tileButtons = new ArrayList<>();
        for (int row = 0; row != Board.NUM_ROWS; row++) {
            for (int col = 0; col != Board.NUM_COLS; col++) {
                Button tmp = new Button(context);
                tmp.setBackgroundResource(board.getTile(row, col).getBackground());
                this.tileButtons.add(tmp);
            }
        }
    }

    /**
     * Update the backgrounds on the buttons to match the tiles.
     */
    private void updateTileButtons() {
        Board board = boardManager.getBoard();
        int nextPos = 0;
        for (Button b : tileButtons) {
            int row = nextPos / Board.NUM_ROWS;
            int col = nextPos % Board.NUM_COLS;
            b.setBackgroundResource(board.getTile(row, col).getBackground());
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
                boardManager = (BoardManager) input.readObject();
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
            outputStream.writeObject(boardManager);
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
     * Save the scores to fileName
     *
     * @param fileName file to save scores to
     */
    public void saveScores(String fileName) {
//        FileOutputStream fos = null;
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(this.openFileOutput(fileName, MODE_PRIVATE));
            out.writeObject(slidingTileMainPageActivity.userList);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Back button from the game to the main page
     */
    @Override
    public void onBackPressed() {
        slidingTileMainPageActivity = new SlidingTileMainPageActivity();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        emailAndScore = new EmailAndScore(firebaseUser.getEmail(), boardManager.getScore());
        this.slidingTileMainPageActivity.userList.add(emailAndScore);

        saveScores(SlidingTileMainPageActivity.FILE_NAME); //SAVE USER AND SCORE TO THE FILE - STATIC SO WILL BE STORED THERE

        Intent intent = new Intent(GameActivity.this, SlidingTileMainPageActivity.class);

        startActivity(intent); //GO TO SLIDING TILE MAIN PAGE
    }
}

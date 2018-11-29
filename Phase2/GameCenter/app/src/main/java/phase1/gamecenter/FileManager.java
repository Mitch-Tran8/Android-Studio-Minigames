package phase1.gamecenter;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import phase1.gamecenter.matched.MatchedBoardManager;
import phase1.gamecenter.slidingtiles.BoardComplexity;
import phase1.gamecenter.slidingtiles.SlidingTileBoardManager;

public abstract class FileManager extends AppCompatActivity {

    /**
     * Load the board manager from fileName.
     *
     */
    protected MatchedBoardManager loadFromFileMatched() {

        try {
            InputStream inputStream = this.openFileInput(phase1.gamecenter.matched.MatchedStartingActivity.TEMP_SAVE_FILENAME);
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                MatchedBoardManager boardManager = (MatchedBoardManager) input.readObject();
                inputStream.close();
                return boardManager;

            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("login activity", "File contained unexpected data type: " + e.toString());
        }
        return null;
    }

    /**
     * Load the board manager from fileName.
     *
     * @param fileName the name of the file
     */
    protected SlidingTileBoardManager loadFromFileSlidingTiles(String fileName) {

        try {
            InputStream inputStream = this.openFileInput(fileName);
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                SlidingTileBoardManager boardManager = (SlidingTileBoardManager) input.readObject();
                inputStream.close();
                return boardManager;

            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("login activity", "File contained unexpected data type: " + e.toString());
        }
        return null;
    }

    /**
     * Save the board manager to fileName.
     *
     * @param fileName the name of the file
     */
    public void saveToFile(String fileName, Object object) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    this.openFileOutput(fileName, MODE_PRIVATE));
            outputStream.writeObject(object);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public int loadRounds(){
        try {
            InputStream inputStream = this.openFileInput("rounds.ser");
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                int rounds = (int) input.readObject();
                inputStream.close();
                return rounds;

            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("login activity", "File contained unexpected data type: " + e.toString());
        }
        return 0;
    }

    /*
     * creates a new file
     */
    protected void createNewFile() throws IOException {
        File file = new File(BoardComplexity.TEMP_SAVE_FILENAME);
        file.createNewFile();
    }

    /*
     * saves rounds
     */
    public void saveRounds(String fileName, int rounds){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    this.openFileOutput(fileName, MODE_PRIVATE));
            outputStream.writeObject(rounds);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}

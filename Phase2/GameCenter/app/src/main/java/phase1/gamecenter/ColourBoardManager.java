package phase1.gamecenter;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.Random;

/**
 * Manage a board, including swapping tiles, checking for a win, and managing taps.
 */
class ColourBoardManager implements Serializable {

    /**
     * The board being managed.
     */
    private ColourBoard board;

    /**
     * the score
     */
    private int score;

    /**
     * the number of moves taken
     */
    private int numOfMoves;

    /**
     * A temporary save file.
     */
    public static final String TEMP_SAVE_FILENAME = "save_file_tmp.ser";

    /**
     * The stack that stocks all previous moves
     */
    private Stack<int[]> moveStack;

    /**
     * the first tap
     */
    private int firstTap;
    /**
     * original time
     */
    private int originalSeconds;

    /**
     * Manage a board that has been pre-populated.
     *
     * @param board the board
     */
    ColourBoardManager(ColourBoard board) {
        this.board = board;
    }

    /**
     * Return the current board.
     */
    ColourBoard getBoard() {
        return board;
    }

    /**
     * countdown timer's seconds
     */
    private int seconds;

    /**
     * countdown timer's minutes
     */
    private int minutes;

    /**
     * The current user's id
     */
    private String user_id;

    /*
     * list of solved tiles that need to be taken care of
     */
    private Stack<Integer> matched;

    /**
     * Manage a new shuffled board.
     */
    ColourBoardManager(int complexity, int minute, int second) {
        List<ColourTile> tiles = new ArrayList<>();
        int tileNum;
        int numTiles;
        seconds = second;
        originalSeconds = second;
        minutes = minute;
        matched= new Stack();

        if (complexity == 3) {
            tileNum = 0;
            numTiles = 10;
        } else if (complexity == 4) {
            tileNum = 9;
            numTiles = 26;
        } else {
            tileNum = 25;
            numTiles = 51;
        }

        for (++tileNum; tileNum != numTiles; tileNum++) {
            tiles.add(new ColourTile(tileNum));
        }
        Collections.shuffle(tiles);
        this.board = new ColourBoard(tiles, complexity);
        this.firstTap = 0;
    }

    /**
     * set the board of this boardmanager only for testing purpose
     * @param board new board to be set
     */
    void setBoard(ColourBoard board){
        this.board = board;
    }

    /**
     * getter for minutes
     */
    int getMinutes() {
        return minutes;
    }

    /**
     * getter for seconds
     */
    int getSeconds() {
        return seconds;
    }

    /**
     * Return whether the tiles are in row-major order.
     *
     * @return whether the tiles are in row-major order
     */
    boolean puzzleSolved() {
        boolean solved = rowSolved();

        if (solved) {
            addNewTiles();
            puzzleSolved();
            try {
                createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return solved;
    }



    /*
     * creates a new file
     */
    private void createNewFile() throws IOException {
        File file = new File(TEMP_SAVE_FILENAME);
        file.createNewFile();
    }

    /**
     * Helper function to puzzleSolved, returns whether all tiles of each row are in the same colour
     *
     * @return whether all tiles of each row are in the same colour
     */
    private boolean rowSolved() {
        int currRow = 0;
        int currCol = 0;
        int currBackground = board.getTiles()[0][0].getBackground();
        int matchedNum = 0;

        //checks whether all tiles in a row are in the same colour
        while (currRow < board.getNUM_ROWS()) {
            currBackground = board.getTiles()[currRow][currCol].getBackground();

            //checks the row
            for (ColourTile tile : board.getTiles()[currRow]) {
                //checks the tile
                if (tile.getBackground() != currBackground) {
                    matchedNum = 1;
                    currBackground = board.getTiles()[currRow][currCol].getBackground();
                } else {
                    matchedNum++;
                    //checks whether there are connecting 3 tiles in the same colour
                    if (matchedNum == 3) {
                        matched.push(currCol);
                        matched.push(currRow);
                        if(originalSeconds == 20){score+=3;}
                        else if(originalSeconds==40){score+=2;}
                        else{score+=1;}

                        return true;
                    }
                }
                currCol++;
            }
            currRow++;
            currCol = 0;
            matchedNum = 0;
        }
        return false;
    }

    /**
     * helper function to addNewTiles to generate a random tile
     * @return a randomized colour tile
     */
    private ColourTile generateTile(){
        int background;
        if (board.getNUM_ROWS() == 3){
            background = new Random().nextInt(8) + 1;
        }
        else if (board.getNUM_ROWS() == 4){
            background = new Random().nextInt(24) + 10;
        }
        else {
            background = new Random().nextInt(49) + 26;
        }
        return new ColourTile(background);
    }

    /*
     * adds new tiles to the board
     */
    private void addNewTiles() {

        //generate three random tiles
        ColourTile tile1 = generateTile();
        ColourTile tile2 = generateTile();
        ColourTile tile3 = generateTile();

        //fetch matched tiles
        int currRow = matched.pop();
        int thirdCol = matched.pop();
        int secondCol = thirdCol - 1;
        int firstCol = thirdCol - 2;

        // replace tiles with tiles in the row above
        while (currRow >= 0) {
            // switch the colour tiles in the first row to randomly generated tiles
            if (currRow == 0) {
                board.setTile(currRow, firstCol, tile1);
                board.setTile(currRow, secondCol, tile2);
                board.setTile(currRow, thirdCol, tile3);
                break;
            }
            // replace this row with the row above it
            board.replaceRow(currRow, thirdCol);
            currRow -= 1;
        }
    }

    /**
     * Helper function to puzzleSolved, returns whether all tiles of each column are of the same colour
     * @return whether all tiles of each column are of the same colour
     */
    private boolean colSolved() {
        int currRow = 1;
        int currCol = 0;
        int currBackground = board.getTiles()[0][0].getBackground();

        //checks whether all tiles in a column are in the same colour
        while (currCol < 4) {
            while (currRow < 4) {
                if (board.getTiles()[currRow][currCol].getBackground() != currBackground) {
                    return false;
                }
                currRow++;
            }
            currCol++;
            currRow = 1;
            currBackground = board.getTiles()[currCol][0].getBackground();
        }
        return true;
    }

    /**
     * returns the score
     */
    int getScore() {
        return score;
    }

    /**
     * Return whether any of the four surrounding tiles is the blank tile.
     *
     * @return whether the tile at position is surrounded by a blank tile
     */
    boolean hasFirstTap() {
        return firstTap != 0;
    }

    /**
     * sets the first tap's position to position
     * @param position the position
     */
    void setFirstTap(int position) {
        this.firstTap = position;
    }

    /**
     * Return whether any of the four surrounding tiles is the first tile.
     *
     * @param position the tile to check
     * @return whether the tile at position is next to the first tile
     */
    boolean isValidTap(int position) {

        int row = position / board.getNUM_ROWS();
        int col = position % board.getNUM_ROWS();

        int firstTapRow = firstTap / board.getNUM_ROWS();
        int firstTapCol = firstTap % board.getNUM_ROWS();

//        return (row != firstTapRow && col != firstTapCol);

        if (row == firstTapRow && col == firstTapCol) {
            return false;
        } else if (row == firstTapRow) {
            if (col - firstTapCol == 1) {
                return true;
            } else return firstTapCol - col == 1;
        } else if (firstTapCol == col) {
            if (row - firstTapRow == 1) {
                return true;
            } else return firstTapRow - row == 1;
        }
        return false;
    }

    /**
     * Process a touch at position in the board, swapping tiles as appropriate.
     *
     * @param position the position
     */
    void touchMove(int position) {

        int row = position / board.getNUM_ROWS();
        int col = position % board.getNUM_ROWS();

        int firstTapRow = firstTap / board.getNUM_ROWS();
        int firstTapCol = firstTap % board.getNUM_ROWS();

        board.swapTiles(row, col, firstTapRow, firstTapCol);
        numOfMoves++;
    }

}

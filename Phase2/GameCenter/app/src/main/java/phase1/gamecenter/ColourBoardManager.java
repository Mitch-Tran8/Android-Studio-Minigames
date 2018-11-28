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
    private Stack<Integer> matchedRow;

    /*
     * list of solved tiles that need to be taken care of
     */
    private Stack<Integer> matchedCol;


    /**
     * The complexity of the board
     */
    private int complexity;

    /**
     * The round of the board
     */
    private int round;

    /**
     * Manage a new shuffled board.
     */
    ColourBoardManager(int round, int complexity, int minute, int second) {
        List<ColourTile> tiles = new ArrayList<>();
        board.round = round;
        this.round = round;
        this.complexity = complexity;
        this.seconds = second;
        this.originalSeconds = second;
        this.minutes = minute;
        matchedRow= new Stack();
        matchedCol= new Stack();
        setUpBoard(complexity, tiles);
        this.firstTap = 0;
    }

    /**
     * getter for the current round that the user is playing
     * @return int round
     */
    public int getRound(){return board.getRound();}

    private void setUpBoard(int complexity, List<ColourTile> tiles) {
        int tileNum;
        int numTiles;
        this.complexity = complexity;
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
        boolean solvedRow = rowSolved();
        boolean solvedCol = colSolved();

        if (solvedRow) {
            addNewTiles();
            puzzleSolved();
            try {
                createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (solvedCol) {
            addNewColTiles();
            puzzleSolved();
            try {
                createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return solvedRow || solvedCol;
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
                        matchedRow.push(currCol);
                        matchedRow.push(currRow);
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
     * Helper function to puzzleSolved, returns whether all tiles of each column are of the same colour
     * @return whether all tiles of each column are of the same colour
     */
    private boolean colSolved() {
        int currCol = 0;
        int matchedNum = 0;
        int currBackground = board.getTiles()[0][currCol].getBackground();
        while (currCol < board.getNUM_COLS()) {

            //check every element in the col
            for (int currRow = 0; currRow < board.getNUM_ROWS(); currRow++) {
                if (board.getTiles()[currRow][currCol].getBackground() == currBackground) {
                    matchedNum++;
                    if (matchedNum == 3) {
                        matchedCol.push(currRow);
                        matchedCol.push(currCol);
                        if(originalSeconds == 20){score+=3;}
                        else if(originalSeconds==40){score+=2;}
                        else{score+=1;}
                        return true;
                    }
                } else {
                    matchedNum = 1;
                    currBackground = board.getTiles()[currRow][currCol].getBackground();
                }
            }
            currCol++;
            matchedNum =0;
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
     * adds new tiles to the rows of the board
     */
    private void addNewTiles() {

        //generate three random tiles
        ColourTile tile1 = generateTile();
        ColourTile tile2 = generateTile();
        ColourTile tile3 = generateTile();

        //fetch matched tiles
        int currRow = matchedRow.pop();
        int thirdCol = matchedRow.pop();
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

    /*
     * adds new tiles to the columns of the board
     */
    private void addNewColTiles() {

        //generate three random tiles
        ColourTile tile1 = generateTile();
        ColourTile tile2 = generateTile();
        ColourTile tile3 = generateTile();

        //fetch matched tiles
        int currCol = matchedCol.pop();
        int thirdRow = matchedCol.pop();
        int secondRow = thirdRow - 1;
        int firstRow = thirdRow - 2;


        board.setTile(firstRow, currCol, tile1);
        board.setTile(secondRow, currCol, tile2);
        board.setTile(thirdRow, currCol, tile3);

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

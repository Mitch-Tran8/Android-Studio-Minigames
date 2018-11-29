package phase1.gamecenter.matched;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.Random;

import phase1.gamecenter.BoardManager;
import phase1.gamecenter.FileManager;

/**
 * Manage a board, including swapping tiles, checking for a win, and managing taps.
 */
public class MatchedBoardManager extends FileManager implements BoardManager {

    /**
     * The board being managed.
     */
    private MatchedBoard board;

    /**
     * the score
     */
    private int score;

    /**
     * A temporary save file.
     */
    static final String TEMP_SAVE_FILENAME = "matched_file_tmp.ser";

    /**
     * the first tap
     */
    private int firstTap;

    /**
     * original time
     */
    private int originalSeconds;

    /**
     * countdown timer's seconds
     */
    private int seconds;

    /**
     * countdown timer's minutes
     */
    private int minutes;

    /*
     * list of solved tiles that need to be taken care of
     */
    private Stack<Integer> matchedRow;

    /*
     * list of solved tiles that need to be taken care of
     */
    private Stack<Integer> matchedCol;

    /**
     * The score required to beat the level and move on to the next one.
     */
    private int scoreReq;

    /**
     * The round of the board
     */
    private int round;

    /**
     * Manage a new shuffled board.
     */
    public MatchedBoardManager(int round, int complexity, int minute, int second) {
        List<MatchedTile> tiles = new ArrayList<>();
        this.round = round;
        seconds = second;
        originalSeconds = second;
        minutes = minute;
        setScoreReq(round);
        matchedRow= new Stack();
        matchedCol= new Stack();
        setUpBoard(complexity, tiles);
        this.firstTap = 0;
    }

    /**
     * Return the current board.
     */
    public MatchedBoard getBoard() {
        return board;
    }

    /**
     * getter for the current round that the user is playing
     * @return int round
     */
    public int getRound(){return round;}

    /**
     * sets the round
     * @param round the round
     */
    public void setRound(int round){this.round = round;}

    /**
     * sets up the board
     * @param complexity the complexity
     * @param tiles the tiles
     */
    private void setUpBoard(int complexity, List<MatchedTile> tiles) {
        int tileNum;
        int numTiles;
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
            tiles.add(new MatchedTile(tileNum));
        }
        Collections.shuffle(tiles);
        puzzleSolved();
        this.board = new MatchedBoard(tiles, complexity);
    }

    /**
     * sets the required score for each round before the user can make it to the next round
     * @param round the round
     */
     void setScoreReq(int round) {
        switch (round) {
            case 1:
                this.scoreReq = 20;
                break;
            case 2:
                this.scoreReq = 40;
                break;
            case 3:
                this.scoreReq = 60;
                break;
            case 4:
                this.scoreReq = 80;
                break;
            case 5:
                this.scoreReq = 100;
                break;
            case 6:
                this.scoreReq = 120;
                break;
            case 7:
                this.scoreReq = 140;
                break;
            case 8:
                this.scoreReq = 160;
                break;
            case 9:
                this.scoreReq = 20;
                break;
            case 10:
                this.scoreReq = 40;
                break;
            default:
                this.score = 50;
                break;
        }
    }

    public int getScoreReq(){return scoreReq;}

    /**
     * set the board of this boardmanager only for testing purpose
     * @param board new board to be set
     */
    public void setBoard(MatchedBoard board){
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
    @Override
    public boolean puzzleSolved() {
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
            for (MatchedTile tile : board.getTiles()[currRow]) {
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
    private MatchedTile generateTile(){
        int background;
        if (board.getNUM_ROWS() == 3){
            background = new Random().nextInt(8) + 1;
        }
        else if (board.getNUM_ROWS() == 4){
            background = new Random().nextInt(24) + 10;
        }else if(board.getNUM_ROWS() == 5){
            background = new Random().nextInt(50) + 26;
        } else {
            background = new Random().nextInt(49) + 26;
        }
        return new MatchedTile(background);
    }

    /*
     * adds new tiles to the rows of the board
     */
    private void addNewTiles() {

        //generate three random tiles
        MatchedTile tile1 = generateTile();
        MatchedTile tile2 = generateTile();
        MatchedTile tile3 = generateTile();

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
        MatchedTile tile1 = generateTile();
        MatchedTile tile2 = generateTile();
        MatchedTile tile3 = generateTile();

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
    public boolean hasFirstTap() {
        return firstTap != 0;
    }

    /**
     * sets the first tap's position to position
     * @param position the position
     */
    public void setFirstTap(int position) {
        this.firstTap = position;
    }

    /**
     * Return whether any of the four surrounding tiles is the first tile.
     *
     * @param position the tile to check
     * @return whether the tile at position is next to the first tile
     */
    public boolean isValidTap(int position) {

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
    public void touchMove(int position) {

        int row = position / board.getNUM_ROWS();
        int col = position % board.getNUM_ROWS();

        int firstTapRow = firstTap / board.getNUM_ROWS();
        int firstTapCol = firstTap % board.getNUM_ROWS();

        board.swapTiles(row, col, firstTapRow, firstTapCol);
    }

}

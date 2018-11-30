package phase1.gamecenter.connectnumber;

import org.junit.Test;

import phase1.gamecenter.connectnumbers.ConnectFourMainActivity;
import phase1.gamecenter.connectnumbers.ConnectThreeAIHardMainActivity;

import static junit.framework.Assert.assertEquals;

public class ConnectThreeAIHardMainActivityTest {

    @Test
    public void testPlayer1WinsPlayer1PointsChange(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.player1Wins();
        assertEquals(20, testerActivity.getPlayer1Points());
    }

    @Test
    public void testPLayer2WinsPlayer1PointsChange(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.opponentWins();
        assertEquals(-2, testerActivity.getPlayer1Points());
    }

    @Test
    public void testMovesLeftIsFalse(){
        String[][] testerBoard = {
                {"X", "X", "O"},
                {"O", "O", "X"},
                {"X", "O", "X"},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.movesLeft(testerBoard);
        assertEquals(false, testerActivity.movesLeft(testerBoard));
    }


    @Test
    public void testNoMovesLeftIsTrue(){
        String[][] testerBoard = {
                {"", "X", "O"},
                {"X", "", "O"},
                {"O", "O", ""},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.movesLeft(testerBoard);
        assertEquals(true, testerActivity.movesLeft(testerBoard));
    }

    @Test
    public void testEvaluateBoardRowsOWinsScore() {
        String[][] testerBoard = {
                {"O", "O", "O"},
                {"O", "X", "X"},
                {"", "X", ""},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(+10, testerActivity.evaluateBoard(testerBoard));
    }

    @Test
    public void testEvaluateBoardRowsXWinsScore() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "X"},
                {"O", "O", ""},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(-10, testerActivity.evaluateBoard(testerBoard));
    }

    @Test
    public void testEvaluateBoardColumnsOWinsScore() {
        String[][] testerBoard = {
                {"", "O", "X"},
                {"X", "O", "O"},
                {"X", "O", "X"},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(+10, testerActivity.evaluateBoard(testerBoard));
    }

    @Test
    public void testEvaluateBoardColumnsXWinsScore() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "O"},
                {"O", "X", "X"},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(-10, testerActivity.evaluateBoard(testerBoard));
    }

    @Test
    public void testEvaluateBoardAscendingDiagonalsOWinsScore() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "O", "X"},
                {"O", "", ""},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(+10, testerActivity.evaluateBoard(testerBoard));
    }

    @Test
    public void testEvaluateBoardAscendingDiagonalsXWinsScore() {
        String[][] testerBoard = {
                {"X", "O", "X"},
                {"", "X", "O"},
                {"X", "O", "O"},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(-10, testerActivity.evaluateBoard(testerBoard));
    }

    @Test
    public void testEvaluateBoardDescendingDiagonalsOWinsScore() {
        String[][] testerBoard = {
                {"O", "X", "X"},
                {"X", "O", "X"},
                {"", "", "O"},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(+10, testerActivity.evaluateBoard(testerBoard));
    }

    @Test
    public void testEvaluateBoardDescendingDiagonalsXWinsScore() {
        String[][] testerBoard = {
                {"X", "X", "O"},
                {"", "X", "O"},
                {"", "O", "X"},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(-10, testerActivity.evaluateBoard(testerBoard));
    }
}

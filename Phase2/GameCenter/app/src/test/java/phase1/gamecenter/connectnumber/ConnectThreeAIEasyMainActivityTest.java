package phase1.gamecenter.connectnumber;

import org.junit.Test;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import phase1.gamecenter.connectnumbers.ConnectThreeAIEasyMainActivity;

import static junit.framework.Assert.assertEquals;

public class ConnectThreeAIEasyMainActivityTest extends AppCompatActivity{

    @Test
    public void testCheckRowsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "X"},
                {"", "O", ""},
        };
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        assertEquals(true, testerActivity.checkRows(testerBoard));
    }

    @Test
    public void testCheckRowsFalse() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "O"},
                {"O", "O", ""},
        };
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        assertEquals(false, testerActivity.checkRows(testerBoard));
    }

    @Test
    public void testCheckColumnsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "O"},
                {"O", "X", "X"},
        };
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        assertEquals(true, testerActivity.checkColumns(testerBoard));
    }

    @Test
    public void testCheckColumnsFalse() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "O"},
                {"O", "O", "X"},
        };
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        assertEquals(false, testerActivity.checkColumns(testerBoard));
    }

    @Test
    public void testCheckAscendingDiagonalsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "O", "O"},
                {"O", "O", "X"},
        };
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        assertEquals(true, testerActivity.checkAscendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckAscendingDiagonalsFalse() {
        String[][] testerBoard = {
                {"O", "X", ""},
                {"X", "", "O"},
                {"", "O", "X"},
        };
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        assertEquals(false, testerActivity.checkAscendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckDescendingDiagonalsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "O", "O"},
                {"O", "O", "O"},
        };
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        assertEquals(true, testerActivity.checkDescendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckDescendingDiagonalsFalse() {
        String[][] testerBoard = {
                {"", "X", "O"},
                {"X", "", "O"},
                {"O", "O", ""},
        };
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        assertEquals(false, testerActivity.checkDescendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckPlayer1RoundsWonGameOverIsTrue(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.setPlayer1RoundsWon(3);
        assertEquals(true, testerActivity.gameOver());
    }

    @Test
    public void testCheckOpponentRoundsWonGameOverIsTrue(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.setOpponentRoundsWon(3);
        assertEquals(true, testerActivity.gameOver());
    }

    @Test
    public void testCheckRoundsWonGameOverIsTrue(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.setRoundsPlayed(5);
        assertEquals(true, testerActivity.gameOver());
    }

    @Test
    public void testCheckGameOverIsFalse(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.setPlayer1RoundsWon(0);
        testerActivity.setOpponentRoundsWon(0);
        testerActivity.setRoundsPlayed(0);
        assertEquals(false, testerActivity.gameOver());
    }

    @Test
    public void testPlayer1WinsPlayer1PointsChange(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.player1Wins();
        assertEquals(2, testerActivity.getPlayer1Points());
    }

    @Test
    public void testPlayer1WinsPlayer1RoundChange(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.player1Wins();
        assertEquals(1, testerActivity.getPlayer1RoundsWon());
    }

    @Test
    public void testPlayer1WinsRoundsPlayedChange(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.player1Wins();
        assertEquals(1, testerActivity.getRoundsPlayed());
    }

    @Test
    public void testPLayer2WinsPlayer1PointsChange(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.opponentWins();
        assertEquals(-8, testerActivity.getPlayer1Points());
    }

    @Test
    public void testPlayer2WinsPlayer2RoundChange(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.opponentWins();
        assertEquals(1, testerActivity.getOpponentRoundsWon());
    }

    @Test
    public void testPlayer2WinsRoundsPlayedChange(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.opponentWins();
        assertEquals(1, testerActivity.getRoundsPlayed());
    }

    @Test
    public void testTieRoundChange(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.tie();
        assertEquals(1, testerActivity.getTies());
    }

    @Test
    public void testTieRoundsPlayedChange(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.tie();
        assertEquals(1, testerActivity.getRoundsPlayed());
    }

}


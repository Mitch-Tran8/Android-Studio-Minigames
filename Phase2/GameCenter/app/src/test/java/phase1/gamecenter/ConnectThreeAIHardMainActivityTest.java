package phase1.gamecenter;

import org.junit.Test;

import phase1.gamecenter.connectnumbers.ConnectFourMainActivity;
import phase1.gamecenter.connectnumbers.ConnectThreeAIHardMainActivity;

import static junit.framework.Assert.assertEquals;

public class ConnectThreeAIHardMainActivityTest {

    @Test
    public void testCheckRowsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "X"},
                {"", "O", ""},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(true, testerActivity.checkRows(testerBoard));
    }

    @Test
    public void testCheckRowsFalse() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "O"},
                {"O", "O", ""},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(false, testerActivity.checkRows(testerBoard));
    }

    @Test
    public void testCheckColumnsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "O"},
                {"O", "X", "X"},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(true, testerActivity.checkColumns(testerBoard));
    }

    @Test
    public void testCheckColumnsFalse() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "O"},
                {"O", "O", "X"},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(false, testerActivity.checkColumns(testerBoard));
    }

    @Test
    public void testCheckAscendingDiagonalsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "O", "O"},
                {"O", "O", "X"},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(true, testerActivity.checkAscendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckAscendingDiagonalsFalse() {
        String[][] testerBoard = {
                {"O", "X", ""},
                {"X", "", "O"},
                {"", "O", "X"},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(false, testerActivity.checkAscendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckDescendingDiagonalsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "O", "O"},
                {"O", "O", "O"},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(true, testerActivity.checkDescendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckDescendingDiagonalsFalse() {
        String[][] testerBoard = {
                {"", "X", "O"},
                {"X", "", "O"},
                {"O", "O", ""},
        };
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        assertEquals(false, testerActivity.checkDescendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckPlayer1RoundsWonGameOverIsTrue(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.setPlayer1RoundsWon(3);
        assertEquals(true, testerActivity.gameOver());
    }

    @Test
    public void testCheckOpponentRoundsWonGameOverIsTrue(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.setOpponentRoundsWon(3);
        assertEquals(true, testerActivity.gameOver());
    }

    @Test
    public void testCheckRoundsWonGameOverIsTrue(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.setRoundsPlayed(5);
        assertEquals(true, testerActivity.gameOver());
    }

    @Test
    public void testCheckGameOverIsFalse(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.setPlayer1RoundsWon(0);
        testerActivity.setOpponentRoundsWon(0);
        testerActivity.setRoundsPlayed(0);
        assertEquals(false, testerActivity.gameOver());
    }

    @Test
    public void testPlayer1WinsPlayer1PointsChange(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.player1Wins();
        assertEquals(5, testerActivity.getPlayer1Points());
    }

    @Test
    public void testPlayer1WinsPlayer1RoundChange(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.player1Wins();
        assertEquals(1, testerActivity.getPlayer1RoundsWon());
    }

    @Test
    public void testPlayer1WinsRoundsPlayedChange(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.player1Wins();
        assertEquals(1, testerActivity.getRoundsPlayed());
    }

    @Test
    public void testPLayer2WinsPlayer1PointsChange(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.opponentWins();
        assertEquals(-3, testerActivity.getPlayer1Points());
    }

    @Test
    public void testPlayer2WinsPlayer2RoundChange(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.opponentWins();
        assertEquals(1, testerActivity.getOpponentRoundsWon());
    }

    @Test
    public void testPlayer2WinsRoundsPlayedChange(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.opponentWins();
        assertEquals(1, testerActivity.getRoundsPlayed());
    }

    @Test
    public void testTieRoundChange(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.tie();
        assertEquals(1, testerActivity.getTies());
    }

    @Test
    public void testTieRoundsPlayedChange(){
        ConnectThreeAIHardMainActivity testerActivity = new ConnectThreeAIHardMainActivity();
        testerActivity.tie();
        assertEquals(1, testerActivity.getRoundsPlayed());
    }
}

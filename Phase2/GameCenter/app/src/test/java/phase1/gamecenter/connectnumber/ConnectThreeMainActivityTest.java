package phase1.gamecenter.connectnumber;

import org.junit.Test;

import phase1.gamecenter.connectnumbers.ConnectThreeMainActivity;

import static junit.framework.Assert.assertEquals;

public class ConnectThreeMainActivityTest {

    @Test
    public void testCheckRowsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "X"},
                {"", "O", ""},
        };
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        assertEquals(true, testerActivity.checkRows(testerBoard));
    }

    @Test
    public void testCheckRowsFalse() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "O"},
                {"O", "O", ""},
        };
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        assertEquals(false, testerActivity.checkRows(testerBoard));
    }

    @Test
    public void testCheckColumnsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "O"},
                {"O", "X", "X"},
        };
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        assertEquals(true, testerActivity.checkColumns(testerBoard));
    }

    @Test
    public void testCheckColumnsFalse() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "X", "O"},
                {"O", "O", "X"},
        };
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        assertEquals(false, testerActivity.checkColumns(testerBoard));
    }

    @Test
    public void testCheckAscendingDiagonalsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "O", "O"},
                {"O", "O", "X"},
        };
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        assertEquals(true, testerActivity.checkAscendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckAscendingDiagonalsFalse() {
        String[][] testerBoard = {
                {"O", "X", ""},
                {"X", "", "O"},
                {"", "O", "X"},
        };
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        assertEquals(false, testerActivity.checkAscendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckDescendingDiagonalsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O"},
                {"X", "O", "O"},
                {"O", "O", "O"},
        };
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        assertEquals(true, testerActivity.checkDescendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckDescendingDiagonalsFalse() {
        String[][] testerBoard = {
                {"", "X", "O"},
                {"X", "", "O"},
                {"O", "O", ""},
        };
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        assertEquals(false, testerActivity.checkDescendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckPlayer1RoundsWonGameOverIsTrue(){
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        testerActivity.setPlayer1RoundsWon(3);
        assertEquals(true, testerActivity.gameOver());
    }

    @Test
    public void testCheckOpponentRoundsWonGameOverIsTrue(){
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        testerActivity.setOpponentRoundsWon(3);
        assertEquals(true, testerActivity.gameOver());
    }

    @Test
    public void testCheckRoundsWonGameOverIsTrue(){
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        testerActivity.setRoundsPlayed(5);
        assertEquals(true, testerActivity.gameOver());
    }

    @Test
    public void testCheckGameOverIsFalse(){
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        testerActivity.setPlayer1RoundsWon(0);
        testerActivity.setOpponentRoundsWon(0);
        testerActivity.setRoundsPlayed(0);
        assertEquals(false, testerActivity.gameOver());
    }

    @Test
    public void testPlayer1WinsPlayer1PointsChange(){
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        testerActivity.player1Wins();
        assertEquals(5, testerActivity.getPlayer1Points());
    }

    @Test
    public void testPlayer1WinsPlayer1RoundChange(){
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        testerActivity.player1Wins();
        assertEquals(1, testerActivity.getPlayer1RoundsWon());
    }

    @Test
    public void testPlayer1WinsRoundsPlayedChange(){
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        testerActivity.player1Wins();
        assertEquals(1, testerActivity.getRoundsPlayed());
    }

    @Test
    public void testPLayer2WinsPlayer1PointsChange(){
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        testerActivity.opponentWins();
        assertEquals(-3, testerActivity.getPlayer1Points());
    }

    @Test
    public void testPlayer2WinsPlayer2RoundChange(){
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        testerActivity.opponentWins();
        assertEquals(1, testerActivity.getOpponentRoundsWon());
    }

    @Test
    public void testPlayer2WinsRoundsPlayedChange(){
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        testerActivity.opponentWins();
        assertEquals(1, testerActivity.getRoundsPlayed());
    }

    @Test
    public void testTieRoundChange(){
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        testerActivity.tie();
        assertEquals(1, testerActivity.getTies());
    }

    @Test
    public void testTieRoundsPlayedChange(){
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        testerActivity.tie();
        assertEquals(1, testerActivity.getRoundsPlayed());
    }
}

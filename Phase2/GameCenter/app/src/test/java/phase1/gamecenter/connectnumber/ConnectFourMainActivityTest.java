package phase1.gamecenter.connectnumber;


import org.junit.Test;

import phase1.gamecenter.connectnumbers.ConnectFourMainActivity;

import static junit.framework.Assert.assertEquals;


public class ConnectFourMainActivityTest {

    @Test
    public void testCheckRowsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O", "X", "X"},
                {"O", "X", "O", "X", "X"},
                {"X", "X", "X", "X", "O"},
                {"", "", "", "", ""},
                {"", "", "", "", ""},

        };
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        assertEquals(true, testerActivity.checkRows(testerBoard));
    }

    @Test
    public void testCheckRowsFalse() {
        String[][] testerBoard = {
                {"O", "X", "O", "X", "O"},
                {"O", "X", "O", "X", ""},
                {"X", "X", "X", "0", ""},
                {"", "", "", "", "", },
                {"", "", "", "", ""},

        };
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        assertEquals(false, testerActivity.checkRows(testerBoard));
    }

    @Test
    public void testCheckColumnsFalse() {
        String[][] testerBoard = {
                {"O", "X", "O", "X", "O"},
                {"", "", "", "", ""},
                {"O", "X", "O", "X", ""},
                {"X", "X", "X", "0", ""},
                {"", "", "", "", "", },
        };
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        assertEquals(false, testerActivity.checkColumns(testerBoard));
    }


    @Test
    public void testCheckColumnsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O", "X", "O"},
                {"", "X", "", "", ""},
                {"O", "X", "O", "X", ""},
                {"X", "X", "X", "0", ""},
                {"", "", "", "", "", },
        };
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        assertEquals(true, testerActivity.checkColumns(testerBoard));
    }

    @Test
    public void testCheckAscendingDiagonalsFalse() {
        String[][] testerBoard = {
                {"O", "X", "O", "X", "O"},
                {"", "", "", "", ""},
                {"O", "X", "O", "X", ""},
                {"X", "X", "X", "0", ""},
                {"", "", "", "", "", },
        };
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        assertEquals(false, testerActivity.checkAscendingDiagonals(testerBoard));
    }


    @Test
    public void testCheckAscendingDiagonalsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O", "O", "O"},
                {"", "X", "O", "", ""},
                {"O", "O", "O", "X", ""},
                {"O", "X", "X", "0", ""},
                {"", "", "", "", "", },
        };
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        assertEquals(true, testerActivity.checkAscendingDiagonals(testerBoard));
    }


    @Test
    public void testCheckDescendingDiagonalsTrue() {
        String[][] testerBoard = {
                {"O", "X", "O", "O", "O"},
                {"", "O", "O", "", ""},
                {"O", "O", "O", "X", ""},
                {"O", "X", "X", "O", ""},
                {"", "", "", "", "", },
        };
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        assertEquals(true, testerActivity.checkDescendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckDescendingDiagonalsFalse() {
        String[][] testerBoard = {
                {"O", "X", "O", "O", "O"},
                {"", "O", "O", "", ""},
                {"O", "O", "X", "X", ""},
                {"O", "X", "X", "O", ""},
                {"", "", "", "", "", },
        };
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        assertEquals(false, testerActivity.checkDescendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckPlayer1RoundsWonGameOverIsTrue(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.setPlayer1RoundsWon(3);
        assertEquals(true, testerActivity.gameOver());
    }

    @Test
    public void testCheckOpponentRoundsWonGameOverIsTrue(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.setOpponentRoundsWon(3);
        assertEquals(true, testerActivity.gameOver());
    }

    @Test
    public void testCheckRoundsWonGameOverIsTrue(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.setRoundsPlayed(5);
        assertEquals(true, testerActivity.gameOver());
    }

    @Test
    public void testCheckGameOverIsFalse(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.setPlayer1RoundsWon(0);
        testerActivity.setOpponentRoundsWon(0);
        testerActivity.setRoundsPlayed(0);
        assertEquals(false, testerActivity.gameOver());
    }

    @Test
    public void testPlayer1WinsPlayer1PointsChange(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.player1Wins();
        assertEquals(15, testerActivity.getPlayer1Points());
    }

    @Test
    public void testPlayer1WinsPlayer1RoundChange(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.player1Wins();
        assertEquals(1, testerActivity.getPlayer1RoundsWon());
    }

    @Test
    public void testPlayer1WinsRoundsPlayedChange(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.player1Wins();
        assertEquals(1, testerActivity.getRoundsPlayed());
    }

    @Test
    public void testPLayer2WinsPlayer1PointsChange(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.opponentWins();
        assertEquals(-4, testerActivity.getPlayer1Points());
    }

    @Test
    public void testPlayer2WinsPlayer2RoundChange(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.opponentWins();
        assertEquals(1, testerActivity.getOpponentRoundsWon());
    }

    @Test
    public void testPlayer2WinsRoundsPlayedChange(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.opponentWins();
        assertEquals(1, testerActivity.getRoundsPlayed());
    }

    @Test
    public void testTieRoundChange(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.tie();
        assertEquals(1, testerActivity.getTies());
    }

    @Test
    public void testTieRoundsPlayedChange(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.tie();
        assertEquals(1, testerActivity.getRoundsPlayed());
    }

}

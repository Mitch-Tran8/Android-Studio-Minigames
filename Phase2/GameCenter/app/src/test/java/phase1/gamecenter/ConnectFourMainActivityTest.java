package phase1.gamecenter;


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
    public void testCheckAiRoundsWonGameOverIsTrue(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.setPlayer2RoundsWon(3);
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
        testerActivity.setPlayer2RoundsWon(0);
        testerActivity.setRoundsPlayed(0);
        assertEquals(false, testerActivity.gameOver());
    }

}

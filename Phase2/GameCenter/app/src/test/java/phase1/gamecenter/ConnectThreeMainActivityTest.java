package phase1.gamecenter;

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
    public void testCheckAiRoundsWonGameOverIsTrue(){
        ConnectThreeMainActivity testerActivity = new ConnectThreeMainActivity();
        testerActivity.setPlayer2RoundsWon(3);
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
        testerActivity.setPlayer2RoundsWon(0);
        testerActivity.setRoundsPlayed(0);
        assertEquals(false, testerActivity.gameOver());
    }


}

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
    public void testCheckRowsTrueScenario2() {
        String[][] testerBoard = {
                {"O", "X", "O", "X", "X"},
                {"O", "X", "O", "X", "X"},
                {"", "X", "X", "X", "X"},
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
    public void testCheckColumnsTrueScenario2() {
        String[][] testerBoard = {
                {"O", "", "O", "X", "O"},
                {"", "X", "", "", ""},
                {"O", "X", "O", "X", ""},
                {"X", "X", "X", "0", ""},
                {"", "X", "", "", "", },
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
    public void testCheckAscendingDiagonalsTrueScenario2() {
        String[][] testerBoard = {
                {"O", "X", "O", "X", "O"},
                {"", "X", "O", "X", ""},
                {"O", "O", "X", "X", ""},
                {"O", "X", "X", "0", ""},
                {"X", "", "", "", "", },
        };
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        assertEquals(true, testerActivity.checkAscendingDiagonals(testerBoard));
    }


    @Test
    public void testCheckAscendingDiagonalsTrueScenario3() {
        String[][] testerBoard = {
                {"O", "X", "O", "X", "X"},
                {"", "X", "O", "X", ""},
                {"O", "O", "X", "X", ""},
                {"O", "X", "X", "0", ""},
                {"", "", "", "", "", },
        };
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        assertEquals(true, testerActivity.checkAscendingDiagonals(testerBoard));
    }


    @Test
    public void testCheckAscendingDiagonalsTrueScenario4() {
        String[][] testerBoard = {
                {"O", "X", "O", "X", ""},
                {"", "X", "O", "", "X"},
                {"O", "O", "", "X", ""},
                {"O", "", "X", "0", ""},
                {"", "X", "", "", "", },
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
    public void testCheckDescendingDiagonalsTrueScenario2() {
        String[][] testerBoard = {
                {"", "X", "O", "O", "O"},
                {"", "O", "O", "", ""},
                {"O", "O", "O", "X", ""},
                {"O", "X", "X", "O", ""},
                {"", "", "", "", "O", },
        };
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        assertEquals(true, testerActivity.checkDescendingDiagonals(testerBoard));
    }

    @Test
    public void testCheckDescendingDiagonalsTrueScenario3() {
        String[][] testerBoard = {
                {"", "X", "O", "O", "O"},
                {"", "O", "X", "", ""},
                {"O", "O", "O", "X", ""},
                {"O", "X", "X", "O", "X"},
                {"", "", "", "", "", },
        };
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        assertEquals(true, testerActivity.checkDescendingDiagonals(testerBoard));
    }


    @Test
    public void testCheckDescendingDiagonalsTrueScenario4() {
        String[][] testerBoard = {
                {"", "", "O", "O", "O"},
                {"O", "O", "X", "", ""},
                {"O", "O", "O", "X", ""},
                {"O", "X", "O", "O", "X"},
                {"", "", "", "O", "", },
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
    public void testPlayer1WinsPlayer1PointsChange(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.player1Wins();
        assertEquals(15, testerActivity.getPlayer1Points());
    }

    @Test
    public void testPLayer2WinsPlayer1PointsChange(){
        ConnectFourMainActivity testerActivity = new ConnectFourMainActivity();
        testerActivity.opponentWins();
        assertEquals(-4, testerActivity.getPlayer1Points());
    }

}
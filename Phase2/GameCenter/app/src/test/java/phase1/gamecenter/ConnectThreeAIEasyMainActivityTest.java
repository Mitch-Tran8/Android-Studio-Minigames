package phase1.gamecenter;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ConnectThreeAIEasyMainActivityTest {
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

}

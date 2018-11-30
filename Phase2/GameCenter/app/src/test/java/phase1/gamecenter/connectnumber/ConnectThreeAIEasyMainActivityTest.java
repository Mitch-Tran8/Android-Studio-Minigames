package phase1.gamecenter.connectnumber;

import org.junit.Test;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import phase1.gamecenter.connectnumbers.ConnectThreeAIEasyMainActivity;

import static junit.framework.Assert.assertEquals;

public class ConnectThreeAIEasyMainActivityTest extends AppCompatActivity{

    @Test
    public void testPlayer1WinsPlayer1PointsChange(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.player1Wins();
        assertEquals(2, testerActivity.getPlayer1Points());
    }

    @Test
    public void testPLayer2WinsPlayer1PointsChange(){
        ConnectThreeAIEasyMainActivity testerActivity = new ConnectThreeAIEasyMainActivity();
        testerActivity.opponentWins();
        assertEquals(-8, testerActivity.getPlayer1Points());
    }

}


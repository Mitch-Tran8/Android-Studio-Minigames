package phase1.gamecenter;

import android.app.Activity;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import phase1.gamecenter.GameCenterMainActivity;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

public class GameCenterMainActivityTest {
    @Rule
    public ActivityTestRule<GameCenterMainActivity> gameCenterMainActivityActivityTestRule = new ActivityTestRule<GameCenterMainActivity>(GameCenterMainActivity.class);
    private GameCenterMainActivity gameCenterMainActivity= null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(GameCenterMainActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        gameCenterMainActivity = gameCenterMainActivityActivityTestRule.getActivity();
    }

    @Test
    public void testMenuButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(gameCenterMainActivity.findViewById(R.id.menuButton));
        //perform click on button
        onView(withId(R.id.menuButton)).perform(click());

        assertNotNull(gameCenterMainActivity.findViewById(R.id.logoutPageButton));
        onView(withId(R.id.logoutPageButton)).perform(click());

    }

    @Test
    public void testSlidingTilesButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(gameCenterMainActivity.findViewById(R.id.slidingtilesbutton));
        //perform click on button
        onView(withId(R.id.slidingtilesbutton)).perform(click());
        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @Test
    public void testColorTilesButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(gameCenterMainActivity.findViewById(R.id.colourtilesbutton));
        //perform click on button
        onView(withId(R.id.colourtilesbutton)).perform(click());
        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @Test
    public void testConnectNumbersButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(gameCenterMainActivity.findViewById(R.id.connect4button));
        //perform click on button
        onView(withId(R.id.connect4button)).perform(click());
        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

/*    @Test
    public void testUserScoreBoardButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(gameCenterMainActivity.findViewById(R.id.scoreboard));
        //perform click on button
        onView(withId(R.id.scoreboard)).perform(click());
        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }*/

/*    @Test
    public void testLeaderBoardButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(gameCenterMainActivity.findViewById(R.id.leaderboard));
        //perform click on button
        onView(withId(R.id.leaderboard)).perform(click());
        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }*/

    @After
    public void tearDown() throws Exception {
        gameCenterMainActivity = null;

    }
}

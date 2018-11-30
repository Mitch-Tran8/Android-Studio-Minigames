package phase1.gamecenter;

import android.app.Activity;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import phase1.gamecenter.connectnumbers.ConnectNumbersStartingActivity;
import phase1.gamecenter.connectnumbers.ConnectThreeDifficultyActivity;
import phase1.gamecenter.connectnumbers.ConnectNumbersSelectActivity;



import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

public class ConnectNumbersStartingActivityTest {

    @Rule
    public ActivityTestRule<ConnectNumbersStartingActivity> connectNumbersStartingActivityActivityTestRule = new ActivityTestRule<ConnectNumbersStartingActivity>(ConnectNumbersStartingActivity.class);
    private ConnectNumbersStartingActivity connectNumbersStartingActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(ConnectNumbersStartingActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        connectNumbersStartingActivity = connectNumbersStartingActivityActivityTestRule.getActivity();
    }

    @Test
    public void testConnectNumbersOnePlayerButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(connectNumbersStartingActivity.findViewById(R.id.one_player_button));

        //perform click on button
        onView(withId(R.id.one_player_button)).perform(click());


        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @Test
    public void testConnectNumbersTwoPlayerButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(connectNumbersStartingActivity.findViewById(R.id.two_player_button));


        //perform click on button
        onView(withId(R.id.two_player_button)).perform(click());

        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
       connectNumbersStartingActivity = null;

    }

}

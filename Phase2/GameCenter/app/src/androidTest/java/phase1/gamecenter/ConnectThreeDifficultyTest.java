package phase1.gamecenter;

import android.app.Activity;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import phase1.gamecenter.connectnumbers.ConnectThreeDifficultyActivity;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

public class ConnectThreeDifficultyTest {

    @Rule
    public ActivityTestRule<ConnectThreeDifficultyActivity> connectThreeDifficultyActivityActivityTestRule = new ActivityTestRule<ConnectThreeDifficultyActivity>(ConnectThreeDifficultyActivity.class);
    private ConnectThreeDifficultyActivity connectThreeDifficultyActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(ConnectThreeDifficultyActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        connectThreeDifficultyActivity = connectThreeDifficultyActivityActivityTestRule.getActivity();
    }

    @Test
    public void testConnectThreeEasyButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(connectThreeDifficultyActivity.findViewById(R.id.easy_button));


        //perform click on button
        onView(withId(R.id.easy_button)).perform(click());


        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @Test
    public void testConnectThreeHardButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(connectThreeDifficultyActivity.findViewById(R.id.hard_button));

        //perform click on button
        onView(withId(R.id.hard_button)).perform(click());

        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        connectThreeDifficultyActivity = null;

    }
}

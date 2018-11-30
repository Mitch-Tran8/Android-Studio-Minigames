package phase1.gamecenter;

import phase1.gamecenter.connectnumbers.ConnectNumbersSelectActivity;

import android.app.Activity;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

public class ConnectNumbersSelectActivityTest {

    @Rule
    public ActivityTestRule<ConnectNumbersSelectActivity> connectNumbersSelectActivityActivityTestRule = new ActivityTestRule<ConnectNumbersSelectActivity>(ConnectNumbersSelectActivity.class);
    private ConnectNumbersSelectActivity connectNumbersSelectActivity= null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(ConnectNumbersSelectActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        connectNumbersSelectActivity = connectNumbersSelectActivityActivityTestRule.getActivity();
    }

    @Test
    public void testConnectThreeButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(connectNumbersSelectActivity.findViewById(R.id.connect_three_button));


        //perform click on button
        onView(withId(R.id.connect_three_button)).perform(click());


        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @Test
    public void testConnectFourButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(connectNumbersSelectActivity.findViewById(R.id.connect_four_button));


        //perform click on button
        onView(withId(R.id.connect_four_button)).perform(click());

        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        connectNumbersSelectActivity = null;

    }
}

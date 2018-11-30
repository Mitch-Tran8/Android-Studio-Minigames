package phase1.gamecenter;


import phase1.gamecenter.matched.MatchedStartingActivity;

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

public class MatchedStartingActivityTest {

    @Rule
    public ActivityTestRule<MatchedStartingActivity> matchedStartingActivityActivityTestRule = new ActivityTestRule<MatchedStartingActivity>(MatchedStartingActivity.class);
    private MatchedStartingActivity matchedStartingActivity= null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MatchedStartingActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        matchedStartingActivity = matchedStartingActivityActivityTestRule.getActivity();
    }

    @Test
    public void testInstructionsButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(matchedStartingActivity.findViewById(R.id.instructions_button2));
        //perform click on button
        onView(withId(R.id.instructions_button2)).perform(click());
    }

    @Test
    public void testStartButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(matchedStartingActivity.findViewById(R.id.StartButton));

        //perform click on button
        onView(withId(R.id.StartButton)).perform(click());

        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }


    @Test
    public void testLoadButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(matchedStartingActivity.findViewById(R.id.LoadButton));

        //perform click on button
        onView(withId(R.id.LoadButton)).perform(click());

        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        matchedStartingActivity = null;

    }
}

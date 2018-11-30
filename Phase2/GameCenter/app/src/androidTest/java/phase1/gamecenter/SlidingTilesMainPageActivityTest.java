package phase1.gamecenter;

import phase1.gamecenter.slidingtiles.SlidingTileMainPageActivity;

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

public class SlidingTilesMainPageActivityTest {

    @Rule
    public ActivityTestRule<SlidingTileMainPageActivity> slidingTileMainPageActivityActivityTestRule = new ActivityTestRule<SlidingTileMainPageActivity>(SlidingTileMainPageActivity.class);
    private SlidingTileMainPageActivity slidingTileMainPageActivity= null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(SlidingTileMainPageActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        slidingTileMainPageActivity = slidingTileMainPageActivityActivityTestRule.getActivity();
    }

    @Test
    public void testStartGameButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(slidingTileMainPageActivity.findViewById(R.id.start_game_button));

        //perform click on button
        onView(withId(R.id.start_game_button)).perform(click());

        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @Test
    public void testHowToPlayButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(slidingTileMainPageActivity.findViewById(R.id.howToPlayButton));

        //perform click on button
        onView(withId(R.id.howToPlayButton)).perform(click());

        assertNotNull(slidingTileMainPageActivity.findViewById(R.id.exitInstructionsButton));

        onView(withId(R.id.exitInstructionsButton)).perform(click());

    }

    @After
    public void tearDown() throws Exception {
        slidingTileMainPageActivity = null;
    }
}

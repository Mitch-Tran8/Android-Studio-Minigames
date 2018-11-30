package phase1.gamecenter;

import android.app.Activity;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import phase1.gamecenter.slidingtiles.BoardComplexity;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

public class BoardComplexityTest {

    @Rule
    public ActivityTestRule<BoardComplexity> boardComplexityActivityTestRule = new ActivityTestRule<BoardComplexity>(BoardComplexity.class);
    private BoardComplexity boardComplexity= null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(BoardComplexity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        boardComplexity = boardComplexityActivityTestRule.getActivity();
    }

    @Test
    public void testFourButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(boardComplexity.findViewById(R.id.four_board));
        //perform click on button
        onView(withId(R.id.four_board)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @Test
    public void testThreeButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(boardComplexity.findViewById(R.id.three_board));
        //perform click on button
        onView(withId(R.id.three_board)).perform(click());
        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @Test
    public void testFiveButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(boardComplexity.findViewById(R.id.five_board));
        //perform click on button
        onView(withId(R.id.five_board)).perform(click());
        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @Test
    public void testLoadButtonClickLaunchActivity(){
        //test first activity
        assertNotNull(boardComplexity.findViewById(R.id.load_game_button));
        //perform click on button
        onView(withId(R.id.load_game_button)).perform(click());
        //test second activity launching
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000); //wait till timeout expires
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        boardComplexity = null;

    }
}



package is.ac.ui.cs.mobileprogramming.satyadharma.helloworld;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class BasicallyInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void changeText_sameActivity() {
        // Press the button.
        onView(withId(R.id.button_first))
                .perform(click());

        // Check that the page has changed by checking if another button appeared.
        onView(withId(R.id.button_second))
                .check(matches(isDisplayed()));
    }

}

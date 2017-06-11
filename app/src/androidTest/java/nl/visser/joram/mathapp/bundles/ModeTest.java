package nl.visser.joram.mathapp.bundles;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static nl.visser.joram.mathapp.bundles.Mode.MODE_BUNDLE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(AndroidJUnit4.class)
public class ModeTest {

    @Test
    public void givenEndlessModeIsProvidedWhenAddModeBundleIsCalledThenAddModeBundleReturnsABundleContainingTheEndlessMode() throws Exception {
        Mode expected = Mode.ENDLESS_MODE;
        Bundle returnedBundle = Mode.addModeBundle(expected);
        Mode actual = (Mode) returnedBundle.get(MODE_BUNDLE);
        assertThat(actual, is(equalTo(expected)));
    }

}

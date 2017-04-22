package nl.visser.joram.mathapp.bundles;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class ModeBundleTest {

    @Before
    public void setUp() throws Exception {
        //TODO create randomMode here.
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void givenRandomModeIsProvidedWhenAddModeBundleIsCalledThenAddModeBundleReturnsABundleContainingTheMode() throws Exception {
        Mode expectedMode = Mode.ENDLESS_MODE;
        Bundle returnedBundle = ModeBundle.addModeBundle(expectedMode);
        Mode mode = (Mode) returnedBundle.get("MODE");
        assertEquals(expectedMode, mode);
    }

}

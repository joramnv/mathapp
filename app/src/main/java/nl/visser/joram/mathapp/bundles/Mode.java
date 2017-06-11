package nl.visser.joram.mathapp.bundles;

import android.os.Bundle;

public enum Mode {
    NORMAL, TIME_TRIAL, ENDLESS_MODE;

    public static final String MODE_BUNDLE = "nl.visser.joram.mathapp.bundles.Mode.MODE_BUNDLE";

    public static Bundle addModeBundle(Mode mode) {
        Bundle modeBundle = new Bundle();
        modeBundle.putSerializable(MODE_BUNDLE, mode);
        return modeBundle;
    }

}

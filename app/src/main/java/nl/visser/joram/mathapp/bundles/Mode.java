package nl.visser.joram.mathapp.bundles;

import android.os.Bundle;

public enum Mode {
    NORMAL, TIME_TRIAL, ENDLESS_MODE;

    public static Bundle addModeBundle(Mode mode) {
        Bundle modeBundle = new Bundle();
        modeBundle.putSerializable("MODE", mode);
        return modeBundle;
    }

}

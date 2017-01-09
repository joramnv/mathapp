package nl.visser.joram.mathapp.bundles;

import android.os.Bundle;

import nl.visser.joram.mathapp.fragments.Mode;

public class ModeBundle {

    public static Bundle addModeBundle(Mode mode) {
        Bundle modeBundle = new Bundle();
        modeBundle.putSerializable("MODE", mode);
        return modeBundle;
    }

}

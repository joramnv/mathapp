package nl.visser.joram.mathapp.fragments;

import android.view.View;

import nl.visser.joram.mathapp.bundles.Mode;

public interface ModesFragment {

    Mode onClickModeNormal(View view);

    Mode onClickModeTimeTrial(View view);

    Mode onClickModeEndlessMode(View view);

}

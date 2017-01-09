package nl.visser.joram.mathapp.fragments;

import android.view.View;

public interface Modes {

    Mode onClickModeNormal(View view);

    Mode onClickModeTimeTrial(View view);

    Mode onClickModeEndlessMode(View view);

}

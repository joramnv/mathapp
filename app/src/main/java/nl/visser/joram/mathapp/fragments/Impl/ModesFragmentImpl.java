package nl.visser.joram.mathapp.fragments.Impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nl.visser.joram.mathapp.R;
import nl.visser.joram.mathapp.bundles.Mode;
import nl.visser.joram.mathapp.fragments.ModesFragment;

public class ModesFragmentImpl extends Fragment implements ModesFragment {

    public static final String FRAGMENT_TAG = "CATAGORIES_FRAGMENT";

    public ModesFragmentImpl() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modes, container, false);
    }

    public Mode onClickModeNormal(View view) {
        return Mode.NORMAL;
    }

    public Mode onClickModeTimeTrial(View view) {
        return Mode.TIME_TRIAL;
    }

    public Mode onClickModeEndlessMode(View view) {
        return Mode.ENDLESS_MODE;
    }

}

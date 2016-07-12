package nl.visser.joram.mathapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nl.visser.joram.mathapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModesFragment extends Fragment {

    private static final String LOG_TAG =  ModesFragment.class.getSimpleName();
    public static final String FRAGMENT_TAG = "CATAGORIES_FRAGMENT";

    public ModesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modes, container, false);
    }

}

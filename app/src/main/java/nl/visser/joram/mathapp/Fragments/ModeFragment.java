package nl.visser.joram.mathapp.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nl.visser.joram.mathapp.Activities.AdditionActivity;
import nl.visser.joram.mathapp.Activities.SubtractionActivity;
import nl.visser.joram.mathapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModeFragment extends Fragment {

    private static final String LOG_TAG =  ModeFragment.class.getSimpleName();
    public static final String FRAGMENT_TAG = "CATAGORIES_FRAGMENT";

    public ModeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mode, container, false);
    }

}

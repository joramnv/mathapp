package nl.visser.joram.mathapp.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nl.visser.joram.mathapp.Activities.AdditionActivity;
import nl.visser.joram.mathapp.Activities.SubtractionActivity;
import nl.visser.joram.mathapp.R;
import nl.visser.joram.mathapp.Score;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment implements Categories {

    private static final String LOG_TAG = CategoriesFragment.class.getSimpleName();
    public final static String TIME_TRIAL = "TIME_TRIAL";

    private int mode;       //mode 1 = normal, mode 2 = timeTrial, mode 3 = endless.

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = this.getArguments();
        mode = bundle.getInt("MODE");
        Log.v(LOG_TAG, "Mode = " + mode);
    }

    public void additions(View view) {
        Intent intent = new Intent(getActivity(), AdditionActivity.class);
        if(mode == 2) {
            intent.putExtra(TIME_TRIAL, true);
        }
        startActivity(intent);
    }

    public void subtractions(View view) {
        Intent intent = new Intent(getActivity(), SubtractionActivity.class);
        if(mode == 2) {
            intent.putExtra(TIME_TRIAL, true);
        }
        startActivity(intent);
    }

    public void multiplications(View view) {
        //TODO implement
    }

    public void divisions(View view) {
        //TODO implement
    }
}

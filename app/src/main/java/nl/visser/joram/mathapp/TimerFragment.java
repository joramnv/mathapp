package nl.visser.joram.mathapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimerFragment extends Fragment {

    private static final String LOG_TAG = TimerFragment.class.getSimpleName();

    public TimerFragment() {
        // Required empty public constructor
    }

    private TimerTask timerTask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        ProgressBar timerBar = (ProgressBar) getView().findViewById(R.id.fragment_timer_bar);
        timerTask = new TimerTask(this, timerBar);
        timerTask.execute();
    }

    public void showScoreboard() {
        Intent intent = new Intent(getActivity(), ScoreboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        /**
         * Need to stop the TimerTask when fragment is no longer visible to the user either because its activity is being stopped or a fragment operation is modifying it in the activity.
         */
        if (timerTask != null && timerTask.getStatus() != AsyncTask.Status.FINISHED) {
            timerTask.cancel(true);
        }
    }

}

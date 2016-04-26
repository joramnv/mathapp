package nl.visser.joram.mathapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimerFragment extends Fragment {

    public TimerFragment() {
        // Required empty public constructor
    }

    private TimerTask timerManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_timer, container, false);

        ProgressBar timerBar = (ProgressBar) view.findViewById(R.id.timer_bar);
        startTimer(timerBar);

        return view;
    }

    public void startTimer(ProgressBar timerBar) {
        timerManager = new TimerTask(this, timerBar);
        timerManager.execute();
    }

    public void showScoreboard() {
        Intent intent = new Intent(getActivity(), ScoreboardActivity.class);
        startActivity(intent);
    }

}

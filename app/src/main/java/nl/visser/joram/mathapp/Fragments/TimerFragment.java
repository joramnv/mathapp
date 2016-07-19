package nl.visser.joram.mathapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import nl.visser.joram.mathapp.Activities.ScoreboardActivity;
import nl.visser.joram.mathapp.CustomTimer;
import nl.visser.joram.mathapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimerFragment extends Fragment {

    private static final String LOG_TAG = TimerFragment.class.getSimpleName();

    private ProgressBar timerBar;
    GameTimer timer;

    public TimerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        timerBar = (ProgressBar) getView().findViewById(R.id.fragment_timer_bar);
        timer = new GameTimer(62000L, 1000);
        timer.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        timer.cancel();
    }

    public void incrementTimer(long timeToIncrement) {
        timer.onIncrement(timeToIncrement);
        timer.start();
    }

    public void showScoreboard() {
        Intent intent = new Intent(getActivity(), ScoreboardActivity.class);
        startActivity(intent);
    }

    public class GameTimer extends CustomTimer {

        public GameTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if (millisUntilFinished / 1000 > 1) {
                int secondsUntilFinished = (int) (long) (millisUntilFinished / 1000);
                int timerBarValues = (secondsUntilFinished * -1 + 61)*100/60;
                timerBar.setProgress(timerBarValues);
            } else {
                showScoreboard();
            }
        }

        @Override
        public void onFinish() {

        }
    }
}


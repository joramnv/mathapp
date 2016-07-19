package nl.visser.joram.mathapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import nl.visser.joram.mathapp.Activities.ScoreboardActivity;
import nl.visser.joram.mathapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimerFragment extends Fragment {

    private static final String LOG_TAG = TimerFragment.class.getSimpleName();

    private ProgressBar timerBar;
    private long millisUntilFinished;

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
        timer(62000L);
    }

    public void showScoreboard() {
        Intent intent = new Intent(getActivity(), ScoreboardActivity.class);
        startActivity(intent);
    }

    public long getMillisUntilFinished() {
        return millisUntilFinished;
    }

    public void setMillisUntilFinished(long millisUntilFinished) {
        this.millisUntilFinished = millisUntilFinished;
    }

    public void timer(long millisInFuture) {
        /**
         * 60 second count down (set to 62 seconds for reasons explained below).
         * onTick() and onFinish() will not happen at exact times, but instead in this case
         * millisUntilFinished parameter will have values like 4995 etc. down to 990.
         * Furthermore calculation in the onTick method uses integer divisions (remainder is cut
         * off).
         * So continuing the example on the last call 990/1000 will be 0, but onFinish will be
         * called only about 1000ms later. That's why there is about 1 ms delay when onFinish is
         * used to invoke another method. And that's why the method invocation is placed inside the
         * onTick method instead.
         */
        new CountDownTimer(millisInFuture, 1000) {
            public void onTick(long millisUntilFinished) {
                setMillisUntilFinished(millisUntilFinished);
                int secondsUntilFinished;
                if (millisUntilFinished / 1000 > 1) {
                    secondsUntilFinished = (int) (long) (millisUntilFinished / 1000);
                    int timerBarValues = secondsUntilFinished * -1 + 61;
                    timerBar.setProgress(timerBarValues);
                } else {
                    showScoreboard();
                }
            }
            public void onFinish() {
            }
        }.start();
    }

}

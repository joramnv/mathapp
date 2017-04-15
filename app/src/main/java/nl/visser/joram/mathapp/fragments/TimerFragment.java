package nl.visser.joram.mathapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import nl.visser.joram.mathapp.CustomTimer;
import nl.visser.joram.mathapp.R;

public class TimerFragment extends Fragment {

    private OnFragmentInteractionListener listener;
    private ProgressBar timerBar;
    private GameTimer timer;

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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void incrementTimer(long timeToIncrement) {
        timer.onIncrement(timeToIncrement);
        timer.start();
    }

    public void onRemove() {
        getFragmentManager().beginTransaction()
                .remove(this)
                .commit();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void showScoreboard();
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
                listener.showScoreboard();
            }
        }

        @Override
        public void onFinish() {

        }
    }

}


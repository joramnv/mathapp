package nl.visser.joram.mathapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * Created by Joram on 17-4-2016.
 */
public class TimerTask extends AsyncTask<Void, Integer, Boolean> {

    private static final String LOG_TAG =  TimerTask.class.getSimpleName();

    private TimerFragment timerFragment;
    private ProgressBar timerBar;

    public TimerTask(TimerFragment timerFragment, ProgressBar timerBar){
        this.timerFragment = timerFragment;
        this.timerBar = timerBar;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        //TODO maybe this should be done using CountDownTimer, see: http://developer.android.com/reference/android/os/CountDownTimer.html
        for(int i = 1; i <= 60; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                Thread.interrupted();
                Log.e(LOG_TAG, "" + ie);
            }
            publishProgress(i);
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean timerFinished) {
        timerFragment.showScoreboard();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        for(int i: values) {
            timerBar.setProgress(i * 100 / 60); //set timer bar to % according to seconds past.
        }
    }
}
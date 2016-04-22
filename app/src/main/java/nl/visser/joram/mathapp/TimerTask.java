package nl.visser.joram.mathapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * Created by Joram on 17-4-2016.
 */
public class TimerTask extends AsyncTask<Void, Integer, Boolean> {

    private static final String LOG_TAG =  TimerTask.class.getSimpleName();

    private Context context;
    private ProgressBar timerBar;

    public TimerTask(Context context, ProgressBar timerBar){
        this.context = context;
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
        if(context instanceof AdditionActivity) {
            ((AdditionActivity)context).showScoreboard();

        } else {
            Log.w(LOG_TAG, "context is not an instance of AdditionActivity");
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        for(int i: values) {
            timerBar.setProgress(i * 100 / 60); //set timer bar to % according to seconds past.
            //Log.v(LOG_TAG, "" + i);
        }
    }
}
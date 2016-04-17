package nl.visser.joram.mathapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Joram on 17-4-2016.
 */
public class TimerTask extends AsyncTask<Void, Integer, String> {

    private static final String LOG_TAG =  TimerTask.class.getSimpleName();

    private ImageView imageView;

    public TimerTask(ImageView imageView){
        this.imageView = imageView;
    }

    @Override
    protected String doInBackground(Void... voids) {

        for(int i = 0; i < 30; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                Thread.interrupted();
                Log.e(LOG_TAG, "" + ie);
            }
            publishProgress(i);
        }

        return "Hij is af";
    }

    @Override
    protected void onPostExecute(String result) {


    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        if(values[0] != 4) {
            imageView.setImageResource(R.drawable.seven);

        }
    }

}

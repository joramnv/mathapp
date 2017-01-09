package nl.visser.joram.mathapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import nl.visser.joram.mathapp.R;

import static nl.visser.joram.mathapp.util.StringUtils.isBlank;

public abstract class MenuActivity extends AppCompatActivity{

    private static final String LOG_TAG =  MenuActivity.class.getSimpleName();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void logger(String logTag, String message) {
        if(isBlank(logTag)) {
            Log.d(LOG_TAG, message);
        } else {
            Log.d(logTag, message);
        }
    }

}

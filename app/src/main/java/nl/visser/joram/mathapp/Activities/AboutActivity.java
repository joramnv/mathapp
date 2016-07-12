package nl.visser.joram.mathapp.Activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import nl.visser.joram.mathapp.R;

public class AboutActivity extends MenuActivity {

    private static final String LOG_TAG = AboutActivity.class.getSimpleName();

    private String settingsInfo = "This math app is developed for self education purposes.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textViewSettings = (TextView) findViewById(R.id.textViewSettings);
        textViewSettings.setText(settingsInfo);

    }
}

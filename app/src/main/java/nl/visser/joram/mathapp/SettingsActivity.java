package nl.visser.joram.mathapp;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import org.honorato.multistatetogglebutton.MultiStateToggleButton;
import org.honorato.multistatetogglebutton.ToggleButton;

public class SettingsActivity extends MenuActivity {

    private static final String LOG_TAG = "SettingsActivity"; //The log tag can only be 23 characters long.

    private String settingsInfo = "Here you can set the difficulty.\nThe current difficulty is set to: ";
    private String currentDifficulty = Integer.toString(Difficulty.INSTANCE.getDifficulty());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textViewSettings = (TextView) findViewById(R.id.textViewSettings);
        textViewSettings.setText(settingsInfo + currentDifficulty);

        MultiStateToggleButton toggleButton = (MultiStateToggleButton) this.findViewById(R.id.button_toggle);
        toggleButton.setOnValueChangedListener(new ToggleButton.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                Log.d(LOG_TAG, "Value: " + value);
                if (value == 0) {
                    Difficulty.INSTANCE.setDifficulty(1);
                } else if (value == 1) {
                    Difficulty.INSTANCE.setDifficulty(2);
                } else if (value == 2) {
                    Difficulty.INSTANCE.setDifficulty(3);
                }
                changedDifficulty();
            }
        });
    }

    public void changedDifficulty() {
        TextView textViewSettings = (TextView) findViewById(R.id.textViewSettings);
        textViewSettings.setText(settingsInfo + currentDifficulty);
    }
}

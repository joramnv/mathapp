package nl.visser.joram.mathapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

public class TimeTrialAdditionActivity extends MenuActivity {

    private static final String LOG_TAG =  TimeTrialAdditionActivity.class.getSimpleName();

    private Numpad numpad;
    private TimerTask timerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_trial_addition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentManager fragmentManager = getSupportFragmentManager();
        NumbersFragment numbersFragment = new NumbersFragment();
        NumpadFragment numpadFragment = new NumpadFragment();
        if(savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container_numbers_time_trial_addition, numbersFragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .add(R.id.container_numpad_time_trial_addition, numpadFragment)
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container_numbers_time_trial_addition, numbersFragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .replace(R.id.container_numpad_time_trial_addition, numpadFragment)
                    .commit();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("MODE", 1);
        numbersFragment.setArguments(bundle);
        MathFragmentManager.INSTANCE.setNumbersFragment(numbersFragment);
        numpad = numpadFragment;

        ProgressBar timerBar = (ProgressBar) findViewById(R.id.timerBar);
        startTimer(timerBar);
    }

    public void onClickNumpadButton(View view) {
        numpad.onClickNumpadButton(view);
    }

    public void startTimer(ProgressBar timerBar) {
        timerManager = new TimerTask(this, timerBar);
        timerManager.execute();
    }

    public void showScoreboard() {
        Intent intent = new Intent(this, ScoreboardActivity.class);
        startActivity(intent);
    }
}

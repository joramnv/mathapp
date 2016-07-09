package nl.visser.joram.mathapp.Activities;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import nl.visser.joram.mathapp.Fragments.MathFragmentManager;
import nl.visser.joram.mathapp.Fragments.NumbersFragment;
import nl.visser.joram.mathapp.Numpad;
import nl.visser.joram.mathapp.Fragments.NumpadFragment;
import nl.visser.joram.mathapp.R;
import nl.visser.joram.mathapp.Fragments.TimerFragment;

public class SubtractionActivity extends MenuActivity {

    private static final String LOG_TAG = SubtractionActivity.class.getSimpleName();

    private Numpad numpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        boolean showTimer = intent.getBooleanExtra(MainActivity.EXTRA_MESSAGE, false);

        if(showTimer) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            TimerFragment timerFragment = new TimerFragment();
            if(savedInstanceState == null) {
                fragmentManager.beginTransaction()
                        .add(R.id.container_timer_fragment, timerFragment)
                        .commit();
            } else {
                fragmentManager.beginTransaction()
                        .replace(R.id.container_timer_fragment, timerFragment)
                        .commit();
            }
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        NumbersFragment numbersFragment = new NumbersFragment();
        NumpadFragment numpadFragment = new NumpadFragment();
        if(savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container_numbers_subtraction, numbersFragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .add(R.id.container_numpad_subtraction, numpadFragment)
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container_numbers_subtraction, numbersFragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .replace(R.id.container_numpad_subtraction, numpadFragment)
                    .commit();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("MODE", 2);
        numbersFragment.setArguments(bundle);
        MathFragmentManager.INSTANCE.setNumbersFragment(numbersFragment);
        numpad = numpadFragment;
    }

    public void onClickNumpadButton(View view) {
        numpad.onClickNumpadButton(view);
    }
}

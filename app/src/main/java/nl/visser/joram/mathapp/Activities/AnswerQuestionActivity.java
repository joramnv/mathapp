package nl.visser.joram.mathapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import nl.visser.joram.mathapp.Fragments.Category;
import nl.visser.joram.mathapp.Fragments.MathFragmentManager;
import nl.visser.joram.mathapp.Fragments.Mode;
import nl.visser.joram.mathapp.Fragments.NumbersFragment;
import nl.visser.joram.mathapp.Fragments.Numpad;
import nl.visser.joram.mathapp.Fragments.NumpadFragment;
import nl.visser.joram.mathapp.Fragments.TimerFragment;
import nl.visser.joram.mathapp.R;

public class AnswerQuestionActivity extends MenuActivity {

    private static final String LOG_TAG =  AnswerQuestionActivity.class.getSimpleName();

    private Numpad numpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Mode mode = (Mode) bundle.get("MODE");
        boolean showTimer = false;
        if (mode == Mode.TIME_TRIAL) {
            showTimer = true;
        }

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
                    .add(R.id.container_numbers_addition, numbersFragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .add(R.id.container_numpad_addition, numpadFragment)
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container_numbers_addition, numbersFragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .replace(R.id.container_numpad_addition, numpadFragment)
                    .commit();
        }

        Bundle getBundleCategory = intent.getExtras();
        Category[] category = (Category[]) bundle.get("CATEGORY");
        Log.v(LOG_TAG, "category contains: " + category[0] + ", " + category[1] + ", "  + category[2] + ", "  + category[3]);
        //TODO simple randomGenerateCategory for now


        Bundle bundleCategory = new Bundle();
        //TODO get this category from .... somewhere.
        if(category[0] != null) {
            bundleCategory.putSerializable("CATEGORY", category[0]);
        } else if(category[1] != null) {
            bundleCategory.putSerializable("CATEGORY", category[1]);
        }
        numbersFragment.setArguments(bundleCategory);
        MathFragmentManager.INSTANCE.setNumbersFragment(numbersFragment);
        numpad = numpadFragment;
    }

    public void onClickNumpadButton(View view) {
        numpad.onClickNumpadButton(view);
    }
}

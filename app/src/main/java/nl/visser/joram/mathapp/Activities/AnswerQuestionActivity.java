package nl.visser.joram.mathapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

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

    private TextView mTextField;

    private Numpad numpad;
    private Intent intent;
    private boolean showTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTextField = (TextView) findViewById(R.id.textview_123);

        intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Mode mode = (Mode) bundle.get("MODE");
        showTimer = false;
        if (mode == Mode.TIME_TRIAL) {
            showTimer = true;
            //TODO start countDown()
        }
        switch (mode) {
            case NORMAL: { startFragments();
                         break;
            }
            case TIME_TRIAL: countDown();
            case ENDLESS: break;
        }


    }

    public void onClickNumpadButton(View view) {
        numpad.onClickNumpadButton(view);
    }

    public void countDown() {
        /**
         * 3 second count down (set to 5 seconds for reasons explained below).
         * onTick() and onFinish() will not happen at exact times, but instead in this case
         * millisUntilFinished parameter will have values like 4995 etc. down to 990.
         * Furthermore calculation in the onTick method uses integer divisions (remainder is cut
         * off).
         * So continuing the example on the last call 990/1000 will be 0, but onFinish will be
         * called only about 1000ms later. That's why there is about 1 ms delay when onFinish is
         * used to invoke another method. And that's why the method invocation is placed inside the
         * onTick method instead.
         */
        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished / 1000 > 1) {
                    mTextField.setText("seconds remaining: " + (millisUntilFinished / 1000 - 1));
                } else {
                    mTextField.setVisibility(View.INVISIBLE);
                    startFragments();
                }
            }
            public void onFinish() {
            }
        }.start();
    }

    public void startFragments() {
        if(showTimer) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            TimerFragment timerFragment = new TimerFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.container_timer_fragment, timerFragment)
                    .commit();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        NumbersFragment numbersFragment = new NumbersFragment();
        NumpadFragment numpadFragment = new NumpadFragment();
        fragmentManager.beginTransaction()
                .add(R.id.container_numbers_addition, numbersFragment)
                .commit();
        fragmentManager.beginTransaction()
                .add(R.id.container_numpad_addition, numpadFragment)
                .commit();

        Bundle getBundleCategory = intent.getExtras();

        //TODO simple randomGenerateCategory for now
        ArrayList<Category> categoryArrayList = (ArrayList<Category>) getBundleCategory.get("CATEGORY");

        Bundle bundleCategory = new Bundle();
        //TODO get this category from .... somewhere.
        if(categoryArrayList.contains(Category.ADDITIONS)) {
            bundleCategory.putSerializable("CATEGORY", Category.ADDITIONS);
        } else if(categoryArrayList.contains(Category.SUBTRACTIONS)) {
            bundleCategory.putSerializable("CATEGORY", Category.SUBTRACTIONS);
        }
        numbersFragment.setArguments(bundleCategory);
        MathFragmentManager.INSTANCE.setNumbersFragment(numbersFragment);
        numpad = numpadFragment;
    }
}

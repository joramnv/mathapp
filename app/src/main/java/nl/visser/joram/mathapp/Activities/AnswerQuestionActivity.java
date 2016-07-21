package nl.visser.joram.mathapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import nl.visser.joram.mathapp.Calculator;
import nl.visser.joram.mathapp.Digit;
import nl.visser.joram.mathapp.Fragments.Category;
import nl.visser.joram.mathapp.Fragments.MathFragmentManager;
import nl.visser.joram.mathapp.Fragments.Mode;
import nl.visser.joram.mathapp.Fragments.NumbersFragment;
import nl.visser.joram.mathapp.Fragments.Numpad;
import nl.visser.joram.mathapp.Fragments.NumpadFragment;
import nl.visser.joram.mathapp.Fragments.TimerFragment;
import nl.visser.joram.mathapp.MathAppNumber;
import nl.visser.joram.mathapp.Operator;
import nl.visser.joram.mathapp.R;
import nl.visser.joram.mathapp.Sum;

public class AnswerQuestionActivity extends MenuActivity implements NumpadFragment.NumpadListener {

    private static final String LOG_TAG =  AnswerQuestionActivity.class.getSimpleName();

    private ImageView chalksImages;

    private Intent intent;
    private boolean showTimer;
    private boolean endlessMode = false;
    private TimerFragment timerFragment;
    private NumbersFragment numbersFragment;
    private NumpadFragment numpadFragment;

    private MathAppNumber userInputNumber;
    private Calculator calculator;
    private Sum experimentSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        chalksImages = (ImageView) findViewById(R.id.chalks);
        intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Mode mode = (Mode) bundle.get("MODE");
        showTimer = false;
        switch (mode) {
            case NORMAL:
                startFragments();
                break;
            case ENDLESS:
                endlessMode = true;
            case TIME_TRIAL:
                countDown();
                showTimer = true;
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(timerFragment != null) {
            timerFragment.onPause();
        }
        if(numbersFragment != null) {
            numbersFragment.onPause();
        }
        if(numpadFragment != null) {
            numpadFragment.onPause();
        }
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
                if (millisUntilFinished > 4000) {
                    chalksImages.setImageResource(R.drawable.red_chalks);
                } else if (millisUntilFinished > 3000 && millisUntilFinished <= 4000) {
                    chalksImages.setImageResource(R.drawable.orange_chalks);
                } else if (millisUntilFinished > 2000 && millisUntilFinished <= 3000) {
                    chalksImages.setImageResource(R.drawable.green_chalk);
                } else if (millisUntilFinished <= 2000){
                    chalksImages.setVisibility(View.INVISIBLE);
                    startFragments();
                }
            }
            public void onFinish() {
            }
        }.start();
    }

    public void startFragments() {

        instantiateUserAnswer();
        calculator = new Calculator();
        experimentSum = new Sum();
        MathAppNumber n1 = new MathAppNumber();
        MathAppNumber n2 = new MathAppNumber();
        n1.pushDigit(Digit.FIVE);
        n2.pushDigit(Digit.SIX);
        experimentSum.pushNumber(n1);
        experimentSum.pushNumber(n2);
        experimentSum.pushOperator(Operator.PLUS);


        if(showTimer) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            timerFragment = new TimerFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.container_timer_fragment, timerFragment)
                    .commit();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        numbersFragment = new NumbersFragment();
        numpadFragment = new NumpadFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.container_numbers_addition, numbersFragment)
                .commit();
        fragmentManager.beginTransaction()
                .replace(R.id.container_numpad_addition, numpadFragment)
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

    }

    public void instantiateUserAnswer() {
        userInputNumber = new MathAppNumber();
    }

    @Override
    public void onNumpadButtonPress(Digit digit) {
        userInputNumber.pushDigit(digit);
        numbersFragment.onClickNumpadButtonNumber(digit);
    }

    @Override
    public void onOperatorButtonPress(Operator operator) {
        switch (operator) {
            case MINUS:
                numbersFragment.turnUserAnswerToNegative();
                break;
            case EQUALS:
                if (calculator.calculateAnswerIsTrue(experimentSum, userInputNumber)) {
                    Log.d(LOG_TAG, "waar");
                    numbersFragment.showCorrectAnswer();
                } else{
                    Log.d(LOG_TAG, "niet waar");
                    numbersFragment.showWrongAnswer();
                }
                break;
            case BACK:
                numbersFragment.backSpaceUserAnswer();
                break;
            case CLEAR:
                userInputNumber.removeDigits();
                numbersFragment.clearUserAnswer();
                break;
        }
    }

}

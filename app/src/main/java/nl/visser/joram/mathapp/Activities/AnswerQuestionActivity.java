package nl.visser.joram.mathapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import nl.visser.joram.mathapp.CalculationModule.Calculator;
import nl.visser.joram.mathapp.CalculationModule.Digit;
import nl.visser.joram.mathapp.Fragments.Category;
import nl.visser.joram.mathapp.Fragments.MathFragmentManager;
import nl.visser.joram.mathapp.Fragments.Mode;
import nl.visser.joram.mathapp.Fragments.NumbersFragment;
import nl.visser.joram.mathapp.Fragments.Numpad;
import nl.visser.joram.mathapp.Fragments.NumpadFragment;
import nl.visser.joram.mathapp.Fragments.TimerFragment;
import nl.visser.joram.mathapp.CalculationModule.MathAppNumber;
import nl.visser.joram.mathapp.CalculationModule.Operator;
import nl.visser.joram.mathapp.R;
import nl.visser.joram.mathapp.CalculationModule.Sum;
import nl.visser.joram.mathapp.CalculationModule.SumGenerator;

public class AnswerQuestionActivity extends MenuActivity implements NumbersFragment.OnCompleteListener, NumpadFragment.NumpadListener, TimerFragment.OnFragmentInteractionListener {

    private static final String LOG_TAG =  AnswerQuestionActivity.class.getSimpleName();

    private ImageView chalksImages;

    private Numpad numpad;

    private Intent intent;
    private boolean showTimer;
    private boolean endlessMode = false;
    private TimerFragment timerFragment;
    private NumbersFragment numbersFragment;
    private NumpadFragment numpadFragment;
    private boolean gameState;

    private MathAppNumber userInputNumber;
    private Calculator calculator;
    private SumGenerator sumGenerator;
    private Sum sum;
    private ArrayList<Category> categoryArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sumGenerator = new SumGenerator();
        intent = this.getIntent();
        Bundle getBundleCategory = intent.getExtras();
        categoryArrayList = new ArrayList<>();
        categoryArrayList = (ArrayList<Category>) getBundleCategory.get("CATEGORY");

        if(savedInstanceState != null) {
            sum = (Sum) savedInstanceState.getSerializable("SOM");
            gameState = savedInstanceState.getBoolean("GAME_STATE");
        } else {
            getSum();
        }

        setContentView(R.layout.activity_answer_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        state.putSerializable("SOM", sum);
        state.putBoolean("GAME_STATE", gameState);
        super.onSaveInstanceState(state);
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
                if(gameState == false) {
                    countDown();
                    showTimer = true;
                } else {
                    startFragments();
                }
                break;
        }
        gameState = true;
    }

    public void onClickNumpadButton(View view) {
        numpad.onClickNumpadButton(view);
    }

    @Override
    public void onPause() {
        super.onPause();
        if(timerFragment != null) {
            timerFragment.onPause();
            timerFragment = null;
        }
        if(numbersFragment != null) {
            numbersFragment.onPause();
            numbersFragment = null;
        }
        if(numpadFragment != null) {
            numpadFragment.onPause();
            numpadFragment = null;
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
        calculator = new Calculator();

        userInputNumber = new MathAppNumber();
        FragmentManager fragmentManager = getSupportFragmentManager();

        if(showTimer) {

            if(fragmentManager.findFragmentByTag("HenkTimer") == null) {
                timerFragment = new TimerFragment();
                fragmentManager.beginTransaction().replace(R.id.container_timer, timerFragment, "HenkTimer").commit();
            } else {
                timerFragment = (TimerFragment) fragmentManager.findFragmentByTag("HenkTimer");
                fragmentManager.beginTransaction().replace(R.id.container_timer, timerFragment);
            }
        }

        if(fragmentManager.findFragmentByTag("Jan") == null) {
            numbersFragment = new NumbersFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.container_numbers, numbersFragment, "Jan")
                    .commit();
        } else {
            numbersFragment = (NumbersFragment) fragmentManager.findFragmentByTag("Jan");
            fragmentManager.beginTransaction().replace(R.id.container_numbers,numbersFragment);
        }
        numpadFragment = new NumpadFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.container_numpad, numpadFragment, "Henk")
                .commit();



        numpad = numpadFragment;


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
                userInputNumber.turnNegative();
                break;
            case EQUALS:
                if(calculator.calculateWhetherAnswerIsTrue(sum, userInputNumber)) {
                    numbersFragment.showCorrectAnswer();
                } else {
                    numbersFragment.showWrongAnswer();
                }
                getSum();
                drawSum();
                userInputNumber.initiate();
                numbersFragment.clearUserAnswer();
                break;
            case BACK:
                numbersFragment.backspaceUserAnswer();
                userInputNumber.removeLastDigit();
                break;
            case CLEAR:
                userInputNumber.removeDigits();
                numbersFragment.clearUserAnswer();
                break;
        }
    }

    public void showScoreboard() {
        numbersFragment.onRemove();
        numpadFragment.onRemove();
        timerFragment.onRemove();
        Intent intent = new Intent(this, ScoreboardActivity.class);
        startActivity(intent);
    }

    public void getSum() {
        //TODO difficulty dynamisch zetten.
        sum = sumGenerator.generateRandomSum(2, categoryArrayList);

    }

    public void drawSum() {
        numbersFragment.drawSum(sum);
    }

    public void onFragmentLoaded() {
        drawSum();
    }
}

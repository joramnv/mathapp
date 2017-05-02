package nl.visser.joram.mathapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import nl.visser.joram.mathapp.calculationModule.Digit;
import nl.visser.joram.mathapp.bundles.Category;
import nl.visser.joram.mathapp.bundles.Mode;
import nl.visser.joram.mathapp.calculationModule.MathAppNumber;
import nl.visser.joram.mathapp.calculationModule.MathAppNumberImpl;
import nl.visser.joram.mathapp.fragments.NumbersFragment;
import nl.visser.joram.mathapp.fragments.NumpadFragment;
import nl.visser.joram.mathapp.fragments.Impl.NumpadFragmentImpl;
import nl.visser.joram.mathapp.fragments.TimerFragment;
import nl.visser.joram.mathapp.calculationModule.Operator;
import nl.visser.joram.mathapp.R;
import nl.visser.joram.mathapp.calculationModule.Sum;
import nl.visser.joram.mathapp.calculationModule.SumGenerator;

import static nl.visser.joram.mathapp.calculationModule.Calculator.calculateSumEqualsUserInputNumber;

public class AnswerQuestionActivity extends MenuActivity implements NumbersFragment.OnCompleteListener, NumpadFragmentImpl.NumpadListener, TimerFragment.OnFragmentInteractionListener {

    private ImageView chalksImages;

    private NumpadFragment numpadFragment;

    private Intent intent;
    private boolean showTimer;
    private boolean endlessMode = false;
    private TimerFragment timerFragment;
    private NumbersFragment numbersFragment;
    private NumpadFragmentImpl numpadFragmentImpl;

    private MathAppNumber userInputNumber;
    private SumGenerator sumGenerator;
    private Sum sum;
    private List<Category> categories;

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
            case ENDLESS_MODE:
                endlessMode = true;
            case TIME_TRIAL:
                countDown();
                showTimer = true;
                break;
        }
    }

    public void onClickNumpadButton(View view) {
        numpadFragment.onClickNumpadButton(view);
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
        if(numpadFragmentImpl != null) {
            numpadFragmentImpl.onPause();
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
        sumGenerator = new SumGenerator();
        userInputNumber = new MathAppNumberImpl();
        if(showTimer) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            timerFragment = new TimerFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.container_timer, timerFragment)
                    .commit();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        numbersFragment = new NumbersFragment();
        numpadFragmentImpl = new NumpadFragmentImpl();
        fragmentManager.beginTransaction()
                .replace(R.id.container_numbers, numbersFragment)
                .commit();
        fragmentManager.beginTransaction()
                .replace(R.id.container_numpad, numpadFragmentImpl)
                .commit();
        Bundle getBundleCategory = intent.getExtras();
        categories = (List<Category>) getBundleCategory.get("CATEGORY");
        numpadFragment = numpadFragmentImpl;
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
                if(calculateSumEqualsUserInputNumber(sum, userInputNumber)) {
                    numbersFragment.showCorrectAnswer();
                } else {
                    numbersFragment.showWrongAnswer();
                }
                getSum();
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
        numpadFragmentImpl.onRemove();
        timerFragment.onRemove();
        Intent intent = new Intent(this, NameYourScoreActivity.class);
        startActivity(intent);
    }

    private void getSum() {
        //TODO difficulty dynamisch zetten.
        sum = sumGenerator.generateRandomSum(2, categories);
        numbersFragment.drawSum(sum);
    }

    public void onComplete() {
        getSum();
    }

}

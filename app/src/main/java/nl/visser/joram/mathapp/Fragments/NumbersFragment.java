package nl.visser.joram.mathapp.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import nl.visser.joram.mathapp.CalculationModule.Digit;
import nl.visser.joram.mathapp.CalculationModule.MathAppNumber;
import nl.visser.joram.mathapp.CalculationModule.Operator;
import nl.visser.joram.mathapp.R;
import nl.visser.joram.mathapp.Score;
import nl.visser.joram.mathapp.CalculationModule.Sum;

/**
 * A placeholder fragment containing a simple view.
 */
public class NumbersFragment extends Fragment {

    private static final String LOG_TAG = NumbersFragment.class.getSimpleName();

    private int userAnswer = 0;
    private boolean minusFlag = false;
    private Score score = Score.INSTANCE;
    private Category category;
    private LinearLayout layout;
    private TextView textViewAnswer;
    private Sum startingSum;

    public NumbersFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numbers, container, false);
        layout = (LinearLayout)view.findViewById(R.id.question_frame);
        textViewAnswer = (TextView)view.findViewById(R.id.textViewAnswer);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = this.getArguments();
        category = (Category) bundle.get("CATEGORY");
        startingSum = (Sum) bundle.get("FIRST_SUM");
        Log.v(LOG_TAG, "Category = " + category);
        drawSum(startingSum);
    }

    @Override
    public void onPause() {
        super.onPause();
        layout.removeAllViews();
    }

    public void backSpaceUserAnswer() {
        userAnswer /= 10;
        if(userAnswer == 0) {
            textViewAnswer.setText("");
        } else {
            textViewAnswer.setText(""+ userAnswer);
        }
    }

    public void clearUserAnswer() {
        //Clear - remove all numbers.
        userAnswer = 0;
        textViewAnswer.setText("");
    }

    public void turnUserAnswerToNegative() {
        userAnswer *= -1;
        if(userAnswer == 0) {
            minusFlag = true;
            textViewAnswer.setText("-");
        } else {
            textViewAnswer.setText(""+ userAnswer);
        }
    }

    public void onClickNumpadButtonNumber(Digit buttonNumber) {
        if(minusFlag) {
            userAnswer = buttonNumber.getValue() * -1;
            Log.d(LOG_TAG, "userAnswer = " + userAnswer + "buttonNumber = " + buttonNumber.getValue());
            minusFlag = false;
        }
        else {
            if(userAnswer < 0) {
                userAnswer = userAnswer * 10 - buttonNumber.getValue();
            } else {
                userAnswer = userAnswer * 10 + buttonNumber.getValue();
            }
        }
        textViewAnswer.setText(""+ userAnswer);
    }

    public void showCorrectAnswer() {
        score.updateScoreForCurrentSession(true);

        Context context = getContext();
        CharSequence text = "Good!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text + " " + String.valueOf(score.getScore()), duration);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 36);
        toast.show();

        userAnswer = 0;
        textViewAnswer.setText("");
    }

    public void showWrongAnswer() {
        score.updateScoreForCurrentSession(false);

        Context context = getContext();
        CharSequence text = "Wrong!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text + " " + String.valueOf(score.getScore()), duration);
        toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 36);
        toast.show();
    }

    public void drawSum(Sum sum) {
        layout.removeAllViews();

        List<MathAppNumber> numbers = sum.getNumbersOfSum();

        int amountOfNumbers = sum.getNumbersOfSum().size();
        int amountOfOperators = sum.getOperatorsOfSum().size();

        for(int i = 0; i < amountOfNumbers; i++) {
            LinkedList<Digit> digitsForNumber = numbers.get(i).getDigits();
            int amountOfDigitsForNumber = digitsForNumber.size();

            for(int j = amountOfDigitsForNumber-1; j >= 0; j--) {
                ImageView digitImage = new ImageView(getContext());

                digitImage.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                digitImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                digitImage.setImageResource(digitsForNumber.get(j).getDrawable());

                layout.addView(digitImage);
            }
            if(i < amountOfOperators) {
                ImageView operationImage = new ImageView(getContext());

                operationImage.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                operationImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                operationImage.setImageResource(sum.getOperatorsOfSum().get(i).getDrawable());
                layout.addView(operationImage);
            }
        }
        ImageView equalsImage = new ImageView(getContext());
        equalsImage.setImageResource(Operator.EQUALS.getDrawable());
        layout.addView(equalsImage);
    }
}
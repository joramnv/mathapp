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

import nl.visser.joram.mathapp.Difficulty;
import nl.visser.joram.mathapp.Digit;
import nl.visser.joram.mathapp.MathAppNumber;
import nl.visser.joram.mathapp.R;
import nl.visser.joram.mathapp.RandomNumberGenerator;
import nl.visser.joram.mathapp.Score;
import nl.visser.joram.mathapp.Sum;

/**
 * A placeholder fragment containing a simple view.
 */
public class NumbersFragment extends Fragment {

    private static final String LOG_TAG = NumbersFragment.class.getSimpleName();

    private int userAnswer = 0;
    private boolean minusFlag = false;
    private Score score = Score.INSTANCE;
    private Category category;
    private RandomNumberGenerator randomNumberGenerator;
    private LinearLayout layout;
    private TextView textViewAnswer;

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
        Log.v(LOG_TAG, "Category = " + category);
        //showRandomNumber();
    }

    @Override
    public void onPause() {
        super.onPause();
        layout.removeAllViews();
    }

    public void onClickNumpadButton(String buttonContent) {

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

        //showRandomNumber();
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

            ImageView image = new ImageView(getContext());
            image.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
            image.setScaleType(ImageView.ScaleType.FIT_CENTER);

            LinkedList<Digit> digitsForNumber = numbers.get(i).getDigits();
            int amountOfDigitsForNumber = digitsForNumber.size();

            for(int j = 0; j < amountOfDigitsForNumber; j++) {
                image.setImageResource(digitsForNumber.get(j).getDrawable());

            }
            if(i <= amountOfOperators) {
                image.setImageResource(sum.getOperatorsOfSum().get(i).getDrawable());
            }
            layout.addView(image);
        }

    }

/*
    public void showRandomNumber() {
        layout.removeAllViews();
        randomNumberGenerator = new RandomNumberGenerator(Difficulty.INSTANCE.getDifficulty());

        int firstRandomNumber = randomNumberGenerator.getFirstNumber();
        setNumber(firstRandomNumber);

        ImageView imageOperation = new ImageView(getContext());
        imageOperation.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
        imageOperation.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if(category == Category.ADDITIONS) {
            imageOperation.setImageResource(R.drawable.plus);
        } else if(category == Category.SUBTRACTIONS) {
            imageOperation.setImageResource(R.drawable.minus);
        } else if(category == Category.MULTIPLICATIONS) {
            imageOperation.setImageResource(R.drawable.times);
        } else if(category == Category.DIVISIONS) {
            imageOperation.setImageResource(R.drawable.division);
        }
        layout.addView(imageOperation);

        int secondRandomNumber = randomNumberGenerator.getSecondNumber();
        setNumber(secondRandomNumber);

        ImageView imageEquals = new ImageView(getContext());
        imageEquals.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
        imageEquals.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageEquals.setImageResource(R.drawable.equals);
        layout.addView(imageEquals);
    }

    public void setNumber(int number) {
        if(number < 10) {
            setImageViewDigitDynamic(number);
        } else if(10 <= number && number < 100) {
            setImageViewDigitDynamic(lastDigit(number/10));
            setImageViewDigitDynamic(lastDigit(number));
        } else if(100 <= number && number < 1000) {
            setImageViewDigitDynamic(lastDigit(number/100));
            setImageViewDigitDynamic(lastDigit(number/10));
            setImageViewDigitDynamic(lastDigit(number));
        } else if(1000 <= number && number < 10000) {
            setImageViewDigitDynamic(lastDigit(number/1000));
            setImageViewDigitDynamic(lastDigit(number/100));
            setImageViewDigitDynamic(lastDigit(number/10));
            setImageViewDigitDynamic(lastDigit(number));
        }
    }

    public int lastDigit(int number) {
        return number % 10;
    }

    public void setImageViewDigitDynamic(int digit) {
        ImageView image = new ImageView(getContext());
        image.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
        image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        image.setImageResource(R.drawable.nine);
        if(digit == 0) {
            image.setImageResource(R.drawable.zero);
        } else if(digit == 1) {
            image.setImageResource(R.drawable.one);
        } else if(digit == 2) {
            image.setImageResource(R.drawable.two);
        } else if(digit == 3) {
            image.setImageResource(R.drawable.three);
        } else if(digit == 4) {
            image.setImageResource(R.drawable.four);
        } else if(digit == 5) {
            image.setImageResource(R.drawable.five);
        } else if(digit == 6) {
            image.setImageResource(R.drawable.six);
        } else if(digit == 7) {
            image.setImageResource(R.drawable.seven);
        } else if(digit == 8) {
            image.setImageResource(R.drawable.eight);
        } else if(digit == 9) {
            image.setImageResource(R.drawable.nine);
        }
        layout.addView(image);
    }*/
}
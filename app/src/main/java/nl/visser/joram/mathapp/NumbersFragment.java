package nl.visser.joram.mathapp;

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

/**
 * A placeholder fragment containing a simple view.
 */
public class NumbersFragment extends Fragment {

    private static final String LOG_TAG = NumbersFragment.class.getSimpleName();

    private int userAnswer = 0;
    private boolean minusFlag = false;
    private Score score = Score.INSTANCE;
    private int mode;
    private RandomNumberGenerator randomNumberGenerator;
    private LinearLayout layout;
    private TextView textViewAnswer;

    public NumbersFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_numbers, container, false);

        Bundle bundle = this.getArguments();
        mode = bundle.getInt("MODE", 1);
        Log.v(LOG_TAG, "Mode = " + mode);

        score.setScore(0);

        randomNumberGenerator = new RandomNumberGenerator(Difficulty.INSTANCE.getDifficulty());

        layout = (LinearLayout)view.findViewById(R.id.question_frame);

        int firstRandomNumber = randomNumberGenerator.getFirstNumber();
        setNumber(firstRandomNumber);

        ImageView imageOperation = new ImageView(getContext());
        imageOperation.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
        imageOperation.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if(mode == 1) {
            imageOperation.setImageResource(R.drawable.plus);
        } else if(mode == 2) {
            imageOperation.setImageResource(R.drawable.minus);
        } else if(mode == 3) {
            imageOperation.setImageResource(R.drawable.times);
        } else if(mode == 4) {
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

        textViewAnswer = (TextView)view.findViewById(R.id.textViewAnswer);

        return view;
    }

    public void onClickNumpadButton(String buttonContent) {
        switch(buttonContent) {
            case "-":
                //Minus - make a positive number negative and vice versa.
                userAnswer *= -1;
                if(userAnswer == 0) {
                    minusFlag = true;
                    textViewAnswer.setText("-");
                } else {
                    textViewAnswer.setText(""+ userAnswer);
                }
                break;
            case "c":
                //Clear - remove all numbers.
                userAnswer = 0;
                textViewAnswer.setText("");
                break;
            case "b":
                //Backspace - remove most left number.
                userAnswer /= 10;
                if(userAnswer == 0) {
                    textViewAnswer.setText("");
                } else {
                    textViewAnswer.setText(""+ userAnswer);
                }
                break;
            case "=":
                //Equals - check if userAnswer is correct.
                userAnswerEqualsResultQuestion(userAnswer);
                break;
        }
    }

    public void onClickNumpadButtonNumber(int buttonNumber) {
        if(minusFlag) {
            userAnswer = buttonNumber * -1;
            Log.d(LOG_TAG, "userAnswer = " + userAnswer + "buttonNumber = " + buttonNumber);
            minusFlag = false;
        }
        else {
            if(userAnswer < 0) {
                userAnswer = userAnswer * 10 - buttonNumber;
            } else {
                userAnswer = userAnswer * 10 + buttonNumber;
            }
        }
        textViewAnswer.setText(""+ userAnswer);
    }

    public void userAnswerEqualsResultQuestion(int textViewAnswerContent) {
        int result = 0;
        if(mode == 1) {
            result = randomNumberGenerator.getAdditionEquals();
        } else if(mode == 2) {
            result = randomNumberGenerator.getSubtractionEquals();
        } else if(mode == 3) {
            result = randomNumberGenerator.getAdditionEquals(); //set to getMultiplicationEquals();
        } else if(mode == 4) {
            result = randomNumberGenerator.getAdditionEquals(); //set to getDivisionEquals();
        }
        if(textViewAnswerContent == result) {
            score.updateScoreForCurrentSession(true);

            Context context = getContext();
            CharSequence text = "Good!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text + " " + String.valueOf(score.getScore()), duration);
            toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 36);
            toast.show();

            randomNumberGenerator = new RandomNumberGenerator(Difficulty.INSTANCE.getDifficulty());
            this.userAnswer = 0;
            textViewAnswer.setText("");

            int firstRandomNumber = randomNumberGenerator.getFirstNumber();
            layout.removeAllViews();
            setNumber(firstRandomNumber);

            ImageView imageOperation = new ImageView(getContext());
            imageOperation.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
            imageOperation.setScaleType(ImageView.ScaleType.FIT_CENTER);
            if(mode == 1) {
                imageOperation.setImageResource(R.drawable.plus);
            } else if(mode == 2) {
                imageOperation.setImageResource(R.drawable.minus);
            } else if(mode == 3) {
                imageOperation.setImageResource(R.drawable.times);
            } else if(mode == 4) {
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

        } else {
            score.updateScoreForCurrentSession(false);

            Context context = getContext();
            CharSequence text = "Wrong!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text + " " + String.valueOf(score.getScore()), duration);
            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 36);
            toast.show();
        }
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
    }

    public int lastDigit(int number) {
        return number % 10;
    }
}
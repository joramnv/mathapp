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
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class NumbersFragment extends Fragment {

    private static final String LOG_TAG = NumbersFragment.class.getSimpleName();

    private int mode;
    private RandomNumberGenerator randomNumberGenerator;
    private TextView textViewAnswer;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;
    private ImageView imageView10;

    public NumbersFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_numbers, container, false);

        Bundle bundle = this.getArguments();
        mode = bundle.getInt("MODE", 1);
        imageView5 = (ImageView)view.findViewById(R.id.imageView5);
        if(mode == 1) {
            imageView5.setImageResource(R.drawable.plus);
        } else if(mode == 2) {
            imageView5.setImageResource(R.drawable.minus);
        } else if(mode == 3) {
            imageView5.setImageResource(R.drawable.times);
        } else if(mode == 4) {
            imageView5.setImageResource(R.drawable.division);
        }
        imageView10 = (ImageView)view.findViewById(R.id.imageView10);
        imageView10.setImageResource(R.drawable.equals);

        Log.d(LOG_TAG, "Mode = " + mode);

        randomNumberGenerator = new RandomNumberGenerator(Difficulty.INSTANCE.getDifficulty());

        imageView1 = (ImageView)view.findViewById(R.id.imageView1);
        imageView2 = (ImageView)view.findViewById(R.id.imageView2);
        imageView3 = (ImageView)view.findViewById(R.id.imageView3);
        imageView4 = (ImageView)view.findViewById(R.id.imageView4);
        setImageViewNumber(imageView1, imageView2, imageView3, imageView4, randomNumberGenerator.getFirstNumber());

        imageView6 = (ImageView)view.findViewById(R.id.imageView6);
        imageView7 = (ImageView)view.findViewById(R.id.imageView7);
        imageView8 = (ImageView)view.findViewById(R.id.imageView8);
        imageView9 = (ImageView)view.findViewById(R.id.imageView9);
        setImageViewNumber(imageView6, imageView7, imageView8, imageView9, randomNumberGenerator.getSecondNumber());

        textViewAnswer = (TextView)view.findViewById(R.id.textViewAnswer);

        return view;
    }

    public void onClick1() {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "1");
    }

    public void onClick2() {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "2");
    }

    public void onClick3() {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "3");
    }

    public void onClick4() {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "4");
    }

    public void onClick5() {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "5");
    }

    public void onClick6() {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "6");
    }

    public void onClick7() {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "7");
    }

    public void onClick8() {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "8");
    }

    public void onClick9() {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "9");
    }

    public void onClick0() {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "0");
    }

    public void onClickMinus() {
        textViewAnswer.setText("-");
    }

    public void onClickClear() {
        String inputNumber = textViewAnswer.getText().toString();
        if (inputNumber.length() >=1 ) {
            inputNumber = inputNumber.substring(0, inputNumber.length() - 1);
            textViewAnswer.setText(inputNumber);
        }
    }

    public void onClickEquals() {
        int result = 0;
        String inputNumber = textViewAnswer.getText().toString();
        if (!"".equals(inputNumber) && !"-".equals(inputNumber)) {
            if(mode == 1) {
                result = randomNumberGenerator.getAdditionEquals();
            } else if(mode == 2) {
                result = randomNumberGenerator.getSubtractionEquals();
            } else if(mode == 3) {
                result = randomNumberGenerator.getAdditionEquals(); //set to getMultiplicationEquals();
            } else if(mode == 4) {
                result = randomNumberGenerator.getAdditionEquals(); //set to getDivisionEquals();
            }
            if(Integer.parseInt(inputNumber) == result) {
                Context context = getContext();
                CharSequence text = "Good!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 36);
                toast.show();

                randomNumberGenerator = new RandomNumberGenerator(Difficulty.INSTANCE.getDifficulty());
                textViewAnswer.setText("");

                imageView1 = (ImageView)getView().findViewById(R.id.imageView1);
                imageView2 = (ImageView)getView().findViewById(R.id.imageView2);
                imageView3 = (ImageView)getView().findViewById(R.id.imageView3);
                imageView4 = (ImageView)getView().findViewById(R.id.imageView4);
                setImageViewNumber(imageView1, imageView2, imageView3, imageView4, randomNumberGenerator.getFirstNumber());

                imageView6 = (ImageView)getView().findViewById(R.id.imageView6);
                imageView7 = (ImageView)getView().findViewById(R.id.imageView7);
                imageView8 = (ImageView)getView().findViewById(R.id.imageView8);
                imageView9 = (ImageView)getView().findViewById(R.id.imageView9);
                setImageViewNumber(imageView6, imageView7, imageView8, imageView9, randomNumberGenerator.getSecondNumber());

            } else {
                Context context = getContext();
                CharSequence text = "Wrong!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 36);
                toast.show();
            }
        } else {
            Context context = getContext();
            CharSequence text = "Invalid input";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 36);
            toast.show();
        }
    }

    public void setImageViewNumber(ImageView imageViewToBeSet1, ImageView imageViewToBeSet2, ImageView imageViewToBeSet3, ImageView imageViewToBeSet4, int number) {
        imageViewToBeSet1.setImageResource(0);
        imageViewToBeSet2.setImageResource(0);
        imageViewToBeSet3.setImageResource(0);
        imageViewToBeSet4.setImageResource(0);

        int firstDigit = -1;
        int secondDigit = -1;
        int thirdDigit = -1;
        int fourthDigit = -1;

        if(number < 10) {
            fourthDigit = number;
        } else if(10 <= number && number < 100) {
            fourthDigit = lastDigit(number);
            thirdDigit = lastDigit((number)/10);
        } else if(100 <= number && number < 1000) {
            fourthDigit = lastDigit(number);
            thirdDigit = lastDigit((number)/10);
            secondDigit = lastDigit(number/100);
        } else if(1000 <= number && number < 10000) {
            fourthDigit = lastDigit(number);
            thirdDigit = lastDigit((number)/10);
            secondDigit = lastDigit(number/100);
            firstDigit = lastDigit(number/1000);
        }

        if(firstDigit == 0) {
            imageViewToBeSet1.setImageResource(R.drawable.zero);
        } else if(firstDigit == 1) {
            imageViewToBeSet1.setImageResource(R.drawable.one);
        } else if(firstDigit == 2) {
            imageViewToBeSet1.setImageResource(R.drawable.two);
        } else if(firstDigit == 3) {
            imageViewToBeSet1.setImageResource(R.drawable.three);
        } else if(firstDigit == 4) {
            imageViewToBeSet1.setImageResource(R.drawable.four);
        } else if(firstDigit == 5) {
            imageViewToBeSet1.setImageResource(R.drawable.five);
        } else if(firstDigit == 6) {
            imageViewToBeSet1.setImageResource(R.drawable.six);
        } else if(firstDigit == 7) {
            imageViewToBeSet1.setImageResource(R.drawable.seven);
        } else if(firstDigit == 8) {
            imageViewToBeSet1.setImageResource(R.drawable.eight);
        } else if(firstDigit == 9) {
            imageViewToBeSet1.setImageResource(R.drawable.nine);
        }

        if(secondDigit == 0) {
            imageViewToBeSet2.setImageResource(R.drawable.zero);
        } else if(secondDigit == 1) {
            imageViewToBeSet2.setImageResource(R.drawable.one);
        } else if(secondDigit == 2) {
            imageViewToBeSet2.setImageResource(R.drawable.two);
        } else if(secondDigit == 3) {
            imageViewToBeSet2.setImageResource(R.drawable.three);
        } else if(secondDigit == 4) {
            imageViewToBeSet2.setImageResource(R.drawable.four);
        } else if(secondDigit == 5) {
            imageViewToBeSet2.setImageResource(R.drawable.five);
        } else if(secondDigit == 6) {
            imageViewToBeSet2.setImageResource(R.drawable.six);
        } else if(secondDigit == 7) {
            imageViewToBeSet2.setImageResource(R.drawable.seven);
        } else if(secondDigit == 8) {
            imageViewToBeSet2.setImageResource(R.drawable.eight);
        } else if(secondDigit == 9) {
            imageViewToBeSet2.setImageResource(R.drawable.nine);
        }

        if(thirdDigit == 0) {
            imageViewToBeSet3.setImageResource(R.drawable.zero);
        } else if(thirdDigit == 1) {
            imageViewToBeSet3.setImageResource(R.drawable.one);
        } else if(thirdDigit == 2) {
            imageViewToBeSet3.setImageResource(R.drawable.two);
        } else if(thirdDigit == 3) {
            imageViewToBeSet3.setImageResource(R.drawable.three);
        } else if(thirdDigit == 4) {
            imageViewToBeSet3.setImageResource(R.drawable.four);
        } else if(thirdDigit == 5) {
            imageViewToBeSet3.setImageResource(R.drawable.five);
        } else if(thirdDigit == 6) {
            imageViewToBeSet3.setImageResource(R.drawable.six);
        } else if(thirdDigit == 7) {
            imageViewToBeSet3.setImageResource(R.drawable.seven);
        } else if(thirdDigit == 8) {
            imageViewToBeSet3.setImageResource(R.drawable.eight);
        } else if(thirdDigit == 9) {
            imageViewToBeSet3.setImageResource(R.drawable.nine);
        }

        if(fourthDigit == 0) {
            imageViewToBeSet4.setImageResource(R.drawable.zero);
        } else if(fourthDigit == 1) {
            imageViewToBeSet4.setImageResource(R.drawable.one);
        } else if(fourthDigit == 2) {
            imageViewToBeSet4.setImageResource(R.drawable.two);
        } else if(fourthDigit == 3) {
            imageViewToBeSet4.setImageResource(R.drawable.three);
        } else if(fourthDigit == 4) {
            imageViewToBeSet4.setImageResource(R.drawable.four);
        } else if(fourthDigit == 5) {
            imageViewToBeSet4.setImageResource(R.drawable.five);
        } else if(fourthDigit == 6) {
            imageViewToBeSet4.setImageResource(R.drawable.six);
        } else if(fourthDigit == 7) {
            imageViewToBeSet4.setImageResource(R.drawable.seven);
        } else if(fourthDigit == 8) {
            imageViewToBeSet4.setImageResource(R.drawable.eight);
        } else if(fourthDigit == 9) {
            imageViewToBeSet4.setImageResource(R.drawable.nine);
        }

        Log.v(LOG_TAG + " bottom", ""+number);
    }

    public int lastDigit(int number) {
        return number % 10;
    }
}

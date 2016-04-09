package nl.visser.joram.mathapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AdditionActivity extends MenuActivity {

    private static final String LOG_TAG = "AdditionActivity"; //The log tag can only be 23 characters long.

    private RandomAddition randomAddition;
    private TextView textViewAnswer;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    //imageView5 is set in content_addition private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;
    //imageView10 is set in content_addition private ImageView imageView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        randomAddition = new RandomAddition(Difficulty.INSTANCE.getDifficulty());

        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        imageView3 = (ImageView)findViewById(R.id.imageView3);
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        setImageViewNumber(imageView1, imageView2, imageView3, imageView4, randomAddition.getFirstNumber());

        imageView6 = (ImageView)findViewById(R.id.imageView6);
        imageView7 = (ImageView)findViewById(R.id.imageView7);
        imageView8 = (ImageView)findViewById(R.id.imageView8);
        imageView9 = (ImageView)findViewById(R.id.imageView9);
        setImageViewNumber(imageView6, imageView7, imageView8, imageView9, randomAddition.getSecondNumber());

        textViewAnswer = (TextView) findViewById(R.id.textViewAnswer);

    }

    public void onClick1(View view) {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "1");
    }

    public void onClick2(View view) {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "2");
    }

    public void onClick3(View view) {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "3");
    }

    public void onClick4(View view) {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "4");
    }

    public void onClick5(View view) {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "5");
    }

    public void onClick6(View view) {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "6");
    }

    public void onClick7(View view) {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "7");
    }

    public void onClick8(View view) {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "8");
    }

    public void onClick9(View view) {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "9");
    }

    public void onClick0(View view) {
        textViewAnswer.setText(textViewAnswer.getText().toString() + "0");
    }

    public void onClickMinus(View view) {
        textViewAnswer.setText("-");
    }

    public void onClickCorrection(View view) {
        String inputNumber = textViewAnswer.getText().toString();
        if (inputNumber.length() >=1 ) {
            inputNumber = inputNumber.substring(0, inputNumber.length() - 1);
            textViewAnswer.setText(inputNumber);
        }
    }

    public void onClickEquals(View view) {
        String inputNumber = textViewAnswer.getText().toString();
        if (!"".equals(inputNumber) && !"-".equals(inputNumber)) {
            if(Integer.parseInt(inputNumber) == randomAddition.getEquals()) {
                Context context = getApplicationContext();
                CharSequence text = "Good!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 36);
                toast.show();

                randomAddition = new RandomAddition(Difficulty.INSTANCE.getDifficulty());
                textViewAnswer.setText("");

                imageView1 = (ImageView)findViewById(R.id.imageView1);
                imageView2 = (ImageView)findViewById(R.id.imageView2);
                imageView3 = (ImageView)findViewById(R.id.imageView3);
                imageView4 = (ImageView)findViewById(R.id.imageView4);
                setImageViewNumber(imageView1, imageView2, imageView3, imageView4, randomAddition.getFirstNumber());

                imageView6 = (ImageView)findViewById(R.id.imageView6);
                imageView7 = (ImageView)findViewById(R.id.imageView7);
                imageView8 = (ImageView)findViewById(R.id.imageView8);
                imageView9 = (ImageView)findViewById(R.id.imageView9);
                setImageViewNumber(imageView6, imageView7, imageView8, imageView9, randomAddition.getSecondNumber());

            } else {
                Context context = getApplicationContext();
                CharSequence text = "Wrong!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 36);
                toast.show();
            }
        } else {
            Context context = getApplicationContext();
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
            firstDigit = number;
        } else if(10 <= number && number < 100) {
            firstDigit = findNextFirstDigit(number);
            int findSecondDigit = number-(firstDigit*10);
            secondDigit = findNextFirstDigit(findSecondDigit);
        } else if(100 <= number && number < 1000) {
            firstDigit = findNextFirstDigit(number);
            int findSecondDigit = number-(firstDigit*100);
            secondDigit = findNextFirstDigit(findSecondDigit);
            int findThirdDigit = findSecondDigit-(secondDigit*10);
            thirdDigit = findNextFirstDigit(findThirdDigit);
        } else if(1000 <= number && number < 10000) {
            firstDigit = findNextFirstDigit(number);
            int findSecondDigit = number-(firstDigit*1000);
            secondDigit = findNextFirstDigit(findSecondDigit);
            int findThirdDigit = findSecondDigit-(secondDigit*100);
            thirdDigit = findNextFirstDigit(findThirdDigit);
            int findFourthDigit = findThirdDigit-(thirdDigit*10);
            fourthDigit = findNextFirstDigit(findFourthDigit);
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

    public int findNextFirstDigit(int x) {
        while (x > 9) {
            x /= 10;
        }
        return x;
    }

}

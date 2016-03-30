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
    //is set in content_addition private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;
    //is set in content_addition private ImageView imageView10;

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
        if(number == 0) {
            imageViewToBeSet1.setImageResource(R.drawable.zero);
        } else if(number == 1) {
            imageViewToBeSet1.setImageResource(R.drawable.one);
        } else if(number == 2) {
            imageViewToBeSet1.setImageResource(R.drawable.two);
        } else if(number == 3) {
            imageViewToBeSet1.setImageResource(R.drawable.three);
        } else if(number == 4) {
            imageViewToBeSet1.setImageResource(R.drawable.four);
        } else if(number == 5) {
            imageViewToBeSet1.setImageResource(R.drawable.five);
        } else if(number == 6) {
            imageViewToBeSet1.setImageResource(R.drawable.six);
        } else if(number == 7) {
            imageViewToBeSet1.setImageResource(R.drawable.seven);
        } else if(number == 8) {
            imageViewToBeSet1.setImageResource(R.drawable.eight);
        } else if(number == 9) {
            imageViewToBeSet1.setImageResource(R.drawable.nine);
        } else if(number == 10) {
            imageViewToBeSet1.setImageResource(R.drawable.one);
            imageViewToBeSet2.setImageResource(R.drawable.zero);
        }
        Log.d(LOG_TAG + " bottom", ""+number);
    }
}

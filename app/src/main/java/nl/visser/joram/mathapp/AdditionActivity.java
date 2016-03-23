package nl.visser.joram.mathapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AdditionActivity extends MenuActivity {

    private static final String LOG_TAG = "AdditionActivity"; //The log tag can only be 23 characters long.

    private TextView textViewQuestion;
    private RandomAddition randomAddition;
    private TextView textViewAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //TODO open keyboard on create.

        textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);
        randomAddition = new RandomAddition(Difficulty.INSTANCE.getDifficulty());
        textViewQuestion.setText(randomAddition.getString());

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
            if(Integer.parseInt(inputNumber) == randomAddition.getInt()) {

                Context context = getApplicationContext();
                CharSequence text = "Good!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 36);
                toast.show();

                randomAddition = new RandomAddition(Difficulty.INSTANCE.getDifficulty());
                textViewQuestion.setText(randomAddition.getString());
                textViewAnswer.setText("");
            } else {
                textViewQuestion.setText(randomAddition.getString() + "\nWrong!");
            }
        } else {
            textViewQuestion.setText(randomAddition.getString() + "\nInvalid input");
        }
    }
}

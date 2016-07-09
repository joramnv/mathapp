package nl.visser.joram.mathapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import nl.visser.joram.mathapp.Numpad;
import nl.visser.joram.mathapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumpadFragment extends Fragment implements Numpad {

    private static final String LOG_TAG =  NumpadFragment.class.getSimpleName();

    public NumpadFragment() {
        // Required empty public constructor
    }

    NumbersFragment numbersFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        numbersFragment = MathFragmentManager.INSTANCE.getNumbersFragment();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_numpad, container, false);
    }

    public void onClickNumpadButton(View view) {
        Button button = (Button)view;
        int buttonId = button.getId();
        switch (buttonId) {
            case R.id.button1:
                numbersFragment.onClickNumpadButtonNumber(1);
                break;
            case R.id.button2:
                numbersFragment.onClickNumpadButtonNumber(2);
                break;
            case R.id.button3:
                numbersFragment.onClickNumpadButtonNumber(3);
                break;
            case R.id.button4:
                numbersFragment.onClickNumpadButtonNumber(4);
                break;
            case R.id.button5:
                numbersFragment.onClickNumpadButtonNumber(5);
                break;
            case R.id.button6:
                numbersFragment.onClickNumpadButtonNumber(6);
                break;
            case R.id.button7:
                numbersFragment.onClickNumpadButtonNumber(7);
                break;
            case R.id.button8:
                numbersFragment.onClickNumpadButtonNumber(8);
                break;
            case R.id.button9:
                numbersFragment.onClickNumpadButtonNumber(9);
                break;
            case R.id.button0:
                numbersFragment.onClickNumpadButtonNumber(0);
                break;
            case R.id.button_minus:
                numbersFragment.onClickNumpadButton("-");
                break;
            case R.id.button_clear:
                numbersFragment.onClickNumpadButton("c");
                break;
            case R.id.button_back:
                numbersFragment.onClickNumpadButton("b");
                break;
            case R.id.button_equals:
                numbersFragment.onClickNumpadButton("=");
                break;
        }
    }
}

package nl.visser.joram.mathapp.fragments.Impl;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import nl.visser.joram.mathapp.mathModule.sumComponents.Digit;
import nl.visser.joram.mathapp.mathModule.sumComponents.Operator;
import nl.visser.joram.mathapp.R;
import nl.visser.joram.mathapp.fragments.NumpadFragment;

public class NumpadFragmentImpl extends Fragment implements NumpadFragment {

    private NumpadListener numpadListener;

    public NumpadFragmentImpl() {
        // Required empty public constructor
    }

    public interface NumpadListener {
        void onNumpadButtonPress(Digit digit);
        void onOperatorButtonPress(Operator operator);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            numpadListener = (NumpadListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_numpad, container, false);
    }

    public void onClickNumpadButton(View view) {
        Button button = (Button)view;
        int buttonId = button.getId();
        switch (buttonId) {
            case R.id.button1:
                numpadListener.onNumpadButtonPress(Digit.ONE);
                break;
            case R.id.button2:
                numpadListener.onNumpadButtonPress(Digit.TWO);
                break;
            case R.id.button3:
                numpadListener.onNumpadButtonPress(Digit.THREE);
                break;
            case R.id.button4:
                numpadListener.onNumpadButtonPress(Digit.FOUR);
                break;
            case R.id.button5:
                numpadListener.onNumpadButtonPress(Digit.FIVE);
                break;
            case R.id.button6:
                numpadListener.onNumpadButtonPress(Digit.SIX);
                break;
            case R.id.button7:
                numpadListener.onNumpadButtonPress(Digit.SEVEN);
                break;
            case R.id.button8:
                numpadListener.onNumpadButtonPress(Digit.EIGHT);
                break;
            case R.id.button9:
                numpadListener.onNumpadButtonPress(Digit.NINE);
                break;
            case R.id.button0:
                numpadListener.onNumpadButtonPress(Digit.ZERO);
                break;
            case R.id.button_minus:
                numpadListener.onOperatorButtonPress(Operator.MINUS);
                break;
            case R.id.button_clear:
                numpadListener.onOperatorButtonPress(Operator.CLEAR);
                break;
            case R.id.button_back:
                numpadListener.onOperatorButtonPress(Operator.BACK);
                break;
            case R.id.button_equals:
                numpadListener.onOperatorButtonPress(Operator.EQUALS);
                break;
        }
    }

    public void onRemove() {
        getFragmentManager().beginTransaction()
                .remove(this)
                .commit();
    }

}

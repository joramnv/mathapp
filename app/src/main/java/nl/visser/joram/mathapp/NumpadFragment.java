package nl.visser.joram.mathapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumpadFragment extends Fragment implements Numpad {

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
        String buttonContent = (String)button.getText();
        numbersFragment.onClickNumpadButton(buttonContent);
    }
}

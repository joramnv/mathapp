package nl.visser.joram.mathapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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

    public void onClick1(View view) {
        numbersFragment.onClick1();
    }

    public void onClick2(View view) {
        numbersFragment.onClick2();
    }

    public void onClick3(View view) {
        numbersFragment.onClick3();
    }

    public void onClick4(View view) {
        numbersFragment.onClick4();
    }

    public void onClick5(View view) {
        numbersFragment.onClick5();
    }

    public void onClick6(View view) {
        numbersFragment.onClick6();
    }

    public void onClick7(View view) {
        numbersFragment.onClick7();
    }

    public void onClick8(View view) {
        numbersFragment.onClick8();
    }

    public void onClick9(View view) {
        numbersFragment.onClick9();
    }

    public void onClick0(View view) {
        numbersFragment.onClick0();
    }

    public void onClickMinus(View view) {
        numbersFragment.onClickMinus();
    }

    public void onClickClear(View view) {
        numbersFragment.onClickClear();
    }

    public void onClickEquals(View view) {
        numbersFragment.onClickEquals();
    }

}

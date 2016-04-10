package nl.visser.joram.mathapp;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AdditionActivity extends MenuActivity {

    private static final String LOG_TAG =  AdditionActivity.class.getSimpleName();

    private Numpad numpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {

            NumbersFragment numbersFragment = new NumbersFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("MODE", 1);
            numbersFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_numbers_addition, numbersFragment)
                    .commit();
            MathFragmentManager.INSTANCE.setNumbersFragment(numbersFragment);

            NumpadFragment numpadFragment = new NumpadFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_numpad_addition, numpadFragment)
                    .commit();
            numpad = numpadFragment;
        }
    }

    public void onClick1(View view) {
        numpad.onClick1(view);
    }

    public void onClick2(View view) {
        numpad.onClick2(view);
    }

    public void onClick3(View view) {
        numpad.onClick3(view);
    }

    public void onClick4(View view) {
        numpad.onClick4(view);
    }

    public void onClick5(View view) {
        numpad.onClick5(view);
    }

    public void onClick6(View view) {
        numpad.onClick6(view);
    }

    public void onClick7(View view) {
        numpad.onClick7(view);
    }

    public void onClick8(View view) {
        numpad.onClick8(view);
    }

    public void onClick9(View view) {
        numpad.onClick9(view);
    }

    public void onClick0(View view) {
        numpad.onClick0(view);
    }

    public void onClickMinus(View view) {
        numpad.onClickMinus(view);
    }

    public void onClickClear(View view) {
        numpad.onClickClear(view);
    }

    public void onClickEquals(View view) {
        numpad.onClickEquals(view);
    }
}

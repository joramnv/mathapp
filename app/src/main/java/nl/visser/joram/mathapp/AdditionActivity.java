package nl.visser.joram.mathapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
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

        FragmentManager fragmentManager = getSupportFragmentManager();
        NumbersFragment numbersFragment = new NumbersFragment();
        NumpadFragment numpadFragment = new NumpadFragment();
        if(savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container_numbers_addition, numbersFragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .add(R.id.container_numpad_addition, numpadFragment)
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container_numbers_addition, numbersFragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .replace(R.id.container_numpad_addition, numpadFragment)
                    .commit();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("MODE", 1);
        numbersFragment.setArguments(bundle);
        MathFragmentManager.INSTANCE.setNumbersFragment(numbersFragment);
        numpad = numpadFragment;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void onClickNumpadButton(View view) {
        numpad.onClickNumpadButton(view);
    }
}

package nl.visser.joram.mathapp.Fragments;

import nl.visser.joram.mathapp.Fragments.NumbersFragment;

/**
 * Created by Joram on 9-4-2016.
 */
public enum MathFragmentManager {
    INSTANCE;

    private NumbersFragment numbersFragment;

    public NumbersFragment getNumbersFragment() {
        return numbersFragment;
    }

    public void setNumbersFragment(NumbersFragment numbersFragment) {
        this.numbersFragment = numbersFragment;
    }
}
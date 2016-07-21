package nl.visser.joram.mathapp;

/**
 * Created by Jorrit on 20-7-2016.
 */
public enum Operator{
    MINUS (R.drawable.minus),
    PLUS (R.drawable.plus),
    EQUALS(R.drawable.equals),
    TIMES(0),
    DIVIDEDBY(0),
    BACK(0),
    CLEAR(0);

    int drawable;

    Operator(int drawable) {
        this.drawable = drawable;
    }

    public int getDrawable() {
        return drawable;
    }
}

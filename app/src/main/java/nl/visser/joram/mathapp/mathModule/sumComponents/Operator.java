package nl.visser.joram.mathapp.mathModule.sumComponents;

import nl.visser.joram.mathapp.R;

public enum Operator implements SumComponent {
    MINUS (R.drawable.minus),
    PLUS (R.drawable.plus),
    EQUALS(R.drawable.equals),
    TIMES(R.drawable.times),
    DIVIDED_BY(R.drawable.division),
    BACK(0),
    CLEAR(0);

    private int drawable;

    Operator(int drawable) {
        this.drawable = drawable;
    }

    public int getDrawable() {
        return drawable;
    }

}

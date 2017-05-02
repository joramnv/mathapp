package nl.visser.joram.mathapp.calculationModule;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import nl.visser.joram.mathapp.R;

public enum Digit {
    ONE(1, R.drawable.one),
    TWO(2, R.drawable.two),
    THREE(3, R.drawable.three),
    FOUR(4, R.drawable.four),
    FIVE(5, R.drawable.five),
    SIX(6, R.drawable.six),
    SEVEN(7, R.drawable.seven),
    EIGHT(8, R.drawable.eight),
    NINE(9, R.drawable.nine),
    ZERO(0, R.drawable.zero),
    COMMA(666, R.drawable.comma);

    int value;
    int drawable;

    Digit(int value, int drawable) {
        this.value = value;
        this.drawable = drawable;
    }

    private static final List<Digit> VALUES = Arrays.asList(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Digit randomDigit()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public int getValue() {
        return value;
    }

    public int getDrawable() {
        return drawable;
    }

}

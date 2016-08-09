package nl.visser.joram.mathapp.CalculationModule;

import java.util.LinkedList;

public class MathAppNumber {

    private LinkedList<Digit> digits = new LinkedList<>();
    private LinkedList<Integer> digitDrawableIds = new LinkedList<>();
    private boolean isNegativeNumber;
    private int value;

    public void initiate() {
        digits = new LinkedList<>();
        isNegativeNumber = false;
    }

    public void pushDigit(Digit digit) {
        digits.push(digit);
        formatDigitToDrawableIds(digit.getDrawable());
    }

    public void removeLastDigit() {
        digits.removeLast();
    }

    public void removeDigits() {
        digits = new LinkedList<>();
    }

    public LinkedList<Digit> getDigits() {
        return digits;
    }

    private void formatDigitToDrawableIds(int digitDrawableId) {
        digitDrawableIds.push(digitDrawableId);
    }

    public void turnNegative() {
        isNegativeNumber = !isNegativeNumber;
    }

    public int getValueOf() {
        int amountOfDigits = digits.size();
        int totalAmount = 0;
        for (int i = amountOfDigits - 1; i >= 0; i--) {
            int digitTens = i;
            totalAmount += digits.get(i).getValue() * Math.pow(10, digitTens);
        }

        if (isNegativeNumber) {
            return totalAmount * -1;
        } else {
            return totalAmount;
        }
    }
}

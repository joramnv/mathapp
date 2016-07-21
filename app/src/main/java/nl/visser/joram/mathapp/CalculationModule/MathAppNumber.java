package nl.visser.joram.mathapp.CalculationModule;

import java.util.LinkedList;

import nl.visser.joram.mathapp.CalculationModule.Digit;

public class MathAppNumber {

    LinkedList<Digit> digits = new LinkedList<>();
    LinkedList<Integer> digitDrawableIds = new LinkedList<>();

    public void pushDigit(Digit digit) {
        digits.push(digit);
        formatDigitToDrawableIds(digit.getDrawable());
    }

    public void removeLastDigit() {

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

    public int getValueOf() {
        int amountOfDigits = digits.size();
        int totalAmount = 0;
        for(int i = amountOfDigits-1; i >= 0; i--) {
            int digitTens = i;
            totalAmount +=digits.get(i).getValue()* Math.pow(10, digitTens);
        }
        return totalAmount;
    }
}

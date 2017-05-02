package nl.visser.joram.mathapp.calculationModule;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MathAppNumberImpl implements MathAppNumber {

    private LinkedList<Digit> digits = new LinkedList<>();
//    private LinkedList<Integer> digitDrawableIds = new LinkedList<>();
    private boolean isNegativeNumber;

    @Override
    public void initiate() {
        digits = new LinkedList<>();
        isNegativeNumber = false;
    }

    @Override
    public void pushDigit(Digit digit) {
        digits.push(digit);
//        formatDigitToDrawableIds(digit.getDrawable());
    }

//    private void formatDigitToDrawableIds(int digitDrawableId) {
//        digitDrawableIds.push(digitDrawableId);
//    }

    @Override
    public void removeLastDigit() {
        try {
            digits.removeLast();
        } catch (NoSuchElementException e) {
            //Do nothing, this is expected behaviour.
        }
    }

    @Override
    public void removeDigits() {
        digits = new LinkedList<>();
    }

    @Override
    public LinkedList<Digit> getDigits() {
        return digits;
    }

    @Override
    public void turnNegative() {
        isNegativeNumber = !isNegativeNumber;
    }

    @Override
    public double getValueOf() {

        LinkedList<Digit> digitsBeforeTheComma = new LinkedList<>();
        LinkedList<Digit> digitsAfterTheComma = new LinkedList<>();

        boolean afterTheComma = false;

        int amountOfDigits = digits.size();
        for (int i = amountOfDigits - 1; i >= 0; i--) {
            if (digits.get(i) == Digit.COMMA) {
                afterTheComma = true;
                continue;
            }
            if (afterTheComma) {
                digitsAfterTheComma.addFirst(digits.get(i));
            } else {
                digitsBeforeTheComma.addFirst(digits.get(i));
            }
        }

        double totalAmount = getDigitsSomethingSomething(digitsBeforeTheComma);

        if (afterTheComma) {
            double amountAfterTheComma = getDigitsSomethingSomething(digitsAfterTheComma) / (Math.pow(10, digitsAfterTheComma.size()));
            totalAmount += amountAfterTheComma;
        }

        if (isNegativeNumber) {
            return totalAmount * -1;
        } else {
            return totalAmount;
        }
    }

    //TODO clean up and rename method
    public double getDigitsSomethingSomething(LinkedList<Digit> digits) {
        int amountOfDigits = digits.size();
        int totalAmount = 0;
        for (int i = amountOfDigits - 1; i >= 0; i--) {
            int digitTens = i;
            totalAmount += digits.get(i).getValue() * Math.pow(10, digitTens);
        }
        return totalAmount;
    }

}

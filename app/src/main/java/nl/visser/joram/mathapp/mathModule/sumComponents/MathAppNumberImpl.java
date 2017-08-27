package nl.visser.joram.mathapp.mathModule.sumComponents;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MathAppNumberImpl implements SumComponent, MathAppNumber {

    private LinkedList<Digit> digits;
    private boolean isNegativeNumber;

    public MathAppNumberImpl() {
        initiate();
    }

    public MathAppNumberImpl(double number) {
        if (number < 0) {
            isNegativeNumber = true;
            number *= -1;
        } else {
            isNegativeNumber = false;
        }
        digits = setNumber(number);
    }

    public LinkedList<Digit> setNumber(double number) {
        int numberInInt = (int) number;
        LinkedList<Digit> digits = new LinkedList<>();
        if(number < 10) {
            digits.push(setDigit(numberInInt));
        } else if(10 <= number && number < 100) {
            digits.push(setDigit(lastDigit(numberInInt/10)));
            digits.push(setDigit(lastDigit(numberInInt)));
        } else if(100 <= number && number < 1000) {
            digits.push(setDigit(lastDigit(numberInInt/100)));
            digits.push(setDigit(lastDigit(numberInInt/10)));
            digits.push(setDigit(lastDigit(numberInInt)));
        } else if(1000 <= number && number < 10000) {
            digits.push(setDigit(lastDigit(numberInInt/1000)));
            digits.push(setDigit(lastDigit(numberInInt/100)));
            digits.push(setDigit(lastDigit(numberInInt/10)));
            digits.push(setDigit(lastDigit(numberInInt)));
        }
        double numbersAfterTheComma = number - Math.floor(number);

        if (numbersAfterTheComma > 0 && numbersAfterTheComma < 1) {
            digits = setDigitsAfterTheComma(numbersAfterTheComma, digits);
        }

        return digits;
    }

    public int lastDigit(int number) {
        return number % 10;
    }

    public Digit setDigit(int singleNumber) {
        Digit digit;
        if(singleNumber == 0) {
            digit = Digit.ZERO;
        } else if(singleNumber == 1) {
            digit = Digit.ONE;
        } else if(singleNumber == 2) {
            digit = Digit.TWO;
        } else if(singleNumber == 3) {
            digit = Digit.THREE;
        } else if(singleNumber == 4) {
            digit = Digit.FOUR;
        } else if(singleNumber == 5) {
            digit = Digit.FIVE;
        } else if(singleNumber == 6) {
            digit = Digit.SIX;
        } else if(singleNumber == 7) {
            digit = Digit.SEVEN;
        } else if(singleNumber == 8) {
            digit = Digit.EIGHT;
        } else if(singleNumber == 9) {
            digit = Digit.NINE;
        } else {
            digit = Digit.ZERO;
        }
        return digit;
    }

    public LinkedList<Digit> setDigitsAfterTheComma(double numbersAfterTheComma, LinkedList<Digit> digits) {
        digits.push(Digit.COMMA);
        digits.push(setDigit(6));
        return digits;
    }

    @Override
    public void initiate() {
        digits = new LinkedList<>();
        isNegativeNumber = false;
    }

    @Override
    public void pushDigit(Digit digit) {
        //TODO use add instead of add, more meaningful in this case. Also refactor the backwards looping in getValueOf()!
        digits.push(digit);
    }

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

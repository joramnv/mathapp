package nl.visser.joram.mathapp.calculationModule;

import java.util.LinkedList;

public interface Digits {

    void pushDigit(Digit digit);

    void removeLastDigit();

    void removeDigits();

    LinkedList<Digit> getDigits();

}

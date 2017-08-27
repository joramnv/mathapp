package nl.visser.joram.mathapp.mathModule.sumComponents;

import java.util.LinkedList;

public interface Digits {

    void pushDigit(Digit digit);

    void removeLastDigit();

    void removeDigits();

    LinkedList<Digit> getDigits();

}

package nl.visser.joram.mathapp.mathModule.generators;

import nl.visser.joram.mathapp.mathModule.sumComponents.MathAppNumberImpl;

public interface MathAppNumberGenerator extends RandomGenerator {

    MathAppNumberImpl generateRandomMathAppNumber(int difficulty, int digitMin);

}

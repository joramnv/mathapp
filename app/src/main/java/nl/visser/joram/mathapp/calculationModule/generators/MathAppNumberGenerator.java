package nl.visser.joram.mathapp.calculationModule.generators;

import nl.visser.joram.mathapp.calculationModule.MathAppNumberImpl;

public interface MathAppNumberGenerator extends RandomGenerator {

    MathAppNumberImpl generateRandomMathAppNumber(int difficulty, int digitMin);

}

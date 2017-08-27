package nl.visser.joram.mathapp.mathModule.generators.Impl;

import org.junit.Test;

import nl.visser.joram.mathapp.mathModule.sumComponents.MathAppNumberImpl;

public class MathAppNumberGeneratorImplTest {

    private MathAppNumberGeneratorImpl mathAppNumberGeneratorImpl = new MathAppNumberGeneratorImpl();

    @Test
    public void generateRandomMathAppNumber() throws Exception {
        MathAppNumberImpl mathAppNumberImpl = mathAppNumberGeneratorImpl.generateRandomMathAppNumber(1, 1);
        //TODO write test
    }

}

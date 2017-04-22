package nl.visser.joram.mathapp.testHelpers;

public class RandomValueGenerator {

    public static String createRandomString() {
        return org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(1, 8);
    }

}

package nl.visser.joram.mathapp.mathModule.generators;

import java.util.List;

import nl.visser.joram.mathapp.bundles.Category;
import nl.visser.joram.mathapp.mathModule.sumComponents.Sum;

public interface SumGenerator extends RandomGenerator {

    Sum generateRandomSum(int difficulty, List<Category> categories);

}

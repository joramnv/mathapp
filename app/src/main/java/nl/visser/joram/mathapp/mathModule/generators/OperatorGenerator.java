package nl.visser.joram.mathapp.mathModule.generators;

import java.util.List;

import nl.visser.joram.mathapp.bundles.Category;
import nl.visser.joram.mathapp.mathModule.sumComponents.Operator;

public interface OperatorGenerator extends RandomGenerator {

    Operator generateRandomOperator(List<Category> categories);

}

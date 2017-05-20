package nl.visser.joram.mathapp.calculationModule.generators;

import java.util.List;

import nl.visser.joram.mathapp.bundles.Category;
import nl.visser.joram.mathapp.calculationModule.Operator;

public interface OperatorGenerator extends RandomGenerator {

    Operator generateRandomOperator(List<Category> categories);

}

package nl.visser.joram.mathapp.unitTests.bundles;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import nl.visser.joram.mathapp.bundles.Category;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(AndroidJUnit4.class)
public class CategoryTest {

    @Test
    public void givenAdditionsAndSubtractionsCategoriesAreProvidedWhenAddCategoriesBundleIsCalledThenAddCategoriesBundleReturnsABundleContainingTheCategoriesAdditionsAndSubtractions() throws Exception {
        List<Category> expected = new ArrayList<>();
        expected.add(Category.ADDITIONS);
        expected.add(Category.SUBTRACTIONS);
        Bundle returnedBundle = Category.addCategoriesBundle(expected);
        List<Category> actual = (List<Category>) returnedBundle.get("CATEGORY");
        assertThat(actual, is(equalTo(expected)));
        assertThat(actual.contains(Category.ADDITIONS), is(true));
        assertThat(actual.contains(Category.SUBTRACTIONS), is(true));
    }

}

package nl.visser.joram.mathapp.bundles;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class CategoriesBundleTest {

    @Before
    public void setUp() throws Exception {
        //TODO create randomMode here.
    }

    @Test
    public void addCategoriesBundle() throws Exception {

    }

    @Test
    public void givenRandomCategoriesAreProvidedWhenAddCategoriesBundleIsCalledThenAddCategoriesBundleReturnsABundleContainingTheCategories() throws Exception {
        ArrayList<Category> expectedCategories = new ArrayList<>();
        expectedCategories.add(Category.ADDITIONS);
        expectedCategories.add(Category.SUBTRACTIONS);
        Bundle returnedBundle = CategoriesBundle.addCategoriesBundle(expectedCategories);
        List<Category> categories = (List<Category>) returnedBundle.get("CATEGORY");
        assertEquals(expectedCategories, categories);
    }

}

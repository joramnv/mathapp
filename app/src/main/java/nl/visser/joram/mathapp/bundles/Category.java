package nl.visser.joram.mathapp.bundles;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public enum Category {
    ADDITIONS, SUBTRACTIONS, MULTIPLICATIONS, DIVISIONS;

    public static final String CATEGORY_BUNDLE = "nl.visser.joram.mathapp.bundles.Category.CATEGORY_BUNDLE";

    public static Bundle addCategoriesBundle(List<Category> categories) { //TODO make non-static.
        ArrayList<Category> serializableListOfCategories = new ArrayList<>(categories);
        Bundle bundleCategories = new Bundle();
        bundleCategories.putSerializable(CATEGORY_BUNDLE, serializableListOfCategories);
        return bundleCategories;
    }

}

package nl.visser.joram.mathapp.bundles;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public enum Category {
    ADDITIONS, SUBTRACTIONS, MULTIPLICATIONS, DIVISIONS;

    public static Bundle addCategoriesBundle(List<Category> categories) {
        ArrayList<Category> serializableListOfCategories = new ArrayList<>(categories);
        Bundle bundleCategories = new Bundle();
        bundleCategories.putSerializable("CATEGORY", serializableListOfCategories);
        return bundleCategories;
    }

}

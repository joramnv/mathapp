package nl.visser.joram.mathapp.bundles;

import android.os.Bundle;

import java.util.ArrayList;

import nl.visser.joram.mathapp.fragments.Category;

public class CategoriesBundle {

    public static Bundle addCategoriesBundle(ArrayList<Category> categories) {
        Bundle bundleCategories = new Bundle();
        bundleCategories.putSerializable("CATEGORY", categories);
        return bundleCategories;
    }

}

package nl.visser.joram.mathapp.bundles;

import android.os.Bundle;

import java.util.ArrayList;

public class CategoriesBundle {

    public static Bundle addCategoriesBundle(ArrayList<Category> categories) {
        Bundle bundleCategories = new Bundle();
        bundleCategories.putSerializable("CATEGORY", categories);
        return bundleCategories;
    }

}

package nl.visser.joram.mathapp.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import nl.visser.joram.mathapp.Fragments.Categories;
import nl.visser.joram.mathapp.Fragments.CategoriesFragment;
import nl.visser.joram.mathapp.Fragments.Mode;
import nl.visser.joram.mathapp.Fragments.ModeFragment;
import nl.visser.joram.mathapp.R;

public class MainActivity extends MenuActivity {

    public static final String FRAGMENT_TAG = "CATAGORIES_FRAGMENT";

    private Categories categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO make this a help or skip button?!
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        ModeFragment modeFragment = new ModeFragment();
        if(savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container_mode_and_categories, modeFragment)
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container_mode_and_categories, modeFragment)
                    .commit();
        }

    }

    public void normal(View view) {
        //TODO variable normal
        FragmentManager fragmentManager = getSupportFragmentManager();
        CategoriesFragment categoriesFragment = new CategoriesFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.container_mode_and_categories, categoriesFragment)
                .commit();
        Bundle bundle = new Bundle();
        bundle.putInt("MODE", 1); // mode 1 = normal.
        categoriesFragment.setArguments(bundle);
        categories = categoriesFragment;
    }

    public void timeTrial(View view) {
        //TODO variable timeTrial
        FragmentManager fragmentManager = getSupportFragmentManager();
        CategoriesFragment categoriesFragment = new CategoriesFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.container_mode_and_categories, categoriesFragment)
                .commit();
        Bundle bundle = new Bundle();
        bundle.putInt("MODE", 2); // mode 2 = timeTrial.
        categoriesFragment.setArguments(bundle);
        categories = categoriesFragment;
    }

    public void endless(View view) {
        //TODO variable endless
        FragmentManager fragmentManager = getSupportFragmentManager();
        CategoriesFragment categoriesFragment = new CategoriesFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.container_mode_and_categories, categoriesFragment)
                .commit();
        Bundle bundle = new Bundle();
        bundle.putInt("MODE", 3); // mode 3 = endless.
        categoriesFragment.setArguments(bundle);
        categories = categoriesFragment;
    }

    public void additions(View view) {
        categories.additions(view);
    }

    public void subtractions(View view) {
        categories.subtractions(view);
    }

    public void multiplications(View view) {
        categories.multiplications(view);
    }

    public void divisions(View view) {
        categories.divisions(view);
    }

}

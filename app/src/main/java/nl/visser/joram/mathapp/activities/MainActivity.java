package nl.visser.joram.mathapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import nl.visser.joram.mathapp.fragments.CategoriesFragment;
import nl.visser.joram.mathapp.fragments.Impl.CategoriesFragmentImpl;
import nl.visser.joram.mathapp.bundles.Mode;
import nl.visser.joram.mathapp.fragments.ModesFragment;
import nl.visser.joram.mathapp.fragments.Impl.ModesFragmentImpl;
import nl.visser.joram.mathapp.R;

import static nl.visser.joram.mathapp.bundles.ModeBundle.addModeBundle;

public class MainActivity extends MenuActivity {

    private ModesFragment modesFragment;
    private CategoriesFragment categoriesFragment;

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
        ModesFragmentImpl modesFragmentImpl = new ModesFragmentImpl();
        if(savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container_mode_and_categories, modesFragmentImpl)
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container_mode_and_categories, modesFragmentImpl)
                    .commit();
        }
        modesFragment = modesFragmentImpl;
    }

    public void onClickModeNormal(View view) {
        Mode mode = modesFragment.onClickModeNormal(view);
        addModeToCategories(mode);
    }

    public void onClickModeTimeTrial(View view) {
        Mode mode = modesFragment.onClickModeTimeTrial(view);
        addModeToCategories(mode);
    }

    public void onClickModeEndlessMode(View view) {
        Mode mode = modesFragment.onClickModeEndlessMode(view);
        addModeToCategories(mode);
    }

    private void addModeToCategories(Mode mode) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        CategoriesFragmentImpl categoriesFragmentImpl = new CategoriesFragmentImpl();
        fragmentManager.beginTransaction()
                .replace(R.id.container_mode_and_categories, categoriesFragmentImpl)
                .commit();

        Bundle bundle = addModeBundle(mode);
        categoriesFragmentImpl.setArguments(bundle);
        categoriesFragment = categoriesFragmentImpl;
    }

    public void onCheckboxClicked(View view) {
        categoriesFragment.onCheckboxClicked(view);
    }

    public void go(View view) {
        categoriesFragment.go(view);
    }

}

package nl.visser.joram.mathapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import nl.visser.joram.mathapp.fragments.Done;
import nl.visser.joram.mathapp.fragments.NameFragment;
import nl.visser.joram.mathapp.R;
import nl.visser.joram.mathapp.Score;

public class NameYourScoreActivity extends AppCompatActivity implements NameFragment.OnFragmentInteractionListener {

    private Done done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_your_score);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentManager fragmentManager = getSupportFragmentManager();
        NameFragment nameFragment = new NameFragment();
        if(savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container_name_your_score, nameFragment)
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container_name_your_score, nameFragment)
                    .commit();
        }
        done = nameFragment;
    }

    public void onClickDone(View view) {
        done.onClickDone(view);
    }

    public void onFragmentInteraction(String name) {
        Score.INSTANCE.setName(name);
        Intent intent = new Intent(this, ScoreboardActivity.class);
        startActivity(intent);
    }

}

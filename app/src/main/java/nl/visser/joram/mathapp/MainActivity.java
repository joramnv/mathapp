package nl.visser.joram.mathapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends MenuActivity {

    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";

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
    }

    public void additionActivity(View view) {
        Intent intent = new Intent(this, AdditionActivity.class);
        startActivity(intent);
    }

    public void subtractionActivity(View view) {
        Intent intent = new Intent(this, SubtractionActivity.class);
        startActivity(intent);
    }

    public void timeTrialAdditionActivity(View view) {
        Intent intent = new Intent(this, AdditionActivity.class);
        intent.putExtra(EXTRA_MESSAGE, true);
        startActivity(intent);
    }
}

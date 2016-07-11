package nl.visser.joram.mathapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ScoreboardActivity extends AppCompatActivity {

    protected ScoreDbHelper scoreDbHelper = new ScoreDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ScoreToDbTask scoreToDbTask = new ScoreToDbTask();
        scoreToDbTask.execute();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
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

        TextView textView = (TextView)findViewById(R.id.textview_scoreboard);
        textView.setText(scoreDbHelper.getDatabaseName());

        textView.setText("Your score is: " + String.valueOf(Score.INSTANCE.getScore()));

    }

    private class ScoreToDbTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            SQLiteDatabase db = scoreDbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(ScoreScheme.ScoreTable.PLAYER_NAME_COLUMN, "Jorrit");
            values.put(ScoreScheme.ScoreTable.PLAYER_SCORE_COLUMN, Score.INSTANCE.getScore());
            values.put(ScoreScheme.ScoreTable.PlAYER_CORRECT_ANSWERS, 10);
            values.put(ScoreScheme.ScoreTable.PLAYER_WRONG_ANSWERS, 15);
            values.put(ScoreScheme.ScoreTable.PLAYER_TIME, 1000);

            long newRowId;
            newRowId = db.insert(
                    scoreDbHelper.DATABASE_NAME,
                    "TRUE",
                    values);

            return null;
        }
    }

    private class ScoreFromDbTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }
    }


}

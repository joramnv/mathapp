package nl.visser.joram.mathapp.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import nl.visser.joram.mathapp.R;
import nl.visser.joram.mathapp.Score;
import nl.visser.joram.mathapp.ScoreDbHelper;
import nl.visser.joram.mathapp.ScoreScheme;

public class ScoreboardActivity extends AppCompatActivity {

    private ScoreDbHelper scoreDbHelper;
    private TableLayout scoreTable;
    private String SAVE_SCORE_STATE = "score_is_saved_state";
    private Boolean scoreIsWrittenToDb = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scoreboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        scoreTable = (TableLayout) findViewById(R.id.score_table);

        scoreDbHelper = new ScoreDbHelper(this);
        ScoreToDbTask scoreToDbTask = new ScoreToDbTask();
        scoreToDbTask.execute();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void addScoreRow(int position, String name, int score, int correctAnswers, int wrongAnswers) {
        TableRow row = new TableRow(ScoreboardActivity.this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);

        TextView idColumn = new TextView(this);
        TextView nameColumn = new TextView(this);
        TextView scoreColumn = new TextView(this);
        TextView correctAnswersColumn = new TextView(this);
        TextView wrongAnswersColumn = new TextView(this);


        idColumn.setText(String.valueOf(position));
        nameColumn.setText(String.valueOf(name));
        scoreColumn.setText(String.valueOf(score));
        correctAnswersColumn.setText(String.valueOf(correctAnswers));
        wrongAnswersColumn.setText(String.valueOf(wrongAnswers));

        row.addView(idColumn);
        row.addView(nameColumn);
        row.addView(scoreColumn);
        row.addView(correctAnswersColumn);
        row.addView(wrongAnswersColumn);

        int indexForNewRow = scoreTable.getChildCount();
        scoreTable.addView(row, indexForNewRow);
    }

    protected void readDatabase() {
        ScoreFromDbTask scoreFromDbTask = new ScoreFromDbTask();
        scoreFromDbTask.execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(SAVE_SCORE_STATE, scoreIsWrittenToDb);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreIsWrittenToDb = (Boolean) savedInstanceState.get(SAVE_SCORE_STATE);
    }

    private class ScoreToDbTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            SQLiteDatabase db = scoreDbHelper.getWritableDatabase();

            if(!scoreIsWrittenToDb) {
                ContentValues values = new ContentValues();
                values.put(ScoreScheme.ScoreTable.PLAYER_NAME_COLUMN, Score.INSTANCE.getName());
                values.put(ScoreScheme.ScoreTable.PLAYER_SCORE_COLUMN, Score.INSTANCE.getScore());
                values.put(ScoreScheme.ScoreTable.PlAYER_CORRECT_ANSWERS, Score.INSTANCE.getCorrectAnswers());
                values.put(ScoreScheme.ScoreTable.PLAYER_WRONG_ANSWERS, Score.INSTANCE.getWrongAnswers());


                long newRowId;
                newRowId = db.insert(
                        ScoreScheme.ScoreTable.TABLE_NAME,
                        null,
                        values);

                scoreIsWrittenToDb = true;
                db.close();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void params) {
            readDatabase();
        }
    }

    private class ScoreFromDbTask extends AsyncTask<String, Void, Cursor> {

        SQLiteDatabase db;

        @Override
        protected Cursor doInBackground(String... params) {
            db = scoreDbHelper.getReadableDatabase();

            String[] projection = {
                    ScoreScheme.ScoreTable._ID,
                    ScoreScheme.ScoreTable.PLAYER_NAME_COLUMN,
                    ScoreScheme.ScoreTable.PLAYER_SCORE_COLUMN,
                    ScoreScheme.ScoreTable.PlAYER_CORRECT_ANSWERS,
                    ScoreScheme.ScoreTable.PLAYER_WRONG_ANSWERS,
            };

            String sortOrder = ScoreScheme.ScoreTable.PLAYER_SCORE_COLUMN + " DESC";

            Cursor c = db.query(
                        ScoreScheme.ScoreTable.TABLE_NAME,
                        projection,
                        null,
                        null,
                        null,
                        null,
                        sortOrder);

            return c;
        }

        @Override
        protected void onPostExecute(Cursor c) {

            c.moveToFirst();
            while(!c.isAfterLast() && c.getPosition() < 20 ) {
                int i = 1;
                int playerPosition = c.getPosition()+1;
                addScoreRow(playerPosition,
                        c.getString(i++),
                        c.getInt(i++),
                        c.getInt(i++),
                        c.getInt(i++));
                c.moveToNext();

                //Delete scores which are not used from database
                String selection = ScoreScheme.ScoreTable._ID + " >?";
                String[] selectionArgs = { String.valueOf(20) };

                db.delete(ScoreScheme.ScoreTable.TABLE_NAME, selection, selectionArgs);
            }
        }

    }

}

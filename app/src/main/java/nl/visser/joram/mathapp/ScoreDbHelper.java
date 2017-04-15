package nl.visser.joram.mathapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import nl.visser.joram.mathapp.ScoreScheme.*;

public class ScoreDbHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Math";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ", ";

    public static final String CREATE_ENTRIES = "CREATE TABLE " + ScoreTable.TABLE_NAME + " (" +
                                                ScoreTable._ID + " INTEGER PRIMARY KEY," +
                                                ScoreTable.PLAYER_NAME_COLUMN + TEXT_TYPE + COMMA_SEP +
                                                ScoreTable.PLAYER_SCORE_COLUMN + " INTEGER" + COMMA_SEP +
                                                ScoreTable.PlAYER_CORRECT_ANSWERS + " INTEGER" + COMMA_SEP +
                                                ScoreTable.PLAYER_WRONG_ANSWERS + " INTEGER" + COMMA_SEP +
                                                ScoreTable.PLAYER_TIME + " INTEGER" + " )";

    public ScoreDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

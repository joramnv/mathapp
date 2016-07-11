package nl.visser.joram.mathapp;

import android.provider.BaseColumns;

public final class ScoreScheme {

    public ScoreScheme() {}

    public static abstract class ScoreTable implements BaseColumns {
        public static final String TABLE_NAME = "PLAYER SCORES";
        public static final String PLAYER_NAME_COLUMN = "PLAYER NAME";
        public static final String PLAYER_SCORE_COLUMN = "PLAYER SCORE";
        public static final String PlAYER_CORRECT_ANSWERS = "CORRECT ANSWERS";
        public static final String PLAYER_WRONG_ANSWERS = "WRONG ANSWERS";
        public static final String PLAYER_TIME = "PLAYER TIME";
    }
}

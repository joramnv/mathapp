package nl.visser.joram.mathapp;

/**
 * Created by Joram on 22-3-2016.
 */
public enum Difficulty {
    INSTANCE;

    private int difficulty = 1;

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}

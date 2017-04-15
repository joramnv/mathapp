package nl.visser.joram.mathapp;

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

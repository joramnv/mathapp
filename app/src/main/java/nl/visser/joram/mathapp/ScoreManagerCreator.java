package nl.visser.joram.mathapp;

public enum  ScoreManagerCreator {
    INSTANCE;

    private final ScoreManager scoreManager;

    ScoreManagerCreator() {
        scoreManager = new ScoreManager();
    }

    public ScoreManager getScoreManager() {
        return scoreManager;
    }
}

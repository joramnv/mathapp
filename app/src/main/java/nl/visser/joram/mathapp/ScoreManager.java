package nl.visser.joram.mathapp;

public class ScoreManager {

    private Score score;

    public ScoreManager() {
        this.score = new Score();
    }

    public void updateScoreForCurrentSession(int difficulty) {

    }

    public int getScoreForCurrentSession() {
        return score.getScore();
    }
}


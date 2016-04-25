package nl.visser.joram.mathapp;

import java.util.ArrayList;
import java.util.List;

public class ScoreManager {

    private Score currentScore;

    List<Score> allScores = new ArrayList<>();

    public ScoreManager() {
        this.currentScore = new Score();
    }

    public Score getNewScore() {
        return new Score();
    }

    public void setScoreForPastSession(Score score) {
        allScores.add(score);
    }

    public List<Score> getAllScores() {
        return allScores;
    }


    private void writeScoresToDisk(Score score) {
        throw new UnsupportedOperationException("nog niet geimplementeerd");
    }
}


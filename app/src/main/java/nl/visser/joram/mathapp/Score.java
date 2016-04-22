package nl.visser.joram.mathapp;

public class Score {

    private String name;
    private int score;
    private int wrongAnswers;
    private int correctAnswers;
    private double time;

    public Score() {
        this.name = " ";
        this.score = 0;
        this.wrongAnswers = 0;
        this.correctAnswers = 0;
        this.time = 0.0;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void updateWrongAnswers() {
        wrongAnswers++;
    }

    public void updateCorrectAnswers() {
        correctAnswers++;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public void updateScoreForCurrentSession(boolean correctAnswer) {

        if(correctAnswer) {
            score += 10;
            updateCorrectAnswers();
        } else {
            updateWrongAnswers();
        }
    }
}

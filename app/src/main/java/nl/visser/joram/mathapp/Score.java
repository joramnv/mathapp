package nl.visser.joram.mathapp;

public enum Score {
    INSTANCE;

    private String name;
    private int score;
    private int correctAnswers;
    private int wrongAnswers;
    private double time;

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

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
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

    public void resetScoreSingleton() {
        score = 0;
        time = 0D;
        correctAnswers = 0;
        wrongAnswers = 0;
        name = null;
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

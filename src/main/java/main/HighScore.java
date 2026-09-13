package main;

public class HighScore {
    private int score;

    public HighScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "HighScore{" +
                "score=" + score +
                '}';
    }
}

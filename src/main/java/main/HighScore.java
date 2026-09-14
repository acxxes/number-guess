package main;

import java.time.LocalDateTime;

public class HighScore {
    private int score;
    private LocalDateTime localDateTime;

    public HighScore(int score) {
        this.score = score;
        localDateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "HighScore{" +
                "localDateTime=" + localDateTime +
                ", score=" + score +
                '}';
    }

    public int getScore() {
        return score;
    }
}

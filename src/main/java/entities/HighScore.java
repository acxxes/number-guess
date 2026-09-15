package entities;

import java.time.LocalDate;

public class HighScore {
    private int score;
    private LocalDate localDate;

    public HighScore(int score) {
        this.score = score;
        localDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Score[" + score + "]"
                + " set at: " + localDate;
    }

    public int getScore() {
        return score;
    }
}

package pojo;

import java.time.LocalDate;

public class HighScore {
    private int score;
    private LocalDate localDate;
    private int countTries;

    public HighScore(int score, int countTries) {
        this.score = score;
        localDate = LocalDate.now();
        this.countTries = countTries;
    }

    @Override
    public String toString() {
        return "Score[" + score + "]"
                + " set at: " + localDate
                + " Try(s): " + countTries;
    }

    public int getScore() {
        return score;
    }
}

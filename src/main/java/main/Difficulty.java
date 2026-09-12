package main;

public enum Difficulty {
    EASY(10),
    MEDIUM(5),
    HARD(3);

    public final int numberOfTries;

    Difficulty(int numberOfTries) {
        this.numberOfTries = numberOfTries;
    }
}

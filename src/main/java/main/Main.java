package main;

import service.NumberService;

public class Main {
    public static NumberService numberService = new NumberService();
    public static void main(String[] args) {

        //TODO
        // - timer so see how long user guesses
        // - hint system
        // - exception handling

        numberService.executeNumberGuess();
    }

}



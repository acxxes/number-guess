package main;

import service.NumberService;

public class Main {
    public static NumberService numberService = new NumberService();
    public static void main(String[] args) {

        //TODO
        // - user guess amount
        // - exception handling

        numberService.executeNumberGuess();
    }

}



package service;

import enums.Difficulty;
import pojo.HighScore;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class NumberLogic {
    private static int input;
    public static int triesCounter = 0;

    public void printHighScore(List<HighScore> list) {
        System.out.println("HIGH SCORE:");
        for (HighScore highScore : list) {
            System.out.println(highScore);
        }
        System.out.println();
    }

    public void printDifficultyOptions() {
        System.out.println("Select the difficulty:\n"
                + "1. Easy (10 tries)\n"
                + "2. Medium (5 tries)\n"
                + "3. Hard (3 tries)\n"
                + "0. Delete Records\n");
    }

    public void numberGuessingLogic(List<HighScore> list,
                                    Scanner scanner,
                                    int currentScore,
                                    Difficulty difficulty) {

        int numberToGenerate;

        numberToGenerate = (int) (Math.random() * 100) + 1;
        System.out.println("Generated number: " + numberToGenerate);
        System.out.println("Enter the number to guess:");
        for (int i = difficulty.numberOfTries - 1; i >= 0; i--) {
            boolean validInput = false;

            while (!validInput) {
                try {
                    input = scanner.nextInt();
                    scanner.nextLine();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("That's not a valid input, please enter a number.");
                    scanner.nextLine();
                }
            }
            int diff = Math.abs(input - numberToGenerate);
            if (diff <= 3) {
                System.out.println("You are super close!");
            } else if (diff <= 10) {
                System.out.println("You are very close!");
            } else if (diff <= 25) {
                System.out.println("Getting even closer now!");
            } else if (diff <= 50) {
                System.out.println("You are getting closer.");
            } else {
                System.out.println("You are far away...");
            }

            if (input == numberToGenerate) {
                System.out.println("You won!");
                triesCounter += 1;
                NumberService.currentScore += 5;
                break;
            } else if (i <= difficulty.numberOfTries && i > 1) {
                triesCounter += 1;
                System.out.println("You have " + i + " tries left to guess the number.");
            } else if (i == 1) {
                triesCounter += 1;
                System.out.println("You have " + i + " try left to guess the number.");
            } else {
                System.out.println("You lost. :(");
                list.add(new HighScore(currentScore, triesCounter));
            }


        }
    }


}

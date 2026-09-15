package service;

import enums.Difficulty;
import json.JsonWriter;
import entities.HighScore;

import java.util.List;
import java.util.Scanner;

public class NumberLogic {
    public static JsonWriter jsonWriter = new JsonWriter();

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
                + "3. Hard (3 tries)\n");
    }

    public void numberGuessingLogic(List<HighScore> list,
                                    Scanner scanner,
                                    int input,
                                    int currentScore,
                                    Difficulty difficulty) {

        int numberToGenerate;

        numberToGenerate = (int) (Math.random() * 100);
        System.out.println("Generated number: " + numberToGenerate);
        System.out.println("Enter the number to guess:");
        for (int i = difficulty.numberOfTries; i >= 0; i--) {
            if (i == 0) {
                System.out.println("You lost. :(");
                list.add(new HighScore(currentScore));
            }
            if (i == 1) {
                System.out.println("You have " + i + " try left to guess the number.");
                input = scanner.nextInt();
                scanner.nextLine();
            }
            if (i <= difficulty.numberOfTries && i > 1) {
                System.out.println("You have " + i + " tries left to guess the number.");
                input = scanner.nextInt();
                scanner.nextLine();
            }
            if (input == numberToGenerate) {
                System.out.println("You won!");
                NumberService.currentScore += 5;
                break;
            }
        }
    }


}

package service;

import enums.Difficulty;
import json.JsonWriter;
import pojo.HighScore;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class NumberService {
    public static int currentScore;
    public static int setDifficultyByUser;
    public static Scanner scanner = new Scanner(System.in);
    public static List<HighScore> highScoreList = new ArrayList<>();
    public static JsonWriter jsonWriter = new JsonWriter();
    public static NumberLogic numberLogic = new NumberLogic();

    public static void executeNumberGuess() {
        while (true) {
            jsonWriter.createJsonFile();
            highScoreList = jsonWriter.readJsonFile();

            numberLogic.printHighScore(highScoreList);
            numberLogic.printDifficultyOptions();
            System.out.println("Current score: " + currentScore + "\n");

            boolean validInput = false;

            while (!validInput) {
                try {
                    setDifficultyByUser = scanner.nextInt();
                    scanner.nextLine();
                    validInput = true;
                } catch (InputMismatchException e ) {
                    System.out.println("That's not a valid input, please enter a number.");
                    scanner.nextLine();
                }
            }

            jsonWriter.deleteJson(setDifficultyByUser);

            while (true) {
                switch (setDifficultyByUser) {
                    case 1:
                        numberLogic.numberGuessingLogic(
                                highScoreList,
                                scanner,
                                currentScore,
                                Difficulty.EASY);
                        break;
                    case 2:
                        numberLogic.numberGuessingLogic(
                                highScoreList,
                                scanner,
                                currentScore,
                                Difficulty.MEDIUM);
                        break;
                    case 3:
                        numberLogic.numberGuessingLogic(
                                highScoreList,
                                scanner,
                                currentScore,
                                Difficulty.HARD);
                        break;
                    default:
                        System.out.println("Please choose a difficulty setting.");
                }

                if (setDifficultyByUser >= 0 && setDifficultyByUser <= 3) {
                    break;
                } else {
                    setDifficultyByUser = scanner.nextInt();
                    scanner.nextLine();
                    continue;
                }

            }

            String playAgain;

            while (true) {
                System.out.println("Wanna play again? (y/n):");
                playAgain = scanner.nextLine();
                if (playAgain.equalsIgnoreCase("y")
                        || playAgain.equalsIgnoreCase("n")) {
                    break;
                }
            }

            if (playAgain.equalsIgnoreCase("n")) {
                jsonWriter.addHighScore(new HighScore(currentScore, NumberLogic.triesCounter));
                break;
            }


        }
    }
}



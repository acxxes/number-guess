package service;

import enums.Difficulty;
import json.JsonWriter;
import pojo.HighScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberService {
    public static int currentScore;
    public static int userInput;
    public static int setDifficultyByUser;
    public static Scanner scanner = new Scanner(System.in);
    public static List<HighScore> highScoreList = new ArrayList<>();
    public static JsonWriter jsonWriter = new JsonWriter();
    public static NumberLogic numberLogic = new NumberLogic();

    public void executeNumberGuess() {
        while (true) {
            jsonWriter.createJsonFile();
            highScoreList = jsonWriter.readJsonFile();

            numberLogic.printHighScore(highScoreList);
            numberLogic.printDifficultyOptions();
            System.out.println("Current score: " + currentScore + "\n");

            setDifficultyByUser = scanner.nextInt();
            scanner.nextLine();

            jsonWriter.deleteJson(setDifficultyByUser);

            while (true) {
                switch (setDifficultyByUser) {
                    case 1:
                        numberLogic.numberGuessingLogic(
                                highScoreList,
                                scanner,
                                userInput,
                                currentScore,
                                Difficulty.EASY);
                        break;
                    case 2:
                        numberLogic.numberGuessingLogic(
                                highScoreList,
                                scanner,
                                userInput,
                                currentScore,
                                Difficulty.MEDIUM);
                        break;
                    case 3:
                        numberLogic.numberGuessingLogic(
                                highScoreList,
                                scanner,
                                userInput,
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
                jsonWriter.addHighScore(new HighScore(currentScore));
                System.out.println("HIGH SCORE:");
                for (HighScore highScore : highScoreList) {
                    System.out.println(highScore);
                }
                break;
            }


        }
    }
}



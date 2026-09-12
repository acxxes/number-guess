package main;

import java.util.Scanner;

public class Main {
    public static int userInput;
    public static String playAgain;
    public static int generateNumber;
    public static int setDifficultyByUser;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //TODO
        // - timer so see how long user guesses
        // - hint system
        // - high score system

        while (true) {
            System.out.println("Select the difficulty: \n"
                    + "1. Easy (10 tries)\n"
                    + "2. Medium (5 tries)\n"
                    + "3. Hard (3 tries)\n");

            setDifficultyByUser = scanner.nextInt();
            scanner.nextLine();

            while (true) {
                switch (setDifficultyByUser) {
                    case 1:
                        generateNumber = (int) (Math.random() * 100);
                        System.out.println("Generated number: " + generateNumber);
                        System.out.println("Enter the number to guess:");
                        for (int i = Difficulty.EASY.numberOfTries; i >= 0; i--) {
                            if (i == 0) {
                                System.out.println("You lost. :(");
                            } else if (i == 1) {
                                System.out.println("You have " + i + " try left to guess the number.");
                                userInput = scanner.nextInt();
                                scanner.nextLine();
                            } else if (i <= Difficulty.HARD.numberOfTries && i > 1) {
                                System.out.println("You have " + i + " tries left to guess the number.");
                                userInput = scanner.nextInt();
                                scanner.nextLine();
                            } else if (userInput == generateNumber) {
                                System.out.println("You won!");
                            }
                        }
                        break;

                    case 2:
                        generateNumber = (int) (Math.random() * 100);
                        System.out.println("Generated number: " + generateNumber);
                        System.out.println("Enter the number to guess:");
                        for (int i = Difficulty.MEDIUM.numberOfTries; i >= 0; i--) {
                            if (i == 0) {
                                System.out.println("You lost. :(");
                            } else if (i == 1) {
                                System.out.println("You have " + i + " try left to guess the number.");
                                userInput = scanner.nextInt();
                                scanner.nextLine();
                            } else if (i <= Difficulty.HARD.numberOfTries && i > 1) {
                                System.out.println("You have " + i + " tries left to guess the number.");
                                userInput = scanner.nextInt();
                                scanner.nextLine();
                            } else if (userInput == generateNumber) {
                                System.out.println("You won!");
                            }
                        }
                        break;

                    case 3:
                        generateNumber = (int) (Math.random() * 100);
                        System.out.println("Generated number: " + generateNumber);
                        System.out.println("Enter the number to guess:");
                        for (int i = Difficulty.HARD.numberOfTries; i >= 0; i--) {
                            if (i == 0) {
                                System.out.println("You lost. :(");
                            } else if (i == 1) {
                                System.out.println("You have " + i + " try left to guess the number.");
                                userInput = scanner.nextInt();
                                scanner.nextLine();
                            } else if (i <= Difficulty.HARD.numberOfTries && i > 1) {
                                System.out.println("You have " + i + " tries left to guess the number.");
                                userInput = scanner.nextInt();
                                scanner.nextLine();
                            } else if (userInput == generateNumber) {
                                System.out.println("You won!");
                            }
                        }
                        break;
                    default:
                        System.out.println("Please choose a difficulty setting.");
                }
                if (setDifficultyByUser == 1
                        || setDifficultyByUser == 2
                        || setDifficultyByUser == 3) {
                    break;
                } else {
                    setDifficultyByUser = scanner.nextInt();
                    scanner.nextLine();
                    continue;
                }

            }

            System.out.println("Wanna play again? (y/n):");
            playAgain = scanner.nextLine();

            if (playAgain.equalsIgnoreCase("n")) {
                break;
            }

            while (true) {
                if (playAgain.equalsIgnoreCase("y")) {
                    break;
                } else {
                    playAgain = scanner.nextLine();
                }
            }

        }

    }

}


import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        
        int minNumber = 1;        
        int maxNumber = 100;      
        int maxGuesses = 5;       
        int totalScore = 0;       

        System.out.println("Welcome to the Number Guessing Game!");

        boolean continuePlaying;

        do {
            
            int targetNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            int currentAttempt = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nNew Round! Try to guess the number between " + minNumber + " and " + maxNumber + ".");

            while (currentAttempt < maxGuesses) {
                System.out.print("Attempt " + (currentAttempt + 1) + "/" + maxGuesses + ": Enter your guess: ");
                int playerGuess = scanner.nextInt();
                currentAttempt++;

               
                if (playerGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    totalScore++;  
                    break;
                } else if (playerGuess < targetNumber) {
                    System.out.println("Your guess is too low! Try again.");
                } else {
                    System.out.println("Your guess is too high! Try again.");
                }
            }

           
            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was " + targetNumber + ".");
            }

            System.out.print("Would you like to play another round? (yes/no): ");
            continuePlaying = scanner.next().equalsIgnoreCase("yes");

        } while (continuePlaying); 

        
        System.out.println("\nGame over! Your total score is: " + totalScore + " round(s) won.");
        System.out.println("Thank you for playing!");

        scanner.close();  
    }
}

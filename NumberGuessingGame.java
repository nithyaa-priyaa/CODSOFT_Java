import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between " + RANGE_MIN + " and " + RANGE_MAX);
            
            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all your attempts! The correct number was " + randomNumber);
            }

            System.out.println("Your score is: " + (MAX_ATTEMPTS - attempts) + " points.");
            System.out.print("Do you want to play again? (yes/no): ");
            String userResponse = scanner.next();

            //playAgain = userResponse.equalsIgnoreCase("yes");
            playAgain = userResponse.trim().toLowerCase().startsWith("y");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}

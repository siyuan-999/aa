import java.util.InputMismatchException;
import java.util.Scanner;

public class TT {
    public static void main(String[] agrs) throws Exception {
        int TotalGames = 1;
        int TotalGuess = 0;
        int correctAnswer = 1 + (int) (Math.random() * 100);
        System.out.println(correctAnswer);
        Scanner input = new Scanner(System.in);
        System.out.println("Guess a number between 1 and 100");
        int userGuess = 0;
        int playAgain = 0;
        while (playAgain != 2) {
            System.out.print("Enter your number: ");
            userGuess = 0;
            playAgain = 0;
            try {
                userGuess = input.nextInt();
                TotalGuess++;
            } catch (InputMismatchException ex) {
                System.out.println("Try again. (Incorrect input : an integer is required)");
                input.nextLine();
                continue;
            }
            if (userGuess > 100){
                System.out.println("Your guess must be 1 < YourGuess < 100");
                continue;
            }
            else if (userGuess < 1){
                System.out.println("Your guess must be 1 < YourGuess < 100");
                continue;
            }
            if (userGuess > correctAnswer) {
                System.out.println("Your answer is higher");
            } else if (userGuess < correctAnswer) {
                System.out.println("Your answer is lower");
            } else {
                System.out.print("You got it right number" + userGuess);
                do {
                    try {
                        System.out.print("Play again (1 = yes 2= no): ");
                        playAgain = input.nextInt();
                    } catch (InputMismatchException ex) {
                        System.out.println("Try again. (Incorrect input : an integer is required)");
                        System.out.println("playAgain value = " + playAgain);
                        input.nextLine();
                    }
                    if (playAgain != 1 && playAgain != 2) {
                        System.out.println("playAgain value must be 1 && 2");
                    }
                } while (playAgain != 1 && playAgain != 2);

                if (playAgain == 1) {
                    correctAnswer = 1 + (int) (Math.random() * 100);
                    System.out.println(correctAnswer);
                    TotalGames++;
                }
            }
            }
        System.out.println("Total Guess =" + TotalGuess);
        // 123456
        System.out.println("Total Games =" + TotalGames );
        // this is the comment
    }
}

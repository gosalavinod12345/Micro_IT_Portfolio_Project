package buy;
import java.util.Scanner;
import java.util.Random;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"rock", "paper", "scissors"};
        System.out.println("Welcome to Rock-Paper-Scissors!");
        while (true) {
            System.out.print("\nEnter your choice (rock, paper, or scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();
            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid input! Please enter rock, paper, or scissors.");
                continue;
            }
            String computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer chose: " + computerChoice);
            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (userChoice.equals("scissors") && computerChoice.equals("paper")) ||
                    (userChoice.equals("paper") && computerChoice.equals("rock"))) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes") && !playAgain.equals("y")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }
        scanner.close();
    }
}

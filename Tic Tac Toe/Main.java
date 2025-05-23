import Model.Player;
import Service.GameService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe 🎮");
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        char userSymbol;
        while (true) {
            System.out.print("Choose your symbol (X or O): ");
            userSymbol = scanner.nextLine().toUpperCase().charAt(0);
            if (userSymbol == 'X' || userSymbol == 'O') break;
            System.out.println("Invalid choice. Please choose X or O.");
        }

        String friendName = "Friend";
        System.out.print("Enter your friend's name: ");
        friendName = scanner.nextLine();

        char friendSymbol = (userSymbol == 'X') ? 'O' : 'X';

        Player user = new Player(userName, userSymbol);
        Player friend = new Player(friendName, friendSymbol);

        GameService game = new GameService(user, friend);

        int gameCount = 0;
        while (true) {
            System.out.println("\nStarting game #" + (gameCount + 1));
            game.startGame(gameCount);
            gameCount++;

            System.out.print("Play again? (y/n): ");
            String again = scanner.next().toLowerCase();
            if (!again.equals("y")) break;
        }

        System.out.println("Thanks for playing!");
    }
}

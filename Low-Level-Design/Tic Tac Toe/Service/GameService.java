package Service;

import Model.Board;
import Model.Player;

import java.util.Scanner;

public class GameService {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private Scanner scanner;

    public GameService(Player p1, Player p2) {
        this.playerX = (p1.getSymbol() == 'X') ? p1 : p2;
        this.playerO = (p1.getSymbol() == 'O') ? p1 : p2;
        this.scanner = new Scanner(System.in);
    }

    public void startGame(int startWithX) {
        board = new Board(3);
        currentPlayer = (startWithX % 2 == 0) ? playerX : playerO;

        while (true) {
            board.display();
            System.out.println(currentPlayer.getName() + "'s Turn (" + currentPlayer.getSymbol() + ")");
            int row, col;
            while (true) {
                System.out.print("Enter row and column (0 0 to 2 2): ");
                row = scanner.nextInt();
                col = scanner.nextInt();
                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (board.placeSymbol(row, col, currentPlayer.getSymbol())) break;
                    else System.out.println("Cell already occupied! Try another.");
                } else {
                    System.out.println("Invalid input! Try again.");
                }
            }

            if (board.checkWin(row, col, currentPlayer.getSymbol())) {
                board.display();
                System.out.println("🎉 " + currentPlayer.getName() + " wins!");
                break;
            }

            if (board.isFull()) {
                board.display();
                System.out.println("It's a draw!");
                break;
            }

            switchTurn();
        }
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }
}

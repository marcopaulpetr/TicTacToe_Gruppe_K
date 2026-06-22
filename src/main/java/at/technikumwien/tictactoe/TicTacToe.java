package at.technikumwien.tictactoe;
import java.util.Scanner;

public class TicTacToe {
    private Player player1 = new Player('X');
    private Player player2 = new Player('O');
    private Player currentPlayer = player1;
    private Board board = new Board();

    public void start() {}

    public int[] getValidCoordinates(Scanner scanner) {
        System.out.print("row (0-2): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Bitte nur Zahlen eingeben!");
            scanner.next();
            return null;
        }
        int x = scanner.nextInt();
        System.out.print("column (0-2): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Bitte nur Zahlen eingeben!");
            scanner.next();
            return null;
        }
        int y = scanner.nextInt();
        if (!board.isCellEmpty(x, y)) {
            System.out.println("Ungültiger Zug! Versuche es erneut.");
            return null;
        }
        return new int[]{x, y};
    }

    public Player getCurrentPlayer() { return currentPlayer; }
    public Board getBoard() { return board; }
    public void switchCurrentPlayer() {}
    public boolean hasWinner() { return false; }
}

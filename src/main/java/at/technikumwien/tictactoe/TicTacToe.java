package at.technikumwien.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            board.clear();
            currentPlayer = player1;
            while (true) {
                System.out.println("Current Player: " + currentPlayer.getMarker());
                board.print();
                int row;
                int column;
                while (true) {
                    System.out.print("row (0-2): ");
                    if (scanner.hasNextInt()) {
                        row = scanner.nextInt();
                        if (row >= 0 && row <= 2) {
                            break;
                        }
                    } else {
                        scanner.next(); // ungültige Eingabe verwerfen
                    }
                    System.out.println("Invalid input! Please enter a number between 0 and 2.");
                }
                while (true) {
                    System.out.print("column (0-2): ");
                    if (scanner.hasNextInt()) {
                        column = scanner.nextInt();
                        if (column >= 0 && column <= 2) {
                            break;
                        }
                    } else {
                        scanner.next(); // ungültige Eingabe verwerfen
                    }
                    System.out.println("Invalid input! Please enter a number between 0 and 2.");
                }
                if (!board.isCellEmpty(row, column)) {
                    System.out.println("Cell already occupied! Try again.");
                    continue;
                }
                board.place(row, column, currentPlayer.getMarker());
                if (hasWinner()) {
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    break;
                }
                if (board.isFull()) {
                    board.print();
                    System.out.println("Draw!");
                    break;
                }
                switchCurrentPlayer();
            }
            while (true) {
                System.out.print("Do you want to play again? (yes/no): ");
                answer = scanner.next().trim().toLowerCase();
                if (answer.equals("yes")
                        || answer.equals("y")
                        || answer.equals("no")
                        || answer.equals("n")) {
                    break;
                }
                System.out.println("Invalid input! Please enter yes or no.");
            }
        } while (answer.equals("yes") || answer.equals("y"));
        System.out.println("Thanks for playing!");
        scanner.close();
    }

//    public int[] getValidCoordinates(Scanner scanner) {
//        System.out.print("row (0-2): ");
//        if (!scanner.hasNextInt()) {
//            System.out.println("Bitte nur Zahlen eingeben!");
//            scanner.next();
//            return null;
//        }
//        int x = scanner.nextInt();
//        System.out.print("column (0-2): ");
//        if (!scanner.hasNextInt()) {
//            System.out.println("Bitte nur Zahlen eingeben!");
//            scanner.next();
//            return null;
//        }
//        int y = scanner.nextInt();
//        if (!board.isCellEmpty(x, y)) {
//            System.out.println("Ungültiger Zug! Versuche es erneut.");
//            return null;
//        }
//        return new int[]{x, y};
//    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char[][] c = board.getCells();
        for (int i = 0; i < 3; i++) {
            if (c[i][0] != ' ' && c[i][0] == c[i][1] && c[i][1] == c[i][2]) {
                return true;
            }
            if (c[0][i] != ' ' && c[0][i] == c[1][i] && c[1][i] == c[2][i]) {
                return true;
            }
        }
        if (c[0][0] != ' ' && c[0][0] == c[1][1] && c[1][1] == c[2][2]) {
            return true;
        }
        if (c[0][2] != ' ' && c[0][2] == c[1][1] && c[1][1] == c[2][0]) {
            return true;
        }
        return false;
    }
}

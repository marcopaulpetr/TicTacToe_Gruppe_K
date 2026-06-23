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

        while (true) {
            System.out.println("Current Player: " + currentPlayer.getMarker());
            board.print();

            int row;
            int column;

            do {
                System.out.print("row (0-2): ");
                row = scanner.nextInt();

                System.out.print("column (0-2): ");
                column = scanner.nextInt();

                if (row < 0 || row > 2 ||
                        column < 0 || column > 2 ||
                        !board.isCellEmpty(row, column)) {

                    System.out.println("Invalid move! Try again.");
                }

            } while (row < 0 || row > 2 ||
                    column < 0 || column > 2 ||
                    !board.isCellEmpty(row, column));

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

package at.technikumwien.tictactoe;

public class Main {
    static void main() {
//        System.out.println("--- MANUAL TEST FOR US-01 ---");
//        TicTacToe game = new TicTacToe();
//        Board board = game.getBoard();
//        Scanner scanner = new Scanner(System.in);
//
//        // Teil 1: Logik-Test für das Board
//        System.out.println("Is cell (0,0) empty? " + board.isCellEmpty(0, 0));
//        board.place(0, 0, 'X');
//        System.out.println("Is cell (0,0) empty now? " + board.isCellEmpty(0, 0));
//
//        // Teil 2: Test der Konsolen-Eingabe und Validierung
//        System.out.println("\n--- Testing Input Validation ---");
//        int[] coords = game.getValidCoordinates(scanner);
//        if (coords != null) {
//            System.out.println("Success! Row: " + coords[0] + " | Col: " + coords[1]);
//        } else {
//            System.out.println("Fail! Input was invalid or cell was already taken.");
//        }
//        System.out.println("=== MANUELLER TEST FÜR US-02 ===");
//        Board board = new Board();
//        // Test-Steine wie in eurem Beispiel setzen
//        board.place(1, 0, 'O');
//        board.place(1, 1, 'X');
//        board.place(1, 2, '0');
//        System.out.println("\nSpielfeld-Ausgabe:\n");
//        board.print();
//        System.out.println("\n=== TEST BEENDET ===");
        TicTacToe game=new TicTacToe();
        game.start();

    }


}

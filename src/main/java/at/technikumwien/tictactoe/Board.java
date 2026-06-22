package at.technikumwien.tictactoe;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
            return false;
        }
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        }
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public char[][] getCells() {
        return cells;
    }

    public void print() {

        System.out.println("▁▁▁▁▁▁▁▁▁▁▁▁▁");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + cells[i][0] + " | " + cells[i][1] + " | " + cells[i][2] + " | ");
        }
        System.out.println("▔▔▔▔▔▔▔▔▔▔▔▔▔");

    }

    public boolean isFull() {
        return false;
    }
}

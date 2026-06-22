package at.technikumwien.tictactoe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    Board board;
    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @AfterEach
    public void tearDown() {
        board = null;
    }

    @Test
    public void testIsCellEmptyPositive() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellEmptyNegative() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlacePositive() {
        Board board = new Board();
        board.place(1, 1, 'X');
        assertEquals('X', board.getCells()[1][1]);
    }

    @Test
    public void testPlaceNegative() {
        Board board = new Board();
        board.place(1, 1, 'X');
        board.place(1, 1, 'O');
        assertNotEquals('O', board.getCells()[1][1]);
    }

    @Test
    public void testGetCellsPositive() {
        Board board = new Board();
        assertNotNull(board.getCells());
    }

    @Test
    public void testGetCellsNegative() {
        Board board = new Board();
        assertEquals(3, board.getCells().length);
    }

    @Test
    public void testClearPositive() {
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testClearNegative() {
        board.place(0, 0, 'X');
        board.clear();
        assertFalse(board.getCells()[0][0] == 'X');
    }
}

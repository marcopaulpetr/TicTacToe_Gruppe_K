package at.technikumwien.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TicTacToeTest {

    TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @AfterEach
    public void tearDown() {
        game = null;
    }

    @Test
    public void testSwitchCurrentPlayerPositive() {

        game.switchCurrentPlayer();
        assertEquals('O', game.getCurrentPlayer().getMarker());
    }

    @Test
    public void testSwitchCurrentPlayerNegative() {

        game.switchCurrentPlayer();
        assertNotEquals('X', game.getCurrentPlayer().getMarker());
    }

    @Test
    public void testGetCurrentPlayerPositive() {

        assertNotNull(game.getCurrentPlayer());
    }

    @Test
    public void testGetCurrentPlayerNegative() {

        assertEquals('X', game.getCurrentPlayer().getMarker());
    }
}

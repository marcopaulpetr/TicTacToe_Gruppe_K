package at.technikumwien.tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player;
    @BeforeEach
    void setUp() {
        player=null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testGetMarkerPositive() {
        player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    @Test
    public void testGetMarkerNegative() {
        player = new Player('O');
        assertNotEquals('X', player.getMarker());
    }
}
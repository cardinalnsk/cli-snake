package ru.cardinalnsk.controller;

import static com.github.stefanbirkner.systemlambda.SystemLambda.catchSystemExit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.cardinalnsk.model.enums.Direction;

class ConsoleControllerTest {

    private Terminal terminal;
    private ConsoleController consoleController;

    @BeforeEach
    public void setUp() {
        terminal = Mockito.mock(Terminal.class);
        consoleController = new ConsoleController(terminal);
        consoleController.setMaxMenuItems(3);
    }

    @Test
    void testArrowUpChangesSelectedMenuItem() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowUp);
        when(terminal.readInput()).thenReturn(keyStroke);

        consoleController.setSelectedMenuItem(1);

        consoleController.keyListener();

        assertEquals(0, consoleController.getSelectedMenuItem());
    }

    @Test
    void testArrowDownChangesSelectedMenuItem() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowDown);
        when(terminal.readInput()).thenReturn(keyStroke);

        consoleController.setSelectedMenuItem(3);

        consoleController.keyListener();

        assertEquals(1, consoleController.getSelectedMenuItem());
    }

    @Test
    void testCharacterWChangesDirectionToUp() throws IOException {
        KeyStroke keyStroke = new KeyStroke('w', false, false);
        when(terminal.readInput()).thenReturn(keyStroke);
        consoleController.setDirection(Direction.RIGHT);

        consoleController.keyListener();

        assertEquals(Direction.UP, consoleController.getDirection());
    }

    @Test
    void testEscapeStopsGame() throws Exception {
        KeyStroke keyStroke = new KeyStroke(KeyType.Escape);

        when(terminal.readInput()).thenReturn(keyStroke);

        consoleController.setAlive(true);

        int exitCode = catchSystemExit(() ->
            consoleController.keyListener()
        );
        assertEquals(0, exitCode);
    }

    @Test
    void testEnterPressed() throws IOException {

        KeyStroke keyStroke = new KeyStroke(KeyType.Enter);
        when(terminal.readInput()).thenReturn(keyStroke);

        assertFalse(consoleController.isEnterPressed());

        consoleController.keyListener();

        assertTrue(consoleController.isEnterPressed());
    }
}
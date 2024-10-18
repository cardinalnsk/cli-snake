package ru.cardinalnsk.view.utils.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.cardinalnsk.view.utils.Printer;

class SwingConsolePrinterTest {

    private Terminal terminal;
    private Printer printer;

    @BeforeEach
    void setUp() {
        terminal = Mockito.mock(Terminal.class);
        printer = new SwingConsolePrinter(terminal);
    }

    @Test
    void testPrint() throws IOException {
        String testString = "test";
        printer.print(testString);

        verify(terminal).putString(testString);
        verify(terminal).flush();
    }

    @Test
    void testMoveToPosition() throws IOException {
        int x = 10;
        int y = 5;

        printer.moveToPosition(x, y);

        verify(terminal).setCursorPosition(x, y);
        verify(terminal).flush();
    }

    @Test
    void testClear() throws IOException {
        printer.clearScreen();

        verify(terminal).clearScreen();
        verify(terminal).flush();
    }

    @Test
    void testWidth() throws IOException {
        TerminalSize terminalSize = new TerminalSize(80, 20);

        when(terminal.getTerminalSize()).thenReturn(terminalSize);

        int width = printer.width();

        assertEquals(80, width);
    }

    @Test
    void testHeight() throws IOException {
        TerminalSize terminalSize = new TerminalSize(80, 20);

        when(terminal.getTerminalSize()).thenReturn(terminalSize);

        int height = printer.height();

        assertEquals(20, height);
    }
}
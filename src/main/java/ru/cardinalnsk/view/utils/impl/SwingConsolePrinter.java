package ru.cardinalnsk.view.utils.impl;

import com.googlecode.lanterna.terminal.Terminal;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import ru.cardinalnsk.view.utils.Printer;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SwingConsolePrinter implements Printer {

    Terminal terminal;

    @SneakyThrows
    @Override
    public void print(String str) {
        terminal.putString(str);
        terminal.flush();
    }

    @SneakyThrows
    @Override
    public void moveToPosition(int x, int y) {
        terminal.setCursorPosition(x, y);
        terminal.flush();

    }

    @SneakyThrows
    @Override
    public void clearScreen() {
        terminal.clearScreen();
        terminal.flush();

    }

    @SneakyThrows
    @Override
    public int width() {
        return terminal.getTerminalSize().getColumns();
    }

    @SneakyThrows
    @Override
    public int height() {
        return terminal.getTerminalSize().getRows();
    }
}

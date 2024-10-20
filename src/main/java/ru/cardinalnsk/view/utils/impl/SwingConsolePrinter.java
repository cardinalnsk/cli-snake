package ru.cardinalnsk.view.utils.impl;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
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
    public TextGraphics getTextGraphics() {
        return terminal.newTextGraphics();
    }

    @SneakyThrows
    @Override
    public void refresh() {
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
    public void setColor(TextColor color) {
        terminal.setForegroundColor(color);
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

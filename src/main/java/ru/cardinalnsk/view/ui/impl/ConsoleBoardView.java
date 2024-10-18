package ru.cardinalnsk.view.ui.impl;

import ru.cardinalnsk.model.Board;
import ru.cardinalnsk.view.AbstractView;
import ru.cardinalnsk.view.ui.BoardView;
import ru.cardinalnsk.view.utils.Printer;

public class ConsoleBoardView extends AbstractView<Board> implements BoardView {

    public ConsoleBoardView(Printer printer, Board model) {
        super(printer, model);
    }

    @Override
    public void draw() {
        WIDTH = model().width();
        HEIGHT = model().height();
        int startX = printer.width() / 2 - WIDTH / 2;
        int startY = printer.height() / 2 - HEIGHT / 2;
        printer.clearScreen();
        for (int row = 0; row < HEIGHT; row++) {
            for (int column = 0; column < WIDTH; column++) {
                if (row == 0 || column == 0 || column == WIDTH - 1 || row == HEIGHT - 1) {
                    printer.moveToPosition(startX + column, startY + row);
                    printer.print(SYMBOL);
                }
            }
        }
    }
}

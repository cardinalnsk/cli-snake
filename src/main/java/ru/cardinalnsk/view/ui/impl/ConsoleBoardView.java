package ru.cardinalnsk.view.ui.impl;

import lombok.SneakyThrows;
import ru.cardinalnsk.model.Board;
import ru.cardinalnsk.view.AbstractView;
import ru.cardinalnsk.view.ui.BoardView;
import ru.cardinalnsk.view.utils.Printer;

public class ConsoleBoardView extends AbstractView<Board> implements BoardView {

    public ConsoleBoardView(Printer printer, Board model) {
        super(printer, model);
    }

    @SneakyThrows
    @Override
    public void draw() {
        WIDTH = model().width();
        HEIGHT = model().height();
        int startX = printer.width() / 2 - WIDTH / 2;
        int startY = printer.height() / 2 - HEIGHT / 2;
        printer.clearScreen();

        for (int sum = 0; sum <= WIDTH + HEIGHT - 2; sum++) {
            for (int row = 0; row < HEIGHT; row++) {
                int column = sum - row;
                if (column >= 0 && column < WIDTH) {
                    if (row == 0 || column == 0 || column == WIDTH - 1 || row == HEIGHT - 1) {
                        printer.moveToPosition(startX + column, startY + row);
                        printer.print(SYMBOL);
                        Thread.sleep(3);
                    }
                }
            }
        }
    }

}

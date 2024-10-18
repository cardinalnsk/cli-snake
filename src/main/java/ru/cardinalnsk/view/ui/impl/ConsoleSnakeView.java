package ru.cardinalnsk.view.ui.impl;

import ru.cardinalnsk.model.Cell;
import ru.cardinalnsk.model.Snake;
import ru.cardinalnsk.view.AbstractView;
import ru.cardinalnsk.view.ui.SnakeView;
import ru.cardinalnsk.view.utils.Printer;

public class ConsoleSnakeView extends AbstractView<Snake> implements SnakeView {

    private Cell oldTail;
    private Cell newHead;

    public ConsoleSnakeView(Printer printer, Snake model) {
        super(printer, model);
    }

    @Override
    public void snakePosition(Cell newHead, Cell oldTail) {
        this.newHead = newHead;
        this.oldTail = oldTail;
        draw();
    }

    @Override
    public void draw() {
        printer.moveToPosition(oldTail.x() + 1, oldTail.y() + 1);
        printer.print(EMPTY_SYMBOL);

        printer.moveToPosition(newHead.x() + 1, newHead.y() + 1);
        printer.print(SNAKE_SYMBOL);
    }
}

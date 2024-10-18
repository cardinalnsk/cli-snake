package ru.cardinalnsk.view.ui.impl;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.cardinalnsk.model.Cell;
import ru.cardinalnsk.model.Snake;
import ru.cardinalnsk.view.ui.SnakeView;
import ru.cardinalnsk.view.utils.Printer;

class ConsoleSnakeViewTest {

    private Printer printer;
    private SnakeView view;
    private Cell oldTail;
    private Cell newHead;

    @BeforeEach
    void setUp() {
        printer = Mockito.mock(Printer.class);
        Snake snake = Mockito.mock(Snake.class);
        view = new ConsoleSnakeView(printer, snake);
        oldTail = new Cell(1, 1);
        newHead = new Cell(2, 2);
    }

    @Test
    void testSnakePosition() {
        view.snakePosition(newHead, oldTail);
        verify(printer).moveToPosition(oldTail.x() + 1, oldTail.y() + 1);
        verify(printer).print(SnakeView.EMPTY_SYMBOL);
        verify(printer).moveToPosition(newHead.x() + 1, newHead.y() + 1);
        verify(printer).print(SnakeView.SNAKE_SYMBOL);
    }

}
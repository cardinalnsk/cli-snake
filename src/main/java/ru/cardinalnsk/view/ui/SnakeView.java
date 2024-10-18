package ru.cardinalnsk.view.ui;

import ru.cardinalnsk.model.Cell;

public interface SnakeView {

    String SNAKE_SYMBOL = "8";
    String EMPTY_SYMBOL = " ";

    void snakePosition(Cell newHead, Cell oldTail);

}

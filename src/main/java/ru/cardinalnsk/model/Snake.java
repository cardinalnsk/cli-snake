package ru.cardinalnsk.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;

@Builder
public record Snake(List<Cell> snakeBody, Cell headCell) {

    public Snake {
        snakeBody = new ArrayList<>();
        Cell tail = headCell.toBuilder()
            .x(headCell().x() - 1)
            .y(headCell().y())
            .build();
        snakeBody.add(headCell);
        snakeBody.add(tail);
    }

}

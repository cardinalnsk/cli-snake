package ru.cardinalnsk.model.enums;

import lombok.Getter;
import ru.cardinalnsk.model.Cell;

@Getter
public enum Direction {
    UP(new Cell(0,-1)),
    DOWN(new Cell(0,1)),
    LEFT(new Cell(-1,0)),
    RIGHT(new Cell(1,0));

    private final Cell direction;
    Direction(Cell cell) {
        this.direction = cell;
    }
}

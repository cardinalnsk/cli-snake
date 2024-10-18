package ru.cardinalnsk.view.ui.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.cardinalnsk.model.Board;
import ru.cardinalnsk.model.Cell;
import ru.cardinalnsk.model.Fruit;
import ru.cardinalnsk.view.ui.FruitView;
import ru.cardinalnsk.view.utils.Printer;

class ConsoleFruitViewTest {

    private Printer printer;
    private Fruit fruit;

    private FruitView view;
    @BeforeEach
    void setUp() {
        printer = Mockito.mock(Printer.class);
        fruit = Mockito.mock(Fruit.class);
        view = new ConsoleFruitView(printer, fruit);
    }

    @Test
    void fruitDraw() {
        Cell cell = new Cell(2,2);
        when(fruit.fruitCell()).thenReturn(cell);

        view.draw();

        verify(printer).moveToPosition(3, 3);
        verify(printer).print(FruitView.SYMBOL);
    }
}
package ru.cardinalnsk.view.ui.impl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.cardinalnsk.model.Board;
import ru.cardinalnsk.view.ui.BoardView;
import ru.cardinalnsk.view.utils.Printer;

class ConsoleBoardViewTest {

    private Printer printer;
    private Board board;

    private BoardView view;

    @BeforeEach
    void setUp() {
        printer = Mockito.mock(Printer.class);
        board = Mockito.mock(Board.class);
        view = new ConsoleBoardView(printer, board);
    }

    @Test
    void testDraw() {
        when(board.width()).thenReturn(5);
        when(board.height()).thenReturn(3);
        when(printer.width()).thenReturn(20);
        when(printer.height()).thenReturn(10);

        view.draw();

        int startX = (20 / 2) - (5 / 2);
        int startY = (10 / 2) - (3 / 2);

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 5; column++) {
                if (row == 0 || column == 0 || row == 2 || column == 4) {
                    verify(printer, times(1))
                        .moveToPosition(startX + column, startY + row);
                }
            }
        }

        verify(printer, times(12))
            .print(BoardView.SYMBOL);


    }
}
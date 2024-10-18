package ru.cardinalnsk.view.ui.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.cardinalnsk.model.Score;
import ru.cardinalnsk.view.ui.ScoreView;
import ru.cardinalnsk.view.utils.Printer;

class ConsoleScoreViewTest {

    private Printer printer;
    private Score score;

    private ScoreView view;

    @BeforeEach
    void setUp() {
        printer = Mockito.mock(Printer.class);
        score = Mockito.mock(Score.class);
        view = new ConsoleScoreView(printer, score);
    }

    @Test
    void scoreDraw() throws Exception {
        String scoreStr = "Score: %d".formatted(10);
        String bestScore = "Best score: %d".formatted(100);
        String fullLine = String.format("%s    %s", scoreStr, bestScore);

        when(score.score()).thenReturn(10);
        when(score.bestScore()).thenReturn(100);

        when(printer.width()).thenReturn(30);
        int x = 30 / 2 - fullLine.length() / 2;
        int y = 4;
        view.draw();

        verify(printer).moveToPosition(x, y);
        verify(printer).print(fullLine);
    }
}
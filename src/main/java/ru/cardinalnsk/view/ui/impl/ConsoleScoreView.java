package ru.cardinalnsk.view.ui.impl;

import ru.cardinalnsk.model.Score;
import ru.cardinalnsk.view.AbstractView;
import ru.cardinalnsk.view.ui.ScoreView;
import ru.cardinalnsk.view.utils.Printer;

public class ConsoleScoreView extends AbstractView<Score> implements ScoreView {

    public ConsoleScoreView(Printer printer, Score model) {
        super(printer, model);
    }

    @Override
    public void draw() {
        String score = "Score: %d".formatted(model().score());
        String bestScore = "Best score: %d".formatted(model().bestScore());
        String fullLine = String.format("%s    %s", score, bestScore);
        int widthX = printer.width() / 2 - fullLine.length() / 2;
        int heightY = 4;

        printer.moveToPosition(widthX, heightY);
        printer.print(fullLine);
    }
}

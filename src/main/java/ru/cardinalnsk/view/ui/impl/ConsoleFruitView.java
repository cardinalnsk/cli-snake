package ru.cardinalnsk.view.ui.impl;

import ru.cardinalnsk.model.Fruit;
import ru.cardinalnsk.view.AbstractView;
import ru.cardinalnsk.view.ui.FruitView;
import ru.cardinalnsk.view.utils.Printer;

public class ConsoleFruitView extends AbstractView<Fruit> implements FruitView {

    public ConsoleFruitView(Printer printer, Fruit model) {
        super(printer, model);
    }

    @Override
    public void draw() {
        printer.moveToPosition(model().fruitCell().x() + 1, model().fruitCell().y() + 1);
        printer.print(SYMBOL);
    }
}

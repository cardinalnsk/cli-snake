package ru.cardinalnsk.view;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.cardinalnsk.view.utils.Printer;

@RequiredArgsConstructor
public abstract class AbstractView<T> {

    protected static int HEIGHT;

    protected static int WIDTH;

    protected final Printer printer;
    @Getter
    private final T model;

    public abstract void draw();


}

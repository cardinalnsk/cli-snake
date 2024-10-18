package ru.cardinalnsk.view.utils;

public interface Printer {

    void print(String str);

    void moveToPosition(int x, int y);

    void clearScreen();

    int width();

    int height();
}

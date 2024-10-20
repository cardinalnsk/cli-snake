package ru.cardinalnsk.view.utils;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public interface Printer {

    void print(String str);

    TextGraphics getTextGraphics();

    void refresh();

    void moveToPosition(int x, int y);

    void clearScreen();

    void setColor(TextColor color);

    int width();

    int height();
}

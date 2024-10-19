package ru.cardinalnsk.view.menu;

public interface MenuView {
    String ACTUAL_MENU_POINT = "> ";
    String EMPTY_MENU_POINT = "  ";

    void draw();
    void drawSelectedMenuItem(int index);
}

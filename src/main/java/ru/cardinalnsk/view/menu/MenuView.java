package ru.cardinalnsk.view.menu;

public interface MenuView {
    String ARROW_RIGHT = "> ";
    String ARROW_LEFT = " <";
    String EMPTY_MENU_POINT = "  ";

    void draw();
    void drawSelectedMenuItem(int index);
}

package ru.cardinalnsk.view.menu.impl;

import ru.cardinalnsk.model.Menu;
import ru.cardinalnsk.view.AbstractView;
import ru.cardinalnsk.view.menu.MenuView;
import ru.cardinalnsk.view.utils.Printer;

public class ConsoleMenuView extends AbstractView<Menu> implements MenuView {

    private final int headerX;
    private final int headerY;
    private final int menuItemX;
    private final int menuItemY;
    private final Menu menu;

    public ConsoleMenuView(Printer printer, Menu menu) {
        super(printer, menu);
        this.menu = menu;
        int headerLength = menu.header().length();
        this.headerX = (printer.width() / 2) - headerLength / 2;
        this.headerY = printer.height() / 2 - menu.menuItems().size();
        this.menuItemX = headerX + 2;
        this.menuItemY = headerY + 2;

    }


    @Override
    public void draw() {
        printer.clearScreen();
        printer.moveToPosition(headerX, headerY);
        printer.print(menu.header());
        for (int i = 0; i < menu.menuItems().size(); i++) {
            String menuItem = menu.menuItems().get(i);
            printer.moveToPosition(menuItemX + 2, menuItemY + i);
            printer.print(menuItem);
        }
    }

    @Override
    public void drawMenuItem(int index) {
        for (int i = 0; i < menu.menuItems().size(); i++) {
            printer.moveToPosition(menuItemX, menuItemY + i);
            if (i == index) {
                printer.print(ACTUAL_MENU_POINT);
            } else {
                printer.print(EMPTY_MENU_POINT);
            }
        }
    }
}

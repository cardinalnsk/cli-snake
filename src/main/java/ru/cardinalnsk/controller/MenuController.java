package ru.cardinalnsk.controller;

import lombok.Getter;
import ru.cardinalnsk.model.Menu;
import ru.cardinalnsk.view.menu.MenuView;
import ru.cardinalnsk.view.menu.impl.ConsoleMenuView;
import ru.cardinalnsk.view.utils.Printer;

public class MenuController implements Runnable {

    private final Menu menu;
    private final MenuView menuView;
    private final ConsoleController consoleController;
    boolean isAlive = false;
    @Getter
    private int selectedMenuItem = -1;

    public MenuController(Printer printer, ConsoleController consoleController, Menu menu) {
        this.menu = menu;
        this.menuView = new ConsoleMenuView(printer, menu);
        this.consoleController = consoleController;
    }

    @Override
    public void run() {
        isAlive = true;
        consoleController.maxMenuItems(menu.menuItems().size());
        menuView.draw();
        while (!consoleController.enterPressed()) {
            menuView.drawSelectedMenuItem(consoleController.selectedMenuItem());

            if (consoleController.enterPressed()) {
                isAlive = false;
                selectedMenuItem = consoleController.selectedMenuItem();
            }
        }
        consoleController.enterPressed(false);
    }

    public void stop() {
        isAlive = false;
        try {
            Thread.currentThread().interrupt();
        } catch (Exception ignored) {

        }
    }

}

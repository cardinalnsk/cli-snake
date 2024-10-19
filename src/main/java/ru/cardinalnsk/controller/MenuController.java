package ru.cardinalnsk.controller;

import java.util.List;
import ru.cardinalnsk.model.Menu;
import ru.cardinalnsk.view.menu.MenuView;
import ru.cardinalnsk.view.menu.impl.ConsoleMenuView;
import ru.cardinalnsk.view.utils.Printer;

public class MenuController {

    private static final Menu STARTUP_MENU = Menu.builder()
        .header("Welcome to snake game")
        .menuItems(List.of(
            "Start game",
            "Score table",
            "Exit"
        ))
        .build();
    private final Printer printer;
    private final MenuView mainMenu;

    public MenuController(Printer printer) {
        this.printer = printer;
        this.mainMenu = new ConsoleMenuView(printer, STARTUP_MENU);
    }


}

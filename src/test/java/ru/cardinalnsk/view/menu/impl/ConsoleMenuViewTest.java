package ru.cardinalnsk.view.menu.impl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.cardinalnsk.model.Menu;
import ru.cardinalnsk.view.menu.MenuView;
import ru.cardinalnsk.view.utils.Printer;

class ConsoleMenuViewTest {

    private static final int TERMINAL_WIDTH = 50;
    private static final int TERMINAL_HEIGHT = 25;
    private Printer printer;
    private Menu menu;
    private MenuView view;
    private int headerX;
    private int headerY;
    private int menuItemX;
    private int menuItemY;

    @BeforeEach
    void setUp() {
        this.printer = Mockito.mock(Printer.class);
        when(printer.width()).thenReturn(TERMINAL_WIDTH);
        when(printer.height()).thenReturn(TERMINAL_HEIGHT);

        List<String> menuItems = List.of("First item", "Second item", "Third item");
        this.menu = Menu.builder()
            .header("Test menu")
            .menuItems(menuItems)
            .build();

        this.view = new ConsoleMenuView(printer, menu);

        int headerLength = menu.header().length();
        this.headerX = 50 / 2 - headerLength / 2;
        this.headerY = 25 / 2 - menu.menuItems().size();
        this.menuItemX = headerX + 2;
        this.menuItemY = headerY + 2;
    }

    @Test
    void testDrawMenu() {
        view.draw();

        verify(printer).clearScreen();

        verify(printer).moveToPosition(headerX, headerY);
        verify(printer).print(menu.header());

        for (int i = 0; i < menu.menuItems().size(); i++) {
            String menuItem = menu.menuItems().get(i);
            verify(printer).moveToPosition(menuItemX + 2, menuItemY + i);
            verify(printer).print(menuItem);
        }
    }

    @Test
    void testDrawMenuItem() {
        int selectedIndex = 1;
        view.drawMenuItem(selectedIndex);
        for (int i = 0; i < menu.menuItems().size(); i++) {
            verify(printer).moveToPosition(menuItemX, menuItemY + i);
        }
        verify(printer).print("> ");
        verify(printer, times(menu.menuItems().size() - 1)).print("  ");
    }
}
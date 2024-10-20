package ru.cardinalnsk.view.ui.impl;

import com.googlecode.lanterna.TextColor.ANSI;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.util.List;
import java.util.Random;
import lombok.SneakyThrows;
import ru.cardinalnsk.core.annotations.InjectByType;
import ru.cardinalnsk.model.Logo;
import ru.cardinalnsk.view.AbstractView;
import ru.cardinalnsk.view.ui.LogoView;
import ru.cardinalnsk.view.utils.Printer;

public class ConsoleLogoView extends AbstractView<Logo> implements LogoView {

    public ConsoleLogoView(Printer printer, Logo model) {
        super(printer, model);
    }

    @SneakyThrows
    @Override
    public void draw() {
        printer.clearScreen();
        TextGraphics textGraphics = printer.getTextGraphics();
        textGraphics.setBackgroundColor(ANSI.BLACK);
        textGraphics.setForegroundColor(ANSI.CYAN_BRIGHT);

        List<String> logo = model().logo();
        int y = printer.height() / 2 - logo.size() / 2;

        // Итерация по строкам
        for (int i = 0; i < logo.size(); i++) {
            String line = logo.get(i);
            int lineLength = line.length();

            // Отрисовка от краев к центру
            for (int j = 0; j <= (lineLength + 1) / 2; j++) {
                // Отрисовка символов слева
                textGraphics.putString(printer.width() / 2 - (lineLength / 2) + j, y + i,
                    String.valueOf(line.charAt(j)));
                // Отрисовка символов справа
                textGraphics.putString(printer.width() / 2 + (lineLength / 2) - j, y + i,
                    String.valueOf(line.charAt(lineLength - j - 1)));

                printer.refresh();
                Thread.sleep(new Random().nextInt(1, 4) * 10L);
            }

        }
        Thread.sleep(2000L);
    }
}

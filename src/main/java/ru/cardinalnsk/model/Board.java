package ru.cardinalnsk.model;

import com.googlecode.lanterna.TerminalSize;
import lombok.Builder;

@Builder
public record Board(int width, int height) {

    public static Board of(TerminalSize terminalSize) {
        int width = terminalSize.getColumns() / 2;
        int height = (int) (width / 3.33);
        return new Board(width, height);
    }

}

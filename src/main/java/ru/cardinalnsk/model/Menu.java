package ru.cardinalnsk.model;

import java.util.List;
import lombok.Builder;

@Builder
public record Menu(String header, List<String> menuItems) {

    public static final Menu MAIN_MENU = Menu.builder()
        .header("Welcome to SNAKE game!")
        .menuItems(List.of("Start game", "Score board", "Exit"))
        .build();
}

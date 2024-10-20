package ru.cardinalnsk.model;

import java.util.List;
import lombok.Builder;

@Builder
public record Logo(List<String> logo) {

    private static final List<String> strLogo = List.of(
        "  ___                 _            ___                      ",
        " / __|  _ _    __ _  | |__  ___   / __|  __ _   _ __    ___ ",
        " \\__ \\ | ' \\  / _` | | / / / -_) | (_ | / _` | | '  \\  / -_)",
        " |___/ |_||_| \\__,_| |_\\_\\ \\___|  \\___| \\__,_| |_|_|_| \\___|",
        "                                                            "
    );

    public static final Logo LOGO = Logo.builder()
        .logo(strLogo)
        .build();

}

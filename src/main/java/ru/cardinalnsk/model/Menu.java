package ru.cardinalnsk.model;

import java.util.List;
import lombok.Builder;

@Builder
public record Menu(String header, List<String> menuItems) {

}

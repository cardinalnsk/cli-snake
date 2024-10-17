package ru.cardinalnsk.model;

import lombok.Builder;

@Builder(toBuilder = true)
public record Cell(int x, int y) {

}

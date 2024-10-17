package ru.cardinalnsk.model;

import lombok.Builder;

@Builder
public record Score(int score, int bestScore) {

}

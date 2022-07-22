package com.github.gustavoflor.ordo.model;

import java.util.List;

public record Munition(String name, Integer category, Integer spaces) {
    private static final Munition ARROW = new Munition("Flechas", 0, 1);
    private static final Munition LIGHT_BULLETS = new Munition("Balas leves", 0, 1);
    private static final Munition CARTRIDGES = new Munition("Cartuchos", 1, 1);
    private static final Munition HEAVY_BULLETS = new Munition("Balas pesadas", 1, 1);
    private static final Munition ROCKET = new Munition("Foguete", 1, 1);
    private static final Munition FUEL = new Munition("Combustível", 1, 1);

    public static List<Munition> values() {
        return List.of(ARROW, LIGHT_BULLETS, CARTRIDGES, HEAVY_BULLETS, ROCKET, FUEL);
    }
}

package com.github.gustavoflor.ordo.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@RequiredArgsConstructor
public enum Origin {
    FIGHTER("Lutador");

    private final String label;

    public String getName() {
        return name();
    }
}

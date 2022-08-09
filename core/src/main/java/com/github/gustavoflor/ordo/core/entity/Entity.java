package com.github.gustavoflor.ordo.core.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public abstract class Entity {
    @Id
    private String id;
}

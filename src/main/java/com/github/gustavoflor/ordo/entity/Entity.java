package com.github.gustavoflor.ordo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

import static java.util.Objects.isNull;

@Getter
@Setter
public abstract class Entity implements Persistable<String> {
    @Id
    private String id;

    @Override
    public boolean isNew() {
        return isNull(getId());
    }
}

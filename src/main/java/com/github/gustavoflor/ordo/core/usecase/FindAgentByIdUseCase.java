package com.github.gustavoflor.ordo.core.usecase;

import com.github.gustavoflor.ordo.core.entity.Agent;
import lombok.NonNull;

import java.util.Optional;

public interface FindAgentByIdUseCase {
    Optional<Agent> execute(@NonNull String id);
}

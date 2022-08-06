package com.github.gustavoflor.ordo.core.usecase;

import lombok.NonNull;

public interface DeleteAgentByIdUseCase {
    void execute(@NonNull String id);
}

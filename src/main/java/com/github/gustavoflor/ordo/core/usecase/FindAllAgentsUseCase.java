package com.github.gustavoflor.ordo.core.usecase;

import com.github.gustavoflor.ordo.core.entity.Agent;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindAllAgentsUseCase {
    Page<Agent> execute(@NonNull Pageable pageable);
}

package com.github.gustavoflor.ordo.usecase;

import com.github.gustavoflor.ordo.entity.Agent;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaginateAgentsUseCase {
    Page<Agent> execute(@NonNull Pageable pageable);
}

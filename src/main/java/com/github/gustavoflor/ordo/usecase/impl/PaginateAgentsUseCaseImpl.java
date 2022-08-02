package com.github.gustavoflor.ordo.usecase.impl;

import com.github.gustavoflor.ordo.context.ThreadContext;
import com.github.gustavoflor.ordo.entity.Agent;
import com.github.gustavoflor.ordo.mapping.UseCase;
import com.github.gustavoflor.ordo.repository.AgentRepository;
import com.github.gustavoflor.ordo.usecase.PaginateAgentsUseCase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@UseCase
@RequiredArgsConstructor
public class PaginateAgentsUseCaseImpl implements PaginateAgentsUseCase {
    private final AgentRepository agentRepository;

    @Override
    public Page<Agent> execute(@NonNull final Pageable pageable) {
        final String userId = ThreadContext.getUserId().orElseThrow();
        return agentRepository.findAllByUserId(userId, pageable);
    }
}

package com.github.gustavoflor.ordo.core.usecase.impl;

import com.github.gustavoflor.ordo.core.entity.Agent;
import com.github.gustavoflor.ordo.core.repository.AgentRepository;
import com.github.gustavoflor.ordo.core.usecase.FindAllAgentsUseCase;
import com.github.gustavoflor.ordo.infra.mapping.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@UseCase
@RequiredArgsConstructor
class FindAllAgentsUseCaseImpl implements FindAllAgentsUseCase {
    private final AgentRepository agentRepository;

    @Override
    public Page<Agent> execute(final Pageable pageable) {
        return agentRepository.findAll(pageable);
    }
}

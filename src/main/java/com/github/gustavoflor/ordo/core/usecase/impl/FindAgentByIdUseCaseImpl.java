package com.github.gustavoflor.ordo.core.usecase.impl;

import com.github.gustavoflor.ordo.core.entity.Agent;
import com.github.gustavoflor.ordo.core.repository.AgentRepository;
import com.github.gustavoflor.ordo.core.usecase.FindAgentByIdUseCase;
import com.github.gustavoflor.ordo.infra.mapping.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
class FindAgentByIdUseCaseImpl implements FindAgentByIdUseCase {
    private final AgentRepository agentRepository;

    @Override
    public Optional<Agent> execute(final String id) {
        return agentRepository.findById(id);
    }
}

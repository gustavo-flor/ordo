package com.github.gustavoflor.ordo.core.usecase.impl;

import com.github.gustavoflor.ordo.core.entity.Agent;
import com.github.gustavoflor.ordo.core.mapping.UseCase;
import com.github.gustavoflor.ordo.core.repository.AgentRepository;
import com.github.gustavoflor.ordo.core.usecase.CreateAgentUseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
class CreateAgentUseCaseImpl implements CreateAgentUseCase {
    private final AgentRepository agentRepository;

    @Override
    public Agent execute(final Payload payload) {
        final var agent = Agent.named(payload.agentName());
        return agentRepository.save(agent);
    }
}

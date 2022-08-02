package com.github.gustavoflor.ordo.usecase.impl;

import com.github.gustavoflor.ordo.context.ThreadContext;
import com.github.gustavoflor.ordo.entity.Agent;
import com.github.gustavoflor.ordo.mapping.UseCase;
import com.github.gustavoflor.ordo.repository.AgentRepository;
import com.github.gustavoflor.ordo.usecase.CreateAgentUseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateAgentUseCaseImpl implements CreateAgentUseCase {
    private final AgentRepository agentRepository;

    @Override
    public Agent execute(Payload payload) {
        final String userId = ThreadContext.getUserId().orElseThrow();
        return agentRepository.save(Agent.of(userId, payload));
    }
}

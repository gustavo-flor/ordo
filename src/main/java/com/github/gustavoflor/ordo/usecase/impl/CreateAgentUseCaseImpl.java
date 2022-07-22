package com.github.gustavoflor.ordo.usecase.impl;

import com.github.gustavoflor.ordo.entity.Agent;
import com.github.gustavoflor.ordo.repository.AgentRepository;
import com.github.gustavoflor.ordo.usecase.CreateAgentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAgentUseCaseImpl implements CreateAgentUseCase {
    private final AgentRepository agentRepository;

    @Override
    public Agent execute(Payload payload) {
        return agentRepository.save(Agent.of(payload));
    }
}

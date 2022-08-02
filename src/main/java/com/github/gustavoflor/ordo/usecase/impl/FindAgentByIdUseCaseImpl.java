package com.github.gustavoflor.ordo.usecase.impl;

import com.github.gustavoflor.ordo.context.ThreadContext;
import com.github.gustavoflor.ordo.entity.Agent;
import com.github.gustavoflor.ordo.mapping.UseCase;
import com.github.gustavoflor.ordo.repository.AgentRepository;
import com.github.gustavoflor.ordo.usecase.FindAgentByIdUseCase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class FindAgentByIdUseCaseImpl implements FindAgentByIdUseCase {
    private final AgentRepository agentRepository;

    @Override
    public Optional<Agent> execute(final String id) {
        final String userId = ThreadContext.getUserId().orElseThrow();
        return agentRepository.findByIdAndUserId(id, userId);
    }
}

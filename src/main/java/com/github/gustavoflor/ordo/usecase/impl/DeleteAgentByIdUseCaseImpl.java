package com.github.gustavoflor.ordo.usecase.impl;

import com.github.gustavoflor.ordo.context.ThreadContext;
import com.github.gustavoflor.ordo.mapping.UseCase;
import com.github.gustavoflor.ordo.repository.AgentRepository;
import com.github.gustavoflor.ordo.usecase.DeleteAgentByIdUseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DeleteAgentByIdUseCaseImpl implements DeleteAgentByIdUseCase {
    private final AgentRepository agentRepository;

    @Override
    public void execute(String id) {
        final String userId = ThreadContext.getUserId().orElseThrow();
        agentRepository.deleteByIdAndUserId(id, userId);
    }
}

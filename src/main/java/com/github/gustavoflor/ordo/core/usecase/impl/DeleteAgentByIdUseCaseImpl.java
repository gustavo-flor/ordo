package com.github.gustavoflor.ordo.core.usecase.impl;

import com.github.gustavoflor.ordo.core.repository.AgentRepository;
import com.github.gustavoflor.ordo.core.usecase.DeleteAgentByIdUseCase;
import com.github.gustavoflor.ordo.infra.mapping.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
class DeleteAgentByIdUseCaseImpl implements DeleteAgentByIdUseCase {
    private final AgentRepository agentRepository;

    @Override
    public void execute(final String id) {
        agentRepository.deleteById(id);
    }
}

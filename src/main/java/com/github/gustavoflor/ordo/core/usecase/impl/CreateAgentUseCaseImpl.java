package com.github.gustavoflor.ordo.core.usecase.impl;

import com.github.gustavoflor.ordo.core.entity.Agent;
import com.github.gustavoflor.ordo.core.repository.AgentRepository;
import com.github.gustavoflor.ordo.core.usecase.CreateAgentUseCase;
import com.github.gustavoflor.ordo.infra.mapping.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
class CreateAgentUseCaseImpl implements CreateAgentUseCase {
    private final AgentRepository agentRepository;

    @Override
    public Agent execute(final Payload payload) {
        final Agent agent = Agent.builder()
                .name(payload.name())
                .origin(payload.origin())
                .role(payload.role())
                .rank(payload.rank())
                .expositionLevel(payload.expositionLevel())
                .agility(payload.agility())
                .strength(payload.strength())
                .presence(payload.presence())
                .intellect(payload.intellect())
                .vitality(payload.vitality())
                .totalLifePoints(payload.totalLifePoints())
                .totalEffortPoints(payload.totalEffortPoints())
                .totalSanityPoints(payload.totalSanityPoints())
                .currentLifePoints(payload.currentLifePoints())
                .currentEffortPoints(payload.currentEffortPoints())
                .currentSanityPoints(payload.currentSanityPoints())
                .build();
        return agentRepository.save(agent);
    }
}

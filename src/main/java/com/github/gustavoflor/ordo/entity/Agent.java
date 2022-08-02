package com.github.gustavoflor.ordo.entity;

import com.github.gustavoflor.ordo.model.Origin;
import com.github.gustavoflor.ordo.model.Rank;
import com.github.gustavoflor.ordo.model.Role;
import com.github.gustavoflor.ordo.usecase.CreateAgentUseCase;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "agents")
@Getter
@Setter
@Builder(access = AccessLevel.PRIVATE)
public class Agent extends Entity {
    private static final int INITIAL_EXPOSURE_LEVEL = 5;

    private String userId;

    private String name;
    private Origin origin;
    private Role role;
    private Rank rank;
    private int exposureLevel;
    private int agility;
    private int strength;
    private int intellect;
    private int presence;
    private int vitality;
    private int totalLifePoints;
    private int totalEffortPoints;
    private int totalSanityPoints;
    private int currentLifePoints;
    private int currentEffortPoints;
    private int currentSanityPoints;

    public static Agent of(final String userId, final CreateAgentUseCase.Payload payload) {
        return Agent.builder()
                .userId(userId)
                .name(payload.name())
                .origin(payload.origin())
                .role(payload.role())
                .rank(payload.rank())
                .exposureLevel(INITIAL_EXPOSURE_LEVEL)
                .agility(payload.agility())
                .strength(payload.strength())
                .intellect(payload.intellect())
                .presence(payload.presence())
                .vitality(payload.vitality())
                .totalLifePoints(payload.initialLifePoints())
                .totalEffortPoints(payload.initialEffortPoints())
                .totalSanityPoints(payload.initialSanityPoints())
                .currentLifePoints(payload.initialLifePoints())
                .currentEffortPoints(payload.initialEffortPoints())
                .currentSanityPoints(payload.initialSanityPoints())
                .build();
    }
}

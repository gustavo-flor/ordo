package com.github.gustavoflor.ordo.entity;

import com.github.gustavoflor.ordo.model.Origin;
import com.github.gustavoflor.ordo.model.Rank;
import com.github.gustavoflor.ordo.model.Role;
import com.github.gustavoflor.ordo.usecase.CreateAgentUseCase;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "agents")
@Getter
@Setter
@Builder(access = AccessLevel.PRIVATE)
public class Agent extends Entity {
    private String name;
    private Origin origin;
    private Role role;
    private Rank rank;
    private Integer paranormalExposureLevel;
    private Integer agility;
    private Integer strength;
    private Integer intellect;
    private Integer presence;
    private Integer vitality;

    public static Agent of(final CreateAgentUseCase.Payload payload) {
        return Agent.builder()
                .name(payload.name())
                .origin(payload.origin())
                .role(payload.role())
                .rank(payload.rank())
                .paranormalExposureLevel(payload.paranormalExposureLevel())
                .agility(payload.agility())
                .strength(payload.strength())
                .intellect(payload.intellect())
                .presence(payload.presence())
                .vitality(payload.vitality())
                .build();
    }
}

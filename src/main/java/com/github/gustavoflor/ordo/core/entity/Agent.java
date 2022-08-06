package com.github.gustavoflor.ordo.core.entity;

import com.github.gustavoflor.ordo.core.Origin;
import com.github.gustavoflor.ordo.core.Rank;
import com.github.gustavoflor.ordo.core.Role;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "agents")
@Getter
@Builder
public class Agent extends Entity {
    private String name;
    private Origin origin;
    private Role role;
    private Rank rank;
    private int expositionLevel;
    private int agility;
    private int strength;
    private int presence;
    private int intellect;
    private int vitality;
    private int totalLifePoints;
    private int totalEffortPoints;
    private int totalSanityPoints;
    private int currentLifePoints;
    private int currentEffortPoints;
    private int currentSanityPoints;

    @Override
    public String toString() {
        return super.toString();
    }
}

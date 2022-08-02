package com.github.gustavoflor.ordo.model;

import com.github.gustavoflor.ordo.entity.Agent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    COMBATANT(20, 2, 12),
    SPECIALIST(16, 3, 16),
    OCCULTIST(12, 4, 20);

    private final int baseLifePoints;
    private final int baseEffortPoints;
    private final int baseSanityPoints;

    public int getInitialLifePoints(final int vitality) {
        return baseLifePoints + vitality;
    }

    public int getInitialEffortPoints(final int presence) {
        return baseEffortPoints + presence;
    }

    public int getInitialSanityPoints() {
        return baseSanityPoints;
    }
}

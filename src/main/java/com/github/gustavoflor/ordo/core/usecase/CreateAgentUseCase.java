package com.github.gustavoflor.ordo.core.usecase;

import com.github.gustavoflor.ordo.core.Origin;
import com.github.gustavoflor.ordo.core.Rank;
import com.github.gustavoflor.ordo.core.Role;
import com.github.gustavoflor.ordo.core.entity.Agent;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Validated
public interface CreateAgentUseCase {
    Agent execute(@NonNull @Valid Payload payload);

    record Payload(@NotBlank @Size(min = 2, max = 64) String name,
                   @NotNull Origin origin,
                   @NotNull Role role,
                   @NotNull Rank rank,
                   @Min(5) @Max(99) int expositionLevel,
                   @Min(0) @Max(5) int agility,
                   @Min(0) @Max(5) int strength,
                   @Min(0) @Max(5) int presence,
                   @Min(0) @Max(5) int intellect,
                   @Min(0) @Max(5) int vitality,
                   int totalLifePoints,
                   int totalEffortPoints,
                   int totalSanityPoints,
                   int currentLifePoints,
                   int currentEffortPoints,
                   int currentSanityPoints) {
    }
}

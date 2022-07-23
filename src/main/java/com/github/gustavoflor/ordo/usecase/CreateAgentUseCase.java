package com.github.gustavoflor.ordo.usecase;

import com.github.gustavoflor.ordo.entity.Agent;
import com.github.gustavoflor.ordo.model.Origin;
import com.github.gustavoflor.ordo.model.Rank;
import com.github.gustavoflor.ordo.model.Role;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Validated
public interface CreateAgentUseCase {
    Agent execute(@Valid Payload payload);

    record Payload(@NotBlank String name,
                   @NotNull Origin origin,
                   @NotNull Role role,
                   @NotNull Rank rank,
                   @NotNull @Min(0) @Max(100) Integer paranormalExposureLevel,
                   @NotNull @Min(0) @Max(5) Integer agility,
                   @NotNull @Min(0) @Max(5) Integer strength,
                   @NotNull @Min(0) @Max(5) Integer intellect,
                   @NotNull @Min(0) @Max(5) Integer presence,
                   @NotNull @Min(0) @Max(5) Integer vitality) {
    }
}

package com.github.gustavoflor.ordo.usecase;

import com.github.gustavoflor.ordo.entity.Agent;
import com.github.gustavoflor.ordo.model.Origin;
import com.github.gustavoflor.ordo.model.Rank;
import com.github.gustavoflor.ordo.model.Role;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public interface CreateAgentUseCase {
    @Validated
    Agent execute(@Valid Payload payload);

    record Payload(@NotBlank String name,
                   @NotNull Origin origin,
                   @NotNull Role role,
                   @NotNull Rank rank,
                   @NotNull @Size(max = 100) Integer paranormalExposureLevel) {
    }
}

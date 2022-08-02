package com.github.gustavoflor.ordo.usecase;

import com.github.gustavoflor.ordo.entity.Agent;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Validated
public interface FindAgentByIdUseCase {
    Optional<Agent> execute(@NotBlank String id);
}

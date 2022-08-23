package com.github.gustavoflor.ordo.core.usecase;

import com.github.gustavoflor.ordo.core.entity.Agent;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Validated
public interface CreateAgentUseCase {
    Agent execute(@Valid Payload payload);

    record Payload(@Size(max = 32) String agentName) {
    }
}

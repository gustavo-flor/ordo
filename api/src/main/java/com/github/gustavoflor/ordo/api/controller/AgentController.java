package com.github.gustavoflor.ordo.api.controller;

import com.github.gustavoflor.ordo.api.request.CreateAgentRequestBody;
import com.github.gustavoflor.ordo.core.entity.Agent;
import com.github.gustavoflor.ordo.core.usecase.CreateAgentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agents")
@RequiredArgsConstructor
public class AgentController {
    private final CreateAgentUseCase createAgentUseCase;

    @PostMapping
    public Agent create(@RequestBody final CreateAgentRequestBody requestBody) {
        final var payload = new CreateAgentUseCase.Payload(requestBody.agentName());
        return createAgentUseCase.execute(payload);
    }
}

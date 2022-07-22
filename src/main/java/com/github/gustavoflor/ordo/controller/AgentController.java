package com.github.gustavoflor.ordo.controller;

import com.github.gustavoflor.ordo.entity.Agent;
import com.github.gustavoflor.ordo.usecase.CreateAgentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/agents")
@RequiredArgsConstructor
public class AgentController {
    private final CreateAgentUseCase createAgentUseCase;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Agent create(@RequestBody CreateAgentUseCase.Payload payload) {
        return createAgentUseCase.execute(payload);
    }
}

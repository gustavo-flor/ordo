package com.github.gustavoflor.ordo.infra.web.controller;

import com.github.gustavoflor.ordo.core.entity.Agent;
import com.github.gustavoflor.ordo.core.usecase.CreateAgentUseCase;
import com.github.gustavoflor.ordo.core.usecase.DeleteAgentByIdUseCase;
import com.github.gustavoflor.ordo.core.usecase.FindAgentByIdUseCase;
import com.github.gustavoflor.ordo.core.usecase.FindAllAgentsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.PositiveOrZero;

@Validated
@RestController
@RequestMapping("/agents")
@RequiredArgsConstructor
public class AgentController {
    private static final int DEFAULT_PAGE_SIZE = 24;

    private final CreateAgentUseCase createAgentUseCase;
    private final FindAllAgentsUseCase findAllAgentsUseCase;
    private final FindAgentByIdUseCase findAgentByIdUseCase;
    private final DeleteAgentByIdUseCase deleteAgentByIdUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agent create(@RequestBody final CreateAgentUseCase.Payload payload) {
        return createAgentUseCase.execute(payload);
    }

    @GetMapping
    public Page<Agent> findAll(@PositiveOrZero @RequestParam(required = false, defaultValue = "0") final Integer page) {
        return findAllAgentsUseCase.execute(PageRequest.of(page, DEFAULT_PAGE_SIZE));
    }

    @GetMapping("/{id}")
    public Agent findById(@PathVariable final String id) {
        return findAgentByIdUseCase.execute(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable final String id) {
        deleteAgentByIdUseCase.execute(id);
    }
}

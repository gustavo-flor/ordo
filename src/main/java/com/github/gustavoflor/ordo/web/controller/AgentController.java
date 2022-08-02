package com.github.gustavoflor.ordo.web.controller;

import com.github.gustavoflor.ordo.entity.Agent;
import com.github.gustavoflor.ordo.usecase.CreateAgentUseCase;
import com.github.gustavoflor.ordo.usecase.DeleteAgentByIdUseCase;
import com.github.gustavoflor.ordo.usecase.FindAgentByIdUseCase;
import com.github.gustavoflor.ordo.usecase.PaginateAgentsUseCase;
import com.github.gustavoflor.ordo.web.HttpHeader;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/agents")
@RequiredArgsConstructor
public class AgentController {
    private static final int DEFAULT_PAGE_SIZE = 24;

    private final CreateAgentUseCase createAgentUseCase;
    private final PaginateAgentsUseCase paginateAgentsUseCase;
    private final FindAgentByIdUseCase findAgentByIdUseCase;
    private final DeleteAgentByIdUseCase deleteAgentByIdUseCase;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse
    public Agent create(@RequestBody CreateAgentUseCase.Payload payload) {
        return createAgentUseCase.execute(payload);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Page<Agent> findAll(@RequestParam(name = "page", required = false) final int page) {
        return paginateAgentsUseCase.execute(PageRequest.of(page, DEFAULT_PAGE_SIZE));
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Agent findById(@PathVariable final String id) {
        return findAgentByIdUseCase.execute(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable final String id) {
        deleteAgentByIdUseCase.execute(id);
    }
}

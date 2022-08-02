package com.github.gustavoflor.ordo.usecase;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
public interface DeleteAgentByIdUseCase {
    void execute(@NotBlank String id);
}

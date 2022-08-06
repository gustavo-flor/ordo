package com.github.gustavoflor.ordo.infra.web.controller;

import com.github.gustavoflor.ordo.core.Origin;
import com.github.gustavoflor.ordo.core.usecase.FindAllOriginsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/origins")
@RequiredArgsConstructor
public class OriginController {
    private final FindAllOriginsUseCase findAllOriginsUseCase;

    @GetMapping
    public List<Origin> findAll() {
        return findAllOriginsUseCase.execute();
    }
}

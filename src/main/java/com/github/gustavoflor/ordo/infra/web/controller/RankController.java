package com.github.gustavoflor.ordo.infra.web.controller;

import com.github.gustavoflor.ordo.core.Rank;
import com.github.gustavoflor.ordo.core.usecase.FindAllRanksUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranks")
@RequiredArgsConstructor
public class RankController {
    private final FindAllRanksUseCase findAllRanksUseCase;

    @GetMapping
    public List<Rank> findAll() {
        return findAllRanksUseCase.execute();
    }
}

package com.github.gustavoflor.ordo.core.usecase.impl;

import com.github.gustavoflor.ordo.core.Rank;
import com.github.gustavoflor.ordo.core.usecase.FindAllRanksUseCase;
import com.github.gustavoflor.ordo.infra.mapping.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@UseCase
@RequiredArgsConstructor
class FindAllRanksUseCaseImpl implements FindAllRanksUseCase {
    @Override
    public List<Rank> execute() {
        return Arrays.stream(Rank.values()).toList();
    }
}

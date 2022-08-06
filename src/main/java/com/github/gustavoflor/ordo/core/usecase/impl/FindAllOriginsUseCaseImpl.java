package com.github.gustavoflor.ordo.core.usecase.impl;

import com.github.gustavoflor.ordo.core.Origin;
import com.github.gustavoflor.ordo.core.usecase.FindAllOriginsUseCase;
import com.github.gustavoflor.ordo.infra.mapping.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@UseCase
@RequiredArgsConstructor
class FindAllOriginsUseCaseImpl implements FindAllOriginsUseCase {
    @Override
    public List<Origin> execute() {
        return Arrays.stream(Origin.values()).toList();
    }
}

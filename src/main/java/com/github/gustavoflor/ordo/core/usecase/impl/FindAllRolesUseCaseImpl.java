package com.github.gustavoflor.ordo.core.usecase.impl;

import com.github.gustavoflor.ordo.core.Role;
import com.github.gustavoflor.ordo.core.usecase.FindAllRolesUseCase;
import com.github.gustavoflor.ordo.infra.mapping.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@UseCase
@RequiredArgsConstructor
class FindAllRolesUseCaseImpl implements FindAllRolesUseCase {
    @Override
    public List<Role> execute() {
        return Arrays.stream(Role.values()).toList();
    }
}

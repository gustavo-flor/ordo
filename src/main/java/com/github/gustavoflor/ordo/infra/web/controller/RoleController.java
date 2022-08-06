package com.github.gustavoflor.ordo.infra.web.controller;

import com.github.gustavoflor.ordo.core.Role;
import com.github.gustavoflor.ordo.core.usecase.FindAllRolesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final FindAllRolesUseCase findAllRolesUseCase;

    @GetMapping
    public List<Role> findAll() {
        return findAllRolesUseCase.execute();
    }
}

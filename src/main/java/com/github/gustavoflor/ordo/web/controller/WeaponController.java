package com.github.gustavoflor.ordo.web.controller;

import com.github.gustavoflor.ordo.model.Weapon;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/weapons")
@RequiredArgsConstructor
public class WeaponController {
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Weapon> findAll() {
        return Arrays.stream(Weapon.values()).toList();
    }
}

package com.github.gustavoflor.ordo.controller;

import com.github.gustavoflor.ordo.model.Munition;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/munitions")
@RequiredArgsConstructor
public class MunitionController {
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Munition> findAll() {
        return Munition.values();
    }
}

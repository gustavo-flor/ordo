package com.github.gustavoflor.ordo.web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HttpHeader {
    USER_ID("X-User-Id");

    private final String headerName;
}

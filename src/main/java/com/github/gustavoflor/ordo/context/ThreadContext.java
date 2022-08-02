package com.github.gustavoflor.ordo.context;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ThreadContext {
    private static final ThreadLocal<String> USER_ID = new ThreadLocal<>();

    public static Optional<String> getUserId() {
        return Optional.ofNullable(USER_ID.get());
    }

    public static void setUserId(final String userId) {
        USER_ID.set(userId);
    }
}

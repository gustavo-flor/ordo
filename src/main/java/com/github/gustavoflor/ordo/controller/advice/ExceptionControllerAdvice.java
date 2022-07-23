package com.github.gustavoflor.ordo.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<Payload> handle(ConstraintViolationException exception, HttpServletRequest request) {
        return Payload.unprocessableEntity(exception.getMessage(), request);
    }

    record Payload(LocalDateTime timestamp, int status, String error, String path) {
        private static ResponseEntity<Payload> of(HttpStatus httpStatus, String error, HttpServletRequest request) {
            Payload payload = new Payload(now(), httpStatus.value(), error, request.getRequestURI());
            return ResponseEntity.status(httpStatus).body(payload);
        }

        public static ResponseEntity<Payload> unprocessableEntity(String error, HttpServletRequest request) {
            return Payload.of(HttpStatus.UNPROCESSABLE_ENTITY, error, request);
        }
    }
}

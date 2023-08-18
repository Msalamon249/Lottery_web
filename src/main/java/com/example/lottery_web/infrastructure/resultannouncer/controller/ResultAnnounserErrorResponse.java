package com.example.lottery_web.infrastructure.resultannouncer.controller;

import org.springframework.http.HttpStatus;

public record ResultAnnounserErrorResponse(
        String message,
        HttpStatus status
) {
}

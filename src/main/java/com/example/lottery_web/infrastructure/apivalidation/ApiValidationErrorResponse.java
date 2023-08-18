package com.example.lottery_web.infrastructure.apivalidation;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.List;


public record ApiValidationErrorResponse(List<String> messages, HttpStatus status) {
}

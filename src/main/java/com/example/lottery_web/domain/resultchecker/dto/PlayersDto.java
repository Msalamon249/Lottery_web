package com.example.lottery_web.domain.resultchecker.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record PlayersDto(
        List<ResultDto> results,
        String message) {
}

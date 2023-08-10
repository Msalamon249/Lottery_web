package com.example.lottery_web.domain.numbergenerator.dto;

import lombok.Builder;

import java.util.Set;


@Builder
public record SixRandomNumbersDto(Set<Integer> numbers) {
}

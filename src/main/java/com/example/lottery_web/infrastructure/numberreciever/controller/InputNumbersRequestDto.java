package com.example.lottery_web.infrastructure.numberreciever.controller;

import lombok.Builder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Builder
public record InputNumbersRequestDto(
        //@NotNull(message = "{inputNumbers.not.null}")
        @NotEmpty(message = "{inputNumbers.not.empty}")
        List<Integer> playerNumbers
) {
}

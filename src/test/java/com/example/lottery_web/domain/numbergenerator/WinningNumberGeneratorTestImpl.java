package com.example.lottery_web.domain.numbergenerator;

import com.example.lottery_web.domain.numbergenerator.RandomNumberGenerable;
import com.example.lottery_web.domain.numbergenerator.dto.SixRandomNumbersDto;

import java.util.Set;


public class WinningNumberGeneratorTestImpl implements RandomNumberGenerable {

    private final Set<Integer> generatedNumbers;

    WinningNumberGeneratorTestImpl() {
        generatedNumbers = Set.of(1, 2, 3, 4, 5, 6);
    }

    WinningNumberGeneratorTestImpl(Set<Integer> generatedNumbers) {
        this.generatedNumbers = generatedNumbers;
    }

    @Override
    public SixRandomNumbersDto generateSixRandomNumbers(int count, int lowerBand, int upperBand) {
        return SixRandomNumbersDto.builder()
                .numbers(generatedNumbers)
                .build();
    }
}

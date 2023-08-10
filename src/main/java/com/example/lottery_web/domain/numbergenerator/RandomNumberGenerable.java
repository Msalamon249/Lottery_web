package com.example.lottery_web.domain.numbergenerator;

import com.example.lottery_web.domain.numbergenerator.dto.SixRandomNumbersDto;

import java.util.Set;

public interface RandomNumberGenerable {

    SixRandomNumbersDto generateSixRandomNumbers(int count, int lowerBand, int upperBand);
}

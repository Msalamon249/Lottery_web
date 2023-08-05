package com.example.lottery_web.domain.numbergenerator;

import io.swagger.models.auth.In;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomGenerator {

    private static final int LOWER_BAND = 1;
    private static final int UPPER_BAND = 99;
    private static final int AMOUNT_OF_NUMBERS = 6;

    private static final int RANDOM_NUMBER_BOUND = (UPPER_BAND - LOWER_BAND) + 1;

    public Set<Integer> generateSixRandomNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (isAmountOfNumbersLowerThanSix(randomNumbers)) {
            int generatedNumber = generateRandomNumber();
            randomNumbers.add(generatedNumber);

        }
        return randomNumbers;
    }


    private boolean isAmountOfNumbersLowerThanSix(Set<Integer> numbers) {
        return numbers.size() < AMOUNT_OF_NUMBERS;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND) + 1;
    }
}

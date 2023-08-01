package com.example.lottery_web.domain.numberreciever;

import java.util.Set;

class NumberValidator {

    private static final int MAX_NUMBERS_FROM_USER = 6;
    private static final int MINIMAL_NUMBER_FROM_USER = 1;
    private static final int MAXIMAL_NUMBER_FROM_USER = 99;


    boolean validUserNumbers(Set<Integer> inputNumbers) {
        return inputNumbers.stream()
                .filter(integer -> integer >= MINIMAL_NUMBER_FROM_USER)
                .filter(integer -> integer <= MAXIMAL_NUMBER_FROM_USER)
                .count() == MAX_NUMBERS_FROM_USER;
    }

}

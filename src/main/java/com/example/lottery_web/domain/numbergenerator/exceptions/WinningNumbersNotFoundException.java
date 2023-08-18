package com.example.lottery_web.domain.numbergenerator.exceptions;

public class WinningNumbersNotFoundException extends RuntimeException{

    public WinningNumbersNotFoundException(String message) {
        super(message);
    }
}

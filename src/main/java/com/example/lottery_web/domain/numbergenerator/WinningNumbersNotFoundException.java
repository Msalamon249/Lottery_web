package com.example.lottery_web.domain.numbergenerator;

public class WinningNumbersNotFoundException extends RuntimeException{

    public WinningNumbersNotFoundException(String message) {
        super(message);
    }
}

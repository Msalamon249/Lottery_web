package com.example.lottery_web.domain.resultchecker;

public class PlayerResultNotFoundException extends RuntimeException {
    PlayerResultNotFoundException(String message) {
        super(message);
    }
}

package com.example.lottery_web.domain.resultannouncer;

public class ResultResponseNotFoundException extends RuntimeException {

    ResultResponseNotFoundException(String message) {
        super(message);
    }
}

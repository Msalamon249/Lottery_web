package com.example.lottery_web.infrastructure.resultannouncer.controller;


import com.example.lottery_web.domain.resultchecker.PlayerResultNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
public class ResultAnnouncerExceptionHandler {


    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PlayerResultNotFoundException.class)
    public ResultAnnounserErrorResponse handlePlayerResultNotFound(PlayerResultNotFoundException exception) {
        String message = exception.getMessage();
        log.error(message);
        return new ResultAnnounserErrorResponse(message, HttpStatus.NOT_FOUND);
    }
}

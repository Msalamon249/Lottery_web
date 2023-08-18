package com.example.lottery_web.domain.resultannouncer;


import com.example.lottery_web.domain.resultannouncer.dto.ResponseDto;

public class ResultMapper {
    static ResponseDto mapToDto(ResultResponse resultResponse) {
        return ResponseDto.builder()
                .drawDate(resultResponse.drawDate())
                .hash(resultResponse.hash())
                .hitNumbers(resultResponse.hitNumbers())
                .numbers(resultResponse.numbers())
                .wonNumbers(resultResponse.wonNumbers())
                .isWinner(resultResponse.isWinner())
                .build();
    }
}

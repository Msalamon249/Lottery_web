package com.example.lottery_web.domain.numberreciever.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
public record NumberRecieverDto(String message, String ticketId, LocalDateTime drawDate,Set<Integer> numbersFromUser) {



}

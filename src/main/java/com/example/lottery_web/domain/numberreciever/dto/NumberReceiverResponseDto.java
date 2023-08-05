package com.example.lottery_web.domain.numberreciever.dto;

import lombok.Builder;

@Builder
public record NumberReceiverResponseDto(
        TicketDto ticketDto,
        String message) {
}

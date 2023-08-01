package com.example.lottery_web.domain.numberreciever;

import com.example.lottery_web.domain.numberreciever.dto.TicketDto;

public class TicketMapper {

    public static TicketDto mapFromTicketToTicketDto(Ticket ticket) {
        return TicketDto.builder()
                .ticketId(ticket.id())
                .drawDate(ticket.drawDate())
                .numbersFromUser(ticket.userNumbers())
                .build();
    }
}

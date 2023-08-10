package com.example.lottery_web.domain.resultchecker;

import com.example.lottery_web.domain.numberreciever.dto.TicketDto;
import com.example.lottery_web.domain.resultchecker.dto.ResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultCheckerMapper {

    static List<ResultDto> mapPlayersToResults(List<Player> players) {
        return players.stream()
                .map(player -> ResultDto.builder()
                        .hash(player.hash())
                        .numbers(player.numbers())
                        .isWinner(player.isWinner())
                        .hitNumbers(player.hitNumbers())
                        .drawDate(player.drawDate())
                        .build())
                .collect(Collectors.toList());
    }


    static List<Ticket> mapFromTicketDto(List<TicketDto> allTickets) {
        return allTickets.stream()
                .map(ticketDto -> Ticket.builder()
                        .hash(ticketDto.hash())
                        .numbers(ticketDto.numbers())
                        .drawDate(ticketDto.drawDate())
                        .build())
                .collect(Collectors.toList());
    }
}

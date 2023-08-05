package com.example.lottery_web.domain.resultchecker;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
class WinnersRetriever {

    private static final int NUMBERS_WHEN_PLAYERS_WON = 3;

    List<Player> retrieveWinners(List<Ticket> tickets, Set<Integer> winningNumbers) {
        return tickets.stream()
                .map(ticket -> {
                    Set<Integer> hitNumbers = calculateHits(winningNumbers, ticket);
                    return buildPlayer(ticket, hitNumbers);
                })
                .toList();
    }


    private Set<Integer> calculateHits(Set<Integer> winningNumbers, Ticket ticket) {
        return ticket.numbers().stream()
                .filter(winningNumbers::contains)
                .collect(Collectors.toSet());
    }


    private Player buildPlayer(Ticket ticket, Set<Integer> hitNumbers) {
        Player.PlayerBuilder builder = Player.builder();

        if (isWinner(hitNumbers)) {
            builder.isWinner(true);
        }

        return builder
                .hash(ticket.hash())
                .numbers(ticket.numbers())
                .drawDate(ticket.drawDate())
                .hitNumbers(hitNumbers)
                .build();
    }


    private boolean isWinner(Set<Integer> hitNumbers) {
        return hitNumbers.size() >= NUMBERS_WHEN_PLAYERS_WON;
    }
}

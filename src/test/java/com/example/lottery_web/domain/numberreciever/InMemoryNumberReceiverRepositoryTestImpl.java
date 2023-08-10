package com.example.lottery_web.domain.numberreciever;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryNumberReceiverRepositoryTestImpl implements TicketRepository {

    Map<String, Ticket> inMemoryDatabase = new ConcurrentHashMap<>();

    @Override
    public Ticket save(Ticket ticket) {
        Ticket put = inMemoryDatabase.put(ticket.hash(), ticket);
        return ticket;
    }

    @Override
    public List<Ticket> findAllTicketsByDrawDate(LocalDateTime drawDate) {
        return inMemoryDatabase.values()
                .stream()
                .filter(ticket -> ticket.drawDate().equals(drawDate))
                .collect(Collectors.toList());
    }
}

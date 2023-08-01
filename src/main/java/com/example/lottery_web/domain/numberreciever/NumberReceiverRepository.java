package com.example.lottery_web.domain.numberreciever;

import java.time.LocalDateTime;
import java.util.List;

public interface NumberReceiverRepository {


    Ticket save(Ticket ticket);

    List<Ticket> findAllTicketsByDrawDate(LocalDateTime drawDate);
}

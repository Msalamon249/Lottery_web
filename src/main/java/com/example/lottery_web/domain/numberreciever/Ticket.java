package com.example.lottery_web.domain.numberreciever;

import java.time.LocalDateTime;
import java.util.Set;

record Ticket(String id, LocalDateTime drawDate, Set<Integer> userNumbers) {
}

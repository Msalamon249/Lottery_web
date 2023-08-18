package com.example.lottery_web.domain.numberreciever;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Document
public record Ticket(
        @Id
        String hash,
        Set<Integer> numbers,
        LocalDateTime drawDate) {
}

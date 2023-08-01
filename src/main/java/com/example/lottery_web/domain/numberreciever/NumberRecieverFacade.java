package com.example.lottery_web.domain.numberreciever;

import com.example.lottery_web.domain.numberreciever.dto.NumberRecieverDto;
import com.example.lottery_web.domain.numberreciever.dto.TicketDto;
import lombok.AllArgsConstructor;


import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class NumberRecieverFacade {


    private final NumberValidator numberValidator;
    private final NumberReceiverRepository numberReceiverRepository;
    private final Clock clock;

    public NumberRecieverDto inputNumbers(Set<Integer> inputNumbers) {
        boolean validatedNumbers = numberValidator.validUserNumbers(inputNumbers);
        String ticketId = UUID.randomUUID().toString();
        LocalDateTime drawDate = LocalDateTime.now(clock);
        Ticket saved = numberReceiverRepository.save(new Ticket(ticketId, drawDate, inputNumbers));

        if (validatedNumbers) {
            return NumberRecieverDto.builder()
                    .drawDate(saved.drawDate())
                    .numbersFromUser(inputNumbers)
                    .ticketId(saved.id())
                    .message("success")
                    .build();
        }
        return NumberRecieverDto.builder()
                .message("failed")
                .build();
    }


    public List<TicketDto> userNumbers(LocalDateTime drawDate) {
        List<Ticket> allTicketsByDrawDate = numberReceiverRepository.findAllTicketsByDrawDate(drawDate);
        return allTicketsByDrawDate.stream()
                .map(TicketMapper::mapFromTicketToTicketDto)
                .collect(Collectors.toList());
    }


}

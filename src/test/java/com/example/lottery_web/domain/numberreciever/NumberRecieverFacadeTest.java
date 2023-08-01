package com.example.lottery_web.domain.numberreciever;

import com.example.lottery_web.domain.numberreciever.dto.NumberRecieverDto;

import com.example.lottery_web.domain.numberreciever.dto.TicketDto;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class NumberRecieverFacadeTest {


    NumberRecieverFacade numberRecieverFacade = new NumberRecieverFacade(
            new NumberValidator(),
            new InMemoryNumberReceiverRepositoryTestImpl(),
            Clock.fixed(LocalDateTime.of(2023, 8, 1, 19, 0, 0).toInstant(ZoneOffset.UTC), ZoneId.systemDefault())
    );

    @Test
    public void should_return_success_when_user_gave_six_numbers() {
        Set<Integer> integers = Set.of(1, 2, 3, 4, 5, 6);

        NumberRecieverDto numberRecieverDto = numberRecieverFacade.inputNumbers(integers);

        assertThat(numberRecieverDto.message()).isEqualTo("success");

    }

    @Test
    public void should_return_failed_when_user_gave_less_than_six_numbers() {
        Set<Integer> integers = Set.of(1, 2, 3, 4, 5);

        NumberRecieverDto numberRecieverDto = numberRecieverFacade.inputNumbers(integers);

        assertThat(numberRecieverDto.message()).isEqualTo("failed");
    }

    @Test
    public void should_return_failed_when_user_gave_more_than_six_numbers() {
        Set<Integer> integers = Set.of(1, 2, 3, 4, 5, 6, 7);

        NumberRecieverDto numberRecieverDto = numberRecieverFacade.inputNumbers(integers);

        assertThat(numberRecieverDto.message()).isEqualTo("failed");
    }

    @Test
    public void should_return_failed_when_user_gave_atleast_one_number_out_of_range_of_1_to_99() {
        Set<Integer> integers = Set.of(1, 289, 3, 404, 5, 6);

        NumberRecieverDto numberRecieverDto = numberRecieverFacade.inputNumbers(integers);

        assertThat(numberRecieverDto.message()).isEqualTo("failed");
    }


    @Test
    public void should_return_save_to_database_when_user_gave_six_correct_numbers() {
        Set<Integer> integers = Set.of(1, 29, 3, 44, 5, 6);

        NumberRecieverDto numberRecieverDto = numberRecieverFacade.inputNumbers(integers);
        LocalDateTime drawDate = LocalDateTime.of(2023, 8, 1, 19, 0, 0).plusHours(2);

        List<TicketDto> ticketDtos = numberRecieverFacade.userNumbers(drawDate);

        assertThat(ticketDtos).contains(
                TicketDto.builder()
                        .ticketId(numberRecieverDto.ticketId())
                        .numbersFromUser(numberRecieverDto.numbersFromUser())
                        .drawDate(drawDate)
                        .build()
        );
    }
}
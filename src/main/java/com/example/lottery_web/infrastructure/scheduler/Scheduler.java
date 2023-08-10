package com.example.lottery_web.infrastructure.scheduler;

import com.example.lottery_web.domain.numbergenerator.WinningNumbersGeneratorFacade;
import com.example.lottery_web.domain.numbergenerator.dto.WinningNumbersDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Log4j2
@Component
public class Scheduler {

    private final WinningNumbersGeneratorFacade winningNumbersGeneratorFacade;

    @Scheduled(cron = "${lotto.number-generator.facade.timer}")
    public WinningNumbersDto shouldDoSomething(){
        log.info("winning numbers scheduler started");
        WinningNumbersDto winningNumbersDto = winningNumbersGeneratorFacade.generateWinningNumbers();
        log.info(winningNumbersDto.getWinningNumbers());
        log.info(winningNumbersDto.getDate());
        return winningNumbersDto;
    }
}

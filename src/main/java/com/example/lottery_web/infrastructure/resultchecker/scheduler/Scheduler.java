package com.example.lottery_web.infrastructure.resultchecker.scheduler;

import com.example.lottery_web.domain.numbergenerator.WinningNumbersGeneratorFacade;
import com.example.lottery_web.domain.numbergenerator.dto.WinningNumbersDto;
import com.example.lottery_web.domain.resultchecker.ResultCheckerFacade;
import com.example.lottery_web.domain.resultchecker.dto.PlayersDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Log4j2
@Component
public class Scheduler {

    private final ResultCheckerFacade resultCheckerFacade;
    private final WinningNumbersGeneratorFacade winningNumbersGeneratorFacade;

    @Scheduled(cron = "${lotto.result-checker.lotteryRunOccurrence}")
    public PlayersDto generateWinners() {
        log.info("ResultCheckerScheduler started...");
        if (!winningNumbersGeneratorFacade.areWinningNumbersGeneratedByDate()) {
            log.error("Winning numbers are not generated");
            throw new RuntimeException("Winning numbers are not generated");
        }
        log.info("Winning numbers has been fetched");
        return resultCheckerFacade.generateResults();
    }
}

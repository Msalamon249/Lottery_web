package com.example.lottery_web.domain.resultchecker;

import com.example.lottery_web.domain.numbergenerator.WinningNumbersGeneratorFacade;
import com.example.lottery_web.domain.numberreciever.NumberReceiverFacade;


public class ResultCheckerConfiguration {

    ResultCheckerFacade createForTest(WinningNumbersGeneratorFacade generatorFacade, NumberReceiverFacade receiverFacade, PlayerRespotiory playerRepository) {
        WinnersRetriever winnerGenerator = new WinnersRetriever();
        return new ResultCheckerFacade(generatorFacade, receiverFacade, playerRepository, winnerGenerator);
    }
}

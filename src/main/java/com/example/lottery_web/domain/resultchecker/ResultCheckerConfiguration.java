package com.example.lottery_web.domain.resultchecker;

import com.example.lottery_web.domain.numbergenerator.NumberGeneratorFacade;
import com.example.lottery_web.domain.numberreciever.NumberRecieverFacade;



public class ResultCheckerConfiguration {

    ResultCheckerFacade createForTest(NumberGeneratorFacade generatorFacade, NumberRecieverFacade receiverFacade, PlayerRespotiory playerRepository) {
        WinnersRetriever winnerGenerator = new WinnersRetriever();
        return new ResultCheckerFacade(generatorFacade, receiverFacade, playerRepository, winnerGenerator);
    }
}

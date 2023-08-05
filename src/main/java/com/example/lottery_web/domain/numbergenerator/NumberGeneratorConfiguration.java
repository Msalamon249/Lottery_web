package com.example.lottery_web.domain.numbergenerator;

import com.example.lottery_web.domain.numberreciever.NumberRecieverFacade;


public class NumberGeneratorConfiguration {

    NumberGeneratorFacade createForTest(RandomNumberGenerable generator, WinningNumbersRepository winningNumbersRepository, NumberRecieverFacade numberReceiverFacade) {
        WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
        return new NumberGeneratorFacade(generator, winningNumberValidator, winningNumbersRepository, numberReceiverFacade);
    }
}

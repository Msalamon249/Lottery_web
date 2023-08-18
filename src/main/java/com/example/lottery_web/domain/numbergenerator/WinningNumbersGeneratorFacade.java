package com.example.lottery_web.domain.numbergenerator;

import com.example.lottery_web.domain.numbergenerator.dto.SixRandomNumbersDto;
import com.example.lottery_web.domain.numbergenerator.dto.WinningNumbersDto;
import com.example.lottery_web.domain.numbergenerator.exceptions.WinningNumbersNotFoundException;
import com.example.lottery_web.domain.numberreciever.NumberReceiverFacade;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
public class WinningNumbersGeneratorFacade {

    private final RandomNumberGenerable winningNumberGenerator;
    private final WinningNumberValidator winningNumberValidator;
    private final WinningNumbersRepository winningNumbersRepository;
    private final NumberReceiverFacade numberRecieverFacade;
    private final WinningNumbersGeneratorFacadeConfigurationProperties properties;


    public WinningNumbersDto generateWinningNumbers() {
        LocalDateTime nextDrawDate = numberRecieverFacade.retrieveNextDrawDate();
        SixRandomNumbersDto sixRandomNumbersDto = winningNumberGenerator.generateSixRandomNumbers(properties.count(), properties.lowerBand(), properties.upperBand());
        Set<Integer> winningNumbers = sixRandomNumbersDto.numbers();
        winningNumberValidator.validate(winningNumbers);
        WinningNumbers winningNumbersDocument = WinningNumbers.builder()
                .winningNumbers(winningNumbers)
                .date(nextDrawDate)
                .build();
        WinningNumbers savedNumbers = winningNumbersRepository.save(winningNumbersDocument);
        return WinningNumbersDto.builder()
                .winningNumbers(savedNumbers.winningNumbers())
                .date(savedNumbers.date())
                .build();
    }

    public WinningNumbersDto retrieveWinningNumberByDate(LocalDateTime date) {
        WinningNumbers numbersByDate = winningNumbersRepository.findNumbersByDate(date)
                .orElseThrow(() -> new WinningNumbersNotFoundException("Not Found"));
        return WinningNumbersDto.builder()
                .winningNumbers(numbersByDate.winningNumbers())
                .date(numbersByDate.date())
                .build();
    }

    public boolean areWinningNumbersGeneratedByDate() {
        LocalDateTime nextDrawDate = numberRecieverFacade.retrieveNextDrawDate();
        return winningNumbersRepository.existsByDate(nextDrawDate);
    }
}

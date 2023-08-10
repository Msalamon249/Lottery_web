package com.example.lottery_web.domain.resultchecker;


import com.example.lottery_web.domain.numbergenerator.WinningNumbersGeneratorFacade;
import com.example.lottery_web.domain.numbergenerator.dto.WinningNumbersDto;
import com.example.lottery_web.domain.numberreciever.NumberReceiverFacade;

import com.example.lottery_web.domain.numberreciever.dto.TicketDto;
import com.example.lottery_web.domain.resultchecker.dto.PlayersDto;
import com.example.lottery_web.domain.resultchecker.dto.ResultDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class ResultCheckerFacade {

 private final WinningNumbersGeneratorFacade winningNumbersGeneratorFacade;
 private final NumberReceiverFacade numberRecieverFacade;
 private final  PlayerRespotiory playerRespotiory;
 private final  WinnersRetriever winnersRetriever;

    public PlayersDto generateWinners(){
        List<TicketDto> allTicketsByDate = numberRecieverFacade.retrieveAllTicketsByNextDrawDate();
        List<Ticket>tickets = ResultCheckerMapper.mapFromTicketDto(allTicketsByDate);
        WinningNumbersDto winningNumbersDto = winningNumbersGeneratorFacade.generateWinningNumbers();
        Set<Integer> winningNumbers = winningNumbersDto.getWinningNumbers();
        if(winningNumbers == null || winningNumbers.isEmpty()){
            return PlayersDto.builder()
                    .message("Winners failed to retrieve")
                    .build();
        }
        List<Player> players = winnersRetriever.retrieveWinners(tickets, winningNumbers);
        playerRespotiory.saveAll(players);
        return PlayersDto.builder()
                .results(ResultCheckerMapper.mapPlayersToResults(players))
                .message("Winners succeeded to retrieve")
                .build();
    }


 public ResultDto findByHash(String hash){
     Player player = playerRespotiory.findById(hash)
             .orElseThrow(() -> new RuntimeException("not found"));
 return ResultDto.builder()
         .hash(hash)
         .hitNumbers(player.hitNumbers())
         .isWinner(player.isWinner())
         .drawDate(player.drawDate())
         .numbers(player.numbers())
         .build();


 }
}

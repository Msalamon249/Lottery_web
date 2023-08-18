package com.example.lottery_web.infrastructure.numberreciever.controller;


import com.example.lottery_web.domain.numberreciever.NumberReceiverFacade;
import com.example.lottery_web.domain.numberreciever.dto.NumberReceiverResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

@RestController
@AllArgsConstructor
@Log4j2
public class InputNumbersRestController {

    private final NumberReceiverFacade numberReceiverFacade;

    @PostMapping("/inputNumbers")
    public ResponseEntity<NumberReceiverResponseDto> inputNumbers(@RequestBody @Valid InputNumbersRequestDto inputNumbersRequestDto) {
        Set<Integer> playerNumbers = new HashSet<>(inputNumbersRequestDto.playerNumbers());
        NumberReceiverResponseDto numberReceiverResponseDto = numberReceiverFacade.inputNumbers(playerNumbers);
        URI uri = UriComponentsBuilder.fromPath("/{id}").buildAndExpand(numberReceiverResponseDto.ticketDto().hash()).toUri();
        return ResponseEntity.created(uri).body(numberReceiverResponseDto);
    }


}

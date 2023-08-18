package com.example.lottery_web.infrastructure.resultannouncer.controller;

import com.example.lottery_web.domain.resultannouncer.ResultAnnouncerFacade;
import com.example.lottery_web.domain.resultannouncer.dto.ResultAnnouncerResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
public class ResultAnnouncerRestController {

     private  final ResultAnnouncerFacade resultAnnouncerFacade;



    @GetMapping("/results/{id}")
    public ResponseEntity<ResultAnnouncerResponseDto> checkResult(@PathVariable String id){
        ResultAnnouncerResponseDto resultAnnouncerResponseDto = resultAnnouncerFacade.checkResult(id);
        return ResponseEntity.ok(resultAnnouncerResponseDto);
    }



}

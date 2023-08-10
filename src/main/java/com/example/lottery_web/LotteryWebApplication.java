package com.example.lottery_web;

import com.example.lottery_web.domain.numbergenerator.WinningNumbersGeneratorFacadeConfigurationProperties;
import com.example.lottery_web.infrastructure.numbergenerator.http.RandomNumberGeneratorRestTemplateConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties({RandomNumberGeneratorRestTemplateConfigurationProperties.class, WinningNumbersGeneratorFacadeConfigurationProperties.class})
@EnableScheduling
public class LotteryWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotteryWebApplication.class, args);
    }

}

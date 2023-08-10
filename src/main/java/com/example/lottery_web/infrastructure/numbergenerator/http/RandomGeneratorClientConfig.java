package com.example.lottery_web.infrastructure.numbergenerator.http;

import com.example.lottery_web.domain.numbergenerator.RandomNumberGenerable;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@AllArgsConstructor
public class RandomGeneratorClientConfig {

    private final RandomNumberGeneratorRestTemplateConfigurationProperties properties;


    @Bean
    public RestTemplateResponseErrorHandler restTemplateResponseErrorHandler() {
        return new RestTemplateResponseErrorHandler();
    }

    @Bean
    public RestTemplate restTemplate(
            RestTemplateResponseErrorHandler restTemplateResponseErrorHandler) {
        return new RestTemplateBuilder()
                .errorHandler(restTemplateResponseErrorHandler)
                .setConnectTimeout(Duration.ofMillis(properties.connectionTimeout()))
                .setReadTimeout(Duration.ofMillis(properties.readTimeout()))
                .build();
    }

    @Bean
    public RandomNumberGenerable remoteNumberGeneratorClient(
            RestTemplate restTemplate
    ) {
        return new RandomNumberGeneratorRestTemplate(restTemplate, properties.uri(), properties.port());
    }

}

package com.example.loterry_web.http.numbergenerator;

import com.example.lottery_web.domain.numbergenerator.RandomNumberGenerable;
import com.example.lottery_web.infrastructure.numbergenerator.http.RandomGeneratorClientConfig;
import org.springframework.web.client.RestTemplate;


public class RandomGeneratorRestTemplateTestConfig extends RandomGeneratorClientConfig {

    public RandomNumberGenerable remoteNumberGeneratorClient(int port, int connectionTimeout, int readTimeout) {
        RestTemplate restTemplate = restTemplate(connectionTimeout, readTimeout, restTemplateResponseErrorHandler());
        return remoteNumberGeneratorClient(restTemplate, "http://localhost", port);
    }
}

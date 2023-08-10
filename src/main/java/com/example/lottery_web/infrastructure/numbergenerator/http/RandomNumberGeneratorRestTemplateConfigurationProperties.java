package com.example.lottery_web.infrastructure.numbergenerator.http;


import lombok.Builder;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Builder
@ConfigurationProperties(prefix = "lotto.number-generator.http.client.config")
public record RandomNumberGeneratorRestTemplateConfigurationProperties(long connectionTimeout, long readTimeout, String uri, int port) {
}

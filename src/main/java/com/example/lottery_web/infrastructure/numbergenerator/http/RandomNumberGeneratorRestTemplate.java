package com.example.lottery_web.infrastructure.numbergenerator.http;

import com.example.lottery_web.domain.numbergenerator.RandomNumberGenerable;
import com.example.lottery_web.domain.numbergenerator.dto.SixRandomNumbersDto;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@AllArgsConstructor
@Log4j2
public class RandomNumberGeneratorRestTemplate implements RandomNumberGenerable {

    public static final int MAXIMAL_WINNING_NUMBERS = 6;
    public static final String RANDOM_NUMBER_SERVICE_PATH = "/api/v1.0/random";
    private final RestTemplate restTemplate;
    private final String uri;
    private final int port;


    @Override
    public SixRandomNumbersDto generateSixRandomNumbers(int count, int lowerBand, int upperBand) {
        log.info("Started fetching winning numbers using http client");
        String url = getUrlForService(RANDOM_NUMBER_SERVICE_PATH);
        try {
            ResponseEntity<List<Integer>> response = makeGetRequest(count, lowerBand, upperBand, url);

            Set<Integer> sixGeneratedNumbers = getSixGeneratedNumbers(response);
            if (sixGeneratedNumbers.size() != MAXIMAL_WINNING_NUMBERS) {
                log.error("Set is less than: {} Have to request one more time", count);
                return generateSixRandomNumbers(count, lowerBand, upperBand);
            }
            return SixRandomNumbersDto.builder()
                    .numbers(sixGeneratedNumbers)
                    .build();
        } catch (ResourceAccessException e) {
            log.error("Error while fetching winning numbers using http client: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private Set<Integer> getSixGeneratedNumbers(ResponseEntity<List<Integer>> response) {
        List<Integer> body = response.getBody();

        if (body == null) {
            log.error("Response body was null");
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        log.info("Success response body returned");
        Set<Integer> generatedNumbers = new HashSet<>();
        return generatedNumbers.stream()
                .distinct()
                .limit(MAXIMAL_WINNING_NUMBERS)
                .collect(Collectors.toSet());
    }

    private ResponseEntity<List<Integer>> makeGetRequest(int count, int lowerBand, int upperBand, String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("count", Integer.toString(count));
        headers.add("lowerBand", Integer.toString(lowerBand));
        headers.add("upperBand", Integer.toString(upperBand));


        ResponseEntity<List<Integer>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<>() {
                }
        );
        return response;
    }


    private String getUrlForService(String service) {
        return uri + ":" + port + service;
    }


}

package com.verve.verve_zhongli.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class FireEndpointService {

    private final WebClient webClient;

    @Autowired
    public FireEndpointService(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    public void fire(String endpoint) {
        webClient.get()
                .uri(endpoint)
                .exchangeToMono(response -> {
                    log.info("HTTP Status Code for endpoint: {}, http code: {}", endpoint, response.statusCode().value());

                    return response.bodyToMono(String.class)
                            .map(body -> {
                                log.info("Successfully fired to endpoint {}, result: {}", endpoint, body);
                                return body;
                            });
                })
                .doOnError(error -> log.error("Error firing to endpoint: {}", endpoint, error))
                .subscribe();
    }
}

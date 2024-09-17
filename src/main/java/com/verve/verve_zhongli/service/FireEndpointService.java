package com.verve.verve_zhongli.service;

import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Slf4j
@Service
public class FireEndpointService {

    private final WebClient webClient;
    @Value("${verve.fire.endpoint.http-method}")
    private String httpMethod;
    @Value("${verve.fire.endpoint.thread-num}")
    private int threadPoolSize;

    @Autowired
    public FireEndpointService(WebClient.Builder builder) {
        this.webClient = builder
                .clientConnector(
                        new ReactorClientHttpConnector(
                                HttpClient
                                        .create(ConnectionProvider.newConnection())
                                        .runOn(new NioEventLoopGroup(threadPoolSize))
                        )
                )
                .build();
    }

    public void fire(String endpoint) {
        webClient.method(HttpMethod.valueOf(httpMethod))
                .uri(endpoint)
                .exchangeToMono(response -> {
                    log.info("sending {} http request to endpoint: {}, http response code: {}", httpMethod, endpoint, response.statusCode().value());

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

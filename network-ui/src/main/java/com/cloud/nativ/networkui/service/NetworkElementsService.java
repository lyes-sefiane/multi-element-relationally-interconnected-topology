package com.cloud.nativ.networkui.service;

import com.cloud.nativ.networkui.domain.NetworkElement;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-19 6:52 p.m.
 */
@Service
public class NetworkElementsService implements IService {

    private WebClient webClient = WebClient.create("http://localhost:8080");

    @Override
    public Flux<NetworkElement> getAllNetworkElements() {
        return webClient//
                .get()//
                .uri("/api/v1/devices")//
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()//
                .bodyToFlux(NetworkElement.class)
                .log();
    }

    @Override
    public Void deleteNetworkElement(String id) {
       return webClient//
                .delete()//
                .uri("/api/v1/devices/{id}", id)//
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)//
                .retrieve()//
                .bodyToMono(Void.class)//
                .log()//
                .block();
    }
}

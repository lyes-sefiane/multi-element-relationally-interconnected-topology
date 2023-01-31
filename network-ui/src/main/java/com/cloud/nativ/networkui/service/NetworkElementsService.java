package com.cloud.nativ.networkui.service;

import com.cloud.nativ.networkui.domain.NetworkElement;
import com.cloud.nativ.networkui.utils.BaseUri;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-19 6:52 p.m.
 */
@Service
public class NetworkElementsService extends AbstractService implements INetworkElementService {

    private final String devicesBaseUri;

    public NetworkElementsService(Environment environment) {
        super(environment);
        devicesBaseUri = environment.getProperty(BaseUri.DEVICES.getValue());
    }

    @Override
    public Flux<NetworkElement> retrieveAllNetworkElements() {
        return webClient//
                .get()//
                .uri(devicesBaseUri)//
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()//
                .bodyToFlux(NetworkElement.class)
                .log();
    }

    @Override
    public NetworkElement retrieveNetworkElement(String id) {
        return webClient
                .get()
                .uri(devicesBaseUri + "/{id}", id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(NetworkElement.class)
                .log()
                .block();
    }

    @Override
    public NetworkElement updateNetworkElement(NetworkElement networkElement, String id) {
        return webClient
                .put()
                .uri(devicesBaseUri + "/{id}", id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(networkElement), NetworkElement.class)
                .retrieve()
                .bodyToMono(NetworkElement.class)
                .log()
                .block();
    }

    @Override
    public Void deleteNetworkElement(String id) {
       return webClient//
                .delete()//
                .uri(devicesBaseUri + "/{id}", id)//
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)//
                .retrieve()//
                .bodyToMono(Void.class)//
                .log()//
                .block();
    }
}

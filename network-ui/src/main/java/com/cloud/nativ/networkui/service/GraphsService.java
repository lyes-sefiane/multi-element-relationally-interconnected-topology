package com.cloud.nativ.networkui.service;

import com.cloud.nativ.networkui.domain.graphql.NetworkGraphQueryResponse;
import com.cloud.nativ.networkui.utils.BaseUri;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-30 11:14 a.m.
 */
@Service
public class GraphsService extends AbstractService implements IGraphsService {

    private final String graphsBaseUri;

    public GraphsService(Environment environment) {
        super(environment);
        graphsBaseUri = environment.getProperty(BaseUri.GRAPHS.getValue());
    }

    @Override
    public Mono<NetworkGraphQueryResponse> retrieveGraph() {
        var retrieveGraphQuery =
                "{ \"query\": \"{ " +
                        "retrieveGraph { " +
                            "nodes { " +
                                "id " +
                                "area " +
                                "elementType" +
                            "} " +
                            "links { " +
                                "source " +
                                "target " +
                                "cost" +
                            "} " +
                        "} " +
                    "}\" " +
                "}";
        return webClient
                .post()
                .uri(graphsBaseUri)
                .bodyValue(retrieveGraphQuery)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(NetworkGraphQueryResponse.class)
                .log();
    }
}

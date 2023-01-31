package com.cloud.nativ.networkui.service;

import com.cloud.nativ.networkui.domain.graphql.NetworkGraphQueryResponse;
import reactor.core.publisher.Mono;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-30 11:14 a.m.
 */
public interface IGraphsService {

    Mono<NetworkGraphQueryResponse> retrieveGraph();
}

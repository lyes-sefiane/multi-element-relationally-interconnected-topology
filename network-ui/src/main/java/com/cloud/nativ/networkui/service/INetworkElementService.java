package com.cloud.nativ.networkui.service;

import com.cloud.nativ.networkui.domain.NetworkElement;
import reactor.core.publisher.Flux;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-19 6:53 p.m.
 */
public interface INetworkElementService {

    Flux<NetworkElement> retrieveAllNetworkElements();

    NetworkElement retrieveNetworkElement(String id);

    NetworkElement updateNetworkElement(NetworkElement networkElement, String id);

    Void deleteNetworkElement(String id);
}

package com.cloud.nativ.networkui.service;

import com.cloud.nativ.networkui.domain.NetworkElement;
import reactor.core.publisher.Flux;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-19 6:53 p.m.
 */
public interface IService {

    Flux<NetworkElement> getAllNetworkElements();

    Void deleteNetworkElement(String id);
}

package com.cloud.nativ.networkui.service;

import com.cloud.nativ.networkui.utils.BaseUri;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-30 11:22 a.m.
 */
public class AbstractService {

    protected String baseUrl;

    protected WebClient webClient;


    public AbstractService(Environment environment) {
        baseUrl = environment.getProperty(BaseUri.GATEWAY.getValue());
        webClient = WebClient.create(baseUrl);
    }

}

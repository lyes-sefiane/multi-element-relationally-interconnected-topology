package com.cloud.nativ.networkui.utils;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-30 12:01 p.m.
 */
public enum BaseUri {
    GATEWAY("gateway.base.url"),
    DEVICES("devices.base.uri"),
    GRAPHS("graphs.base.uri");

    private String value;

    private BaseUri(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

package com.cloud.nativ.networkcommon.exception.entities;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-13 12:40 p.m.
 */
public class NodeNotFoundException extends RuntimeException {

    private final static String DEFAULT_MESSAGE = "node not found";

    public NodeNotFoundException() {
        this(DEFAULT_MESSAGE);
    }

    public NodeNotFoundException(String message) {
        super(message);
    }

}

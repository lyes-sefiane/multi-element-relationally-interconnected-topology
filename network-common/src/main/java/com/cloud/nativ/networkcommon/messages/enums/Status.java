package com.cloud.nativ.networkcommon.messages.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 12:41 p.m.
 */
public enum Status {
    NEW("NEW"), //
    UPDATE("UPDATE"),//
    DELETE("DELETE"),//
    UNKNOWN("UNKNOWN");

    private static final Map<String, Status> mapOfEnumsByValue = Arrays.stream(Status.values()).collect(Collectors.toMap(entry -> entry.value, entry -> entry));

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * Get Enum By Value
     *
     * @param value
     * @return MessageStatus
     */
    public static Status getEnumByValue(String value) {

        if (value == null) {
            throw new IllegalArgumentException("Value Provided Should Not be Null !!");
        }

        final Status result = mapOfEnumsByValue.get(value);

        if (result == null) {
            throw new IllegalArgumentException(value);
        }
        return result;
    }
}

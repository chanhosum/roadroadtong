package com.mountbet.accountservice.constant;

import java.util.Arrays;

/**
 * Bets persistence types.
 */
public enum PersistenceType {
    LAPSE(0),
    PERSIST(1),
    MARKET_ON_CLOSE(2);

    private final int code;

    PersistenceType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    /**
     * Returns an enum instance matching the specified code.
     *
     * @param code an enum code
     * @return an enum instance or {@code null}
     */
    public static PersistenceType fromCode(int code) {
        return Arrays.stream(values()).filter(value -> value.code == code).findFirst().orElse(null);
    }
}
package com.mountbet.accountservice.constant;

import java.util.Arrays;

public enum OrderStatus {

    /**
     * An order that has a remaining unmatched portion
     */
    EXECUTABLE(0),

    /**
     * An order that does not have any remaining unmatched portion.
     */
    EXECUTION_COMPLETE(1),

    /**
     * An asynchronous order is yet to be processed. Once the bet has been processed by the exchange
     * (including waiting for any in-play delay), the result will be reported and available on the
     * Exchange Stream API and API NG.
     * Not a valid search criteria on MarketFilter
     */
    PENDING(2),

    /**
     * The order is no longer available for execution due to its time in force constraint.
     * In the case of FILL_OR_KILL orders, this means the order has been killed because it could not be filled to your specifications.
     * Not a valid search criteria on MarketFilter
     */
    EXPIRED(3);

    private final int code;

    OrderStatus(int code) {
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
    public static OrderStatus fromCode(int code) {
        return Arrays.stream(values()).filter(value -> value.code == code).findFirst().orElse(null);
    }
}


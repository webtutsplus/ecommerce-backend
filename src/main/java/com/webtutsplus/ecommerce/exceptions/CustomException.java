package com.webtutsplus.ecommerce.exceptions;

public class CustomException extends IllegalArgumentException {
    // TODO: Add a better explanation of this exception.
    /**
     * Custom exception for broader exceptions.
     * @param msg Message to send upstream.
     */
    public CustomException(String msg) {
        super(msg);
    }
}

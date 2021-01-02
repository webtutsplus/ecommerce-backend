package com.webtutsplus.ecommerce.exceptions;

public class ValidationException extends RuntimeException{
	private static final long serialVersionUID = 6064663768170825752L;

	public ValidationException(String message) {
        super(message);
    }
	
	public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}

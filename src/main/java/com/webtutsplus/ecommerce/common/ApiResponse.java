package com.webtutsplus.ecommerce.common;

import java.time.LocalDateTime;

public class ApiResponse {
	private final boolean success;
	private final String message;
	// try again

	/**
	 * A response object that the server will send back to describe whether or not a
	 * request was successful, and add an accompanying message with the response.
	 * @param success Was the request at all successful or not.
	 * @param message Additional message to send back with the response.
	 */
	public ApiResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
	
	public String getTimestamp() {
		return LocalDateTime.now().toString();
	}
}

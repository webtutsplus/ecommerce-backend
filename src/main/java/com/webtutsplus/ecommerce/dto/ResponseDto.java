package com.webtutsplus.ecommerce.dto;


public class ResponseDto {
    private String status;
    private String message;

    /**
     * Constructor for ResponseDto object.
     * @param status The status of the response.
     * @param message The message of the response.
     */
    public ResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * Used to get the status of the ResponseDto object.
     * @return status of type String.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Used to set the status of the ResponseDto object.
     * @param status the new status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Used to get the message of the ResponseDto object.
     * @return message of type String.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Used to set the message of the ResponseDto object.
     * @param message the new message.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}

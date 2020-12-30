package com.webtutsplus.ecommerce.dto.userDTOs;

public class SignInResponseDto {
    private String status;
    private String token;

    /**
     * The constructor for the SignInResponseDto object.
     * @param status sign in status.
     * @param token sing in token.
     */
    public SignInResponseDto(String status, String token) {
        this.status = status;
        this.token = token;
    }

    /**
     * Used to get the sign in status.
     * @return status of type String
     */
    public String getStatus() {
        return status;
    }

    /**
     * Used to set the sign in status.
     * @param status new sign in status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Used to get the sign in token.
     * @return token of type String.
     */
    public String getToken() {
        return token;
    }

    /**
     * Used to set the sign in token.
     * @param token new sign in token.
     */
    public void setToken(String token) {
        this.token = token;
    }
}

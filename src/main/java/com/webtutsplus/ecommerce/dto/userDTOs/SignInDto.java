package com.webtutsplus.ecommerce.dto.userDTOs;

public class SignInDto {
    private String email;
    private String password;

    /**
     * Used to get the email address of the SignInDto object.
     * @return email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Used to set the email address of the SignInDto object.
     * @param email new email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Used to get the password of the SignInDto object.
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Used to set the password of the SignInDto object.
     * @param password new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

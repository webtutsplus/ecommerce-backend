package com.webtutsplus.ecommerce.dto.userDTOs;

public class SignupDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    /**
     * Used to get the first name of the SignupDto object.
     * @return first name of type String.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Used to set the first name of the SignupDto object.
     * @param firstName new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Use to get the last name of the SignupDto object.
     * @return last name of type String.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Used ot set the last name of the SignupDto object.
     * @param lastName new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Use to get the email of the SignupDto object.
     * @return email of type String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Used ot set the email of the SignupDto object.
     * @param email new email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Use to get the password of the SignupDto object.
     * @return password of type String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Used ot set the password of the SignupDto object.
     * @param password new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

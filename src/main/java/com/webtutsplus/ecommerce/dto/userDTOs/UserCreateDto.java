package com.webtutsplus.ecommerce.dto.userDTOs;


import com.webtutsplus.ecommerce.enums.Role;

public class UserCreateDto {
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String password;

    /**
     * Used to get the first name of the UserCreateDto object.
     * @return first name of type String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Used ot set the first name of the UserCreateDto object.
     * @param firstName new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Used to get the last name of the UserCreateDto object.
     * @return last name of type String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Used ot set the last name of the UserCreateDto object.
     * @param lastName new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Used to get the email of the UserCreateDto object.
     * @return email of type String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Used ot set the email of the UserCreateDto object.
     * @param email new email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Used to get the role of the UserCreateDto object.
     * @return role of type Role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Used ot set the role of the UserCreateDto object.
     * @param role new role.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Used to get the password of the UserCreateDto object.
     * @return password of type String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Used ot set the password of the UserCreateDto object.
     * @param password new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
